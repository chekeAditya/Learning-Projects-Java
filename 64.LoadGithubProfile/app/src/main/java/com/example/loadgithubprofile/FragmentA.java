package com.example.loadgithubprofile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.loadgithubprofile.ModelClass.ResponseModelItem;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;

public class FragmentA extends Fragment {

    private List<ResponseModelItem> responseModelItemList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private EditText mEtUserName;
    private Button mGetButton;
    private ProfileAdapter profileAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void setRecyclerAdapter() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<List<ResponseModelItem>> call = apiService.getData(mEtUserName.getText().toString());
        call.enqueue(new Callback<List<ResponseModelItem>>() {
            @Override
            public void onResponse(Call<List<ResponseModelItem>> call, Response<List<ResponseModelItem>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseModelItemList = response.body();
                    profileAdapter.updateData(responseModelItemList);
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModelItem>> call, Throwable t) {

            }
        });
    }

    private void displayData() {
        profileAdapter = new ProfileAdapter(responseModelItemList);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(profileAdapter);
    }

    private void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mEtUserName = view.findViewById(R.id.etSearch);
        mGetButton = view.findViewById(R.id.btnGetData);
        mGetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayData();
                setRecyclerAdapter();
            }
        });
    }
}