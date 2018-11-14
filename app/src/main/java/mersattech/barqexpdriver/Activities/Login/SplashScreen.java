package mersattech.barqexpdriver.Activities.Login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.HomeActivity;
import mersattech.barqexpdriver.Activities.Preferences.PreferencesActivity;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends BaseActivity {
    private ActivitySplashScreenBinding mActivitySplashScreenBinding;
    private boolean isLoggedIn;
    private boolean isPrefSet;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySplashScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);
      //  LocationService.getInstance(this).getLocation();
        SharedPreferences sharedPreferences = DataUtils.getInstance().getDefaultSharedPreferences(getApplicationContext());

        int languageSelected = sharedPreferences.getInt(AppConstants.LANGUAGE_SELECTED, 1);
//        if (!TextUtils.isEmpty(mLanguageSelected)) {
        if (languageSelected == 1) {
            DataUtils.setLocale(getApplicationContext(), AppConstants.ENGLISH_LANG);
        } else {
            DataUtils.setLocale(getApplicationContext(), AppConstants.ARABIC_LANG);
        }
//        }

        SharedPreferences getPref = getSharedPreferences("login_pref", Context.MODE_PRIVATE);
         s = getPref.getString("token","0");

        isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        isPrefSet = sharedPreferences.getBoolean("Pref_Set", false);
        if (ContextCompat.checkSelfPermission(SplashScreen.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            sharedPreferences.edit().putBoolean("isLocationPermissionGranted", false).apply();
        } else {
            sharedPreferences.edit().putBoolean("isLocationPermissionGranted", true).apply();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!isPrefSet && isLoggedIn) {
                    Toast.makeText(SplashScreen.this, "Preferences not set correctly ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SplashScreen.this, PreferencesActivity.class);
                    intent.putExtra(AppConstants.FROM_LOGIN, true);
                    startActivity(intent);
                } else if(isLoggedIn){
                    Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                    intent.putExtra(AppConstants.FROM_LOGIN, true);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                    intent.putExtra(AppConstants.IS_FROM_REGISTRATION, true);
                    startActivity(intent);
                }

                finish();

            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mActivitySplashScreenBinding.unbind();
    }
}