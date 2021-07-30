package com.example.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    ImageView mIvImage;
    TextView mTvName;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        initiViews(itemView);
    }

    private void initiViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivAnimal);
        mTvName = itemView.findViewById(R.id.tvName);
    }

    public void setData(Animal animal){
        mTvName.setText(animal.getName());
        mIvImage.setImageResource(animal.getImage());
    }
}
