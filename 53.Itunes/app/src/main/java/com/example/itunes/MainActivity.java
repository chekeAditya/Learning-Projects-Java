package com.example.itunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListner {

    private RecyclerView mRecycleView;
    private EditText mEtArtistName;
    private List<ResultsModel> resultsModelsList = new ArrayList<>();
    private iTunesAdapter iTunesAdapter;
    private Button mBtnSearch;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
    }

    private void fetchData(String searchTerm) {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ResponseModel> call = apiService.getSearch(searchTerm);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responseModel = response.body();
                assert responseModel != null;
                resultsModelsList.addAll(responseModel.getResults());
                iTunesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView() {
        iTunesAdapter = new iTunesAdapter(resultsModelsList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecycleView.setLayoutManager(gridLayoutManager);
        mRecycleView.setAdapter(iTunesAdapter);
    }

    private void initViews() {
        mEtArtistName = findViewById(R.id.etArtistName);
        mRecycleView = findViewById(R.id.recyclerView);
        mBtnSearch = findViewById(R.id.btnSearch);
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData(mEtArtistName.getText().toString());
            }
        });
    }


    @Override
    public void onItemClicked(int position, ItunesViewHolder itunesViewHolder) {
        ResultsModel resultsModel = resultsModelsList.get(position);
        String url = resultsModel.getPreviewUrl();
        Uri url2 = Uri.parse(url);
        itunesViewHolder.mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(MainActivity.this, url2);
                    mediaPlayer.prepare();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        itunesViewHolder.mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }
}