package com.example.addbuyer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button mBtnClick;
    EditText mEtCustomerName, mEtPhoneNumber, mEtAddress, mEtEmail, mEtTaxId, mEtCompanyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("customerName",mEtCustomerName.getText().toString());
                intent.putExtra("phoneNumber",mEtPhoneNumber.getText().toString());
                intent.putExtra("address",mEtAddress.getText().toString());
                intent.putExtra("emailId",mEtEmail.getText().toString());
                intent.putExtra("taxId",mEtTaxId.getText().toString());
                intent.putExtra("companyId",mEtCompanyId.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void intiViews() {
        mEtCustomerName = findViewById(R.id.etCustomerName);
        mEtPhoneNumber = findViewById(R.id.etPhoneNumber);
        mEtAddress = findViewById(R.id.etAddress);
        mEtEmail = findViewById(R.id.etEmail);
        mEtTaxId = findViewById(R.id.etTaxId);
        mEtCompanyId = findViewById(R.id.etCompanyId);
        mBtnClick = findViewById(R.id.btnDone);
    }
}