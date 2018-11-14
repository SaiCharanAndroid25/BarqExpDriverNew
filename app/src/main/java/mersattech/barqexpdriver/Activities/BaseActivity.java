package mersattech.barqexpdriver.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import java.util.Calendar;

import mersattech.barqexpdriver.Activities.Pickoupcheckout.ScanQRnImagescreen;
import mersattech.barqexpdriver.Interfaces.LocationPermissionUpdate;
import mersattech.barqexpdriver.Models.s.ForgotPassword.ForgotPasswordModel;
import mersattech.barqexpdriver.Models.s.HistoryPackage.HistoryResponse;
import mersattech.barqexpdriver.Models.s.LoginModel.DriverRegistrationModel;
import mersattech.barqexpdriver.Models.s.OtpResponse.OtpResponseModel;
import mersattech.barqexpdriver.Models.s.ResetPassword.ResetPasswordModel;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.databinding.ToolbarLayoutBinding;
import pl.aprilapps.easyphotopicker.EasyImage;

public class BaseActivity extends FragmentActivity {

    private Activity mActivity;
    private LocationPermissionUpdate mLocationPermissionUpdate;

    private boolean mIsForPhotoUpload;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setRegistrationProgressStatus(View firstView, View secondView, View thirdView,
                                              View fourthView, View fivethView) {
        int registrationProgressCount = DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getInt(AppConstants.RESTRATION_PROGRESS_KEY, 0);

        switch (registrationProgressCount) {
            case 1:
                firstView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                secondView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                thirdView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                fourthView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                fivethView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));

                break;

            case 2:
                firstView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                secondView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                thirdView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                fourthView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                fivethView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                break;

            case 3:
                firstView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                secondView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                thirdView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                fourthView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                fivethView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                break;

            case 4:
                firstView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                secondView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                thirdView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                fourthView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                fivethView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                break;

