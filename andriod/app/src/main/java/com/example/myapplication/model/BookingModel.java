package com.example.myapplication.model;

public class BookingModel {
    public String uid;
    public String pid;
    public int amount;
    public String name;
    public String pic1;
    public int tot_amount;
    public String address;
    public String date;
    public String time;
    public String service_date;
    public String service_time;
    public int status;
    public String c_o;
    public String c_discount;
    public String c_code;
    public String id;

    public BookingModel(String uid, String pid, int amount, String name, String pic1, int tot_amount, String address, String date, String time, String service_date, String service_time, int status, String c_o, String c_discount, String c_code, String id) {
        this.uid = uid;
        this.pid = pid;
        this.amount = amount;
        this.name = name;
        this.pic1 = pic1;
        this.tot_amount = tot_amount;
        this.address = address;
        this.date = date;
        this.time = time;
        this.service_date = service_date;
        this.service_time = service_time;
        this.status = status;
        this.c_o = c_o;
        this.c_discount = c_discount;
        this.c_code = c_code;
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public int getTot_amount() {
        return tot_amount;
    }

    public void setTot_amount(int tot_amount) {
        this.tot_amount = tot_amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getService_date() {
        return service_date;
    }

    public void setService_date(String service_date) {
        this.service_date = service_date;
    }

    public String getService_time() {
        return service_time;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getC_o() {
        return c_o;
    }

    public void setC_o(String c_o) {
        this.c_o = c_o;
    }

    public String getC_discount() {
        return c_discount;
    }

    public void setC_discount(String c_discount) {
        this.c_discount = c_discount;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
