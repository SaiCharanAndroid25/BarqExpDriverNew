package mersattech.barqexpdriver.Adapters;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import mersattech.barqexpdriver.Activities.Pickoupcheckout.ScanQRnImagescreen;
import mersattech.barqexpdriver.Fragments.HomePageFragment;
import mersattech.barqexpdriver.Interfaces.ReasonsSelected;
import mersattech.barqexpdriver.Models.s.CancelReasons.CancelReasonResponse;
import mersattech.barqexpdriver.Models.s.Checkedout.ItemCheckedOutRequestBody;
import mersattech.barqexpdriver.Models.s.CurrentOrders.DeliveryRequestDetail;
import mersattech.barqexpdriver.Models.s.Orders.OderRejectRequestModel;
import mersattech.barqexpdriver.Models.s.Orders.OrderAssignmentService;
import mersattech.barqexpdriver.Models.s.OrdersList.CurrentPickup;
import mersattech.barqexpdriver.Models.s.Reasonmodel.ReasonsModel;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.itemPickup.ItemPickupResponse;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.databinding.OrderDeliveryBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static mersattech.barqexpdriver.Fragments.HomePageFragment.cancel_btn;
import static mersattech.barqexpdriver.Fragments.HomePageFragment.deliver_btn;

public class OrderDeliveryAdapter extends RecyclerView.Adapter<OrderDeliveryAdapter.Historyview> {

    private Context mContext;
    private java.util.List<DeliveryRequestDetail> mDrList;
    private String mAuth;
    Dialog dialog;
    static final Integer MY_PERMISSIONS_REQUESTS = 1;
    public  int i,k;
    DeliveryRequestDetail parentItem;
    private OrderDeliveryBinding morderDeliveryBinding;


    public OrderDeliveryAdapter(java.util.List<DeliveryRequestDetail> list) {
        mDrList = list;
        // mContext = Context;
    }

