package com.kindalab.elevator.models;

public class GoUpState implements ElevatorState {

    private final Elevator elevator;

    public GoUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void callToGoUpFromFloor(Long floor) {
        if (floor.equals(this.elevator.getCurrentFloor())) {
            this.elevator.setState(this.elevator.getStoppedState());
        } else {
            this.elevator.addRequiredFloor(floor);
        }
    }

    @Override
    public void callToGoDownFromFloor(Long floor) {
        this.elevator.addRequiredFloor(floor);
    }

    @Override
    public void goToFloor(Long floor) {
        this.elevator.addRequiredFloor(floor);
    }

}
