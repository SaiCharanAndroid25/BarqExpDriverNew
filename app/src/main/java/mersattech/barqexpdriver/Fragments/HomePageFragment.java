package mersattech.barqexpdriver.Fragments;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.LocalActivityManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v13.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import co.ceryle.segmentedbutton.SegmentedButton;
import co.ceryle.segmentedbutton.SegmentedButtonGroup;
import mersattech.barqexpdriver.Adapters.CurrentOrderAdapter;
import mersattech.barqexpdriver.Adapters.HistoryParentListAdapter;
import mersattech.barqexpdriver.Adapters.OrderDeliveryAdapter;
import mersattech.barqexpdriver.DemoPackage.Tab1Activity;
import mersattech.barqexpdriver.DemoPackage.Tab2Activity;
import mersattech.barqexpdriver.DemoPackage.Tab3Activity;
import mersattech.barqexpdriver.DemoPackage.Tab4Activity;
import mersattech.barqexpdriver.DemoPackage.Tab5Activity;
import mersattech.barqexpdriver.DemoPackage.Tab6Activity;
import mersattech.barqexpdriver.HomePackage.HomePageOneActivity;
import mersattech.barqexpdriver.Interfaces.ReasonsSelected;
import mersattech.barqexpdriver.Models.s.CODAmount.CurrentOrderCODResponse;
import mersattech.barqexpdriver.Models.s.CancelReasons.CancelReasonResponse;
import mersattech.barqexpdriver.Models.s.CurrentOrders.CurrentOrderResponse;
import mersattech.barqexpdriver.Models.s.CurrentOrders.DeliveryRequestDetail;
import mersattech.barqexpdriver.Models.s.HistoryPackage.HistoryResponse;
import mersattech.barqexpdriver.Models.s.Orders.OderRejectRequestModel;
import mersattech.barqexpdriver.Models.s.Orders.OrderAssignmentService;
import mersattech.barqexpdriver.Models.s.OrdersList.CurrentPickup;
import mersattech.barqexpdriver.Models.s.OrdersList.List;
import mersattech.barqexpdriver.Models.s.OrdersList.OrderListResponseModel;
import mersattech.barqexpdriver.Models.s.Reasonmodel.ReasonsModel;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.Utils.NewAppArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;


public class HomePageFragment extends Fragment {

