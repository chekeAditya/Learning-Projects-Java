package com.example.loginsection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    EditText mEtEmail, mEtPassword;
    Button mBtnLogin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        intiViews();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailIdVaild() && isPasswordValid()){
                    Intent intent = new Intent(LoginScreen.this,HomeScreen.class);
                    intent.putExtra("key",mEtEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    private void intiViews() {
        mEtEmail = findViewById(R.id.etEmailId);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.bnLogin);
    }

    private boolean isEmailIdVaild() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Email Id Invaild");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}