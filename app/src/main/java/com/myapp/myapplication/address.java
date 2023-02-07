package com.myapp.myapplication;

public class address {
    String name;
    String email;
    String address;
    String nearest_landmark;
    String state;
    String city;

    public address(String name, String email, String address, String nearest_landmark, String state, String city) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.nearest_landmark = nearest_landmark;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNearest_landmark() {
        return nearest_landmark;
    }

    public void setNearest_landmark(String nearest_landmark) {
        this.nearest_landmark = nearest_landmark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
