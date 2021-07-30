package com.example.loadgithubprofile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loadgithubprofile.ModelClass.ResponseModel;
import com.example.loadgithubprofile.ModelClass.ResponseModelItem;

import org.jetbrains.annotations.NotNull;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvProfile;
    private TextView mTvName;
    private TextView mTvLogin;

    public ProfileViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvProfile = itemView.findViewById(R.id.ivProfile);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvLogin = itemView.findViewById(R.id.tvLogin);
    }

    public void setData(ResponseModelItem responseModelItem){
        Glide.with(mIvProfile).load(responseModelItem.getOwner().getAvatarUrl()).into(mIvProfile);
        mTvName.setText(responseModelItem.getName());
        mTvLogin.setText(responseModelItem.getOwner().getLogin());
    }
}
