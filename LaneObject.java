public class LaneObject {
    MoveableObject[][] lanes;
    Boolean toJunction;
    MoveableObject[] laneLeaders; // same length as there are lanes
    Boolean pedestrianCrossing;
    byte numLeftTurnLanes;
    byte numRightTurnLanes;
    byte numStraightLanes;
    Boolean busLane; // if true, numLeftTurnLanes = 0
    char directionOfTravel;
}
