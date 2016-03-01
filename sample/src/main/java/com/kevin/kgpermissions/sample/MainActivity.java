package com.kevin.kgpermissions.sample;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kevin.kgpermissions.KGPermissions;
import com.kevin.kgpermissions.OnPermissionListener;


public class MainActivity extends AppCompatActivity implements OnPermissionListener{

    public static final int RQUEST_CODE_LOCATION = 0;

    private Button getperMission;
    private Toolbar toolbar;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        KGPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getperMission = (Button) findViewById(R.id.getPermissions);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getperMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KGPermissions.requestPermission(MainActivity.this, MainActivity.this, RQUEST_CODE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
            }
        });
    }

    @Override
    public void granted(int requestCode) {
        Toast.makeText(MainActivity.this, "granted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void denied(int requestCode) {
        Toast.makeText(MainActivity.this, "denied", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterAskNeverAgain(int requestCode) {
        Toast.makeText(MainActivity.this, "AskNeverAgain", Toast.LENGTH_SHORT).show();
    }
}
