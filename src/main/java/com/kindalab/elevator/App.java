package com.kindalab.elevator;

import com.kindalab.elevator.models.Building;
import com.kindalab.elevator.models.Elevator;
import com.kindalab.elevator.models.ElevatorWithPrivateStories;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Elevator freightElevator = new Elevator(-1L, 50L, 3000D);

        ElevatorWithPrivateStories publicElevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        Building building = new Building(freightElevator, publicElevator);

        building.getFreightElevator().call(0L);
        building.getFreightElevator().setWeight(400D);
        building.getFreightElevator().goToFloor(60L);

        building.getFreightElevator().call(40L);
        building.getFreightElevator().setWeight(4000D);
        building.getFreightElevator().goToFloor(10L);

        building.getPublicElevator().call(0L);
        building.getPublicElevator().setWeight(230D);
        building.getPublicElevator().goToFloor(10L);

        building.getPublicElevator().call(5L);
        building.getPublicElevator().setWeight(180D);
        building.getPublicElevator().goToFloor(15L, false);

        building.getPublicElevator().call(0L);
        building.getPublicElevator().setWeight(1230D);
        building.getPublicElevator().goToFloor(50L, false);

        building.getPublicElevator().call(40L);
        building.getPublicElevator().setWeight(230D);
        building.getPublicElevator().goToFloor(50L, true);
    }

}
