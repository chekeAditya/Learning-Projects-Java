package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEtUserName, mEtPassword;
    Button mBtnLogin;
    CheckBox mcheckBox;
    private static final String SHARED_PREFERENCE_KEY = "FirstDir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckBox.isChecked()) {
                    String username = mEtUserName.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", username);
                    editor.apply();
                } else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        mEtUserName = findViewById(R.id.eetUsername);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.btnogin);
        mcheckBox = findViewById(R.id.checkbox);
    }
}