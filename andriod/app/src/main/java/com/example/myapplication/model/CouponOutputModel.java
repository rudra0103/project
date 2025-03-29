package com.example.myapplication.model;

public class CouponOutputModel {
    public String message;
    public boolean status;
    public CouponModel coupon_data;

    public CouponOutputModel(String message, boolean status, CouponModel coupon_data) {
        this.message = message;
        this.status = status;
        this.coupon_data = coupon_data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CouponModel getCoupon_data() {
        return coupon_data;
    }

    public void setCoupon_data(CouponModel coupon_data) {
        this.coupon_data = coupon_data;
}
}