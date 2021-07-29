package com.example.musicplayer.ViewHolder;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.ClickListener.ItemClickedListener;
import com.example.musicplayer.R;
import com.example.musicplayer.Model.Songs;

public class SongViewHolder extends RecyclerView.ViewHolder {

    private ItemClickedListener itemClickedListener;
    private TextView mTvTitle;
    private Button mBtnPlay;
    private Button mBtnPause;
    private TextView mTvDuration;

    public SongViewHolder(@NonNull View itemView, ItemClickedListener itemClickedListener) {
        super(itemView);
        this.itemClickedListener = itemClickedListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mBtnPlay = itemView.findViewById(R.id.btnPlay);
        mTvTitle = itemView.findViewById(R.id.tvSongTitle);
        mBtnPause = itemView.findViewById(R.id.btnPause);
        mTvDuration = itemView.findViewById(R.id.tvDuration);
    }

    public void setData(Songs songs) {
       mTvTitle.setText(songs.getContent());
       final MediaPlayer mediaPlayer = MediaPlayer.create(mTvTitle.getContext(),songs.getResId());
//  play button clicked
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying())
                    mediaPlayer.start();
            }
        });

// pause button clicked
        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
            }
        });

//        delete button clicked
//        mBtnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                itemClickedListener.onItemClicked(songs);
//            }
//        });

    }
}
