package com.kindalab.elevator.models;

import java.util.Optional;

public class StoppedState implements ElevatorState {

    private final Elevator elevator;

    public StoppedState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void call(Long floor) {
        this.elevator.addRequiredFloor(floor);
        moveToNearFloor();
    }

    @Override
    public void goToFloor(Long floor) {
        this.elevator.addRequiredFloor(floor);
        moveToNearFloor();
    }

    private void moveToNearFloor() {
        Optional<Long> nearFloor = this.elevator.getRequiredList().stream()
                .min((a, b) -> {
                    Long diffA = Math.abs(a - this.elevator.getCurrentFloor());
                    Long diffB = Math.abs(b - this.elevator.getCurrentFloor());
                    return diffA.compareTo(diffB);
                });

        nearFloor.ifPresent(this::moveToFloor);
    }

    private void moveToFloor(Long floor) {
        System.out.println("[StoppedState] Move to floor: " + floor);

        if (this.elevator.getWeight() > this.elevator.getMaxWeight()) {
            System.out.println("[StoppedState] Overweight, the elevator turn off");
            // delay to change overweight
            return;
        }

        if (floor.equals(this.elevator.getCurrentFloor())) {
            System.out.println("Stop on " + this.elevator.getCurrentFloor());
            this.elevator.setState(this.elevator.getStoppedState());

        } else {

            if (this.elevator.getCurrentFloor() > floor) {
                goToDown(floor);

            } else if (this.elevator.getCurrentFloor() < floor) {
                goToUp(floor);
            }
        }

        this.elevator.removeRequiredFloor(this.elevator.getCurrentFloor());

        if (!this.elevator.getRequiredList().isEmpty()) {
            moveToNearFloor();
        }

    }

    private void goToUp(Long floor) {
        System.out.println("[StoppedState] define go to up until floor " + floor);
        this.elevator.setState(this.elevator.getGoUpState());
        while (this.elevator.getCurrentFloor() < floor) {
            System.out.println("Up " + this.elevator.getCurrentFloor());
            this.elevator.setCurrentFloor(this.elevator.getCurrentFloor() + 1);
        }
        this.elevator.setState(this.elevator.getStoppedState());
    }

    private void goToDown(Long floor) {
        System.out.println("[StoppedState] define go to down until floor " + floor);
        this.elevator.setState(this.elevator.getGoDownState());
        while (this.elevator.getCurrentFloor() > floor) {
            System.out.println("Down " + this.elevator.getCurrentFloor());
            this.elevator.setCurrentFloor(this.elevator.getCurrentFloor() - 1);
        }
        this.elevator.setState(this.elevator.getStoppedState());
    }

}
