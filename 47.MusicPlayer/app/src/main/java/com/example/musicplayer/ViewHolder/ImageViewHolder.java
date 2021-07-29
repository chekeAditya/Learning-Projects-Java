package com.example.musicplayer.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.ClickListener.ItemClickedListener;
import com.example.musicplayer.R;
import com.example.musicplayer.Model.Songs;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ItemClickedListener itemClickedListener;
    private ImageView mIvSongImage;
    private TextView mTvImageTitle;

    public ImageViewHolder(@NonNull View itemView,ItemClickedListener itemClickedListener) {
        super(itemView);
        this.itemClickedListener = itemClickedListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvImageTitle = itemView.findViewById(R.id.tvImageTitle);
    }

    public void setData(Songs songs){
        mTvImageTitle.setText(songs.getContent());
        mIvSongImage.setImageResource(songs.getResId());
    }
}
