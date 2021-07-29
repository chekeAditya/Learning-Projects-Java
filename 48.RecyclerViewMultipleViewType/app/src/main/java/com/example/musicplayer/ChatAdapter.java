package com.example.musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// passing the parent itself
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ArrayList<BaseModel> baseModelsList;

    public ChatAdapter(ArrayList<BaseModel> baseModelsList) {
        this.baseModelsList = baseModelsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_item_layout, parent, false);
                return new SenderViewHolder(view);

            case 1:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.receiver_item_layout, parent, false);
                return new ReceiverViewHolder(view1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = baseModelsList.get(position).getViewType();
        switch (viewType) {
            case 0:
                if (holder instanceof SenderViewHolder) {
                    SenderModel senderModel = (SenderModel) baseModelsList.get(position);
                    ((SenderViewHolder) holder).setData(senderModel);
                }
                break;
            case 1:
                if (holder instanceof ReceiverViewHolder) {
                    ReceiverModel receiverModel = (ReceiverModel) baseModelsList.get(position);
                    ((ReceiverViewHolder) holder).setData(receiverModel);
                }
                break;
        }
    }

    //this decide which layout has to be defined, this has sender and receiver
    @Override
    public int getItemViewType(int position) {
        return baseModelsList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return baseModelsList.size();
    }
}
