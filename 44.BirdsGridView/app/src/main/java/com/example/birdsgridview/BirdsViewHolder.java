package com.example.birdsgridview;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BirdsViewHolder extends RecyclerView.ViewHolder {

    private Interface anInterface;
    private ImageView mIvImage;
    private TextView mTvBirdName;
    private CardView cardView;

    public BirdsViewHolder(@NonNull View itemView, Interface anInterface) {
        super(itemView);
        this.anInterface = anInterface;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivImage);
        cardView = itemView.findViewById(R.id.cardView);
    }

    public void setData(Birds birds) {
        mIvImage.setImageResource(birds.getImage());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anInterface.onItemClicked(birds);
            }
        });
    }
}
