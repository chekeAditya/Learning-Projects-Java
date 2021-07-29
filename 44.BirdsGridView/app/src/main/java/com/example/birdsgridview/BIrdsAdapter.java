package com.example.birdsgridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BIrdsAdapter extends RecyclerView.Adapter<BirdsViewHolder> {

    private ArrayList<Birds> birdsList;
    private Interface anInterface;

    public BIrdsAdapter(ArrayList<Birds> birdsList, Interface anInterface) {
        this.birdsList = birdsList;
        this.anInterface = anInterface;
    }

    @NonNull
    @Override
    public BirdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new BirdsViewHolder(view,anInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull BirdsViewHolder holder, int position) {
        Birds birds = birdsList.get(position);
        holder.setData(birds);
    }

    @Override
    public int getItemCount() {
        return birdsList.size();
    }
}
