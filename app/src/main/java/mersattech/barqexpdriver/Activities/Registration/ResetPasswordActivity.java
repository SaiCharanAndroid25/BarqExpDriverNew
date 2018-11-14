package mersattech.barqexpdriver.Activities.Registration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.History.HistoryActivity;
import mersattech.barqexpdriver.Activities.HomeActivity;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordModel;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordRequestModel;
import mersattech.barqexpdriver.Models.s.ResetPassword.ResetPasswordModel;
import mersattech.barqexpdriver.Models.s.ResetPassword.ResetPasswordRequestModel;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.databinding.ActivityResetPasswordBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ResetPasswordActivity extends BaseActivity {
    ProgressDialog mProgressDialog;
    private ActivityResetPasswordBinding mActivityResetPasswordBinding;
    private View.OnClickListener mOnClickListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityResetPasswordBinding = DataBindingUtil.setContentView(ResetPasswordActivity.this,
                R.layout.activity_reset_password);

        initialiseViews();
        registerViewListeners();

        mActivityResetPasswordBinding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {
                    if (NetworkUtils.getInstance().isNetworkAvailable(ResetPasswordActivity.this)) {
                        mProgressDialog = getProgressDialog(ResetPasswordActivity.this);
                        callResetPasswordApi();
                    } else {
                        Toast.makeText(ResetPasswordActivity.this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    private void initialiseViews() {
        setToolbar(mActivityResetPasswordBinding.toolbar, getString(R.string.reset_title_text), true);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.back_icon:
                        onBackPressed();
                        break;
                }
            }
        };
    }

    private void registerViewListeners() {
        mActivityResetPasswordBinding.toolbar.backIcon.setOnClickListener(mOnClickListener);
    }



    private void callResetPasswordApi() {
        Call<ResetPasswordModel> forgotPasswordCall = NetworkUtils.getApiInterface().resetpasswordDriver(getResetPassRequest());

        forgotPasswordCall.enqueue(new Callback<ResetPasswordModel>() {
            @Override
            public void onResponse(@NonNull Call<ResetPasswordModel> call,
                                   @NonNull Response<ResetPasswordModel> response) {
                ResetPasswordModel resetpasswordModel = response.body();

                if (resetpasswordModel != null) {
                    switch (resetpasswordModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            Intent intent = new Intent(ResetPasswordActivity.this, HomeActivity.class);
                            // intent.putExtra(AppConstants.IS_FROM_FORGOT_PASS, true);
                            // intent.putExtra(AppConstants.MOBILE_NUM, mActivityForgotPasswordBinding.phoneEt.getText().toString());
                            startActivity(intent);
                            finish();
                            Toast.makeText(ResetPasswordActivity.this, "Password Changes Successfully", Toast.LENGTH_SHORT).show();
                            mProgressDialog.dismiss();
                            break;

                        default:
                            showToastMessage(ResetPasswordActivity.this, resetpasswordModel);
                            break;
                    }
                } else {
                    Toast.makeText(ResetPasswordActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<ResetPasswordModel> call, @NonNull Throwable t) {
                Toast.makeText(ResetPasswordActivity.this,
                        getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
    }

    private ResetPasswordRequestModel getResetPassRequest() {
        ResetPasswordRequestModel resetPasswordRequestModel = new ResetPasswordRequestModel();
        resetPasswordRequestModel.setMobileNumber("9959343132");
        resetPasswordRequestModel.setPassword(mActivityResetPasswordBinding.newPwdEt.getText().toString().trim());
        resetPasswordRequestModel.setPassword(mActivityResetPasswordBinding.confPwdEt.getText().toString().trim());

        return resetPasswordRequestModel;
    }
    private boolean validation() {

        mActivityResetPasswordBinding.newPwdInputLayout.setErrorEnabled(false);
        mActivityResetPasswordBinding.confPwdInputLayout.setErrorEnabled(false);

       if (TextUtils.isEmpty(mActivityResetPasswordBinding.newPwdEt.getText().
                toString().trim())) {
            mActivityResetPasswordBinding.newPwdInputLayout.setError(getString(R.string.lbl_empty_new_pwd_field));
            mActivityResetPasswordBinding.newPwdEt.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(mActivityResetPasswordBinding.confPwdEt.getText().
                toString().trim())) {
            mActivityResetPasswordBinding.confPwdInputLayout.setError(getString(R.string.lbl_empty_conf_pwd_field));
            mActivityResetPasswordBinding.confPwdEt.requestFocus();
            return false;
        } else if (! mActivityResetPasswordBinding.newPwdEt.getText().toString().equals(mActivityResetPasswordBinding.confPwdEt.getText().toString())) {
            mActivityResetPasswordBinding.confPwdInputLayout.setError("Both Passwords are not same");
            return false;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityResetPasswordBinding.unbind();
    }
}