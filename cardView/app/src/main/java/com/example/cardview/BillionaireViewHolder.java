package com.example.cardview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BillionaireViewHolder extends RecyclerView.ViewHolder {

    private ItemClickListener itemClickListener;
    private ImageView mIvImage;
    private TextView mTvHeading;
    private TextView mTvAge;
    private TextView mTvProfession;
    private CardView mCardView;


    public BillionaireViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvHeading = itemView.findViewById(R.id.tvMicrosoft);
        mCardView = itemView.findViewById(R.id.cardView);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvProfession = itemView.findViewById(R.id.tvProfession);
    }

    public void setData(Billionaire billionaire){
        mIvImage.setImageResource(billionaire.getImage());
        mTvHeading.setText(billionaire.getHeading());
        mTvAge.setText(billionaire.getAge());
        mTvProfession.setText(billionaire.getProfession());
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(billionaire);
            }
        });
    }

}
