package com.example.loadgithubprofile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loadgithubprofile.ModelClass.ResponseModelItem;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    List<ResponseModelItem> responseModelItemList;

    public ProfileAdapter(List<ResponseModelItem> responseModelItemList) {
        this.responseModelItemList = responseModelItemList;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        ResponseModelItem profileViewHolder  = responseModelItemList.get(position);
        holder.setData(profileViewHolder);
    }

    @Override
    public int getItemCount() {
        return responseModelItemList.size();
    }
    public void updateData(List<ResponseModelItem> responseModelItems){
        this.responseModelItemList = responseModelItems;
        notifyDataSetChanged();
    }
}
