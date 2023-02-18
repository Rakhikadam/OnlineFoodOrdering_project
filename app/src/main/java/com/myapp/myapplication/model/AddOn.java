package com.example.myapplication.model;

public class AddOn {
    String addon_name ;
    String addon_price;



    public AddOn(String addon_name, String addon_price) {
        this.addon_name = addon_name;
        this.addon_price = addon_price;
    }

    public String getAddon_name() {
        return addon_name;
    }

    public void setAddon_name(String addon_name) {
        this.addon_name = addon_name;
    }

    public String getAddon_price() {
        return addon_price;
    }

    public void setAddon_price(String addon_price) {
        this.addon_price = addon_price;
    }
}
