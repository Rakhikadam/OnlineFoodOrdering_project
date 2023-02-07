package com.myapp.myapplication;

public class NonvegImage {
    String offer;
    String food_name;
    String price;
    String image;

    public NonvegImage(String offer, String food_name, String price, String image) {
        this.offer = offer;
        this.food_name = food_name;
        this.price = price;
        this.image = image;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
