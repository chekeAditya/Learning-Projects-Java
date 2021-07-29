package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button mBtnSumbit;
    EditText mEtFirstName, mEtLastName, mEtEmailId, mEtPhoneNumber;

    private static final String SHARED_PREFERENCE_KEY = "FirstDir";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mEtFirstName.getText().toString().trim();
                String lastName = mEtLastName.getText().toString();
                String emailId = mEtEmailId.getText().toString();
                String phoneNumber = mEtPhoneNumber.getText().toString();

//                Using Shared Preferences
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("firstName", firstName);
                editor.putString("lastName", lastName);
                editor.putString("emailid", emailId);
                editor.putString("phoneNumber", phoneNumber);
                editor.apply();

//                Using Intent
                Intent intent = new Intent(MainActivity.this, SecondScreeen.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        mEtFirstName = findViewById(R.id.etFirstName);
        mEtLastName = findViewById(R.id.etLastName);
        mEtEmailId = findViewById(R.id.etEmail);
        mEtPhoneNumber = findViewById(R.id.etPhoneNumber);
        mBtnSumbit = findViewById(R.id.btnSubmit);
    }
}