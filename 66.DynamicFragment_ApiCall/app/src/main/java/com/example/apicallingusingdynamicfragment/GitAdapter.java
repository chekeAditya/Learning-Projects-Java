package com.example.apicallingusingdynamicfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicallingusingdynamicfragment.Model.ResponseModelItem;

import java.util.List;

public class GitAdapter extends RecyclerView.Adapter<GitViewHolder> {

    List<ResponseModelItem> responseModelItemList;

    public GitAdapter(List<ResponseModelItem> responseModelItemList) {
        this.responseModelItemList = responseModelItemList;
    }

    @NonNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new GitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder holder, int position) {
        ResponseModelItem responseModelItem = responseModelItemList.get(position);
        holder.setData(responseModelItem);
    }

    @Override
    public int getItemCount() {
        return responseModelItemList.size();
    }

}
