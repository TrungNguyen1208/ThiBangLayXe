package ptit.nttrung.thibanglayxe.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Util {
    public static final String CLASS_OF_LICENSE = "classoflicense";
    public static final String FINISHGUIDE = "finishguide";
    public static final String SharedPreferencesName = "carlicense";
    public static final boolean isDisplayAds = false;

    public static void setIsRated(Context mContext) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(SharedPreferencesName, 0).edit();
        editor.putBoolean("isRated", true);
        editor.commit();
    }

    public static boolean isRated(Context mContext) {
        return mContext.getSharedPreferences(SharedPreferencesName, 0).getBoolean("isRated", false);
    }

    public static void setIsClickAds(Context mContext) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(SharedPreferencesName, 0).edit();
        editor.putBoolean("isClickedAds", true);
        editor.commit();
    }

    public static boolean IsClickAds(Context mContext) {
        return mContext.getSharedPreferences(SharedPreferencesName, 0).getBoolean("isClickedAds", false);
    }

    public static int getWidthScreen(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    @SuppressLint("WrongConstant")
    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}