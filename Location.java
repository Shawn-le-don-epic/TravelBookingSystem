package com.travelbookingsystem;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String source;
    private List<String> destinations;
    private List<String> transportOptions;

    public Location(String source) {
        this.source = source;
        this.destinations = new ArrayList<>();
        this.transportOptions = new ArrayList<>();
    }

    public String getSource() {
        return source;
    }

    public void addDestination(String destination) {
        destinations.add(destination);
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void addTransportOption(String transportOption) {
        transportOptions.add(transportOption);
    }

    public List<String> getTransportOptions() {
        return transportOptions;
    }
}

