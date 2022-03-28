package com.kindalab.elevator.models;

public class GoUpState implements ElevatorState {

    private final Elevator elevator;

    public GoUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void call(Long floor) {
        this.elevator.addRequiredFloor(floor);
    }

    @Override
    public void goToFloor(Long floor) {
        this.elevator.addRequiredFloor(floor);
    }

}
