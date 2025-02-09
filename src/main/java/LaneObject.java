import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class LaneObject {
    byte directionComingIn;
    MoveableObject[][] lanes;
    ArrayList<Byte> laneTypes;
    Boolean leftDrive;

    // directions and numerical values

    private static final byte NORTH = 0;
    private static final byte EAST = 1;
    private static final byte SOUTH = 2;
    private static final byte WEST = 3;

    // lane types and their numerical values

    private static final byte CENTRE = 4;
    private static final byte LEFT = 5;
    private static final byte RIGHT = 6;
    private static final byte CENTRE_LEFT = 7;
    private static final byte CENTRE_RIGHT = 8;
    private static final byte CENTRE_LEFT_RIGHT = 9;
    private static final byte BUS_LANE = 10;
    private static final byte OUTGOING = 11; // away from the junction

    // preset lane length, open for change

    private static final byte LANE_LENGTH = 100;

    // standard error code for our program = -111

    private static final byte ERROR_CODE = -111;
    private static final byte ALTERNATIVE_SOLUTION = -51;

    public LaneObject(ArrayList<Byte> laneTypes) {
        this.laneTypes = laneTypes;
        lanes = new MoveableObject[laneTypes.size()][LANE_LENGTH];

    }

    public Boolean spawnVehicle(int id, byte endArm, Boolean bus, short ghgEmissions) {
        if (bus) { // spawning a bus
            // do we need this, or can we spawn buses anyway even if no bus lane
            if (armContainsBusLane()) {

            } else {

            }
        } else {// spawning a car
            MoveableObject temp = new MoveableObject();
            byte spawnLane = findStartingLane(endArm);
            Vehicle v = new Vehicle(id, LocalDateTime.now(), directionComingIn, endArm, spawnLane, bus, ghgEmissions);
            lanes[spawnLane][LANE_LENGTH - 1] = v;
        }
        return false;
    }

    public Boolean spawnPedestrianGroup(int id, byte laneBeingCrossed) {
        return false;
    }

    private Boolean armContainsBusLane() {
        return false;
    }

    private byte findStartingLane(byte endArm) throws NullPointerException {
        // identify which lanes we can go in to start
        // identify which of those lanes are emptiest
        // if one no need to check
        try {
            ArrayList<Byte> viableLanes = findViableLanes(endArm);
            byte startingLane = ERROR_CODE;
            if (viableLanes.size() == 0) {
                // error, we have no viable lanes for the direction we want to travel in
                throw new NullPointerException();
            } else if (viableLanes.size() == 1) {
                return viableLanes.get(0);
            } else {// 2 or more lanes available
                return findEmptierLane(viableLanes);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            // how do we handle this error
            return 0;
        }
    }

    private ArrayList<Byte> findViableLanes(byte endArm) {
        ArrayList<Byte> viableLanes = new ArrayList<>();
        byte turnVal = (byte) (directionComingIn - endArm); // value will never be outside range -3<=val<=3

        ArrayList<Byte> temp = new ArrayList<>();

        if (Math.abs(turnVal) == 2) {// want to go straight

            // numerical values for which a lane is acceptable: 4,7,8,9
            for (byte i = 0; i < laneTypes.size(); i++) {
                byte v = laneTypes.get(i);
                if (v == 4 || v == 7 || v == 8 || v == 9) { // can we generalise this feature
                    viableLanes.add(v);
                }
            }

        } else if (turnVal == 1 || turnVal == -3) {// want to turn right

            // numerical values for which a lane is acceptable: 6,8,9

            for (byte i = 0; i < laneTypes.size(); i++) {
                byte v = laneTypes.get(i);
                if (v == 6 || v == 8 || v == 9) { // can we generalise this feature
                    viableLanes.add(v);
                }
            }
        } else if (turnVal == -1 || turnVal == 3) {// want to turn left

            // numerical values for which a lane is acceptable: 5,7,9

            for (byte i = 0; i < laneTypes.size(); i++) {
                byte v = laneTypes.get(i);
                if (v == 5 || v == 7 || v == 9) { // can we generalise this feature
                    viableLanes.add(v);
                }
            }
        } else {
            // error
        }
        return viableLanes;
    }

    private byte findEmptierLane(ArrayList<Byte> viableLanes) {

        byte emptiestLane = ERROR_CODE;
        byte minCarsFound = 101;

        for (byte i = 0; i < viableLanes.size(); i++) {
            // find which lane has less vehicles, return that one
            byte carsCount = 0;
            for (byte j = 0; j < LANE_LENGTH; j++) {
                if (lanes[i][j] != null) { // need to set empty cells to null
                    carsCount++;
                }
            }
            if (carsCount < minCarsFound) {
                emptiestLane = i;
            }
        }
        return emptiestLane;
    }

    private byte nextAvailableSlot(byte lane) { // delete if not used by the end
        for (byte i = 0; i < LANE_LENGTH; i++) {
            if (lanes[lane][i] == null) {
                return i;
            }
        }
        return ALTERNATIVE_SOLUTION;
    }

    public static byte getLaneLength() {
        return LANE_LENGTH;
    }

    // Getter methods for the constants
    public static byte getCentreLane() {
        return CENTRE;
    }

    public static byte getLeftLane() {
        return LEFT;
    }

    public static byte getRightLane() {
        return RIGHT;
    }

    public static byte getNorth() {
        return NORTH;
    }

}
