package com.example.musicplayer.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.ClickListener.ItemClickedListener;
import com.example.musicplayer.Model.Songs;
import com.example.musicplayer.R;

public class TextViewHolder extends RecyclerView.ViewHolder {
    private ItemClickedListener itemClickedListener;
    private TextView mTvTitle;

    public TextViewHolder(@NonNull View itemView,ItemClickedListener itemClickedListener) {
        super(itemView);
        this.itemClickedListener = itemClickedListener;
        mTvTitle = itemView.findViewById(R.id.tvTitle);
    }
    public void setData(Songs songs){
        mTvTitle.setText(songs.getContent());
    }
}
