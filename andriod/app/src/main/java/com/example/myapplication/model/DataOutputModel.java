package com.example.myapplication.model;

import java.util.ArrayList;

public class DataOutputModel {
    public boolean status;
    public ArrayList<BannerModel> banner;
    public ArrayList<CouponModel> coupon;
    public ArrayList<CategoryModel> category;
    public ArrayList<ServiceModel> service;

    public DataOutputModel(boolean status, ArrayList<BannerModel> banner, ArrayList<CouponModel> coupon, ArrayList<CategoryModel> category, ArrayList<ServiceModel> service) {
        this.status = status;
        this.banner = banner;
        this.coupon = coupon;
        this.category = category;
        this.service = service;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<BannerModel> getBanner() {
        return banner;
    }

    public void setBanner(ArrayList<BannerModel> banner) {
        this.banner = banner;
    }

    public ArrayList<CouponModel> getCoupon() {
        return coupon;
    }

    public void setCoupon(ArrayList<CouponModel> coupon) {
        this.coupon = coupon;
    }

    public ArrayList<CategoryModel> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<CategoryModel> category) {
        this.category = category;
    }

    public ArrayList<ServiceModel> getService() {
        return service;
    }

    public void setService(ArrayList<ServiceModel> service) {
        this.service = service;
    }
}
