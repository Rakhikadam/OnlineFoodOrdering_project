package com.myapp.myapplication;

public class reviewlistnew {
    String profile;
    String name;
    String comments;
    String date;
    String message;
    String star;

    public reviewlistnew(String profile, String name, String comments, String date, String message, String star) {
        this.profile = profile;
        this.name = name;
        this.comments = comments;
        this.date = date;
        this.message = message;
        this.star = star;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
