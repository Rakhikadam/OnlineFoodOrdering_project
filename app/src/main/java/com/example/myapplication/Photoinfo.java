package com.example.myapplication;

public class Photoinfo {
    String id;
    String image;
    String hotel_id;
    String type;

    public Photoinfo(String id, String image, String hotel_id, String type) {
        this.id = id;
        this.image = image;
        this.hotel_id = hotel_id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
