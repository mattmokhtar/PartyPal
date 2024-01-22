package com.example.PartyPal.models;

public class HomeVerModel {

    int image;
    String name;
    String timing;
    String rating;
    String price;

    public HomeVerModel(int image, String name, String timing, String rating, String price){

        this.image=image;
        this.name=name;
        this.price=price;
        this.rating=rating;
        this.timing=timing;

<<<<<<< Updated upstream
=======

    public HomeVerModel(String partyId, String hostName, String partyTitle, String contactInformation, String partyDescription, String partyDate, String partyLocation) {
        this.hostName = hostName;
        this.partyTitle = partyTitle;
        this.contactInformation = contactInformation;
        this.partyDescription = partyDescription;
        this.partyDate = partyDate;
        this.partyLocation = partyLocation;
>>>>>>> Stashed changes
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getPartyId() {
        return null;
    }
}