    private static Context mcontext;
    LocalActivityManager mLocalActivityManager;
    static  LinearLayout linear_no_views,linear_view_layout_1,linear_view_layout_4,linear_view_layout_5,linear_view_layout_6;
    private static String mAuth;
    private static ProgressDialog mProgressDialog;
    static RecyclerView recyclerview,recyclerview_6;
    static TextView order_id_val_tv,date_val_tv,status_val_tv,order_id_val_tv_6,date_val_tv_6,status_val_tv_6;
    TextView cod_amount,cod_collected_amount;
    Dialog dialog;
    static CurrentOrderResponse getcurrentorderResponse;
    static final Integer MY_PERMISSIONS_REQUESTS = 1;
    static SegmentedButtonGroup sbg;
    SegmentedButton checkoutbtn,orderdeliverybtn,codbtn;
    SwipeRefreshLayout mSwipeRefreshLayout;
    TextView order_id_val_tv_4,city_val_tv_4,block_val_tv_4,status_val_tv_4;
    public  static Button deliver_btn,cancel_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_main_frag, container, false);

        mAuth = AppPreferences.getAppPreferences(getActivity()).getString(AppPreferences.TOKEN, "");
        currentorderapiCall();

        sbg = (SegmentedButtonGroup) view.findViewById(R.id.segmentedButtonGroup);

      /*  mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentorderapiCall();
            }
        });*/

        order_id_val_tv_4 = (TextView) view.findViewById(R.id.order_id_val_tv_4);
        city_val_tv_4 = (TextView) view.findViewById(R.id.city_val_tv_4);
        block_val_tv_4 = (TextView) view.findViewById(R.id.block_val_tv_4);
        status_val_tv_4 = (TextView) view.findViewById(R.id.status_val_tv_4);

        checkoutbtn = (SegmentedButton) view.findViewById(R.id.segmentedButtonOne);
        orderdeliverybtn = (SegmentedButton) view.findViewById(R.id.segmentedButtonTwo);
        codbtn = (SegmentedButton) view.findViewById(R.id.segmentedButtonThree);

        order_id_val_tv = (TextView) view.findViewById(R.id.order_id_val_tv);
        date_val_tv = (TextView) view.findViewById(R.id.date_val_tv);
        status_val_tv = (TextView) view.findViewById(R.id.status_val_tv);
        order_id_val_tv_6 = (TextView) view.findViewById(R.id.order_id_val_tv_6);
        date_val_tv_6 = (TextView) view.findViewById(R.id.date_val_tv_6);
        status_val_tv_6 = (TextView) view.findViewById(R.id.status_val_tv_6);

        linear_view_layout_1 = (LinearLayout) view.findViewById(R.id.linear_view_layout_1);
        linear_view_layout_4 = (LinearLayout) view.findViewById(R.id.linear_view_layout_4);
        linear_view_layout_6 = (LinearLayout) view.findViewById(R.id.linear_view_layout_6);
        linear_view_layout_5 = (LinearLayout) view.findViewById(R.id.linear_view_layout_5);
        linear_no_views = (LinearLayout) view.findViewById(R.id.linear_no_views);

        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerview_6 = (RecyclerView) view.findViewById(R.id.recyclerview_6);
        deliver_btn =  (Button) view.findViewById(R.id.deliver_btn);
        cancel_btn = (Button) view.findViewById(R.id.cancel_btn);

        sbg.setOnClickedButtonListener(new SegmentedButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(int position) {
                if (position == 0) {
                    linear_view_layout_1.setVisibility(View.VISIBLE);
                    linear_view_layout_4.setVisibility(View.GONE);
                    linear_view_layout_6.setVisibility(View.GONE);
                    linear_view_layout_5.setVisibility(View.GONE);
                    // currentorderapiCall();
                } else  if (position == 1) {
                   // currentorderapiCall();
                    linear_view_layout_1.setVisibility(View.GONE);
                    linear_view_layout_4.setVisibility(View.GONE);
                    linear_view_layout_6.setVisibility(View.VISIBLE);
                    linear_view_layout_5.setVisibility(View.GONE);
                    try{
                        order_id_val_tv_6.setText(String.valueOf(getcurrentorderResponse.getEntity().getID()));
                    }catch(Exception e){

                    }
                    try {
                        String dateTime = getcurrentorderResponse.getEntity().getCreatedDatetime();
                        SimpleDateFormat formatter = getFormator();
                        Date date = null;
                        try {
                            date = formatter.parse(dateTime);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        } catch (NullPointerException npe) {
                            npe.printStackTrace();
                        }
                        SimpleDateFormat newFormat = getFormator();
                        try {
                            String finalString = newFormat.format(date);

                            date_val_tv_6.setText(finalString);
                            status_val_tv_6.setText(getcurrentorderResponse.getEntity().getOrderStatus());
                        } catch (NullPointerException npe) {
                            npe.printStackTrace();
                        }
                    }

                    catch (NullPointerException npe) {
                        npe.printStackTrace();
                    }
                    try {
                        setData_order(getcurrentorderResponse.getEntity().getDeliveryRequestDetails());
                    }catch(NullPointerException npe){

                    }

                } else  if (position == 2) {
                   // currentorderapiCall();
                    linear_view_layout_1.setVisibility(View.GONE);
                    linear_view_layout_4.setVisibility(View.GONE);
                    linear_view_layout_6.setVisibility(View.GONE);
                    linear_view_layout_5.setVisibility(View.VISIBLE);
                    codapiCall();
                }
            }
        });


        cod_amount = (TextView) view.findViewById(R.id.cod_amount);
        cod_collected_amount = (TextView) view.findViewById(R.id.cod_collected_amount);


        return  view;
    }


    private void callPhoneNumber() {
            try
            {
                if(Build.VERSION.SDK_INT > 22)
                {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 101);

                        return;
                    }
                    String phone = getcurrentorderResponse.getEntity().getDeliveryRequestDetails().get(0).getSenderAddress().getPhone();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                }
                else {
                    String phone = getcurrentorderResponse.getEntity().getDeliveryRequestDetails().get(0).getSenderAddress().getPhone();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
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
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 102);
                    return;
                }
                String phone = getcurrentorderResponse.getEntity().getDeliveryRequestDetails().get(0).getRecieverDetails().getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);

            }
            else {
                String phone = getcurrentorderResponse.getEntity().getDeliveryRequestDetails().get(0).getRecieverDetails().getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults)
    {
        if(requestCode == 101)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhoneNumber();
            }
            else
            {
                Log.e(TAG, "Permission not Granted");
            }
        }
        if(requestCode == 102)
    {
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            callPhoneNumber_reciver();
        }
        else
        {
            Log.e(TAG, "Permission not Granted");
        }
    }
    }

    public  void  currentorderapiCall() {
        if (NetworkUtils.getInstance().isNetworkAvailable(getActivity())) {
            mProgressDialog = getProgressDialog(getActivity());
             callCurrentOrderApi();
        } else {
            Toast.makeText(getActivity(), "No network.Please check your internet connection.", Toast.LENGTH_SHORT).show();
        }
    }

    public ProgressDialog getProgressDialog(Context context) {
        return ProgressDialog.show(context, "", "Loading please wait..", true);
    }

    private void codapiCall() {
        if (NetworkUtils.getInstance().isNetworkAvailable(getActivity())) {
              mProgressDialog = getProgressDialog(getActivity());
              callCODApi();
        } else {
            Toast.makeText(getActivity(), "No network.Please check your internet connection.", Toast.LENGTH_SHORT).show();
        }
    }

    public static void callCurrentOrderApi() {
        final Call<CurrentOrderResponse> getcuurentorderResponseCall = NetworkUtils.getApiInterface().
                getOrderList("bearer "+mAuth);
        getcuurentorderResponseCall.enqueue(new Callback<CurrentOrderResponse>() {
            @Override
            public void onResponse(@NonNull Call<CurrentOrderResponse> call,
                                   @NonNull Response<CurrentOrderResponse> response) {
                 getcurrentorderResponse = response.body();

                if (getcurrentorderResponse != null) {
                    switch (getcurrentorderResponse.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:

                            order_id_val_tv.setText(String.valueOf(getcurrentorderResponse.getEntity().getID()));

                            String dateTime = getcurrentorderResponse.getEntity().getCreatedDatetime();
                            SimpleDateFormat formatter = getFormator();
                            Date date = null;
                            try {
                                date = formatter.parse(dateTime);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            SimpleDateFormat newFormat = getFormator();
                            String finalString = newFormat.format(date);
                            date_val_tv.setText(finalString);

                            status_val_tv.setText(getcurrentorderResponse.getEntity().getOrderStatus());

                            setData(getcurrentorderResponse.getEntity().getDeliveryRequestDetails());

                            NewAppArrayList.getInstance().setOrderListResponseModels(getcurrentorderResponse);

                            CurrentPickup.getInstance().setDeliveryRequestDetails(NewAppArrayList.getInstance().getOrderListResponseModels().getEntity()
                                    .getDeliveryRequestDetails());
                           /* CurrentPickup.getInstance().setDeliveryRequestItemEntities(NewAppArrayList.getInstance().getOrderListResponseModels().getEntity()
                                    .getDeliveryRequestDetails().get(0).getDeliveryRequestItem());*/

                            Log.e("TAGD", String.valueOf(NewAppArrayList.getInstance().getOrderListResponseModels().getEntity()
                                    .getDeliveryRequestDetails().get(0).getDeliveryRequestItem()));


                            if (getcurrentorderResponse.getEntity().getIsAllDRsPickedUp().equals("0") && getcurrentorderResponse.getStatus().equals("Picked Up")
                                    ||  getcurrentorderResponse.getStatus().equals("Delivered")
                                    ||   getcurrentorderResponse.getStatus().equals("Rejected By Receiver")) {
                                sbg.setClickable(false);
                            } else {
                                sbg.setClickable(true);
                            }

                            break;

                        default:
                            mProgressDialog.dismiss();
                            linear_view_layout_1.setVisibility(View.GONE);
                            linear_no_views.setVisibility(View.VISIBLE);
                            linear_view_layout_6.setVisibility(View.GONE);
                            linear_view_layout_5.setVisibility(View.GONE);
                            break;
                    }
                } else {
                    mProgressDialog.dismiss();
                  //  Toast.makeText(mcontext, "No response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentOrderResponse> call, @NonNull Throwable t) {
//                Toast.makeText(mcontext, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
    }

    private void callCODApi() {
        Call<CurrentOrderCODResponse> getcuurentorderResponseCall = NetworkUtils.getApiInterface().
                getOrderCODList( "bearer "+mAuth);

        getcuurentorderResponseCall.enqueue(new Callback<CurrentOrderCODResponse>() {
            @Override
            public void onResponse(@NonNull Call<CurrentOrderCODResponse> call,
                                   @NonNull Response<CurrentOrderCODResponse> response) {
                CurrentOrderCODResponse getcurrentordercodamountResponse = response.body();

                if (getcurrentordercodamountResponse != null) {
                    switch (getcurrentordercodamountResponse.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            cod_amount.setText(String.valueOf(getcurrentordercodamountResponse.getEntity().getTotalCOD()));
                            cod_collected_amount.setText(String.valueOf(getcurrentordercodamountResponse.getEntity().getTotalCollectedCOD()));
                            mProgressDialog.dismiss();
                            break;
                        default:
                              mProgressDialog.dismiss();
                            break;
                    }
                } else {
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(), getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentOrderCODResponse> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
    }

    private static void setData(java.util.List<DeliveryRequestDetail> list) {
        final CurrentOrderAdapter currentListAdapter = new CurrentOrderAdapter(list);
        recyclerview.setLayoutManager(new LinearLayoutManager(mcontext));
        recyclerview.setAdapter(currentListAdapter);
        mProgressDialog.dismiss();
    }

    private void setData_order(java.util.List<DeliveryRequestDetail> list) {
        final OrderDeliveryAdapter orderdeliveryListAdapter = new OrderDeliveryAdapter(list);
        recyclerview_6.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview_6.setAdapter(orderdeliveryListAdapter);
        mProgressDialog.dismiss();
    }

    private static SimpleDateFormat getFormator() {
        SimpleDateFormat simpleDateFormat;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD",
                    Locale.getDefault(Locale.Category.FORMAT));
        } else {
            simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");
        }
        return simpleDateFormat;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
//        mLocalActivityManager.dispatchResume();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
