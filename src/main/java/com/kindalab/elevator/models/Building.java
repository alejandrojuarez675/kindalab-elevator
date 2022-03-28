package com.kindalab.elevator.models;

public class Building {

    private Elevator freightElevator;
    private ElevatorWithPrivateStories publicElevator;

    public Building(Elevator freightElevator, ElevatorWithPrivateStories publicElevator) {
        this.freightElevator = freightElevator;
        this.publicElevator = publicElevator;
    }

    public Elevator getFreightElevator() {
        return freightElevator;
    }

    public void setFreightElevator(Elevator freightElevator) {
        this.freightElevator = freightElevator;
    }

    public ElevatorWithPrivateStories getPublicElevator() {
        return publicElevator;
    }

    public void setPublicElevator(ElevatorWithPrivateStories publicElevator) {
        this.publicElevator = publicElevator;
    }
}
