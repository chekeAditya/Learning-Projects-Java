package com.example.identitycard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutViewHolder> {

    ArrayList<LayoutModel> layoutModels;

    public LayoutAdapter(ArrayList<LayoutModel> layoutModels) {
        this.layoutModels = layoutModels;
    }

    @NonNull
    @Override
    public LayoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new LayoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutViewHolder holder, int position) {
        LayoutModel layoutModel = layoutModels.get(position);
        holder.setData(layoutModel);
    }

    @Override
    public int getItemCount() {
        return layoutModels.size();
    }
}
