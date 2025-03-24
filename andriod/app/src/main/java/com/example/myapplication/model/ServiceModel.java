package com.example.myapplication.model;

import java.io.Serializable;

public class ServiceModel implements Serializable {
    public String title;
    public String description;
    public String price;

    public String Ser_duration;

    public String Ser_cat;

    public String Ser_pic1;
    public String Ser_pic2;
    public String Ser_pic3;

    public String Ser_video;
    public String id;

    public ServiceModel(String title, String description, String price, String ser_duration, String ser_cat, String ser_pic1, String ser_pic2, String ser_pic3, String ser_video, String id) {
        this.title = title;
        this.description = description;
        this.price = price;
        Ser_duration = ser_duration;
        Ser_cat = ser_cat;
        Ser_pic1 = ser_pic1;
        Ser_pic2 = ser_pic2;
        Ser_pic3 = ser_pic3;
        Ser_video = ser_video;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return Ser_duration;
    }

    public String getSer_duration() {
        return Ser_duration;
    }

    public void setSer_duration(String ser_duration) {
        Ser_duration = ser_duration;
    }

    public String getSer_video() {
        return Ser_video;
    }

    public void setSer_video(String ser_video) {
        Ser_video = ser_video;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDuration(String description) {
        this.Ser_duration = Ser_duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSer_cat() {
        return Ser_cat;
    }

    public void setSer_cat(String ser_cat) {
        this.Ser_cat = ser_cat;
    }

    public String getSer_pic1() {
        return Ser_pic1;
    }

    public void setSer_pic1(String ser_pic1) {
        this.Ser_pic1 = ser_pic1;
    }

    public String getSer_pic2() {
        return Ser_pic2;
    }

    public void setSer_pic2(String ser_pic2) {
        this.Ser_pic2 = ser_pic2;
    }

    public String getSer_pic3() {
        return Ser_pic3;
    }

    public void setSer_pic3(String ser_pic3) {
        this.Ser_pic3 = ser_pic3;
    }

  /*  public String getSer_video() {
        return Ser_video;
    }

    public void setSer_video(String ser_video) {
        this.Ser_video = ser_video;
    }*/
}
