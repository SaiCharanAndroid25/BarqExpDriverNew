package mersattech.barqexpdriver.Activities.Login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.HomeActivity;
import mersattech.barqexpdriver.Activities.Preferences.PreferencesActivity;
import mersattech.barqexpdriver.Activities.Registration.ForgotPasswordActivity;
import mersattech.barqexpdriver.DemoPackage.DemoActivity;
import mersattech.barqexpdriver.Models.s.LoginModel.DriverLoginRequestModel;
import mersattech.barqexpdriver.Models.s.LoginModel.DriverRegistrationModel;
import mersattech.barqexpdriver.Models.s.LoginModel.TokenResponse;
import mersattech.barqexpdriver.Models.s.Preferences.PreferenceResponseBody;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.Utils.MySharedPreferences;
import mersattech.barqexpdriver.databinding.ActivityLoginScreenBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static mersattech.barqexpdriver.Utils.MySharedPreferences.ACCESS_TOKEN;


public class LoginActivity extends BaseActivity {

    String mMobileNum;
    SharedPreferences sharedPreferences;
    private ActivityLoginScreenBinding mActivityLoginScreenBinding;
    private View.OnClickListener mOnClickListener;
    private Call<DriverRegistrationModel> mLoginCall;
    private Call<TokenResponse> mTokenResponse;
    private Boolean mIsFromResetPassword;
    private ProgressDialog mProgressDialog;
    private DriverRegistrationModel driverRegistrationModel;
    private int mLanguagePref;
    SharedPreferences spf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_screen);

       // spf = getSharedPreferences("myPref", Context.MODE_PRIVATE);


        if (getIntent() != null) {
            mIsFromResetPassword = getIntent().getBooleanExtra("isFromResetPassScreen", false);
            mMobileNum = getIntent().getStringExtra("mobile_number");
            mActivityLoginScreenBinding.loginUserIdEt.setText(mMobileNum);
            mActivityLoginScreenBinding.loginUserIdEt.setSelection(mActivityLoginScreenBinding.
                    loginUserIdEt.length());

            mActivityLoginScreenBinding.loginUserIdEt.requestFocus();
        }

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.login_btn:
                        if (validateInputFields()) {
                            if (NetworkUtils.getInstance().isNetworkAvailable(LoginActivity.this)) {
                                mProgressDialog = getProgressDialog(LoginActivity.this);
                                callLoginApi();
                            } else {
                                Toast.makeText(LoginActivity.this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;

                    case R.id.forgot_pass_tv:
                        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                        startActivity(intent);
                        break;
                }
            }

        };

        registerViewListeners();
    }

    private void callLoginApi() {
        mLoginCall = NetworkUtils.getApiInterface().loginDriver(getLoginRequest());

        mLoginCall.enqueue(new Callback<DriverRegistrationModel>() {
            @Override
            public void onResponse(Call<DriverRegistrationModel> call,
                                   Response<DriverRegistrationModel> response) {
                driverRegistrationModel = response.body();

                if (driverRegistrationModel != null) {
                    sharedPreferences = DataUtils.getInstance().
                            getDefaultSharedPreferences(LoginActivity.this);

                    switch (driverRegistrationModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:

                            sharedPreferences.edit().putInt(AppConstants.USER_ID, driverRegistrationModel
                                    .getEntity().getID()).commit();

                            if (driverRegistrationModel.getEntity().getDriverId() != 0)
                                sharedPreferences.edit().putInt(AppConstants.DRIVER_ID, driverRegistrationModel.getEntity().getDriverId()).commit();

                            sharedPreferences.edit().putString(AppConstants.TOKEN, driverRegistrationModel.getEntity().getToken()).commit();


                         /*   SharedPreferences pref = getApplicationContext().getSharedPreferences("login_pref", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("token", driverRegistrationModel.getEntity().getToken());
                            editor.commit();*/

                            sharedPreferences.edit().putBoolean("isLoggedIn", true).commit();

                            if (driverRegistrationModel.getEntity().getBankID() != null)
                                sharedPreferences.edit().putString(AppConstants.BANK_ID, driverRegistrationModel
                                        .getEntity().getBankID().toString()).commit();

                            if (driverRegistrationModel.getEntity().getVehicleID() != 0)
                                sharedPreferences.edit().putInt(AppConstants.VEHICLE_ID, driverRegistrationModel
                                        .getEntity().getVehicleID()).commit();

                            sharedPreferences.edit().putString(AppConstants.PHONE_NUMBER,
                                    driverRegistrationModel.getEntity().getMobileNumber().toString()).commit();

                            sharedPreferences.edit().putBoolean("isLoggedIn", true).commit();

                            if (driverRegistrationModel.getEntity().getPhotographId() != null)
                                sharedPreferences.edit().putString("profileImageId", driverRegistrationModel.
                                        getEntity().getPhotographId().toString()).commit();

                            if (driverRegistrationModel.getEntity().getName() != null) {
                                if (!driverRegistrationModel.getEntity().getName().equals("")) {
                                    sharedPreferences.edit().putString("name", driverRegistrationModel.
                                            getEntity().getName()).commit();
                                }
                            }

                            if (driverRegistrationModel.getEntity().getEmail() != null &&
                                    !driverRegistrationModel.getEntity().getEmail().equals("")) {
                                sharedPreferences.edit().putString("email", driverRegistrationModel.
                                        getEntity().getEmail()).commit();
                            }

                            if (driverRegistrationModel.getEntity().getMobileNumber() != null &&
                                    !driverRegistrationModel.getEntity().getMobileNumber().equals("")) {
                                sharedPreferences.edit().putString("MobileNumber", driverRegistrationModel.
                                        getEntity().getMobileNumber()).commit();
                            }

                            if (driverRegistrationModel.getEntity().getCountryID() != 0 ) {
                                sharedPreferences.edit().putInt("countryId", driverRegistrationModel.
                                        getEntity().getCountryID()).commit();
                            }
                            if (driverRegistrationModel.getEntity().getLanguage() != 0) {
                                sharedPreferences.edit().putInt(AppConstants.LANGUAGE_SELECTED,
                                        driverRegistrationModel.getEntity().getLanguage()).commit();

                                switch (driverRegistrationModel.getEntity().getLanguage()) {
                                    case 1:
                                        DataUtils.setLocale(getApplicationContext(), AppConstants.ENGLISH_LANG);
                                        break;

                                    case 2:
                                        DataUtils.setLocale(getApplicationContext(), AppConstants.ARABIC_LANG);
                                        break;

                                    default:
                                        DataUtils.setLocale(getApplicationContext(), AppConstants.ENGLISH_LANG);
                                        break;
                                }
                            }
                            sharedPreferences.edit().putBoolean(AppConstants.IS_ONLINE,
                                    driverRegistrationModel.getEntity().isOnline()).apply();
                            if (NetworkUtils.getInstance().isNetworkAvailable(LoginActivity.this)) {
                              //  getToken(true);
                                if(driverRegistrationModel != null)
                                {
                                    switch (driverRegistrationModel.getStatus())
                                    {
                                        case 0 :
                                               // Intent intent = new Intent(LoginActivity.this, DemoActivity.class);
                                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                                intent.putExtra(AppConstants.FROM_LOGIN, true);
                                                startActivity(intent);
                                                finish();

                                            sharedPreferences.edit().putBoolean("Pref_Set", true).apply();
                                            break;
                                        case 1 :
                                            Toast.makeText(LoginActivity.this, "Preferences Not Set", Toast.LENGTH_SHORT).show();
                                            Intent intent1 = new Intent(LoginActivity.this,PreferencesActivity.class);
                                            intent1.putExtra(AppConstants.FROM_LOGIN, true );
                                            startActivity(intent1);
                                            finish();
                                            break;
                                    }
                                }else
                                {
                                    Toast.makeText(LoginActivity.this, "No Repsonse from Driver Preference", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, getString(
                                        R.string.no_network_message), Toast.LENGTH_SHORT).show();
                            }

                            break;

//                        case NetworkConstants.RESPONSE_NO_DATA_FOUND:
//                            showToastMessage(LoginScreen.this, driverRegistrationModel);
//                            break;
//
                        case NetworkConstants.RESPONSE_NOT_ACTIVE:
                            if (NetworkUtils.getInstance().isNetworkAvailable(LoginActivity.this)) {
                              //  getToken(false);
                            } else {
                                Toast.makeText(LoginActivity.this, getString(
                                        R.string.no_network_message), Toast.LENGTH_SHORT).show();
                            }
                            showToastMessage(LoginActivity.this, driverRegistrationModel);
                            break;

                        case 4:
                            Toast.makeText(LoginActivity.this, "Driver is not approved, Please contact administrator", Toast.LENGTH_LONG).show();
                            break;

                        default:
                            showToastMessage(LoginActivity.this, driverRegistrationModel);
                            break;
                    }

                } else {
                    Toast.makeText(LoginActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<DriverRegistrationModel> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(LoginActivity.this,
                        getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

   /* private void getToken(final boolean b) {
        mTokenResponse = NetworkUtils.getApiInterface().getTokenResponse(getHashmap());
        mTokenResponse.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.body() != null) {
                    String auth = response.body().getTokenType() + " " + response.body().getAccessToken();
                    Log.d("orderid", response.body().getAccessToken());
                    sharedPreferences.edit().putString(AppConstants.TOKEN, auth).commit();
                    MySharedPreferences.setMyStringPref(getApplicationContext(), ACCESS_TOKEN, auth);
                    Log.d("token","login2  "+auth);
                      checkforpreference(b);

                } else {
                    Toast.makeText(LoginActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private HashMap getHashmap() {
        HashMap<String, String> mHashMap = new HashMap<>();
        mHashMap.put("username", mActivityLoginScreenBinding.loginUserIdEt.getText().toString().trim());
        mHashMap.put("password", mActivityLoginScreenBinding.loginPasswordEt.getText().toString().trim());
        mHashMap.put("grant_type", "password");
        return mHashMap;
    }*/

    private void checkforpreference(final boolean b) {
        Call<PreferenceResponseBody> getDriverPreferences = NetworkUtils.getApiInterface().getPreferences(getToken(this));

        getDriverPreferences.enqueue(new Callback<PreferenceResponseBody>() {
            @Override
            public void onResponse(Call<PreferenceResponseBody> call, Response<PreferenceResponseBody> response) {
                PreferenceResponseBody preferenceResponseBody = response.body();
                if(preferenceResponseBody != null)
                {
                    switch (preferenceResponseBody.getStatus())
                    {
                        case 0 :
                            if (b) {
                                Intent intent = new Intent(LoginActivity.this, DemoActivity.class);
                            //    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                intent.putExtra(AppConstants.FROM_LOGIN, true);
                                startActivity(intent);
                                finish();
                            } else {
                                Intent intent = new Intent(LoginActivity.this, DemoActivity.class);
                                intent.putExtra(AppConstants.FROM_LOGIN, true);
                                startActivity(intent);
                                finish();
                            }
                            sharedPreferences.edit().putBoolean("Pref_Set", true).apply();
                            break;
                        case 3 :
                            Toast.makeText(LoginActivity.this, "Preferences Not Set", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,PreferencesActivity.class);
                            intent.putExtra(AppConstants.FROM_LOGIN, true );
                            startActivity(intent);
                            finish();
                            break;

                    }


                }else
                {

                    Toast.makeText(LoginActivity.this, "No Repsonse from Driver Preference", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PreferenceResponseBody> call, Throwable t) {

            }
        });
    }

    public DriverLoginRequestModel getLoginRequest() {
        DriverLoginRequestModel driverLoginRequestModel = new DriverLoginRequestModel();
        driverLoginRequestModel.setMobileNumber(mActivityLoginScreenBinding.loginUserIdEt.getText().toString().trim());
        driverLoginRequestModel.setPassword(mActivityLoginScreenBinding.loginPasswordEt.getText().toString().trim());
        return driverLoginRequestModel;
    }

    private boolean validateInputFields() {

        mActivityLoginScreenBinding.loginUserIdLayout.setErrorEnabled(false);
        mActivityLoginScreenBinding.loginPasswordLayout.setErrorEnabled(false);

        if (TextUtils.isEmpty(mActivityLoginScreenBinding.loginUserIdEt.getText().
                toString().trim())) {
            mActivityLoginScreenBinding.loginUserIdLayout.setError(getString(R.string.lbl_empty_phone_field));
            mActivityLoginScreenBinding.loginUserIdEt.requestFocus();
            return false;
        } else if (mActivityLoginScreenBinding.loginUserIdEt.getText().toString().length() < 10) {
            mActivityLoginScreenBinding.loginUserIdLayout.setError(getString(R.string.lbl_phone_digit_er));
            mActivityLoginScreenBinding.loginUserIdEt.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(mActivityLoginScreenBinding.
                loginPasswordEt.getText().toString())) {
            mActivityLoginScreenBinding.loginPasswordLayout.setError(getString(R.string.lbl_empty_pass_er));
            mActivityLoginScreenBinding.loginPasswordEt.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void registerViewListeners() {
        mActivityLoginScreenBinding.loginBtn.setOnClickListener(mOnClickListener);
        mActivityLoginScreenBinding.forgotPassTv.setOnClickListener(mOnClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
     //   mActivityLoginScreenBinding.unbind();
    }
}