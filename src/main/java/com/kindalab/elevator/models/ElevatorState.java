package com.kindalab.elevator.models;

public interface ElevatorState {

    void call(Long floor);
    void goToFloor(Long floor);
}
