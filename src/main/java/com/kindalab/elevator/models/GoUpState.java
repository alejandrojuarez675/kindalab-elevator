package com.kindalab.elevator.models;

import java.util.Comparator;
import java.util.Optional;

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
        this.goingUp();
    }

    private void goingUp() {
        if (!this.elevator.getRequiredList().isEmpty()) {
            Optional<Long> minRequiredFloorOpt = this.elevator.getRequiredList().stream()
                    .filter(x -> x >= this.elevator.getCurrentFloor())
                    .min(Comparator.naturalOrder());

            if (minRequiredFloorOpt.isPresent()) {
                Long minRequiredFloor = minRequiredFloorOpt.get();

                while (minRequiredFloor > this.elevator.getCurrentFloor()) {
                    System.out.println("Up " + this.elevator.getCurrentFloor());
                    this.elevator.setCurrentFloor(this.elevator.getCurrentFloor() + 1);
                }
            }
        }
        this.elevator.setState(this.elevator.getStoppedState());
    }

}
