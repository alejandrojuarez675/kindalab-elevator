package com.kindalab.elevator.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ElevatorTest {

    @Test
    public void callToGoUpFromFloorZeroFirstTime() {
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToUpperStory() {
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToALowerStory() {
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

        elevator.call(10L);
        Assertions.assertEquals(10L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(5L);
        Assertions.assertEquals(5L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToOutsideRangeStory() {
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

        elevator.call(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());

        elevator.setWeight(400D);
        elevator.goToFloor(100L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    public void callFromZeroAndGoToOverweight() {
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

        elevator.call(0L);
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