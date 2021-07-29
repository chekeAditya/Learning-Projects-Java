package com.example.uploadvideo.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("in_most_viral")
    private Boolean inMostViral;

    @SerializedName("ad_type")
    private Object adType;

    @SerializedName("link")
    private String link;

    @SerializedName("description")
    private Object description;

    @SerializedName("section")
    private Object section;

    @SerializedName("title")
    private Object title;

    @SerializedName("type")
    private String type;

    @SerializedName("deletehash")
    private String deletehash;

    @SerializedName("datetime")
    private Integer datetime;

    @SerializedName("has_sound")
    private Boolean hasSound;

    @SerializedName("id")
    private String id;

    @SerializedName("in_gallery")
    private Boolean inGallery;

    @SerializedName("vote")
    private Object vote;

    @SerializedName("views")
    private Integer views;

    @SerializedName("height")
    private Integer height;

    @SerializedName("bandwidth")
    private Integer bandwidth;

    @SerializedName("is_ad")
    private Boolean isAd;

    @SerializedName("nsfw")
    private Object nsfw;

    @SerializedName("ad_url")
    private Object adUrl;

    @SerializedName("hls")
    private String hls;

    @SerializedName("tags")
    private List<Object> tags;

    @SerializedName("mp4")
    private String mp4;

    @SerializedName("account_id")
    private Object accountId;

    @SerializedName("size")
    private Integer size;

    @SerializedName("account_url")
    private Object accountUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("width")
    private Integer width;

    @SerializedName("animated")
    private Boolean animated;

    @SerializedName("processing")
    private Processing processing;

    @SerializedName("favorite")
    private Boolean favorite;

    public boolean isInMostViral(){
        return inMostViral;
    }

    public Object getAdType(){
        return adType;
    }

    public String getLink(){
        return link;
    }

    public Object getDescription(){
        return description;
    }

    public Object getSection(){
        return section;
    }

    public Object getTitle(){
        return title;
    }

    public String getType(){
        return type;
    }

    public String getDeletehash(){
        return deletehash;
    }

    public Integer getDatetime(){
        return datetime;
    }

    public boolean isHasSound(){
        return hasSound;
    }

    public String getId(){
        return id;
    }

    public boolean isInGallery(){
        return inGallery;
    }

    public Object getVote(){
        return vote;
    }

    public Integer getViews(){
        return views;
    }

    public Integer getHeight(){
        return height;
    }

    public Integer getBandwidth(){
        return bandwidth;
    }

    public boolean isIsAd(){
        return isAd;
    }

    public Object getNsfw(){
        return nsfw;
    }

    public Object getAdUrl(){
        return adUrl;
    }

    public String getHls(){
        return hls;
    }

    public List<Object> getTags(){
        return tags;
    }

    public String getMp4(){
        return mp4;
    }

    public Object getAccountId(){
        return accountId;
    }

    public Integer getSize(){
        return size;
    }

    public Object getAccountUrl(){
        return accountUrl;
    }

    public String getName(){
        return name;
    }

    public Integer getWidth(){
        return width;
    }

    public boolean isAnimated(){
        return animated;
    }

    public Processing getProcessing(){
        return processing;
    }

    public boolean isFavorite(){
        return favorite;
    }
}
