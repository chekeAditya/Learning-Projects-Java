package com.example.retorofit_iiiupload.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

    @SerializedName("in_most_viral")
    private Boolean inMostViral;

    @SerializedName("ad_type")
    private Integer adType;

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

    @SerializedName("nsfw")
    private Object nsfw;

    @SerializedName("is_ad")
    private Boolean isAd;

    @SerializedName("ad_url")
    private String adUrl;

    @SerializedName("tags")
    private List<Object> tags;

    @SerializedName("account_id")
    private Integer accountId;

    @SerializedName("size")
    private Integer size;

    @SerializedName("width")
    private Integer width;

    @SerializedName("account_url")
    private Object accountUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("animated")
    private Boolean animated;

    @SerializedName("favorite")
    private Boolean favorite;

    public boolean isInMostViral(){
        return inMostViral;
    }

    public Integer getAdType(){
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

    public Object getNsfw(){
        return nsfw;
    }

    public boolean isIsAd(){
        return isAd;
    }

    public String getAdUrl(){
        return adUrl;
    }

    public List<Object> getTags(){
        return tags;
    }

    public Integer getAccountId(){
        return accountId;
    }

    public Integer getSize(){
        return size;
    }

    public Integer getWidth(){
        return width;
    }

    public Object getAccountUrl(){
        return accountUrl;
    }

    public String getName(){
        return name;
    }

    public boolean isAnimated(){
        return animated;
    }

    public boolean isFavorite(){
        return favorite;
    }
}