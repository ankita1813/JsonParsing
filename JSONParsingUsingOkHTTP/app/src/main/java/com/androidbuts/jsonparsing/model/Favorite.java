package com.androidbuts.jsonparsing.model;

/**
 * Created by Ankita on 02-Sep-17.
 */
public class Favorite {

    private int viewcount;

    private String title;

    private String imageUrl;

    private String desc;

    private String type;

    public int getViewcount() {return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
