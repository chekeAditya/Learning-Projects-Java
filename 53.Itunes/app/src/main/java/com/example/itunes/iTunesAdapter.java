package com.example.itunes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class iTunesAdapter extends RecyclerView.Adapter<ItunesViewHolder> {

    private List<ResultsModel> resultsModelList;
    private final ItemClickListner itemClickListner;

    public iTunesAdapter(List<ResultsModel> resultsModelList, ItemClickListner itemClickListner) {
        this.resultsModelList = resultsModelList;
        this.itemClickListner = itemClickListner;
    }

    @NonNull
    @Override
    public ItunesViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ItunesViewHolder(view,itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ItunesViewHolder holder, int position) {
        ResultsModel resultsModel = resultsModelList.get(position);
        holder.setData(resultsModel);
    }

    @Override
    public int getItemCount() {
        return resultsModelList.size();
    }
}
