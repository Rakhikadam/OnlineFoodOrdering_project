package com.myapp.myapplication;

public class restaurant {
    String name;
    String offer;
    String image;

    public restaurant(String name, String offer, String image) {
        this.name = name;
        this.offer = offer;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
