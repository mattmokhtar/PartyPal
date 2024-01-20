package com.example.PartyPal.models;

public class YourPostModel {

    private final String partyTitle;
    private String hostName;
    private String contactInformation;
    private String partyDescription;
    private String partyDate;
    private String partyLocation;

    public YourPostModel(String partyTitle, String hostName, String contactInformation, String partyDescription, String partyDate, String partyLocation) {
        this.partyTitle = partyTitle;
        this.hostName = hostName;
        this.contactInformation = contactInformation;
        this.partyDescription = partyDescription;
        this.partyDate = partyDate;
        this.partyLocation = partyLocation;
    }

    public String getPartyTitle() {
        return partyTitle;
    }

    public String getHostName() {
        return hostName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public String getPartyDescription() {
        return partyDescription;
    }

    public String getPartyDate() {
        return partyDate;
    }

    public String getPartyLocation() {
        return partyLocation;
    }
}


