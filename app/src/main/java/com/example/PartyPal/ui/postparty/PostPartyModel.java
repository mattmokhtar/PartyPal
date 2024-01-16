package com.example.PartyPal.ui.postparty;

// PartyModel.java
public class PostPartyModel {
    public String partyTitle;
    public String hostName;
    public String contactInfo;
    public String partyDescription;
    public String dateTime;
    public String location;

    // Default constructor required for calls to DataSnapshot.getValue(PartyModel.class)
    public PostPartyModel() {
    }

    // Constructor to initialize the model
    public PostPartyModel(String partyTitle, String hostName, String contactInfo, String partyDescription, String dateTime, String location) {
        this.partyTitle = partyTitle;
        this.hostName = hostName;
        this.contactInfo = contactInfo;
        this.partyDescription = partyDescription;
        this.dateTime = dateTime;
        this.location = location;
    }
}

