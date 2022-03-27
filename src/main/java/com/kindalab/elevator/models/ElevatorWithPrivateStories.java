package com.kindalab.elevator.models;

import java.util.List;

public class ElevatorWithPrivateStories extends Elevator {

    private final List<Long> privateStories;

    public ElevatorWithPrivateStories(Long minStory, Long maxStory, Double maxWeight, List<Long> privateStories) {
        super(minStory, maxStory, maxWeight);
        this.privateStories = privateStories;
    }

    public void goToFloor(Long floor) {
        System.out.println("Somebody order elevator without admin cart go to " + floor);

        if (this.privateStories != null && !this.privateStories.isEmpty()) {
            if (privateStories.contains(floor)) {
                System.out.println("Somebody try to go to a private story without admin cart");
                return;
            }
        }

        this.getState().goToFloor(floor);
    }

    public void goToFloor(Long floor, Boolean isAdmin) {
        if (isAdmin) {
            this.getState().goToFloor(floor);
        } else {
            this.goToFloor(floor);
        }
    }
}
