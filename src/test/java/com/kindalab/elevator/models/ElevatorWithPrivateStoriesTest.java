package com.kindalab.elevator.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ElevatorWithPrivateStoriesTest {

    @Test
    public void callToGoUpFromFloorZeroFirstTime() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToUpperAllowedStory_withCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(10L, true);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToALowerAllowedStory_withCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(5L, true);
        Assertions.assertEquals(5L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToUpperPrivateStory_withCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(50L, true);
        Assertions.assertEquals(50L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToALowerPrivateStory_withCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(-1L, true);
        Assertions.assertEquals(-1L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToUpperAllowedStory_withoutCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(10L, false);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToALowerAllowedStory_withoutCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(5L, false);
        Assertions.assertEquals(5L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToUpperPrivateStory_withoutCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(50L, false);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToALowerPrivateStory_withoutCard() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(-1L, false);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToUpperAllowedStory_insecureMethod() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToALowerAllowedStory_insecureMethod() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(5L);
        Assertions.assertEquals(5L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToUpperPrivateStory_insecureMethod() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(50L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToALowerPrivateStory_insecureMethod() {
        ElevatorWithPrivateStories elevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        elevator.call(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(-1L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }
}
