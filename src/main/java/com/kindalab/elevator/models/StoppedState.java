package com.kindalab.elevator.models;

import java.util.Optional;

public class StoppedState extends ElevatorState {

    public StoppedState(Elevator elevator) {
        super(elevator);
        System.out.println("Stop " + this.elevator.getCurrentFloor());

        this.elevator.removeRequiredFloor(this.elevator.getCurrentFloor());

        if (!this.elevator.getRequiredList().isEmpty()) {
            moveToNearFloor();
        }
    }

    @Override
    public void callToGoUpFromFloor(Long floor) {
        this.elevator.addRequiredFloor(floor);
        moveToNearFloor();
    }

    @Override
    public void callToGoDownFromFloor(Long floor) {
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
        System.out.println("[Stopped] Move to floor: " + floor);
        if (this.elevator.getWeight() > this.elevator.getMaxWeight()) {
            System.out.println("Overweight, the elevator turn off");
            // delay to change overweight
            return;
        }

        if (floor.equals(this.elevator.getCurrentFloor())) {
            this.elevator.setState(new StoppedState(this.elevator));
            return;
        }

        this.elevator.addRequiredFloor(floor);

        if (this.elevator.getCurrentFloor() > floor) {
            this.elevator.setState(new GoDownState(this.elevator));
        } else if (this.elevator.getCurrentFloor() < floor) {
            this.elevator.setState(new GoUpState(this.elevator));
        }
    }

}
