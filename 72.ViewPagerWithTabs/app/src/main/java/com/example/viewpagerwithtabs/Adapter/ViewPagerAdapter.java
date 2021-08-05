package com.example.viewpagerwithtabs.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagerwithtabs.R;
import com.example.viewpagerwithtabs.ViewHolder.ViewHolder;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

   private final List<String> stringList;

    public ViewPagerAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
