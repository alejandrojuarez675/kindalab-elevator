# KindaLab elevator test

## Exam statement
- Please write a small program that effectively models this scenario, making
  sure to adhere to proper OOP design.
- Include a basic set of unit test
- Please include README file with instruction for running your program.
- Please push your code as a MVN project in a github repository.

### Problem

- The building is 50 stories high and has a basement additionally.
- The building has two elevators. One is for the public and another is a
freight elevator.

  - Public Elevator
    - The public elevator can go to all floors but you need a
    keycard to access the basement and 50th floor.
    - The public elevator has a weight limit of 1 ton.
    iii.This elevator has an alarm and shut off mechanism if
    the weight limit is exceeded.

  - Freight Elevator
    - The freight elevator can go to all floors and the
    basement without a keycard.
    - The freight elevator has a weight limit of 3 tons.
    - This elevator has an alarm and shut off mechanism if
    the weight limit is exceeded.

- You need to design the keycard system for the public elevator.
- We need a way to manage the position of the elevator in the building.


## Solution
### Proposal
I propose use the state pattern to control elevator position.

I simplify the problem, assuming that has only three state, 
moving to up, to down and stopped. So I don't model other like open doors for example.

The logic of the program is on the classes:
- Elevator
- ElevatorState
- GoDownState
- GoUpState
- StoppedState

These classes control the elevator position. Because of time (I spent about 6 hour on 
this test), I model a simple control, that don't allow intermediate stops between 
travels. For example, if you travel from the floor 10 to 5 and when you are on 8 
floor somebody calls the  elevator from 6 floor, the elevator doesn't stop on 6, 
it will go to 5, stop and after will go to 6.

Additionally, I model an elevator that has private floors, to access to them, you need 
a keycard. These type of elevators I call ElevatorWithPrivateStories, when you create 
one, you  need to set what are this private floors

So to model the building, I created a Building object that has a public elevator and a 
freight elevator. On ``src/test/java/com/kindalab/elevator/models/BuildingTest.java`` 
you can see how to use it.

Furthermore, there are a DEMO that shows how to set a building and use it. It's on file
``src/main/java/com/kindalab/elevator/App.java``. This program has no function, it's only for shows how to use.

### How to run
It's a maven project so to compile and run tests you can use:
````
mvn clean install
````

In case that you want to run the demo
````
mvn clean install
mvn package
java -cp target\kindalab-elevator-1.0-SNAPSHOT.jar com.kindalab.elevator.App
````
