package com.example.musicplayer;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReceiverViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvReceiverMessage;

    public ReceiverViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvReceiverMessage = itemView.findViewById(R.id.tvReceiverMessage);
    }
    public void setData(ReceiverModel receiverModel){
        mTvReceiverMessage.setText(receiverModel.getReceiverMessage());
    }
}
