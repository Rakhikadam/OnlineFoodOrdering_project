package com.example.myapplication;

public class Hotelinfo {
    String id;
    String name;
    String loacation;
    String image;
    String offers;
    String about;
    String number;
    String averagecost;

    public Hotelinfo(String name, String loacation, String image, String offers, String about, String number, String averagecost) {
        this.name = name;
        this.loacation = loacation;
        this.image = image;
        this.offers = offers;
        this.about = about;
        this.number = number;
        this.averagecost = averagecost;
        id ="0";
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

    public String getLoacation() {
        return loacation;
    }

    public void setLoacation(String loacation) {
        this.loacation = loacation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAveragecost() {
        return averagecost;
    }

    public void setAveragecost(String averagecost) {
        this.averagecost = averagecost;
    }
}
