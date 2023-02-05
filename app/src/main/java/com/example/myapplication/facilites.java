package com.example.myapplication;

public class facilites {
    String id;
    String text;
    String hotel_id;
    String type;


    public facilites(String id, String text, String hotel_id, String type) {
        this.id = id;
        this.text = text;
        this.hotel_id = hotel_id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }
}
