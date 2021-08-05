package com.example.viewpagerwithtabs.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagerwithtabs.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvDate;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvDate = itemView.findViewById(R.id.tvText);
    }

    public void setData(String data) {
        mTvDate.setText(data);
    }
}
