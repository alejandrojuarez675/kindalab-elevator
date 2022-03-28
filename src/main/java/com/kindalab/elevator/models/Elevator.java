package com.kindalab.elevator.models;

import java.util.ArrayList;
import java.util.List;

public class Elevator implements ElevatorState {

    private Long currentFloor;
    private Long minStory;
    private Long maxStory;
    private Double weight;
    private Double maxWeight;
    private List<Long> requiredList;
    private ElevatorState state;

    private final ElevatorState stoppedState;
    private final ElevatorState goUpState;
    private final ElevatorState goDownState;

    public Elevator(Long minStory, Long maxStory, Double maxWeight) {
        this.minStory = minStory;
        this.maxStory = maxStory;
        this.maxWeight = maxWeight;
        this.currentFloor = 0L;
        this.weight = 0D;
        this.requiredList = new ArrayList<>();

        this.stoppedState = new StoppedState(this);
        this.goUpState = new GoUpState(this);
        this.goDownState = new GoDownState(this);

        this.state = this.stoppedState;
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

    public ElevatorState getStoppedState() {
        return stoppedState;
    }

    public ElevatorState getGoUpState() {
        return goUpState;
    }

    public ElevatorState getGoDownState() {
        return goDownState;
    }

    public void addRequiredFloor(Long floor) {
        if (floor > maxStory || floor < minStory) {
            System.out.println("Out of range story");
            return;
        }

        if (this.requiredList == null) {
            this.requiredList = new ArrayList<>();
        }

        if (!this.requiredList.contains(floor)) {
            this.requiredList.add(floor);
        }
        System.out.println("Add floor: Updating required list: " + this.requiredList.toString());
    }

    public void removeRequiredFloor(Long floor) {
        if (this.requiredList == null) {
            this.requiredList = new ArrayList<>();
        }

        this.requiredList.remove(floor);
        System.out.println("Remove floor: Updating required list: " + this.requiredList.toString());
    }

    @Override
    public void call(Long floor) {
        System.out.println("Somebody call elevator from " + floor);
        this.state.call(floor);
    }

    @Override
    public void goToFloor(Long floor) {
        System.out.println("Somebody order elevator got to " + floor);
        this.state.goToFloor(floor);
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                ", minStory=" + minStory +
                ", maxStory=" + maxStory +
                ", weight=" + weight +
                ", maxWeight=" + maxWeight +
                ", requiredList=" + requiredList +
                ", state=" + (state != null ? state.getClass() : "null") +
                '}';
    }
}
