package com.travelbookingsystem;

public class Trip {
    private String startDate;
    private String source;
    private String destination;
    private String transportMode;
    private String accommodation;

    public Trip(String startDate, String source, String destination, String transportMode, String accommodation) {
        this.startDate = startDate;
        this.source = source;
        this.destination = destination;
        this.transportMode = transportMode;
        this.accommodation = accommodation;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public String getAccommodation() {
        return accommodation;
    }
}


