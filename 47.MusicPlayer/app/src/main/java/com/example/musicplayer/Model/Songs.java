package com.example.musicplayer.Model;

public class Songs {

    public static final int Text_Type = 0;
    public static final int Image_type = 1;
    public static final int Audio_type = 2;


    private int itemType;
    private int resId;
    private String content;

    public Songs(int itemType, int resId, String content) {
        this.itemType = itemType;
        this.resId = resId;
        this.content = content;
    }

    public int getItemType() {
        return itemType;
    }

    public int getResId() {
        return resId;
    }

    public String getContent() {
        return content;
    }
}
