package com.example.myapplication.model;

public class CouponModel{
    public String cou_code;
    public String cou_desc;
    public String cou_discount;
    public String cou_maxamt;
    public String cou_pic;

    public String id;

    public CouponModel(String cou_code, String cou_desc, String cou_discount, String cou_maxamt, String cou_pic, String id) {
        this.cou_code = cou_code;
        this.cou_desc = cou_desc;
        this.cou_discount = cou_discount;
        this.cou_maxamt = cou_maxamt;
        this.cou_pic = cou_pic;
        this.id = id;

    }

    public String getCou_code() {
        return cou_code;
    }

    public void setCou_code(String cou_code) {
        this.cou_code = cou_code;
    }

    public String getCou_desc() {
        return cou_desc;
    }

    public void setCou_desc(String cou_desc) {
        this.cou_desc = cou_desc;
    }

    public String getCou_discount() {
        return cou_discount;
    }

    public void setCou_discount(String cou_discount) {
        this.cou_discount = cou_discount;
    }

    public String getCou_maxamt() {
        return cou_maxamt;
    }

    public void setCou_maxamt(String cou_maxamt) {
        this.cou_maxamt = cou_maxamt;
    }

    public String getCou_pic() {
        return cou_pic;
    }

    public void setCou_pic(String cou_pic) {
        this.cou_pic = cou_pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
