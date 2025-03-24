package com.example.myapplication.model;

import java.util.ArrayList;

public class BookingOutputModel {
    public boolean status;
    public String message;
    public ArrayList<BookingModel> booking;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<BookingModel> getBooking() {
        return booking;
    }

    public void setBooking(ArrayList<BookingModel> booking) {
        this.booking = booking;
    }
}