    @Override
    public OrderDeliveryAdapter.Historyview onCreateViewHolder(ViewGroup parent, final int viewType) {
        mContext = parent.getContext();
        mAuth = AppPreferences.getAppPreferences(mContext).getString(AppPreferences.TOKEN, "");
         morderDeliveryBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.order_delivery, parent, false);
        return new OrderDeliveryAdapter.Historyview(morderDeliveryBinding);
    }


    @Override
    public void onBindViewHolder(final Historyview holder, final int position) {
        parentItem = mDrList.get(position);

        holder.morderDeliveryBinding.orderIdValTv4.setText(String.valueOf(parentItem.getID()));
        holder.morderDeliveryBinding.statusValTv4.setText(parentItem.getStatus());
        holder.morderDeliveryBinding.cityValTv4.setText(parentItem.getRecieverDetails().getCityName());
        holder.morderDeliveryBinding.blockValTv4.setText(parentItem.getRecieverDetails().getBlockName());


        if(parentItem.getDeliveryRequestItem().get(0).getIsDelivered() == true){
            holder.morderDeliveryBinding.deliverBtn.setVisibility(View.GONE);
            holder.morderDeliveryBinding.cancelBtn.setVisibility(View.GONE);
        }else{
            holder.morderDeliveryBinding.deliverBtn.setVisibility(View.VISIBLE);
            holder.morderDeliveryBinding.cancelBtn.setVisibility(View.VISIBLE);
        }

        morderDeliveryBinding.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k = holder.getAdapterPosition();
                callGetReasonsApi();
            }
        });


        morderDeliveryBinding.detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = holder.getAdapterPosition();
                // Create custom dialog object
                final Dialog dialog = new Dialog(mContext);
                // Include dialog.xml file
                dialog.setContentView(R.layout.address_details);
                dialog.show();
                Button declineButton = (Button) dialog.findViewById(R.id.pickup_btn_2);
                Button dismissButton = (Button) dialog.findViewById(R.id.cancel_btn_2);

                TextView drstatus = (TextView) dialog.findViewById(R.id.status_val_tv);
                TextView drid = (TextView) dialog.findViewById(R.id.dr_id_val_tv);
                TextView pickupdate = (TextView) dialog.findViewById(R.id.date_val_tv);

                TextView sendername = (TextView) dialog.findViewById(R.id.snder_name_title);
                TextView senderphn = (TextView) dialog.findViewById(R.id.sndr_phn_val_tv);

                TextView recivername = (TextView) dialog.findViewById(R.id.reciver_cntct_title);
                TextView reciverphn = (TextView) dialog.findViewById(R.id.receiver_contact_title);

                TextView address = (TextView) dialog.findViewById(R.id.address_val_tv);

                drstatus.setText( mDrList.get(i).getStatus());
                drid.setText(String.valueOf(mDrList.get(i).getID()));

                String dateTime = mDrList.get(i).getPickupDate();
                SimpleDateFormat formatter = getFormator();
                Date date = null;
                try {
                    date = formatter.parse(dateTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat newFormat = getFormator();
                String finalString = newFormat.format(date);
                pickupdate.setText(finalString);

                sendername.setText(mDrList.get(i).getSenderAddress().getName());
                senderphn.setText(mDrList.get(i).getSenderAddress().getPhone());

                recivername.setText(mDrList.get(i).getRecieverDetails().getName());
                reciverphn.setText(mDrList.get(i).getRecieverDetails().getPhone());

                address.setText(mDrList.get(i).getRecieverDetails().getAddressLine1() +","+ mDrList.get(i).getRecieverDetails().getAddressLine2()
                        +","+ mDrList.get(i).getRecieverDetails().getCityName() +","+ mDrList.get(i).getRecieverDetails().getCountryName());

                senderphn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = holder.getAdapterPosition();
                        callPhoneNumber();
                    }
                });

                reciverphn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = holder.getAdapterPosition();
                        callPhoneNumber_reciver();
                    }
                });

                // if decline button is clicked, close the custom dialog
                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });
                dismissButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });
            }
        });


        morderDeliveryBinding.deliverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = holder.getAdapterPosition();
                SharedPreferences setPref = mContext.getSharedPreferences("Packagename", Context.MODE_PRIVATE);
                setPref.edit().putInt("position", i).commit();

                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext, Manifest.permission.CAMERA)) {
                        //Show Information about why you need the permission
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setTitle("Need Camera Permission");
                        builder.setMessage("This app needs camera permission.");
                        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
                    } else {
                        //just request the permission
                        ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
                    }
                } else {
                    //You already have the permission, just go ahead.
                    Intent intent = new Intent(mContext, ScanQRnImagescreen.class);
                    intent.putExtra("Deliver_Code", "4");
                    mContext.startActivity(intent);


                }
            }
        });
        morderDeliveryBinding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = holder.getAdapterPosition();
                callPhoneNumber_reciver();
            }
        });
    }

    private SimpleDateFormat getFormator() {
        SimpleDateFormat simpleDateFormat;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat("yyyy-DD-MM",
                    Locale.getDefault(Locale.Category.FORMAT));
        } else {
            simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");
        }
        return simpleDateFormat;
    }

    private void callPhoneNumber() {
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }
                String phone = mDrList.get(i).getSenderAddress().getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                mContext.startActivity(intent);
            }
            else {
                String phone = mDrList.get(i).getSenderAddress().getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                mContext.startActivity(intent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void callPhoneNumber_reciver() {
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CALL_PHONE}, 102);
                    return;
                }
                String phone = mDrList.get(i).getRecieverDetails().getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                mContext.startActivity(intent);
            }
            else {
                String phone = mDrList.get(i).getRecieverDetails().getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                mContext.startActivity(intent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhoneNumber();
            } else {
                Log.e(TAG, "Permission not Granted");
            }
        }
        if (requestCode == 102) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhoneNumber_reciver();
            } else {
                Log.e(TAG, "Permission not Granted");
            }
        }
    }

    private void callGetReasonsApi() {

        Call<CancelReasonResponse> mReasonCodeListModelCall = NetworkUtils.getApiInterface().getReasonCodesByType(
                "bearer "+mAuth, AppConstants.ReasonsType.DELIVERY_REQUEST_CANCELLATION);

        mReasonCodeListModelCall.enqueue(new Callback<CancelReasonResponse>() {
            @Override
            public void onResponse(@NonNull Call<CancelReasonResponse> call, @NonNull Response<CancelReasonResponse> response) {
                CancelReasonResponse reasonCodeListModel = response.body();

                if (reasonCodeListModel != null) {
                    switch (reasonCodeListModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            final ArrayList<ReasonsModel> reasonsModelList = new ArrayList<>();
                            for (int i = 0; i < reasonCodeListModel.getList().size(); i++) {
                                mersattech.barqexpdriver.Models.s.CancelReasons.List listItem =
                                        reasonCodeListModel.getList().get(i);
                                ReasonsModel reasonsModel = new ReasonsModel();
                                reasonsModel.setmId(listItem.getID());
                                reasonsModel.setmReason(listItem.getReason());
                                reasonsModel.setmStatus(false);
                                reasonsModelList.add(reasonsModel);
                            }

                            dialog = DataUtils.getInstance().getReasonsDialog(mContext,
                                    "Select a reason for cancellation", reasonsModelList, new ReasonsSelected() {
                                        @Override
                                        public void onReasonSelected(Dialog dialog, int position, String otherReasonText) {
                                            if (!(position == -1)) {
                                                callRejectedApi(reasonsModelList.get(position).getmId(), otherReasonText);
                                            }
                                            dialog.dismiss();
                                        }

                                        @Override
                                        public void onDismiss(Dialog dialog) {
                                            dialog.dismiss();
                                            //  callThread();
                                        }
                                    });
                            dialog.setCancelable(false);
                            dialog.setCanceledOnTouchOutside(false);
                            if (!dialog.isShowing()) {
                                dialog.show();
                            }
                            break;
                    }
                } else {
                    // Toast.makeText(HomeActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CancelReasonResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callRejectedApi(int reasonsId, String otherReasonString) {
        final Call<OrderAssignmentService> rejectCall = NetworkUtils.getApiInterface().updateOderRejectedReason(
                "bearer "+mAuth, getRejectOderRequestBody(reasonsId, otherReasonString));

       rejectCall.enqueue(new Callback<OrderAssignmentService>() {
            @Override
            public void onResponse(@NonNull Call<OrderAssignmentService> call, @NonNull Response<OrderAssignmentService> response) {
                OrderAssignmentService orderAssignmentService = response.body();
                if (orderAssignmentService != null) {
                    switch (orderAssignmentService.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            //  callThread();
                            Toast.makeText(mContext, "Cancelled Successfully", Toast.LENGTH_SHORT).show();
                            deliver_btn.setVisibility(View.GONE);
                            cancel_btn.setVisibility(View.GONE);
                            HomePageFragment.callCurrentOrderApi();
                            break;

                        default:
                            //   callThread();
                            break;
                    }
                } else {
                    //  Toast.makeText(mContext, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<OrderAssignmentService> call, @NonNull Throwable t) {
                // callThread();
            }
        });
    }

    private OderRejectRequestModel getRejectOderRequestBody(int reasonsId, String otherReasonString) {
        OderRejectRequestModel requestBody = new OderRejectRequestModel();
        requestBody.setID( mDrList.get(k).getID());
        requestBody.setCancelReasonID(reasonsId);
        requestBody.setDeliveryStatusID(10);
        return requestBody;
    }

    private void callCheckoutOrderApi() {
        Call<ItemPickupResponse> getcuurentorderResponseCall = NetworkUtils.getApiInterface().
                getCheckedOut( "bearer "+mAuth,requestbodyforcheckedout());

        getcuurentorderResponseCall.enqueue(new Callback<ItemPickupResponse>() {
            @Override
            public void onResponse(@NonNull Call<ItemPickupResponse> call,
                                   @NonNull Response<ItemPickupResponse> response) {
                ItemPickupResponse getcurrentorderResponse = response.body();

                if (getcurrentorderResponse != null) {
                    switch (getcurrentorderResponse.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            //   setData(getcurrentorderResponse.getEntity().getDeliveryRequestDetails());
                            if( getcurrentorderResponse.getEnglishDetails().equals("Modified successfully")){
                                if (ContextCompat.checkSelfPermission(mContext,
                                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                                    if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                                    {
                                        if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext, Manifest.permission.CAMERA))
                                        {
                                            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(mContext);
                                            alertBuilder.setCancelable(true);
                                            alertBuilder.setTitle("Permission necessary");
                                            alertBuilder.setMessage("CAMERA is necessary");
                                            alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                                public void onClick(DialogInterface dialog, int which) {
                                                    ActivityCompat.requestPermissions((Activity) mContext,
                                                            new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);


                                                }
                                            });
                                            AlertDialog alert = alertBuilder.create();
                                            alert.show();
                                        } else {
                                            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
                                        }
                                        //  return false;
                                    } else {
                                        //  return true;
                                    }
                                }

                            }else{
                               /* mcurrentorderItemBinding.checkoutBtn.setVisibility(View.VISIBLE);
                                mcurrentorderItemBinding.checkoutBtn1.setVisibility(View.GONE);*/
                            }
                            break;

                        default:
                            //  mProgressDialog.dismiss();
                            break;
                    }
                } else {
//                    mProgressDialog.dismiss();
                    // Toast.makeText(mContext, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ItemPickupResponse> call, @NonNull Throwable t) {
                //  Toast.makeText(mContext, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                //  mProgressDialog.dismiss();
            }
        });
    }

    private ItemCheckedOutRequestBody requestbodyforcheckedout() {
        ItemCheckedOutRequestBody checkedoutRequestbody = new ItemCheckedOutRequestBody();
        if(mDrList.size()>0){
            Log.e("Pos", String.valueOf(i));
            Log.e("Pos", String.valueOf(CurrentPickup.getInstance().getDeliveryRequestDetails().get(i).getID()));
            checkedoutRequestbody.setID(CurrentPickup.getInstance().getDeliveryRequestDetails().get(i).getID());
            checkedoutRequestbody.setDRInventoryStatusID(4);
            return checkedoutRequestbody;
        }else{

        }
        return checkedoutRequestbody;
    }

    @Override
    public int getItemCount() {
        try {
            return mDrList.size();
        }catch(Exception e){
          return  0;
        }
    }

    class Historyview extends RecyclerView.ViewHolder {
        OrderDeliveryBinding morderDeliveryBinding;

        Historyview(OrderDeliveryBinding itemView) {
            super(itemView.getRoot());
            this.morderDeliveryBinding = itemView;
        }
    }

}