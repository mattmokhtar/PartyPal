package com.example.PartyPal.models;

public class HomeVerModel {

    private final String hostName;
    private final String partyTitle;
    private final String contactInformation;
    private final String partyDescription;
    private final String partyDate;
    private final String partyLocation;

    public HomeVerModel(String hostName, String partyTitle, String contactInformation, String partyDescription, String partyDate, String partyLocation) {
        this.hostName = hostName;
        this.partyTitle = partyTitle;
        this.contactInformation = contactInformation;
        this.partyDescription = partyDescription;
        this.partyDate = partyDate;
        this.partyLocation = partyLocation;
    }

    public String getHostName() {
        return hostName;
    }

    public String getPartyTitle() {
        return partyTitle;
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
