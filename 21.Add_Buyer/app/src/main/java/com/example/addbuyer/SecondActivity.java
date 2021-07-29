package com.example.addbuyer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView custmerName, mobileNumber, Address, email, taxId, companyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        if (getIntent() != null){
            String nameCustomer = getIntent().getStringExtra("customerName");
            custmerName.setText(nameCustomer);
            String number = getIntent().getStringExtra("phoneNumber");
            custmerName.setText(number);
            String addres = getIntent().getStringExtra("address");
            custmerName.setText(addres);
            String emailId = getIntent().getStringExtra("emailId");
            custmerName.setText(emailId);
            String taxId = getIntent().getStringExtra("taxId");
            custmerName.setText(taxId);
            String companyId = getIntent().getStringExtra("companyId");
            custmerName.setText(companyId);

        }
    }

    private void initViews() {
        custmerName = findViewById(R.id.customerName);
        mobileNumber = findViewById(R.id.mobileNumber);
        Address = findViewById(R.id.Address);
        email = findViewById(R.id.emailId);
        taxId = findViewById(R.id.taxId);
        companyId = findViewById(R.id.complanyId);
    }
}