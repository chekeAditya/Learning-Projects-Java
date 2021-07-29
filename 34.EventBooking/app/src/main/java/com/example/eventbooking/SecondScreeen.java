package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreeen extends AppCompatActivity {

    TextView mTvFirstName, mTvLastName, mTvEmailId;
    EditText mEtNoOfSeats, mEtDateOfShow;
    Button mBtnBook;
    private static final String SHARED_PREFERENCE_KEY = "FirstDir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_scareen);
        initViews();
        showData();
        mBtnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seats = mEtNoOfSeats.getText().toString();
                String date = mEtDateOfShow.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NoOfSeats", seats);
                editor.putString("DateOfShow", date);
                editor.apply();
                Intent intent = new Intent(SecondScreeen.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY,MODE_PRIVATE);
        String firstName  = sharedPreferences.getString("firstName","");
        String lastName  = sharedPreferences.getString("lastName","");
        String emailId  = sharedPreferences.getString("emailid","");
        mTvFirstName.setText(firstName);
        mTvLastName.setText(lastName);
        mTvEmailId.setText(emailId);
    }

    private void initViews() {
        mTvFirstName = findViewById(R.id.tvFirstName);
        mTvLastName = findViewById(R.id.tvLastName);
        mTvEmailId = findViewById(R.id.tvEmailId);
        mEtNoOfSeats = findViewById(R.id.etNumberOfSeats);
        mEtDateOfShow = findViewById(R.id.etDateOfShow);
        mBtnBook = findViewById(R.id.btnBook);
    }
}