            case 5:
                firstView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                secondView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                thirdView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                fourthView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                fivethView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.app_button_color));
                break;

            default:
                firstView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                secondView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                thirdView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                fourthView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                fivethView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.text_hint_color));
                break;

        }
    }

   /* public void photoSelection(final Activity activity) {

        if (mIsForPhotoUpload) {
            final Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.profile_picture_selection_dialog);
            ImageView dialogButton = dialog.findViewById(R.id.callGallery);

            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    EasyImage.openGallery(activity, 0);
                    dialog.dismiss();
                }
            });
            ImageView dialogButton2 = dialog.findViewById(R.id.callCamera);
            dialogButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EasyImage.openCamera(activity, 2);
                    dialog.dismiss();
                }
            });

           *//* if (activity instanceof ScanQRnImagescreen) {
                EasyImage.openCamera(activity, 2);
            } else {
                dialog.show();
            }*//*

            Window window = dialog.getWindow();
            if (window != null)
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        } else {
            moveToScanActivity(mActivity);
        }
    }*/

    public void checkPermissions(Activity activity, String permission,
                                 LocationPermissionUpdate mLocationPermissionUpdate, boolean isForPhotoUpload) {

        this.mActivity = activity;
        this.mLocationPermissionUpdate = mLocationPermissionUpdate;
        this.mIsForPhotoUpload = isForPhotoUpload;

        switch (permission) {

            case Manifest.permission.CAMERA:

                if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {

                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

                        //This is called if user has denied the permission before
                        //In this case I am just asking the permission again
                        ActivityCompat.requestPermissions(activity, new String[]{permission}, AppConstants.CAMERA_PERMISSION);

                    } else {

                        ActivityCompat.requestPermissions(activity, new String[]{permission}, AppConstants.CAMERA_PERMISSION);
                    }
                } else {
                    photoSelection(activity);
                }
                break;

            case Manifest.permission.ACCESS_FINE_LOCATION:

                if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {

                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

                        //This is called if user has denied the permission before
                        //In this case I am just asking the permission again
                        ActivityCompat.requestPermissions(activity, new String[]{permission}, AppConstants.LOCATION);

                    } else {

                        ActivityCompat.requestPermissions(activity, new String[]{permission}, AppConstants.LOCATION);
                    }

                    mLocationPermissionUpdate.isLocationPermissionGranted(false);
                } else {
                    mLocationPermissionUpdate.isLocationPermissionGranted(true);
                }
                break;

        }
    }

    public void photoSelection(final Activity activity) {

        if (mIsForPhotoUpload) {
            final Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.profile_picture_selection_dialog);
            ImageView dialogButton = dialog.findViewById(R.id.callGallery);

            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    EasyImage.openGallery(activity, 0);
                    dialog.dismiss();
                }
            });
            ImageView dialogButton2 = dialog.findViewById(R.id.callCamera);
            dialogButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EasyImage.openCamera(activity, 2);
                    dialog.dismiss();
                }
            });

            if (activity instanceof ScanQRnImagescreen) {
                EasyImage.openCamera(activity, 2);
            } else {
                dialog.show();
            }


            Window window = dialog.getWindow();
            if (window != null)
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        } else {
            moveToScanActivity(mActivity);
        }
    }

    public void checkPermissionsForScan(Activity activity, String permission) {

        this.mActivity = activity;
        this.mLocationPermissionUpdate = mLocationPermissionUpdate;

        switch (permission) {

            case Manifest.permission.CAMERA:

                if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {

                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

                        //This is called if user has denied the permission before
                        //In this case I am just asking the permission again
                        ActivityCompat.requestPermissions(activity, new String[]{permission}, AppConstants.CAMERA_PERMISSION_SCAN_BUTTON);

                    } else {

                        ActivityCompat.requestPermissions(activity, new String[]{permission}, AppConstants.CAMERA_PERMISSION_SCAN_BUTTON);
                    }

                  //  return false;
                } else {
                  //  return true;
                }
                break;

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case AppConstants.CAMERA_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                 //   photoSelection(mActivity);
                } else {
                    return;
                }
                break;

            case AppConstants.LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionUpdate.isLocationPermissionGranted(true);
                  //  LocationService.getInstance(this);

                } else {
                    mLocationPermissionUpdate.isLocationPermissionGranted(false);
                }
                break;

            case AppConstants.CAMERA_PERMISSION_SCAN_BUTTON:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    moveToScanActivity(mActivity);
                } else {
                    return;
                }
                break;
        }
    }

    private void moveToScanActivity(Activity mActivity) {
       /* Intent intent = new Intent(mActivity, ScanQRnImagescreen.class);
        //todo to get the delivery stage
        intent.putExtra("TYPE", 1);
        startActivity(intent);*/
    }


    public void showToastMessage(Context context, DriverRegistrationModel driverRegistrationModel) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (driverRegistrationModel.getMessage() != null) {
                Toast.makeText(context,
                        driverRegistrationModel.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (driverRegistrationModel.getEnglishMessage() != null) {
                Toast.makeText(context,
                        driverRegistrationModel.getEnglishMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, HistoryResponse getHistoryResponse) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (getHistoryResponse.getMessage() != null) {
                Toast.makeText(context,
                        getHistoryResponse.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (getHistoryResponse.getEnglishMessage() != null) {
                Toast.makeText(context,
                        getHistoryResponse.getEnglishMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, ForgotPasswordModel forgotpasswordResponse) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (forgotpasswordResponse.getMessage() != null) {
                Toast.makeText(context,
                        (Integer) forgotpasswordResponse.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (forgotpasswordResponse.getEnglishMessage() != null) {
                Toast.makeText(context,
                        (Integer) forgotpasswordResponse.getEnglishMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, ResetPasswordModel resetPasswordModel) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (resetPasswordModel.getMessage() != null) {
                Toast.makeText(context,
                        resetPasswordModel.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (resetPasswordModel.getEnglishMessage() != null) {
                Toast.makeText(context,
                        resetPasswordModel.getEnglishMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, OtpResponseModel driverDocsResponseModel) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (driverDocsResponseModel.getMessage() != null) {
                Toast.makeText(context,
                        (Integer) driverDocsResponseModel.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (driverDocsResponseModel.getEnglishMessage() != null) {
                Toast.makeText(context, (String)driverDocsResponseModel.getEnglishMessage(),Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

   /*
   public void showToastMessage(Context context, BankDetailsResponseModel bankDetailsResponseModel) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (bankDetailsResponseModel.getMessage() != null) {
                Toast.makeText(context,
                        bankDetailsResponseModel.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (bankDetailsResponseModel.getEnglishMessage() != null) {
                Toast.makeText(context,
                        bankDetailsResponseModel.getEnglishMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, AddVehicleDetailsResponseModel addVehicleDetailsResponseModel) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (addVehicleDetailsResponseModel.getMessage() != null) {
                Toast.makeText(context,
                        addVehicleDetailsResponseModel.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (addVehicleDetailsResponseModel.getEnglishMessage() != null) {
                Toast.makeText(context,
                        addVehicleDetailsResponseModel.getEnglishMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, OtpResponseModel otpResponseModel) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (otpResponseModel.getMessage() != null) {
                Toast.makeText(context,
                        otpResponseModel.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (otpResponseModel.getEnglishMessage() != null) {
                Toast.makeText(context,
                        otpResponseModel.getEnglishMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, PaymentSummaryResponse paymentSummaryResponse) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (paymentSummaryResponse.getMessage() != null) {
                Toast.makeText(context,
                        paymentSummaryResponse.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (paymentSummaryResponse.getEnglishMessage() != null) {
                Toast.makeText(context,
                        paymentSummaryResponse.getEnglishMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, SingleBankResponse singleBankResponse) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (singleBankResponse.getMessage() != null) {
                Toast.makeText(context,
                        singleBankResponse.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (singleBankResponse.getEnglishMessage() != null) {
                Toast.makeText(context,
                        singleBankResponse.getEnglishMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showToastMessage(Context context, GetComapnyBankDetailsResponse getComapnyBankDetailsResponse) {
        if ((DataUtils.getInstance().getDefaultSharedPreferences(
                getApplicationContext()).getString(
                AppConstants.LANGUAGE_SELECTED_KEY, "")
                .equals(AppConstants.ARABIC_LANG))) {
            if (getComapnyBankDetailsResponse.getMessage() != null) {
                Toast.makeText(context,
                        getComapnyBankDetailsResponse.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            if (getComapnyBankDetailsResponse.getEnglishMessage() != null) {
                Toast.makeText(context,
                        getComapnyBankDetailsResponse.getEnglishMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,
                        getResources().getString(R.string.api_failure_message),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    public String stringNullCheck(Object object) {
        if (object == null) {
            return "";
        } else {
            return object.toString();
        }
    }

    public ProgressDialog getProgressDialog(Context context) {
        return ProgressDialog.show(context, "", "Loading please wait..", true);
    }

    public int getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public int getAgeByHijri(int year, int month, int day) {
        UmmalquraCalendar dob = new UmmalquraCalendar();
        UmmalquraCalendar today = new UmmalquraCalendar();

        dob.set(year, month, day);

        int age = today.get(UmmalquraCalendar.YEAR) - dob.get(UmmalquraCalendar.YEAR);

        if (today.get(UmmalquraCalendar.DAY_OF_YEAR) < dob.get(UmmalquraCalendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public String getToken(Context context) {
        return DataUtils.getInstance().getDefaultSharedPreferences(context).getString(
                AppConstants.TOKEN, "");
    }

    public int getCountryId(Context context) {
        return DataUtils.getInstance().getDefaultSharedPreferences(context).getInt(
                "countryId",0);
    }


    public String getDate(String date, boolean isHijri) {
        String finalDate;

        if (isHijri) {
            String[] separated = date.split("-");
            UmmalquraCalendar uCal = new UmmalquraCalendar(Integer.parseInt(separated[2]),
                    Integer.parseInt(separated[1]), Integer.parseInt(separated[0]));

            finalDate = "" + uCal.get(UmmalquraCalendar.DAY_OF_MONTH) + "/" +
                    uCal.get(UmmalquraCalendar.MONTH) + "/" + uCal.get(UmmalquraCalendar.YEAR);
        } else {
            String[] separated = date.split("-");
            finalDate = separated[2] + "-" + separated[1] + "-" + separated[0];
        }

        return finalDate;
    }

    public void setToolbar(ToolbarLayoutBinding toolbar, String toolbarTitle, boolean isBackVisible) {

        toolbar.toolbarTitle.setText(toolbarTitle);
        if (isBackVisible)
            toolbar.backIcon.setVisibility(View.VISIBLE);
    }


}