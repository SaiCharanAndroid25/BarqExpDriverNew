package mersattech.barqexpdriver.Adapters;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v13.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import mersattech.barqexpdriver.Activities.Pickoupcheckout.ScanQRnImagescreen;
import mersattech.barqexpdriver.Models.s.Checkedout.ItemCheckedOutRequestBody;
import mersattech.barqexpdriver.Models.s.CurrentOrders.DeliveryRequestDetail;
import mersattech.barqexpdriver.Models.s.OrdersList.CurrentPickup;
import mersattech.barqexpdriver.Models.s.otherutilitymodel.itemPickup.ItemPickupResponse;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.databinding.CurrentorderParentItemBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentOrderAdapter extends RecyclerView.Adapter<CurrentOrderAdapter.Historyview> {

    private Context mContext;
    private java.util.List<DeliveryRequestDetail> mDrList;
    private String mAuth;
    private CurrentorderParentItemBinding mcurrentorderItemBinding;
    Dialog dialog;
    static final Integer MY_PERMISSIONS_REQUESTS = 1;
    public  int i ;
    DeliveryRequestDetail parentItem;


    public CurrentOrderAdapter(java.util.List<DeliveryRequestDetail> list) {
        mDrList = list;
       // mContext = Context;
    }

    @Override
    public CurrentOrderAdapter.Historyview onCreateViewHolder(ViewGroup parent, final int viewType) {
        mContext = parent.getContext();
        mAuth = AppPreferences.getAppPreferences(mContext).getString(AppPreferences.TOKEN, "");
        mcurrentorderItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.currentorder_parent_item, parent, false);
        return new CurrentOrderAdapter.Historyview(mcurrentorderItemBinding);
    }

    @Override
    public void onBindViewHolder(final CurrentOrderAdapter.Historyview holder, final int position) {
        DeliveryRequestDetail parentItem = mDrList.get(position);

        Log.d("DDDDD", String.valueOf(mDrList.size()));

        holder.mcurrentorderItemBinding.orderIdValTv.setText(String.valueOf(parentItem.getID()));
        holder.mcurrentorderItemBinding.statusValTv.setText(parentItem.getStatus());

        holder.mcurrentorderItemBinding.cityValTv.setText(parentItem.getRecieverDetails().getCityName());
        holder.mcurrentorderItemBinding.blockValTv.setText(parentItem.getRecieverDetails().getBlockName());

        if(parentItem.getCheckOutStatus() != 0  && parentItem.getStatus().equals("Picked Up") || parentItem.getStatus().equals("Delivered")
                ||  parentItem.getStatus().equals("Rejected By Receiver")){
            mcurrentorderItemBinding.checkoutBtn.setVisibility(View.GONE);
            mcurrentorderItemBinding.checkoutBtn1.setVisibility(View.VISIBLE);
        }else{
            mcurrentorderItemBinding.checkoutBtn.setVisibility(View.VISIBLE);
            mcurrentorderItemBinding.checkoutBtn1.setVisibility(View.GONE);
        }
        mcurrentorderItemBinding.checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = holder.getAdapterPosition();
                SharedPreferences setPref = mContext.getSharedPreferences("Packagename", Context.MODE_PRIVATE);
                setPref.edit().putInt("position", i).commit();

                if (NetworkUtils.getInstance().isNetworkAvailable(mContext)) {
                    //  mProgressDialog = getProgressDialog(getActivity());
                    callCheckoutOrderApi();
                } else {
                    Toast.makeText(mContext, "No network.Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            }

        });
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
                                    intent.putExtra("Deliver_Code", "3");
                                    mContext.startActivity(intent);
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
        return mDrList.size();
    }

    class Historyview extends RecyclerView.ViewHolder {
        CurrentorderParentItemBinding mcurrentorderItemBinding;

        Historyview(CurrentorderParentItemBinding itemView) {
            super(itemView.getRoot());
            this.mcurrentorderItemBinding = itemView;
        }
    }




}