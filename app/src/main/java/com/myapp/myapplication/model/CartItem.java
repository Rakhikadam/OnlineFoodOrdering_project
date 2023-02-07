package com.example.myapplication.model;

import java.util.List;

public class CartItem {
    String id;
    String name;
    String imageUrl;
    String price;
    String count;
    String user_id;
    String status;
    List<AddOn> addOnList;

    public CartItem(String id, String name, String imageUrl, String price, String count, String user_id, List<AddOn> addOnList) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.count = count;
        this.user_id = user_id;
        this.addOnList = addOnList;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setOrder_id(String order_id) {
        this.user_id = order_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
