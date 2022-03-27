package com.kindalab.elevator.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ElevatorTest {

    @Test
    void callToGoUpFromFloorZeroFirstTime() {
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

        elevator.callToGoUpFromFloor(0L);
        Assertions.assertEquals(0L, elevator.getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, elevator.getState().getClass());
    }

    @Test
    void callFromZeroAndGoToUpperStory() {
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

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
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

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
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

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
        Elevator elevator = new Elevator(-1L, 50L, 1000D);

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