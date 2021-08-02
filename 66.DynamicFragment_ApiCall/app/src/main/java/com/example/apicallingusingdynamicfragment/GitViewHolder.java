package com.example.apicallingusingdynamicfragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apicallingusingdynamicfragment.Model.ResponseModelItem;

public class GitViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private TextView mTvOne;
    private TextView mTvTwo;

    public GitViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvOne = itemView.findViewById(R.id.tvOne);
        mTvTwo = itemView.findViewById(R.id.tvTwo);
    }

    public void setData(ResponseModelItem responseModelItem) {
        Glide.with(mIvImage).load(responseModelItem.getImage()).into(mIvImage);
        mTvOne.setText(responseModelItem.getTitle());
        mTvTwo.setText(responseModelItem.getSubTitle());
    }
}
