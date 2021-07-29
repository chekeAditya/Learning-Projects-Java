package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmail;
    private EditText mEtPassword;
    private EditText mEtTitle;
    private EditText mEtRequestType;
    private Button mBtnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mEtTitle = findViewById(R.id.etTitle);
        mEtRequestType = findViewById(R.id.etRequestType);
        mBtnGetData = findViewById(R.id.btnGetData);
        mBtnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<RequestModel> call = apiService.getRequest();
        call.enqueue(new Callback<RequestModel>() {
            @Override
            public void onResponse(Call<RequestModel> call, Response<RequestModel> response) {
                RequestModel requestModel = response.body();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("title",mEtTitle.getText().toString());
                intent.putExtra("email",mEtEmail.getText().toString());
                intent.putExtra("requestType",mEtRequestType.getText().toString());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<RequestModel> call, Throwable t) {

            }
        });
    }
}