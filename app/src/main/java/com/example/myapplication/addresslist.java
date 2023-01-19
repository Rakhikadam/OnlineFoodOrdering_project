package com.example.myapplication;

public class addresslist {
    String name ;
    String location ;
    String address;
    String number_email;

    public addresslist(String name, String location, String address, String number_email) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.number_email = number_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number_email;
    }

    public void setNumber(String number_email) {
        this.number_email = number_email;
    }
}
