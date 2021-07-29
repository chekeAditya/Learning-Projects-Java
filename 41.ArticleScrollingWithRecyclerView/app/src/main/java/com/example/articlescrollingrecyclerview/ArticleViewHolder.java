package com.example.articlescrollingrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private ItemClickListener itemClickListener;
    private ImageView mIvImage;
    private TextView mTvHeading2;
    private TextView mTvHeading3;
    private TextView mTvPara;


    public ArticleViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews();
    }

    private void initViews() {
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvHeading2 = itemView.findViewById(R.id.tvHeading2);
        mTvHeading3 = itemView.findViewById(R.id.tvHeading3);
        mTvPara = itemView.findViewById(R.id.para);
    }

    public void setData(Article article) {
        mIvImage.setImageResource(article.getImageView());
        mTvHeading2.setText(article.getmTvHeading2());
        mTvHeading3.setText(article.getmTvHeading3());
        mTvPara.setText(article.getmTvPara());
        mIvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), article);
            }
        });
    }
}
