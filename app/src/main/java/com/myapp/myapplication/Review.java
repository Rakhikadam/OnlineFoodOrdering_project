package com.myapp.myapplication;

public class Review {
    String id;
    String image;
    String name;
    String date;
    String title;
    String decription;
    String reviewaverage;
    String hotel_id;
    String type;

    public Review(String id, String image, String name, String date, String title, String decription, String reviewaverage, String hotel_id, String type) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.date = date;
        this.title = title;
        this.decription = decription;
        this.reviewaverage = reviewaverage;
        this.hotel_id = hotel_id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getReviewaverage() {
        return reviewaverage;
    }

    public void setReviewaverage(String reviewaverage) {
        this.reviewaverage = reviewaverage;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }
}
