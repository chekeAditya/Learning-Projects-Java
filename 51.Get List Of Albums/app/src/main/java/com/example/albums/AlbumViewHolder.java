package com.example.albums;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvId;
    private TextView mTvTitle;

    public AlbumViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvId = itemView.findViewById(R.id.tvId);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
    }

    public void setData(ResponseModel responseModel){
        mTvTitle.setText(responseModel.getUserId() + "");
        mTvId.setText(responseModel.getTitle());
    }
}
