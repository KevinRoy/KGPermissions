package com.kevin.kgpermissions;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * 处理一些sharePreference
 * Created by kevin on 16/3/7.
 */
public class KGPermissionsShared {
    private static final String TAG = "KGPermissionsShared";
    private static SharedPreferences mSharedPreferences;
    private static Context mContext;

    public static final String SHAREPRE_NAME = "KGPermissions";
    public static final String PERMISSIONS_NAME = "permissions_name";

    public static void init(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHAREPRE_NAME, Context.MODE_PRIVATE);
        mContext = context;
    }

    private static SharedPreferences getSharedPreferences() {
        if (mSharedPreferences == null) {
            Log.e(TAG, "SharedPreferences is null");
            return null;
        }
        return mSharedPreferences;
    }

    public static void putFirstPermission(String permissionName, boolean isFirstPermission) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(permissionName, isFirstPermission);
        editor.commit();
    }

    public static boolean isFirstPermission(String permissionName) {
        return getSharedPreferences().getBoolean(permissionName, true);
    }
}
