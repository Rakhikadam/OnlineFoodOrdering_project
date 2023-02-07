package com.myapp.myapplication;

public class pesronpayment {
    String card_number;
    String name_of_card;
    String expiry_date;
    String CVV;
    String type;

    public pesronpayment(String card_number, String name_of_card, String expiry_date, String CVV, String type) {
        this.card_number = card_number;
        this.name_of_card = name_of_card;
        this.expiry_date = expiry_date;
        this.CVV = CVV;
        this.type = type;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getName_of_card() {
        return name_of_card;
    }

    public void setName_of_card(String name_of_card) {
        this.name_of_card = name_of_card;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
