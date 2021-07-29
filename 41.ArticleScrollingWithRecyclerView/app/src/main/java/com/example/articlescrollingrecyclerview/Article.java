package com.example.articlescrollingrecyclerview;

public class Article {
    private int imageView;
    private String mTvHeading2;
    private String mTvHeading3;
    private String mTvPara;
    private String mTvAuthorName;

    public Article(int imageView, String mTvHeading2, String mTvHeading3, String mTvPara,String mTvAuthorName) {
        this.imageView = imageView;
        this.mTvHeading2 = mTvHeading2;
        this.mTvHeading3 = mTvHeading3;
        this.mTvPara = mTvPara;
        this.mTvAuthorName = mTvAuthorName;
    }

    public int getImageView() {
        return imageView;
    }

    public String getmTvHeading2() {
        return mTvHeading2;
    }

    public String getmTvHeading3() {
        return mTvHeading3;
    }

    public String getmTvPara() {
        return mTvPara;
    }

    public String getmTvAuthorName() {
        return mTvAuthorName;
    }

}
