package com.example.apicallingusingservice.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apicallingusingservice.Model.ResponseModel;
import com.example.apicallingusingservice.R;
import com.example.apicallingusingservice.Service.GetDataService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ResponseModel> responseModelList = new ArrayList<>();
    private EditText mEtEnterNumber;
    private Button mBtnSubmit;
    private TextView mTvData;
    private LocalBroadCastReceiver localBroadCastReceiver;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerLocalBroadcast();
    }

    private void registerLocalBroadcast() {
        Log.d(TAG, "registerLocalBroadcast");
        localBroadCastReceiver = new LocalBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.aditya.localBroadCast");
        registerReceiver(localBroadCastReceiver, intentFilter);
    }


    private void initViews() {
        mEtEnterNumber = findViewById(R.id.etEnterNumber);
        mBtnSubmit = findViewById(R.id.btnSubmit);
        mTvData = findViewById(R.id.tvText);
        Intent intent = new Intent(this, GetDataService.class);
        intent.putExtra("edittext", mEtEnterNumber.getText().toString());
        mBtnSubmit.setOnClickListener(v -> {
            Log.d(TAG, "buttonClicked");
            startService(intent);
        });
    }


    //updating the layout   
    private class LocalBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "buttonClicked");
            if (intent != null && intent.getExtras() != null) {
                String data = intent.getStringExtra("title");
                mTvData.setText(data);
                Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
            }
        }
    }
}