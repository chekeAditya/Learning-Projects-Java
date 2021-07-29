package com.example.musicplayer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.ClickListener.ItemClickedListener;
import com.example.musicplayer.R;
import com.example.musicplayer.Model.Songs;
import com.example.musicplayer.ViewHolder.ImageViewHolder;
import com.example.musicplayer.ViewHolder.SongViewHolder;
import com.example.musicplayer.ViewHolder.TextViewHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongMultipleViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Songs> songList;
    private ItemClickedListener itemClickedListener;

    public SongMultipleViewTypeAdapter(ArrayList<Songs> songList, ItemClickedListener itemClickedListener) {
        this.songList = songList;
        this.itemClickedListener = itemClickedListener;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case Songs.Audio_type:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_item_type, parent, false);
                return new SongViewHolder(view, itemClickedListener);
            case Songs.Image_type:
                View imageViewType = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_type, parent, false);
                return new SongViewHolder(imageViewType, itemClickedListener);
            case Songs.Text_Type:
                View textViewType = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_item_type, parent, false);
                return new SongViewHolder(textViewType, itemClickedListener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = songList.get(position).getItemType();
        Songs songs = songList.get(position);

        switch (viewType) {
            case Songs.Audio_type:
                if (holder instanceof SongViewHolder) {
                    ((SongViewHolder) holder).setData(songs);
                }
                break;
            case Songs.Image_type:
                if (holder instanceof ImageViewHolder) {
                    ((ImageViewHolder) holder).setData(songs);
                }
                break;
            case Songs.Text_Type:
                if (holder instanceof TextViewHolder) {
                    ((TextViewHolder) holder).setData(songs);
                }
        }
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int itemType = songList.get(position).getItemType();
        switch (itemType) {
            case Songs.Text_Type:
                return Songs.Text_Type;
            case Songs.Audio_type:
                return Songs.Audio_type;
            case Songs.Image_type:
                return Songs.Image_type;
        }
        return -1;
    }
}
