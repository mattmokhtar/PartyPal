package com.example.PartyPal.ui.postparty;

public class PostPartyModel {
    public String partyTitle;
    public String hostName;
    public String contactInformation;
    public String partyDescription;
    public String partyDate;
    public String partyLocation;


    public PostPartyModel(String partyTitle, String hostName, String contactInformation, String partyDescription, String partyDate, String partyLocation) {
        this.partyTitle = partyTitle;
        this.hostName = hostName;
        this.contactInformation = contactInformation;
        this.partyDescription = partyDescription;
        this.partyDate = partyDate;
        this.partyLocation = partyLocation;
    }
}

