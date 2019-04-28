package com.example.studentlocator;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class StartScanQrActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_scan_qr);
    }


    public void onViewClicked(View view) {

        Intent intent =new Intent(StartScanQrActivity.this,ScannerActivity.class);
        startActivity(intent);

    }
}
