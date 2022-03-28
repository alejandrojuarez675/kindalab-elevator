package com.kindalab.elevator;

import com.kindalab.elevator.models.Elevator;
import com.kindalab.elevator.models.ElevatorWithPrivateStories;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        Elevator freightElevator = new Elevator(-1L, 50L, 3000D);

        freightElevator.call(0L);
        freightElevator.setWeight(400D);
        freightElevator.goToFloor(60L);

        freightElevator.call(40L);
        freightElevator.setWeight(4000D);
        freightElevator.goToFloor(10L);

        // --------------------------------------------------------------------------------

        ElevatorWithPrivateStories publicElevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        publicElevator.call(0L);
        publicElevator.setWeight(230D);
        publicElevator.goToFloor(10L);

        publicElevator.call(5L);
        publicElevator.setWeight(180D);
        publicElevator.goToFloor(15L, false);

        publicElevator.call(0L);
        publicElevator.setWeight(1230D);
        publicElevator.goToFloor(50L, false);

        publicElevator.call(40L);
        publicElevator.setWeight(230D);
        publicElevator.goToFloor(50L, true);
    }

}
