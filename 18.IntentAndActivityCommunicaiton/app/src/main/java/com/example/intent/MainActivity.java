package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUsername, mEtEmail, mEtPassword;
    private Button mBtnSubmit;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emailId = isEmailValid();
                boolean password = isPasswordValid();
                boolean name = isUserNameValid();
                if (emailId && password && name) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("username",mEtUsername.getText().toString());
                    intent.putExtra("emailId",mEtEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void intiViews() {
        mEtUsername = findViewById(R.id.etUserName);
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnSubmit = findViewById(R.id.btnSubmit);
    }


    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid email");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().trim().length() >= 6) {
            return true;
        } else {
            mEtPassword.setError("Password Length is less then 6 digit");
            return false;
        }
    }

    private boolean isUserNameValid() {
        if (mEtUsername.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            mEtUsername.setError("Username size is less then 4");
            return false;
        }
    }
}