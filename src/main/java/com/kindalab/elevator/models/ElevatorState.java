package com.kindalab.elevator.models;

public interface ElevatorState {

    void callToGoUpFromFloor(Long floor);
    void callToGoDownFromFloor(Long floor);
    void goToFloor(Long floor);
}
