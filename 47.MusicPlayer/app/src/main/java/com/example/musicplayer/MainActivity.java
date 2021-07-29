package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.musicplayer.Adapter.SongMultipleViewTypeAdapter;
import com.example.musicplayer.ClickListener.ItemClickedListener;
import com.example.musicplayer.Model.Songs;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickedListener {

    private RecyclerView mRecyclerView;
    private ArrayList<Songs> songsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
        setRecyclerViews();
    }

    private void setRecyclerViews() {
        SongMultipleViewTypeAdapter songMultipleViewTypeAdapter = new SongMultipleViewTypeAdapter(songsList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(songMultipleViewTypeAdapter);
    }

    private void buildList() {
            songsList.add(new Songs(Songs.Text_Type, 0, "Shape Of You"));
            songsList.add(new Songs(Songs.Image_type, R.drawable.shapeofyou, "Shape Of You"));
            songsList.add(new Songs(Songs.Audio_type, R.raw.shape_of_you, "Shape of You"));
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(Songs songs) {

    }
}