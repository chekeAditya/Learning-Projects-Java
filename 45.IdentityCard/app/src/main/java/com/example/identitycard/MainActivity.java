package com.example.identitycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<LayoutModel> layoutModels;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        LayoutAdapter layoutAdapter = new LayoutAdapter(layoutModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(layoutAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void buildList() {
        layoutModels = new ArrayList<>();
        for (int i=0;i<20;i++){
            layoutModels.add(new LayoutModel("Microsoft",R.drawable.billgate,"Age : 64","Profession : Business"));
            layoutModels.add(new LayoutModel("Amazon",R.drawable.jeffbezos,"Age : 56","Profession : Business"));
            layoutModels.add(new LayoutModel("Masai School",R.drawable.prateek,"Age : 31","Profession : Business"));
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}