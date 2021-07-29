package com.example.cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BillionaireAdapter extends RecyclerView.Adapter<BillionaireViewHolder> {

    private ArrayList<Billionaire> arrayAdapter;
    private ItemClickListener itemClickListener;

    public BillionaireAdapter(ArrayList<Billionaire> arrayAdapter, ItemClickListener itemClickListener) {
        this.arrayAdapter = arrayAdapter;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public BillionaireViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new BillionaireViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BillionaireViewHolder holder, int position) {
        Billionaire billionaire = arrayAdapter.get(position);
        holder.setData(billionaire);
    }

    @Override
    public int getItemCount() {
        return arrayAdapter.size();
    }
}
