package com.example.getresourcesapi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getresourcesapi.Interface.ApiService;
import com.example.getresourcesapi.Model.ResponseModel;
import com.example.getresourcesapi.Network;
import com.example.getresourcesapi.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserId;
    private Button mBtnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LoadingDialog loadingDialog = new LoadingDialog(this);
        initViews();
        mBtnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoadingAnimation();
                ApiService();
            }
        });
    }

    private void initViews() {
        mEtUserId = findViewById(R.id.etUserId);
        mBtnGetData = findViewById(R.id.btnGetData);
    }

    private void ApiService() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int userId = Integer.parseInt(mEtUserId.getText().toString());
        apiService.getUserId(userId).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel model = response.body();
                String name = model.getData().getName();
                String year = String.valueOf(model.getData().getYear());
                String company = model.getData().getPantoneValue();
                String color = model.getData().getColor();
                intent.putExtra("firstName", name);
                intent.putExtra("year", year);
                intent.putExtra("companyName", company);
                intent.putExtra("color", color);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Data Not Send", Toast.LENGTH_SHORT).show();
            }
        });
    }
}