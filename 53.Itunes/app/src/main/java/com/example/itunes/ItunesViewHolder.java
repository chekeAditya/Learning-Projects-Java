package com.example.itunes;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItunesViewHolder extends RecyclerView.ViewHolder {
    private ItemClickListner itemClickListner;
    private TextView mTvArtistName;
    private TextView mTvTrackName;
    private ImageView mIvTrackImage;
    public Button mBtnPlay;
    public Button mBtnPause;
    public Button mBtnDelete;
    private ItunesViewHolder itunesViewHolder;

    public ItunesViewHolder(@NonNull View itemView,ItemClickListner itemClickListner) {
        super(itemView);
        this.itemClickListner = itemClickListner;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvArtistName = itemView.findViewById(R.id.tvArtistName);
        mTvTrackName = itemView.findViewById(R.id.tvTrackName);
        mIvTrackImage = itemView.findViewById(R.id.ivTrackImage);
        mBtnPlay = itemView.findViewById(R.id.btnPlay);
        mBtnDelete = itemView.findViewById(R.id.btnDelete);
    }

    public void setData(ResultsModel resultsModel) {
        if (resultsModel.getWrapperType().equals("track")) {
            mTvTrackName.setText(resultsModel.getTrackName());
        }else {
            mTvTrackName.setText(resultsModel.getCollectionName());
        }
        mTvArtistName.setText(resultsModel.getArtistName());
        Glide.with(mIvTrackImage).load(resultsModel.getArtworkUrl100()).into(mIvTrackImage);
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.onItemClicked(getLayoutPosition(),itunesViewHolder);
            }
        });
    }
}
