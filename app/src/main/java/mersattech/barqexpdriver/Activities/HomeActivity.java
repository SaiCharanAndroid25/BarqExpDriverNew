package mersattech.barqexpdriver.Activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;

import mersattech.barqexpdriver.Activities.History.HistoryActivity;
import mersattech.barqexpdriver.Activities.Login.LoginActivity;
import mersattech.barqexpdriver.Activities.Preferences.PreferencesActivity;
import mersattech.barqexpdriver.Activities.Registration.ResetPasswordActivity;
import mersattech.barqexpdriver.Adapters.NavigationMenuBarAdapter;
import mersattech.barqexpdriver.Adapters.ViewPagerAdapter;
import mersattech.barqexpdriver.DemoPackage.DemoActivity;
import mersattech.barqexpdriver.Fragments.HomePageFragment;
import mersattech.barqexpdriver.HomePackage.HomePageOneActivity;
import mersattech.barqexpdriver.Interfaces.OnProfileItemClickInterface;
import mersattech.barqexpdriver.Models.s.Driveractivestatus.IsDriverActiveStatusRequest;
import mersattech.barqexpdriver.Models.s.Driveractivestatus.IsDriverActiveStatusResponse;
import mersattech.barqexpdriver.Models.s.Orders.OrderAssignmentService;
import mersattech.barqexpdriver.Models.s.Updatestarttrip.UpdateStartTripResponse;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.Profile.ProfileFragment;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Services.TimerService;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.Utils.NewAppArrayList;
import mersattech.barqexpdriver.Utils.Tables.DBUtils.DBHelper;
import okhttp3.ResponseBody;
import retrofit2.Call;
import mersattech.barqexpdriver.databinding.ActivityHomeBinding;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity /* implements MapPickupnDropScreenFragment.
        OnFragmentInteractionListener, MapsPickupnDropListFragment.OnFragmentInteractionListener */ {
    DBHelper db;
    Dialog dialog;
    private ActivityHomeBinding mActivityHomeBinding;
  //  private MapPickupnDropScreenFragment mapPickupnDropScreenFragment;
 //   private MapsPickupnDropListFragment mapsListFragment;

   // private OrdersFragment orderslistScreenFragment;
    private boolean mIsProfileScreenLoaded;
    private Boolean isFromLogin;
    private Boolean isFromList;
    private ViewPagerAdapter mViewPagerAdapter;
    private String mProfileId;
    private Dialog mTimerDialogialog;
  //  private PickupRequestDialogWithTimerBinding mBinding;
    private OrderAssignmentService mOorderAssignmentService;
    private boolean mIsBroadCastReceiverRegistered;
    private boolean mIsThreadAlreadyCalled;
    private Call<UpdateStartTripResponse> updateStartTripResponseCall;
    private Handler mHandler;
    private Runnable mRunnable;
    private boolean statusOfGPS;
    private boolean isDenied;
    private boolean isAccepted;
    private FirebaseJobDispatcher mDispatcher;
    private String mAuth;
    private boolean is_on_Trip = false;
    private ProgressDialog mProgressDialog;
    private ToneGenerator toneG;
    private LatLng currentLatLng;
    private AlertDialog.Builder dialogBuilder;
    private Dialog dialog1;
    private Intent trackingIntent;
    private boolean boolOrderSeg;
    private AlertDialog builder1;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // binding views
        mActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        sharedPreferences = DataUtils.getInstance().
                getDefaultSharedPreferences(HomeActivity.this);
        // ini
        initData();
        screenIntialization();
        setupMenuAdapter();
        registerViewListners();
        setupViewPager();

    }

    private void initData() {
        isFromLogin = getIntent() != null && getIntent().getBooleanExtra(AppConstants.FROM_LOGIN, false);
        isFromList = getIntent() != null && getIntent().getBooleanExtra("isFromList", false);
        mAuth = AppPreferences.getAppPreferences(getApplicationContext()).getString(AppPreferences.TOKEN, "");
    }

    private void screenIntialization() {
        mActivityHomeBinding.toolbarLayout.menuIcon.setVisibility(View.VISIBLE);
        mActivityHomeBinding.toolbarLayout.toolbarTitle.setText(getString(R.string.app_name));
        mActivityHomeBinding.headerView.driverName.setText(DataUtils.getInstance().
                getDefaultSharedPreferences(HomeActivity.this).getString("name", ""));
        mActivityHomeBinding.headerView.driverEmail.setText(DataUtils.getInstance().
                getDefaultSharedPreferences(HomeActivity.this).getString("MobileNumber", ""));
      //  mActivityHomeBinding.headerView.profilePic.setImageDrawable(R.drawable.addimage);
        setProfilePic(true, DataUtils.getInstance().
                getDefaultSharedPreferences(HomeActivity.this).getString("profileImageId", ""));
    }


    private void setProfilePic(boolean isFromServer, String photoId) {
        Call<ResponseBody> getProfilePic;
        if (isFromServer) {
            getProfilePic = NetworkUtils.getApiInterface().getImage(photoId);
        } else {
            getProfilePic = NetworkUtils.getApiInterface().getImage(mProfileId);
        }
        getProfilePic.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call,
                                   @NonNull Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        byte[] bytes = response.body().bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        mActivityHomeBinding.headerView.profilePic.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), getString(R.string.image_loading_fail_msg), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupMenuAdapter() {
        mActivityHomeBinding.navigationMenuItems.setLayoutManager(new LinearLayoutManager(this));
        NavigationMenuBarAdapter navigationMenuBarAdapter = new NavigationMenuBarAdapter(
                getResources().getStringArray(R.array.navigation_menu_items),
                getResources().obtainTypedArray(R.array.nav_drawables_list), onProfileItemClickInterface);
        mActivityHomeBinding.navigationMenuItems.setAdapter(navigationMenuBarAdapter);
    }

    private void showLogoutDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(HomeActivity.this);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setMessage("Do you want to logout?");
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              /*  SharedPreferences pref = getApplicationContext().getSharedPreferences("login_pref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();*/

                sharedPreferences.edit().putBoolean("isLoggedIn", false).commit();

                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        Dialog dialog = dialogBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    private IsDriverActiveStatusRequest getRequestBody(int status, String reason) {
        IsDriverActiveStatusRequest requestBody = new IsDriverActiveStatusRequest();
        requestBody.setIsonline(0);
        requestBody.setOfflineStatusReasonText("cancel");
        return requestBody;
    }
    private void logout() {
        if (mHandler != null)
            mHandler.removeCallbacks(mRunnable);
        NewAppArrayList.getInstance().setOrderListResponseModels(null);

        SharedPreferences sharedPreferences = DataUtils.getInstance().getDefaultSharedPreferences(
                HomeActivity.this);
        boolean isLocationPermissionsOn = sharedPreferences.getBoolean("isLocationPermissionGranted", false);
        sharedPreferences.edit().clear().apply();

        DataUtils.getInstance().getDefaultSharedPreferences(HomeActivity.this).edit().
                putBoolean("isLocationPermissionGranted", isLocationPermissionsOn).apply();

        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void registerViewListners() {
        mActivityHomeBinding.toolbarLayout.menuIcon.setOnClickListener(mOnClickListener);
        mActivityHomeBinding.toolbarLayout.backIcon.setOnClickListener(mOnClickListener);
        mActivityHomeBinding.noLocationPermissionLayout.setOnClickListener(mOnClickListener);
    }

    private void settoolbarLayoutTitle(int position) {
        switch (position) {
            case 0:
                mActivityHomeBinding.toolbarLayout.toolbarTitle.setText(getString(R.string.app_name));
                break;

            case 1:
                mActivityHomeBinding.toolbarLayout.toolbarTitle.setText(getString(R.string.listofpickupitems));
                break;
        }
    }

    private void setupViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //orderslistScreenFragment = new OrdersFragment();
       // ProfileFragment orderslistScreenFragment = new ProfileFragment();
        HomePageFragment orderslistScreenFragment = new HomePageFragment();
        Bundle bundle = new Bundle();
        orderslistScreenFragment.setArguments(bundle);
        mViewPagerAdapter.insertNewFragment(orderslistScreenFragment);
        mActivityHomeBinding.mainTabContent.setAdapter(mViewPagerAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        getCacheDir().delete();

        mActivityHomeBinding.unbind();

        stopService(new Intent(HomeActivity.this, TimerService.class));
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
            mIsThreadAlreadyCalled = false;
        }

        mIsProfileScreenLoaded = false;
//        callDriverActiveStatusUpdate();
//        unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    public void onBackPressed() {

       /* if (mIsProfileScreenLoaded) {
            onBackPressedFromProfileFragment();
        } else {
            super.onBackPressed();
        }*/
    }

    private void onBackPressedFromProfileFragment() {
      /*  mIsProfileScreenLoaded = false;
        mActivityHomeBinding.fragmnetsContainer.setVisibility(View.GONE);
        mActivityHomeBinding.tabLayout.setVisibility(View.GONE);
        mActivityHomeBinding.mainTabContent.setVisibility(View.GONE);
        mActivityHomeBinding.toolbarLayout.backIcon.setVisibility(View.GONE);
        mActivityHomeBinding.toolbarLayout.menuIcon.setVisibility(View.VISIBLE);
        settoolbarLayoutTitle(mActivityHomeBinding.mainTabContent.getCurrentItem());
        super.onBackPressed();*/
        mIsProfileScreenLoaded = false;
        mActivityHomeBinding.fragmnetsContainer.setVisibility(View.VISIBLE);
        mActivityHomeBinding.tabLayout.setVisibility(View.VISIBLE);
        mActivityHomeBinding.mainTabContent.setVisibility(View.VISIBLE);
        mActivityHomeBinding.toolbarLayout.backIcon.setVisibility(View.GONE);
        mActivityHomeBinding.toolbarLayout.menuIcon.setVisibility(View.VISIBLE);
        settoolbarLayoutTitle(mActivityHomeBinding.mainTabContent.getCurrentItem());
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
            mIsThreadAlreadyCalled = false;
        }
     //   unregisterReceiver(mBroadcastReceiver);
        if (mTimerDialogialog != null) {
            mTimerDialogialog.dismiss();
            toneG.release();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == AppConstants.LANGUAGE_CHANGED) {
            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
            if (i != null) {
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
            startActivity(i);
            finish();
        }
    }

    public int getSegmentId() {
        SharedPreferences sharedPreferences = DataUtils.getInstance().getDefaultSharedPreferences(HomeActivity.this);
        return sharedPreferences.getInt("SegmentId", 0);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.menu_icon:
                    if (mActivityHomeBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        mActivityHomeBinding.drawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        mActivityHomeBinding.drawerLayout.openDrawer(GravityCompat.START);
                    }
                    break;

                case R.id.back_icon:
                     onBackPressedFromProfileFragment();
                    break;

                case R.id.no_location_permission_layout:
                    /*if (statusOfGPS) {
                        checkPermissions(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION, mLocationPermissionUpdate, false);
                    } else {
                        locationPermissionsCheck();
                    }*/
                    break;
            }
        }
    };

    private OnProfileItemClickInterface onProfileItemClickInterface = new OnProfileItemClickInterface() {
        @Override
        public void onProfileItemClickCallback(int position) {
            switch (position) {

                case AppConstants.MenuItemConstants.ORDERSLIST:
                    HomePageFragment homepageFragment = new HomePageFragment();
                    Bundle bundle1 = new Bundle();
                    homepageFragment.setArguments(bundle1);
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.replace(mActivityHomeBinding.fragmnetsContainer.getId(), homepageFragment);
                    transaction1.addToBackStack(null);
                    transaction1.commit();

                    mIsProfileScreenLoaded = true;
                    mActivityHomeBinding.toolbarLayout.toolbarTitle.setText(R.string.current_order);

                    mActivityHomeBinding.fragmnetsContainer.setVisibility(View.VISIBLE);
                    mActivityHomeBinding.tabLayout.setVisibility(View.GONE);
                    mActivityHomeBinding.mainTabContent.setVisibility(View.GONE);
                    mActivityHomeBinding.toolbarLayout.backIcon.setVisibility(View.VISIBLE);
                    mActivityHomeBinding.toolbarLayout.menuIcon.setVisibility(View.GONE);
                    mActivityHomeBinding.noLocationPermissionLayout.setVisibility(View.GONE);
                    break;

                case AppConstants.MenuItemConstants.PROFILE_DETAILS:
                    ProfileFragment profileFragment = new ProfileFragment();
                    Bundle bundle = new Bundle();
                    profileFragment.setArguments(bundle);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(mActivityHomeBinding.fragmnetsContainer.getId(), profileFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                    mIsProfileScreenLoaded = true;
                    mActivityHomeBinding.toolbarLayout.toolbarTitle.setText(R.string.profile_info);

                    mActivityHomeBinding.fragmnetsContainer.setVisibility(View.VISIBLE);
                    mActivityHomeBinding.tabLayout.setVisibility(View.GONE);
                    mActivityHomeBinding.mainTabContent.setVisibility(View.GONE);
                    mActivityHomeBinding.toolbarLayout.backIcon.setVisibility(View.VISIBLE);
                    mActivityHomeBinding.toolbarLayout.menuIcon.setVisibility(View.GONE);
                    mActivityHomeBinding.noLocationPermissionLayout.setVisibility(View.GONE);
                    break;


                case AppConstants.MenuItemConstants.HISTORY:
                    Intent historyIntent = new Intent(HomeActivity.this, HistoryActivity.class);
                    startActivity(historyIntent);
                    break;

                case AppConstants.MenuItemConstants.RESET_PASSWORD:
                    Intent resetintent = new Intent(HomeActivity.this, ResetPasswordActivity.class);
                    startActivity(resetintent);
                    break;

                case AppConstants.MenuItemConstants.SETTINGS:
                    Intent intent = new Intent(HomeActivity.this, PreferencesActivity.class);
                    startActivityForResult(intent, AppConstants.LANGUAGE_CHANGED);
                    break;

                case AppConstants.MenuItemConstants.LOGOUT:
                    if (is_on_Trip) {
                        Toast.makeText(HomeActivity.this, "Logout not possible because you are on Trip", Toast.LENGTH_SHORT).show();
                    } else {
                        showLogoutDialog();
                    }
                    break;

            }

            mActivityHomeBinding.drawerLayout.closeDrawer(GravityCompat.START);
        }
    };

}