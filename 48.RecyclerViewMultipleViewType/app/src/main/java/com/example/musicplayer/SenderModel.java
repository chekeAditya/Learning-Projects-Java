package com.example.musicplayer;

public class SenderModel extends BaseModel {
    private String getSenderMessage;
    public SenderModel(String getSenderMessage){
        this.getSenderMessage = getSenderMessage;
    }

    public String getGetSenderMessage() {
        return getSenderMessage;
    }

    @Override
    int getViewType() {
        return 0;
    }
}
