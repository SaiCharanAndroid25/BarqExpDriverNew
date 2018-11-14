package mersattech.barqexpdriver.Activities.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.Registration.ResetPasswordActivity;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordRequestModel;
import mersattech.barqexpdriver.Models.s.OtpResponse.OtpResponseModel;
import mersattech.barqexpdriver.Models.s.ResetPassword.DriverActivateAccRequestModel;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.databinding.ActivityOtpVerficationScreenBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mersat-tech on 07/11/2017.
 * Otp Verfication Screen
 */

public class OtpVerificationScreen extends BaseActivity {

    private ActivityOtpVerficationScreenBinding mOtpVerficationScreenBinding;
    private View.OnClickListener mOnClickListener;
    private Call<OtpResponseModel> mVerifyOtpCall;
    private Call<OtpResponseModel> mVerifyConfirmationCodeCall;
    private Call<OtpResponseModel> mResendOTPCall;
    private String mMobileNum;
    private Boolean mIsFromForgotPassword;

    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOtpVerficationScreenBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_otp_verfication_screen);

        if (getIntent() != null) {
            mIsFromForgotPassword = getIntent().getBooleanExtra(AppConstants.IS_FROM_FORGOT_PASS, false);
        }

        if (getIntent() != null)
            mMobileNum = getIntent().getStringExtra(AppConstants.MOBILE_NUM);


        initializeViews();
        registerViewListeners();

        mOtpVerficationScreenBinding.verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mOtpVerficationScreenBinding.otpEt.getText().toString())) {
                    mOtpVerficationScreenBinding.otpEt.setError(getString(R.string.enter_otp));
                    mOtpVerficationScreenBinding.otpEt.requestFocus();

                } else {
                    mProgressDialog = getProgressDialog(OtpVerificationScreen.this);
                    if (NetworkUtils.getInstance().isNetworkAvailable(OtpVerificationScreen.this)) {
                        if (mIsFromForgotPassword) {
                            callVerifyConfimationCode();
                        } else {
                            callVerifyOtpApi();
                        }
                    } else {
                        Toast.makeText(OtpVerificationScreen.this,
                                getString(R.string.no_network_message),
                                Toast.LENGTH_SHORT).show();
                        mProgressDialog.dismiss();
                    }
                }
            }
        });
        mOtpVerficationScreenBinding.resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog = getProgressDialog(OtpVerificationScreen.this);
                if (NetworkUtils.getInstance().isNetworkAvailable(OtpVerificationScreen.this)) {
                    mOtpVerficationScreenBinding.otpEt.setText("");
                    callResendOtp();
                } else {
                    Toast.makeText(OtpVerificationScreen.this,
                            getString(R.string.no_network_message),
                            Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                }
            }
        });

     /*   mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.verify_btn:
                        Toast.makeText(OtpVerificationScreen.this,"VERIFY CLICKED",
                                Toast.LENGTH_SHORT).show();
                        if (TextUtils.isEmpty(mOtpVerficationScreenBinding.otpEt.getText().toString())) {
                            mOtpVerficationScreenBinding.otpEt.setError(getString(R.string.enter_otp));
                            mOtpVerficationScreenBinding.otpEt.requestFocus();

                        } else {
                            mProgressDialog = getProgressDialog(OtpVerificationScreen.this);
                            if (NetworkUtils.getInstance().isNetworkAvailable(OtpVerificationScreen.this)) {
                                if (mIsFromForgotPassword) {
                                    callVerifyConfimationCode();
                                } else {
                                    callVerifyOtpApi();
                                }
                            } else {
                                Toast.makeText(OtpVerificationScreen.this,
                                        getString(R.string.no_network_message),
                                        Toast.LENGTH_SHORT).show();
                                mProgressDialog.dismiss();
                            }
                        }
                        break;

                    case R.id.resend_btn:
                        mProgressDialog = getProgressDialog(OtpVerificationScreen.this);
                        Toast.makeText(OtpVerificationScreen.this,"OTP RESEND CLICKED",
                                Toast.LENGTH_SHORT).show();
                        if (NetworkUtils.getInstance().isNetworkAvailable(OtpVerificationScreen.this)) {
                            mOtpVerficationScreenBinding.otpEt.setText("");
                            callResendOtp();
                        } else {
                            Toast.makeText(OtpVerificationScreen.this,
                                    getString(R.string.no_network_message),
                                    Toast.LENGTH_SHORT).show();
                            mProgressDialog.dismiss();
                        }
                        break;
                }
            }
        };*/


        String mobileNum = DataUtils.getInstance().getDefaultSharedPreferences(OtpVerificationScreen.this).
                getString(AppConstants.PHONE_NUMBER, "");
    }

    private void callResendOtp() {
        mResendOTPCall = NetworkUtils.getApiInterface().resendOtp(getResendOtpRequestBody());

        mResendOTPCall.enqueue(new Callback<OtpResponseModel>() {
            @Override
            public void onResponse(Call<OtpResponseModel> call, Response<OtpResponseModel> response) {
                OtpResponseModel driverRegistrationModel = response.body();

                if (driverRegistrationModel != null) {
                    switch (driverRegistrationModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                           // mOtpVerficationScreenBinding.otpEt.setText("OTP sent");
//                            mOtpVerficationScreenBinding.otpEt.setText(driverRegistrationModel.getEntity().
////                                    getActivationCode());
                            break;

                        default:
                            showToastMessage(OtpVerificationScreen.this, driverRegistrationModel);
                            break;
                    }
                } else {
                    Toast.makeText(OtpVerificationScreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }

                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<OtpResponseModel> call, @NonNull Throwable t) {
                Toast.makeText(OtpVerificationScreen.this,
                        getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();

                mProgressDialog.dismiss();
            }
        });
    }

    private ForgotPasswordRequestModel getResendOtpRequestBody() {
        ForgotPasswordRequestModel forgotPasswordRequestModel = new ForgotPasswordRequestModel();
        forgotPasswordRequestModel.setMobileNumber(mMobileNum);
        return forgotPasswordRequestModel;
    }

    private void callVerifyConfimationCode() {
        mVerifyConfirmationCodeCall = NetworkUtils.getApiInterface().verifyConfirmationCode(/*getRequestUrl()*/
                mMobileNum, mOtpVerficationScreenBinding.otpEt.getText().toString().trim());

        mVerifyConfirmationCodeCall.enqueue(new Callback<OtpResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<OtpResponseModel> call,
                                   @NonNull Response<OtpResponseModel> response) {
                OtpResponseModel otpResponseModel = response.body();

                if (otpResponseModel != null) {
                    switch (otpResponseModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            Intent intent = new Intent(OtpVerificationScreen.this, ResetPasswordActivity.class);
                            intent.putExtra(AppConstants.MOBILE_NUM, mMobileNum);
                            startActivity(intent);
                            finish();
                            break;

                        default:
                            showToastMessage(OtpVerificationScreen.this, otpResponseModel);
                            break;
                    }
                } else {
                    Toast.makeText(OtpVerificationScreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }

                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<OtpResponseModel> call, @NonNull Throwable t) {
                Toast.makeText(OtpVerificationScreen.this,
                        getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();

                mProgressDialog.dismiss();
            }
        });
    }

    private String getRequestUrl() {
        return mMobileNum + "/" + mOtpVerficationScreenBinding.otpEt.getText().toString().trim();
    }

    private void callVerifyOtpApi() {
        mVerifyOtpCall = NetworkUtils.getApiInterface().verifyOtpDriver(getActivateAccRequest());
        mVerifyOtpCall.enqueue(new Callback<OtpResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<OtpResponseModel> call,
                                   @NonNull Response<OtpResponseModel> response) {
                OtpResponseModel otpResponseModel = response.body();

                if (otpResponseModel != null) {
                    switch (otpResponseModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            Intent intent = new Intent(OtpVerificationScreen.this, LoginActivity.class);
                            intent.putExtra(AppConstants.MOBILE_NUM, mMobileNum);
                            startActivity(intent);
                            finish();
                            break;

                        default:
                            showToastMessage(OtpVerificationScreen.this, otpResponseModel);
                            break;
                    }
                } else {
                    Toast.makeText(OtpVerificationScreen.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<OtpResponseModel> call, @NonNull Throwable t) {
                Toast.makeText(OtpVerificationScreen.this,
                        getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();

                mProgressDialog.dismiss();
            }
        });
    }

    private DriverActivateAccRequestModel getActivateAccRequest() {
        DriverActivateAccRequestModel driverActivateAccRequestModel = new DriverActivateAccRequestModel();
        driverActivateAccRequestModel.setMobileNumber(mMobileNum);
        driverActivateAccRequestModel.setActivationCode(mOtpVerficationScreenBinding.
                otpEt.getText().toString().trim());
        return driverActivateAccRequestModel;
    }

    private void initializeViews() {
        mOtpVerficationScreenBinding.toolbar.toolbarTitle.setText(getString(R.string.otp_verification));
        mOtpVerficationScreenBinding.toolbar.backIcon.setVisibility(View.VISIBLE);
        mOtpVerficationScreenBinding.toolbar.registrationProgressLayout.setVisibility(View.GONE);
        mOtpVerficationScreenBinding.toolbar.menuIcon.setVisibility(View.GONE);

        mOtpVerficationScreenBinding.toolbar.backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    private void registerViewListeners() {
        mOtpVerficationScreenBinding.verifyBtn.setOnClickListener(mOnClickListener);
        mOtpVerficationScreenBinding.resendBtn.setOnClickListener(mOnClickListener);

        mOtpVerficationScreenBinding.otpEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    mOtpVerficationScreenBinding.verifyBtn.setClickable(true);
                    mOtpVerficationScreenBinding.verifyBtn.setBackgroundTintList(
                            ContextCompat.getColorStateList(getApplicationContext(), R.color.dark_app_button_color));
                    mOtpVerficationScreenBinding.verifyBtn.setTextColor(ContextCompat.
                            getColor(getApplicationContext(), R.color.white));

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOtpVerficationScreenBinding.unbind();
    }
}
