package mersattech.barqexpdriver.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {


    //All keys in the shared preferences
    public static String CANCEL_DELIVERY_POSITION_ID = "CANCEL_DELV_ID";
    public static String ACCESS_TOKEN = "ACCESS_TOKEN";
    public static String IS_LOGGED_IN = "IS_LOGGED_IN";

    private static SharedPreferences getUserPrefs(Context context) {
        return context.getSharedPreferences("barqPref", Context.MODE_PRIVATE);
    }

    public static String getMyStringPref(Context context, String key) {
        return getUserPrefs(context).getString(key, "default");
    }

    public static int getMyIntPref(Context context, String key) {
        return getUserPrefs(context).getInt(key, 0);
    }

    public static boolean getMyBooleanPref(Context context, String key) {
        return getUserPrefs(context).getBoolean(key, false);
    }


    public static void setMyStringPref(Context context, String key, String value) {
        // perform validation etc..
        getUserPrefs(context).edit().putString(key, value).commit();
    }

    public static void setMyIntPref(Context context, String key, int value) {
        // perform validation etc..
        getUserPrefs(context).edit().putInt(key, value).commit();
    }

    public static void setMyIntPref(Context context, String key, boolean value) {
        // perform validation etc..
        getUserPrefs(context).edit().putBoolean(key, value).commit();
    }
}
