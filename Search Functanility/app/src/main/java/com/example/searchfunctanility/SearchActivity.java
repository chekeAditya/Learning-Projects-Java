package com.example.searchfunctanility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView userRecycler;
    SearchViewAdapter recyclerviewAdapter;
    EditText searchView;
    CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.etSearchData);

        List<DataModel> userDataList = new ArrayList<>();
        userDataList.add(new DataModel("Nishant Rishab"));
        userDataList.add(new DataModel("Aditya Cheke"));
        userDataList.add(new DataModel("Sudarshan Parsad"));
        userDataList.add(new DataModel("Mausam Singh"));
        userDataList.add(new DataModel("Prabhakar Kumar"));
        userDataList.add(new DataModel("Niket Nayan"));
        userDataList.add(new DataModel("Adams Green"));

        setUserRecycler(userDataList);


        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                recyclerviewAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private  void  setUserRecycler(List<DataModel> userDataList){
        userRecycler = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        userRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new SearchViewAdapter(this, userDataList);
        userRecycler.setAdapter(recyclerviewAdapter);
    }

}