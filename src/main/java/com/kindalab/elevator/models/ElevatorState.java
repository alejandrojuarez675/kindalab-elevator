package com.kindalab.elevator.models;

public abstract class ElevatorState {

    Elevator elevator;

    public ElevatorState(Elevator elevator) {
        this.elevator = elevator;
    }

    public abstract void callToGoUpFromFloor(Long floor);
    public abstract void callToGoDownFromFloor(Long floor);
    public abstract void goToFloor(Long floor);
}
