package mersattech.barqexpdriver.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPreferences {

    private SharedPreferences sharedPreferences;
    private  static  AppPreferences appPreferences;
    public static final String TOKEN = "token";

    public AppPreferences(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static AppPreferences getAppPreferences(Context context) {
        if (appPreferences == null) {
            appPreferences = new AppPreferences(context);
        }
        return appPreferences;
    }

    public void putString(String key, String value) {
        try {
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();
            prefEdit.putString(key, value);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getString(String key, String defValue) throws ClassCastException {
        return sharedPreferences.getString(key, defValue);
    }

    public void putInt(String key, Integer value) {
        try {
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();
            prefEdit.putInt(key, value);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getInt(String key, Integer defValue) throws ClassCastException {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putLong(String key, Long value) {
        try {
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();
            prefEdit.putLong(key, value);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getLong(String key, Long defValue) throws ClassCastException {
        return sharedPreferences.getLong(key, defValue);
    }

    public void putBoolean(String key, Boolean defValue) {
        try {
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();
            prefEdit.putBoolean(key, defValue);
            prefEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean getBoolean(String key, Boolean defValue) throws ClassCastException {
        return sharedPreferences.getBoolean(key, defValue);
    }
}
