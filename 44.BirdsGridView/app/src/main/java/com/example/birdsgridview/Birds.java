package com.example.birdsgridview;

public class Birds {
    private int Image;
    private String BirdName;

    public Birds(int image, String birdName) {
        Image = image;
        BirdName = birdName;
    }

    public int getImage() {
        return Image;
    }

    public String getBirdName() {
        return BirdName;
    }
}
