package com.example.animaldetails;

import android.telephony.ims.ImsMmTelManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ItemClickListner itemClickListner;
    private RelativeLayout mRelativeLayout;
    private TextView mtvAnimalHeading;
    private ImageView mivAnimalImage;
    private TextView mtvAnimalName;
    private TextView mtvAnimalSound;

    public AnimalViewHolder(@NonNull View itemView, ItemClickListner itemClickListner) {
        super(itemView);
        this.itemClickListner = itemClickListner;
        initViews();
    }

    private void initViews() {
        mRelativeLayout = itemView.findViewById(R.id.rlCard);
        mtvAnimalHeading = itemView.findViewById(R.id.tvAnimalHeading);
        mivAnimalImage = itemView.findViewById(R.id.ivAnimalImage);
        mtvAnimalName = itemView.findViewById(R.id.tvAnimalName);
        mtvAnimalSound = itemView.findViewById(R.id.tvAnimalSound);
    }
    public void setData(Animal animal){
        mtvAnimalHeading.setText(animal.getAnimalHeading());
        mivAnimalImage.setImageResource(animal.getAnimalImage());
        mtvAnimalName.setText(animal.getAnimalName());
        mtvAnimalSound.setText(animal.getAnimalSound());
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.onItemClicked(getAdapterPosition(),animal);
            }
        });
    }
}
