package com.kindalab.elevator.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorWithoutPrivateStoriesTest {

    @Test
    void callToGoUpFromFloorZeroFirstTime() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of());

        elevator.callToGoUpFromFloor(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    void callFromZeroAndGoToUpperStory() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of());

        elevator.callToGoUpFromFloor(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    void callFromZeroAndGoToALowerStory() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of());

        elevator.callToGoUpFromFloor(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(5L);
        Assertions.assertEquals(5L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    void callFromZeroAndGoToOutsideRangeStory() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of());

        elevator.callToGoUpFromFloor(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(100L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    void callFromZeroAndGoToOverweight() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of());

        elevator.callToGoUpFromFloor(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(4000D);
        elevator.goToFloor(10L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }
}