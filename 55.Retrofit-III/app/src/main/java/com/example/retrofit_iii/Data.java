package com.example.retrofit_iii;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("in_most_viral")
	private boolean inMostViral;

	@SerializedName("ad_type")
	private int adType;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private Object description;

	@SerializedName("section")
	private Object section;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("deletehash")
	private String deletehash;

	@SerializedName("datetime")
	private int datetime;

	@SerializedName("has_sound")
	private boolean hasSound;

	@SerializedName("id")
	private String id;

	@SerializedName("in_gallery")
	private boolean inGallery;

	@SerializedName("vote")
	private Object vote;

	@SerializedName("views")
	private int views;

	@SerializedName("height")
	private int height;

	@SerializedName("bandwidth")
	private int bandwidth;

	@SerializedName("nsfw")
	private Object nsfw;

	@SerializedName("is_ad")
	private boolean isAd;

	@SerializedName("edited")
	private String edited;

	@SerializedName("ad_url")
	private String adUrl;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("account_id")
	private int accountId;

	@SerializedName("size")
	private int size;

	@SerializedName("width")
	private int width;

	@SerializedName("account_url")
	private Object accountUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("animated")
	private boolean animated;

	@SerializedName("favorite")
	private boolean favorite;

	public boolean isInMostViral(){
		return inMostViral;
	}

	public int getAdType(){
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

	public String getTitle(){
		return title;
	}

	public String getType(){
		return type;
	}

	public String getDeletehash(){
		return deletehash;
	}

	public int getDatetime(){
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

	public int getViews(){
		return views;
	}

	public int getHeight(){
		return height;
	}

	public int getBandwidth(){
		return bandwidth;
	}

	public Object getNsfw(){
		return nsfw;
	}

	public boolean isIsAd(){
		return isAd;
	}

	public String getEdited(){
		return edited;
	}

	public String getAdUrl(){
		return adUrl;
	}

	public List<Object> getTags(){
		return tags;
	}

	public int getAccountId(){
		return accountId;
	}

	public int getSize(){
		return size;
	}

	public int getWidth(){
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