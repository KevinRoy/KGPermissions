package com.kevin.kgpermissions;

import android.app.Application;

/**
 * Created by kevin on 16/3/7.
 */
public class KGPermissionsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KGPermissionsShared.init(this);
    }
}
