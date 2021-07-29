package com.example.birdsgridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Interface {

    private ArrayList<Birds> birdsArrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        BIrdsAdapter bIrdsAdapter = new BIrdsAdapter(birdsArrayList,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(bIrdsAdapter);
    }

    private void buildData() {
        birdsArrayList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (i % 4 == 0) {
                birdsArrayList.add(new Birds(R.drawable.australia_satin_bower_bird, "Australia Satin Bird"));
            } else if (i % 4 == 1) {
                birdsArrayList.add(new Birds(R.drawable.pigeon_bird, "pegionxlu"));
            }
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(Birds birds) {
        Toast.makeText(this, "Bird name is " + birds.getBirdName(), Toast.LENGTH_SHORT).show();
    }
}