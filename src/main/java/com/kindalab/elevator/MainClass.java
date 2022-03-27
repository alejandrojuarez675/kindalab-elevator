package com.kindalab.elevator;

import com.kindalab.elevator.models.Elevator;
import com.kindalab.elevator.models.ElevatorWithPrivateStories;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        Elevator freightElevator = new Elevator(-1L, 50L, 3000D);

        freightElevator.callToGoUpFromFloor(0L);
        freightElevator.setWeight(400D);
        freightElevator.goToFloor(60L);

        freightElevator.callToGoDownFromFloor(40L);
        freightElevator.setWeight(4000D);
        freightElevator.goToFloor(10L);

        // --------------------------------------------------------------------------------

        ElevatorWithPrivateStories publicElevator = new ElevatorWithPrivateStories(
                -1L, 50L, 1000D, List.of(-1L, 50L));

        publicElevator.callToGoUpFromFloor(0L);
        publicElevator.setWeight(230D);
        publicElevator.goToFloor(10L);

        publicElevator.callToGoUpFromFloor(5L);
        publicElevator.setWeight(180D);
        publicElevator.goToFloor(15L, false);

        publicElevator.callToGoUpFromFloor(0L);
        publicElevator.setWeight(1230D);
        publicElevator.goToFloor(50L, false);

        publicElevator.callToGoUpFromFloor(40L);
        publicElevator.setWeight(230D);
        publicElevator.goToFloor(50L, true);
    }

}
