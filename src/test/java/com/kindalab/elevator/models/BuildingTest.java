package com.kindalab.elevator.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class BuildingTest {

    @Test
    public void publicElevator_roundTest() {
        Building building = new Building(
                new Elevator(-1L, 50L, 4000D),
                new ElevatorWithPrivateStories(-1L, 50L, 1000D, List.of(-1L, 50L))
        );

        building.getPublicElevator().call(0L);
        Assertions.assertEquals(0L, building.getPublicElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getPublicElevator().getState().getClass());

        building.getPublicElevator().setWeight(399D);
        building.getPublicElevator().goToFloor(23L, false);
        Assertions.assertEquals(23L, building.getPublicElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getPublicElevator().getState().getClass());

        building.getPublicElevator().call(10L);
        building.getPublicElevator().setWeight(300D);
        building.getPublicElevator().goToFloor(13L, false);
        building.getPublicElevator().goToFloor(26L, false);
        Assertions.assertEquals(26L, building.getPublicElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getPublicElevator().getState().getClass());

        building.getPublicElevator().call(20L);
        building.getPublicElevator().setWeight(500D);
        building.getPublicElevator().goToFloor(50L, false);
        Assertions.assertEquals(20L, building.getPublicElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getPublicElevator().getState().getClass());

        building.getPublicElevator().goToFloor(50L, true);
        Assertions.assertEquals(50L, building.getPublicElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getPublicElevator().getState().getClass());
    }

    @Test
    public void freightElevator_roundTest() {
        Building building = new Building(
                new Elevator(-1L, 50L, 4000D),
                new ElevatorWithPrivateStories(-1L, 50L, 1000D, List.of(-1L, 50L))
        );

        building.getFreightElevator().call(0L);
        Assertions.assertEquals(0L, building.getFreightElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getFreightElevator().getState().getClass());

        building.getFreightElevator().setWeight(399D);
        building.getFreightElevator().goToFloor(23L);
        Assertions.assertEquals(23L, building.getFreightElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getFreightElevator().getState().getClass());

        building.getFreightElevator().call(10L);
        building.getFreightElevator().setWeight(300D);
        building.getFreightElevator().goToFloor(13L);
        building.getFreightElevator().goToFloor(26L);
        Assertions.assertEquals(26L, building.getFreightElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getFreightElevator().getState().getClass());

        building.getFreightElevator().call(20L);
        building.getFreightElevator().setWeight(500D);
        building.getFreightElevator().goToFloor(50L);
        Assertions.assertEquals(50L, building.getFreightElevator().getCurrentFloor());
        Assertions.assertEquals(StoppedState.class, building.getFreightElevator().getState().getClass());

    }
}