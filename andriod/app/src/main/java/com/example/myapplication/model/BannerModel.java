package com.example.myapplication.model;

public class BannerModel{
    public String cat_pic;
    public String banner_name;
    public String banner_pic;

    public String id;

    public BannerModel(String id, String banner_pic, String banner_name, String cat_pic) {
        this.id = id;
        this.banner_pic = banner_pic;
        this.banner_name = banner_name;
        this.cat_pic = cat_pic;
    }

    public String getCat_pic() {
        return cat_pic;
    }

    public void setCat_pic(String cat_pic) {
        this.cat_pic = cat_pic;
    }

    public String getBanner_name() {
        return banner_name;
    }

    public void setBanner_name(String banner_name) {
        this.banner_name = banner_name;
    }

    public String getBanner_pic() {
        return banner_pic;
    }

    public void setBanner_pic(String banner_pic) {
        this.banner_pic = banner_pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
