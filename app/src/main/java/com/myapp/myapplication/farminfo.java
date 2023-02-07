package com.myapp.myapplication;

public class farminfo {
    String id;
    String name;
    String image;
    String price;
    String about;
    String nutration;

    public farminfo(String id, String name, String image, String price, String about, String nutration) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.about = about;
        this.nutration = nutration;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getNutration() {
        return nutration;
    }

    public void setNutration(String nutration) {
        this.nutration = nutration;
    }
}
