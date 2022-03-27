package com.kindalab.elevator.models;

import java.util.Comparator;
import java.util.Optional;

public class GoUpState extends ElevatorState {

    public GoUpState(Elevator elevator) {
        super(elevator);
        System.out.println("Up " + this.elevator.getCurrentFloor());

        this.elevator.setCurrentFloor(this.elevator.getCurrentFloor() + 1);

        if (!this.elevator.getRequiredList().isEmpty()) {

            Optional<Long> minRequiredFloorOpt = this.elevator.getRequiredList().stream()
                    .filter(x -> x >= this.elevator.getCurrentFloor())
                    .min(Comparator.naturalOrder());

            if (minRequiredFloorOpt.isPresent()) {
                Long minRequiredFloor = minRequiredFloorOpt.get();

                if (minRequiredFloor.equals(this.elevator.getCurrentFloor())) {
                    this.elevator.setState(new StoppedState(this.elevator));
                } else {
                    this.elevator.setState(new GoUpState(this.elevator));
                }

            } else {
                this.elevator.setState(new StoppedState(this.elevator));
            }
        } else {
            this.elevator.setState(new StoppedState(this.elevator));
        }

    }

    @Override
    public void callToGoUpFromFloor(Long floor) {
        if (floor.equals(this.elevator.getCurrentFloor())) {
            this.elevator.setState(new StoppedState(this.elevator));
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
