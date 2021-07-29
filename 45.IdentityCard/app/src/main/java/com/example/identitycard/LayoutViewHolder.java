package com.example.identitycard;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LayoutViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvHeading;
    private ImageView mIvImage;
    private RelativeLayout mRelativeView;
    private TextView mTvAg;
    private TextView mTvProfession;

    public LayoutViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvHeading = itemView.findViewById(R.id.tvHeading);
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvAg = itemView.findViewById(R.id.tvAge);
        mTvProfession = itemView.findViewById(R.id.tvProfession);
        mRelativeView = itemView.findViewById(R.id.relativeLayout);
    }

    public void setData(LayoutModel layoutModel){
        mTvHeading.setText(layoutModel.getHeading());
        mTvAg.setText(layoutModel.getAge());
        mTvProfession.setText(layoutModel.getProfession());
        mIvImage.setImageResource(layoutModel.getImage());
    }
}
