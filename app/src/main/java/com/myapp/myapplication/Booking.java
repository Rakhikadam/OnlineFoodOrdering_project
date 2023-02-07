package com.myapp.myapplication;

public class Booking {
    String id;
    String user_id;
    String order_id;

    public Booking(String id, String user_id, String order_id) {
        this.id = id;
        this.user_id = user_id;
        this.order_id = order_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
