package mersattech.barqexpdriver.Activities.Registration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.HomeActivity;
import mersattech.barqexpdriver.Activities.Login.OtpVerificationScreen;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordModel;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordRequestModel;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.databinding.ActivityForgotPasswordBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends BaseActivity {
    ProgressDialog mProgressDialog;
    private ActivityForgotPasswordBinding mActivityForgotPasswordBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityForgotPasswordBinding = DataBindingUtil.setContentView(ForgotPasswordActivity.this,
                R.layout.activity_forgot_password);

        mActivityForgotPasswordBinding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {
                    if (NetworkUtils.getInstance().isNetworkAvailable(ForgotPasswordActivity.this)) {
                        mProgressDialog = getProgressDialog(ForgotPasswordActivity.this);
                        callForgotPasswordApi();
                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void callForgotPasswordApi() {
        Call<ForgotPasswordModel> forgotPasswordCall = NetworkUtils.getApiInterface().forgotloginDriver(getForgotPassRequest());

        forgotPasswordCall.enqueue(new Callback<ForgotPasswordModel>() {
            @Override
            public void onResponse(@NonNull Call<ForgotPasswordModel> call,
                                   @NonNull Response<ForgotPasswordModel> response) {
                ForgotPasswordModel forgotpasswordModel = response.body();

                if (forgotpasswordModel != null) {
                    switch (forgotpasswordModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            Intent intent = new Intent(ForgotPasswordActivity.this, OtpVerificationScreen.class);
                            intent.putExtra(AppConstants.IS_FROM_FORGOT_PASS, true);
                            intent.putExtra(AppConstants.MOBILE_NUM, mActivityForgotPasswordBinding.phoneEt.getText().toString());
                            startActivity(intent);
                            finish();
                            mProgressDialog.dismiss();
                            break;

                        default:
                            showToastMessage(ForgotPasswordActivity.this, forgotpasswordModel);
                            break;
                    }
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<ForgotPasswordModel> call, @NonNull Throwable t) {
                Toast.makeText(ForgotPasswordActivity.this,
                        getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
    }

    private ForgotPasswordRequestModel getForgotPassRequest() {
        ForgotPasswordRequestModel forgotPasswordRequestModel = new ForgotPasswordRequestModel();
        forgotPasswordRequestModel.setMobileNumber(mActivityForgotPasswordBinding.phoneEt.getText().toString().trim());

        return forgotPasswordRequestModel;
    }

    private boolean validation() {
        mActivityForgotPasswordBinding.phoneInputLayout.setErrorEnabled(false);

        if (TextUtils.isEmpty(mActivityForgotPasswordBinding.phoneEt.getText().
                toString().trim())) {
            mActivityForgotPasswordBinding.phoneInputLayout.setError(getString(R.string.lbl_empty_phone_field));
            mActivityForgotPasswordBinding.phoneEt.requestFocus();
            return false;
        } else if (mActivityForgotPasswordBinding.phoneEt.getText().toString().length() < 10) {
            mActivityForgotPasswordBinding.phoneInputLayout.setError(getString(R.string.lbl_phone_digit_er));
            mActivityForgotPasswordBinding.phoneInputLayout.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityForgotPasswordBinding.unbind();
    }
}
