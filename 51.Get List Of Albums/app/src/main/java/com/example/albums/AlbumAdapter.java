package com.example.albums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    private List<ResponseModel> responseModels ;
    public AlbumAdapter(List<ResponseModel> responseModels) {
        this.responseModels = responseModels;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        ResponseModel responseModel = responseModels.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return responseModels.size();
    }

    public void updateData(List<ResponseModel> responseModels){
        this.responseModels = responseModels;
        notifyDataSetChanged();
    }
}
