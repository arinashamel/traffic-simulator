import java.util.ArrayList;

public class LaneObject {
    byte directionComingIn;
    MoveableObject[][] lanes;
    byte[] laneTypes;
    Boolean leftDrive;

    // directions and numerical values
    // NORTH = 0
    // EAST = 1
    // SOUTH = 2
    // WEST = 3
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

    public LaneObject(byte[] laneTypes){
        this.laneTypes = laneTypes;
        lanes = new MoveableObject[laneTypes.length][LANE_LENGTH];
    }

    public Boolean spawnVehicle(int id, byte endLane, Boolean bus){
        if(bus && armContainsBusLane()){ // spawning a bus
            // do we need this, or can we spawn buses anyway even if no bus lane
        }
        else{// spawning a car
            MoveableObject temp = new MoveableObject();
            byte startLane = findStartingLane(endLane);

        }
        return false;
    }
    private Boolean armContainsBusLane(){
        return false;
    }
    private byte findStartingLane(byte endLane){
        //identify which lanes we can go in to start
        //identify which of those lanes are emptiest
        //if one no need to check
        ArrayList<Byte> viableLanes = findViableLanes(endLane);
        byte startingLane= -1;
        if(viableLanes.size() ==0){

        }
        else if(viableLanes.size() ==1){

        }
        else{// 2 or more lanes available
            
        }

        if(startingLane ==-1){
            // error
        }
        else{
            return startingLane;
        }
        
    }
    private ArrayList<Byte> findViableLanes(byte endLane){
        ArrayList<Byte> viableLanes = new ArrayList<>();
        for(int i = 0; i < laneTypes.length; i++){
            switch(endLane){
                case 0:
                    // want to go north, identify lanes going north relative to the arm direction, i.e., if we comi
                    break;
                case 1:
                    // want to go east, ...
                    break;
                case 2:
                    // want to go south, ...
                    break;
                case 3:
                    // want to go west, ...
                    break;
                default:
                    // erroneous direction to which we want to go
                    break;
            }
        }
        return viableLanes.toArray();
    }

    
}
