package com.kindalab.elevator.models;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private Long currentFloor;
    private Long minStory;
    private Long maxStory;
    private Double weight;
    private Double maxWeight;
    private List<Long> requiredList;
    private ElevatorState state;

    public Elevator(Long minStory, Long maxStory, Double maxWeight) {
        this.minStory = minStory;
        this.maxStory = maxStory;
        this.maxWeight = maxWeight;
        this.currentFloor = 0L;
        this.weight = 0D;
        this.requiredList = new ArrayList<>();
        this.state = new StoppedState(this);
    }

    public Long getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Long currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<Long> getRequiredList() {
        return requiredList;
    }

    public void setRequiredList(List<Long> requiredList) {
        this.requiredList = requiredList;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public Long getMinStory() {
        return minStory;
    }

    public void setMinStory(Long minStory) {
        this.minStory = minStory;
    }

    public Long getMaxStory() {
        return maxStory;
    }

    public void setMaxStory(Long maxStory) {
        this.maxStory = maxStory;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addRequiredFloor(Long floor) {
        if (this.requiredList == null) {
            this.requiredList = new ArrayList<>();
        }

        if (!this.requiredList.contains(floor)) {
            this.requiredList.add(floor);
        }
    }

    public void removeRequiredFloor(Long floor) {
        if (this.requiredList == null) {
            this.requiredList = new ArrayList<>();
        }

        this.requiredList.remove(floor);
    }

}
