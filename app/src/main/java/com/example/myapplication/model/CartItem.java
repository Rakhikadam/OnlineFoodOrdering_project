package com.example.myapplication.model;

import java.util.List;

public class CartItem {
    String name;
    String imageUrl;
    String price;
    String count;
    List<AddOn> addOnList;

    public CartItem(String name, String imageUrl, String price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<AddOn> getAddOnList() {
        return addOnList;
    }

    public void setAddOnList(List<AddOn> addOnList) {
        this.addOnList = addOnList;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
