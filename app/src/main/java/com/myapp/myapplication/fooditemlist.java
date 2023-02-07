package com.myapp.myapplication;

public class fooditemlist {
    String name;
    String price;
    String category;
    String image;
    String Service_type;

    public fooditemlist(String name, String price, String category, String image, String service_type) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
        Service_type = service_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getService_type() {
        return Service_type;
    }

    public void setService_type(String service_type) {
        Service_type = service_type;
    }
}
