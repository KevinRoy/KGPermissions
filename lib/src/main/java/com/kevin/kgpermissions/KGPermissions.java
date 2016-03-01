package com.kevin.kgpermissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 16/2/26.
 */
public class KGPermissions {
    private static OnPermissionListener mOnPermissionListener;

    public static void onRequestPermissionsResult(Object context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        List<String> deniedPermissions = new ArrayList<String>();
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                deniedPermissions.add(permissions[i]);
            }
        }

        if (deniedPermissions.size() > 0) {
            for (int i = 0; i < deniedPermissions.size(); i++) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(PermissionUtil.getActivity(context), deniedPermissions.get(i))) {
                    mOnPermissionListener.afterAskNeverAgain(requestCode);
                } else if (mOnPermissionListener != null) {
                    mOnPermissionListener.denied(requestCode);
                }
            }
        } else {
            if (mOnPermissionListener != null) {
                mOnPermissionListener.granted(requestCode);
            }
        }
    }

    public static void requestPermission(Activity context, OnPermissionListener onPermissionListener, int requestCode, String... permissions) {
        mOnPermissionListener = onPermissionListener;
        requestCommonPermission(context, requestCode, permissions);
    }

    public static void requestPermission(Fragment context, OnPermissionListener onPermissionListener, int requestCode, String... permissions) {
        mOnPermissionListener = onPermissionListener;
        requestCommonPermission(context, requestCode, permissions);
    }

    private static void requestCommonPermission(Object context, int requestCode, String... permissions) {
        if (!PermissionUtil.isMarshmallow()) {
            return;
        }

        List<String> deniedPermissions = PermissionUtil.getDeniedPermissions(PermissionUtil.getActivity(context), permissions);

        if (deniedPermissions.size() > 0) {
            if (context instanceof Activity) {
                ActivityCompat.requestPermissions((Activity) context, deniedPermissions.toArray(new String[1]), requestCode);
            } else if (context instanceof Fragment) {
                ActivityCompat.requestPermissions(((Fragment) context).getActivity(), deniedPermissions.toArray(new String[deniedPermissions.size()]), requestCode);
            } else {
                throw new IllegalArgumentException(context.getClass().getName() + " is not supported!");
            }
        } else {
            if (mOnPermissionListener != null) {
                mOnPermissionListener.granted(requestCode);
            }
        }
    }
}
