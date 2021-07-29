package com.example.retrofit_ii;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView mtvName;
    private TextView mTvEmail;
    private TextView mTvBody;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvBody = itemView.findViewById(R.id.tvBody);
        mtvName = itemView.findViewById(R.id.tvName);
        mTvEmail = itemView.findViewById(R.id.tvEmail);
    }
    public void setData(ResponseModel responseModel){
        mtvName.setText(responseModel.getName());
        mTvEmail.setText(responseModel.getEmail());
        mTvBody.setText(responseModel.getBody());
    }
}
