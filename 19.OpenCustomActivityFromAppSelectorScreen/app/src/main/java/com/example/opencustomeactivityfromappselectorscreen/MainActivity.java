package com.example.opencustomeactivityfromappselectorscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEtUserName;
    Button mBtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.content.Intent.ACTION_SEND");
                intent.putExtra("username", mEtUserName.getText().toString());
                intent.setType("text/plain");
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Package manager not found",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void intiViews() {
        mEtUserName = findViewById(R.id.userName);
        mBtnSubmit = findViewById(R.id.btnSubmit);
    }
}