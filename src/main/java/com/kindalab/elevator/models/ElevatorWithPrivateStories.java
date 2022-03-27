package com.kindalab.elevator.models;

import java.util.List;

public class ElevatorWithPrivateStories extends Elevator {

    private List<Long> privateStories;

    public ElevatorWithPrivateStories(Long minStory, Long maxStory, Double maxWeight, List<Long> privateStories) {
        super(minStory, maxStory, maxWeight);
        this.privateStories = privateStories;
    }

}
