package ptit.nttrung.thibanglayxe.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import ptit.nttrung.thibanglayxe.GPLXApp;

/**
 * Created by TrungNguyen on 7/24/2017.
 */

public class SharedPrefsUtil {
    private static final String PREFS_NAME = "carlicense";
    private static SharedPrefsUtil mInstance;
    private SharedPreferences sharedPreferences = null;

    private SharedPrefsUtil() {
        Context context = GPLXApp.getContext();
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
    }

    public static SharedPrefsUtil getInstance() {
        if (mInstance == null) {
            mInstance = new SharedPrefsUtil();
        }
        return mInstance;
    }

    public void saveBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key, boolean defVa) {
        return sharedPreferences.getBoolean(key, defVa);
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defVa) {
        return sharedPreferences.getString(key, defVa);
    }

    public void saveInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key, int defVa) {
        return sharedPreferences.getInt(key, defVa);
    }

    public void saveFloat(String key, float value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public float getFloat(String key, float defVa) {
        return sharedPreferences.getFloat(key, defVa);
    }

    public synchronized void saveDouble(String key, double value) {
        String dValue = String.valueOf(value);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, dValue);
        editor.apply();
    }

    public synchronized double getDouble(String key, double defVa) {
        String strDefVa = String.valueOf(defVa);
        String dValue = sharedPreferences.getString(key, strDefVa);
        return (dValue.equals(strDefVa)) ? defVa : Double
                .valueOf(dValue);
    }

    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void remove(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

}
