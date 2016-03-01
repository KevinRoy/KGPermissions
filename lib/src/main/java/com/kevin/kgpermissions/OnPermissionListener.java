package com.kevin.kgpermissions;

/**
 * Created by kevin on 16/2/23.
 */
public interface OnPermissionListener {

    public void granted(int requestCode);

    public void denied(int requestCode);

    public void afterAskNeverAgain(int requestCode);
}