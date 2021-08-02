package com.example.apicallingusingdynamicfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.apicallingusingdynamicfragment.Model.ResponseModelItem;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentA extends Fragment {

    Button mBtnGetData;
    RecyclerView mRecyclerView;
    GitAdapter gitAdapter;
    List<ResponseModelItem> responseModelItemList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mBtnGetData = view.findViewById(R.id.btnGetData);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mBtnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayData();
                setRecyclerAdapter();
            }
        });
    }

    private void displayData() {
        gitAdapter = new GitAdapter(responseModelItemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(gitAdapter);
    }

    private void setRecyclerAdapter() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<List<ResponseModelItem>> call = apiService.data("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe",
                "raw","c651391e428182f08d60d59e79073f3fcf79b858","nobroker");

        call.enqueue(new Callback<List<ResponseModelItem>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<ResponseModelItem>> call, Response<List<ResponseModelItem>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) ;
                responseModelItemList = response.body();
                gitAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ResponseModelItem>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
/*
https://gist.githubusercontent.com/shivarajp/2cbe00030c04472c9d8ad4b0ec112dbe/raw/c651391e428182f08d60d59e79073f3fcf79b858/nobroker
 */