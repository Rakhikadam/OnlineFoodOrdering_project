package com.myapp.myapplication;

public class cuisine {
    String id;
    String name;
    String hotel_id;
    String type;


    public cuisine(String id, String name, String hotel_id, String type) {
        this.id = id;
        this.name = name;
        this.hotel_id = hotel_id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }
}
