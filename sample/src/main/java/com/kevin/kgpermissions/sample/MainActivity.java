package com.kevin.kgpermissions.sample;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.kevin.kgpermissions.KGPermissions;
import com.kevin.kgpermissions.OnPermissionListener;


public class MainActivity extends AppCompatActivity implements OnPermissionListener{

    public static final int RQUEST_CODE_LOCATION = 0;
    public static final int RQUEST_CODE_MANY = 1;

    private Button getPermission, getPermissions;
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

        getPermission = (Button) findViewById(R.id.getPermission);
        getPermissions = (Button) findViewById(R.id.getPermissions);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KGPermissions.requestPermission(MainActivity.this, MainActivity.this, RQUEST_CODE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
            }
        });

        getPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KGPermissions.requestPermission(MainActivity.this, MainActivity.this, RQUEST_CODE_MANY, Manifest.permission.WRITE_CONTACTS, Manifest.permission.CAMERA);
            }
        });
    }

    @Override
    public void granted(int requestCode) {
        switch (requestCode){
            case RQUEST_CODE_LOCATION:
                Toast.makeText(MainActivity.this, "location_granted", Toast.LENGTH_SHORT).show();
                break;
            case RQUEST_CODE_MANY:
                Toast.makeText(MainActivity.this, "many_granted", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void denied(int requestCode) {
        switch (requestCode){
            case RQUEST_CODE_LOCATION:
                Toast.makeText(MainActivity.this, "location_denied", Toast.LENGTH_SHORT).show();
                break;
            case RQUEST_CODE_MANY:
                Toast.makeText(MainActivity.this, "many_denied", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void afterAskNeverAgain(int requestCode) {
        switch (requestCode){
            case RQUEST_CODE_LOCATION:
                Toast.makeText(MainActivity.this, "location_AskNeverAgain", Toast.LENGTH_SHORT).show();
                break;
            case RQUEST_CODE_MANY:
                Toast.makeText(MainActivity.this, "many_AskNeverAgain", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
