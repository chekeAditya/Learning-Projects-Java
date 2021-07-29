package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEtTo, mEtcc, mEtText,mEtSubject;
    Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"dextor.lap@gmail.com"});
                intent.putExtra(Intent.EXTRA_CC,new String[] {"adityacheke@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                intent.putExtra(Intent.EXTRA_TEXT,"Hi Sir,\n + This mail is regarding my leaves as I won’t be able to attend the team meetings due to health issues. Kindly excuse my absence");
                startActivity(intent);
            }
        }); 
    }

    private void initViews() {
        mEtTo = findViewById(R.id.tvTo);
        mEtcc = findViewById(R.id.tvcc);
        mEtText = findViewById(R.id.tvMessage);
        mEtSubject = findViewById(R.id.tvSubject);
        mBtnSend = findViewById(R.id.btnSend);
    }
}