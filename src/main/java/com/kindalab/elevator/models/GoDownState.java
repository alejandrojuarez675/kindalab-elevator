package com.kindalab.elevator.models;

import java.util.Comparator;
import java.util.Optional;

public class GoDownState extends ElevatorState {

    public GoDownState(Elevator elevator) {
        super(elevator);

        System.out.println("Elevator is going to down");
        this.elevator.setCurrentFloor(this.elevator.getCurrentFloor() - 1);

        if (!this.elevator.getRequiredList().isEmpty()) {

            Optional<Long> maxRequiredFloorOpt = this.elevator.getRequiredList().stream()
                    .filter(x -> x <= this.elevator.getCurrentFloor())
                    .max(Comparator.naturalOrder());

            if (maxRequiredFloorOpt.isPresent()) {
                Long minRequiredFloor = maxRequiredFloorOpt.get();

                if (minRequiredFloor.equals(this.elevator.getCurrentFloor())) {
                    this.elevator.setState(new StoppedState(this.elevator));
                } else {
                    this.elevator.setState(new GoDownState(this.elevator));
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
        this.elevator.addRequiredFloor(floor);
    }

    @Override
    public void callToGoDownFromFloor(Long floor) {
        if (floor.equals(this.elevator.getCurrentFloor())) {
            this.elevator.setState(new StoppedState(this.elevator));
        } else {
            this.elevator.addRequiredFloor(floor);
        }
    }

    @Override
    public void goToFloor(Long floor) {
        this.elevator.addRequiredFloor(floor);
    }
}
