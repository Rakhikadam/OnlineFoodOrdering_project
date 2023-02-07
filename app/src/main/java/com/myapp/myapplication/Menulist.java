package com.myapp.myapplication;

public class Menulist {
    String id;
    String name;
    String image;
    String price;
    String category;
    String serve_type;
    String hotel_id;
    String type;

    public Menulist(String id, String name, String image, String price, String category, String serve_type, String hotel_id, String type) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.category = category;
        this.serve_type = serve_type;
        this.hotel_id = hotel_id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getServe_type() {
        return serve_type;
    }

    public void setServe_type(String serve_type) {
        this.serve_type = serve_type;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
