package com.kevin.kgpermissions;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 * Created by kevin on 16/2/29.
 */
public class PermissionUtil {

    /**
     * 判断系统是否为6.0以上的系统
     *
     * @return
     */
    public static boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * 获取activity
     * @param context
     * @return
     */
    public static Activity getActivity(Object context) {
        if (context instanceof Activity) {
            return (Activity) context;
        } else if (context instanceof Fragment) {
            return ((Fragment) context).getActivity();
        }
        return null;
    }

    /**
     * 是否授权
     *
     * @param permissionCode
     * @return
     */
    public static boolean isGranted(int permissionCode) {
        return permissionCode == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 是否拒绝
     *
     * @param permissionCode
     * @return
     */
    public static boolean isDenied(int permissionCode) {
        return permissionCode == PackageManager.PERMISSION_DENIED;
    }

    /**
     * 检查是否为granted
     *
     * @param context
     * @param permission
     * @return
     */
    private static boolean checkSelfPermission(Context context, String permission) {
        return isGranted(ContextCompat.checkSelfPermission(context, permission));
    }

    /**
     * 获取没有授权权限的permission列表
     *
     * @param context
     * @param permissions
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static List<String> getDeniedPermissions(Activity context, String... permissions) {
        List<String> deniedPermissions = new ArrayList<String>();
        for (String permission : permissions) {
            if (!checkSelfPermission(context, permission)) {
                deniedPermissions.add(permission);
            }
        }
        return deniedPermissions;
    }

    /**
     * 是否开启了通讯录相关权限
     *
     * @return
     */
    public static boolean isContacts(Context context) {
        return checkSelfPermission(context, Manifest.permission.WRITE_CONTACTS)
                || checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS)
                || checkSelfPermission(context, Manifest.permission.READ_CONTACTS);

    }

    /**
     * 是否开启了电话相关权限
     *
     * @return
     */
    public static boolean isPhone(Context context) {
        return checkSelfPermission(context, Manifest.permission.READ_CALL_LOG)
                || checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
                || checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                || checkSelfPermission(context, Manifest.permission.WRITE_CALL_LOG)
                || checkSelfPermission(context, Manifest.permission.USE_SIP)
                || checkSelfPermission(context, Manifest.permission.PROCESS_OUTGOING_CALLS)
                || checkSelfPermission(context, Manifest.permission.ADD_VOICEMAIL);

    }

    /**
     * 是否开启了日程相关权限
     *
     * @param context
     * @return
     */
    public static boolean isCalendar(Context context) {
        return checkSelfPermission(context, Manifest.permission.READ_CALENDAR)
                || checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR);
    }

    /**
     * 是否开启了照相相关权限
     *
     * @param context
     * @return
     */
    public static boolean isCamera(Context context) {
        return checkSelfPermission(context, Manifest.permission.CAMERA);
    }

    /**
     * 是否开启了传感器相关权限
     *
     * @param context
     * @return
     */
    public static boolean isSensors(Context context) {
        return checkSelfPermission(context, Manifest.permission.BODY_SENSORS);
    }

    /**
     * 是否开启了定位相关权限
     *
     * @param context
     * @return
     */
    public static boolean isLocation(Context context) {
        return checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                || checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    /**
     * 是否开启了存储相关权限
     *
     * @param context
     * @return
     */
    public static boolean isStorage(Context context) {
        return checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                || checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    /**
     * 是否开启了录音相关权限
     *
     * @param context
     * @return
     */
    public static boolean isMicroPhone(Context context) {
        return checkSelfPermission(context, Manifest.permission.RECORD_AUDIO);
    }


    public static boolean isSMS(Context context) {
        return checkSelfPermission(context, Manifest.permission.READ_SMS)
                || checkSelfPermission(context, Manifest.permission.RECEIVE_WAP_PUSH)
                || checkSelfPermission(context, Manifest.permission.RECEIVE_MMS)
                || checkSelfPermission(context, Manifest.permission.RECEIVE_SMS)
                || checkSelfPermission(context, Manifest.permission.SEND_SMS);
    }
}
