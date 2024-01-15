package com.example.PartyPal.models;

public class CartModel {

    int image;

    String id;
    String name;
    String price;
    String rating;

    public CartModel(int image, String id, String name, String price, String rating) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
