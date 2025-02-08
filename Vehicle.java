import java.time.LocalDateTime;

public class Vehicle extends MoveableObject{
    
    private byte startArm;
    private byte endArm;
    private byte spawnLane;
    private Boolean bus;
    // private Boolean laneLeader; might not be necessary
    private short numStops;
    private short ghgEmissions; // measured in kg/hour, sounds reasonable enough


    public Vehicle(int id, LocalDateTime spawnTime, byte startArm, byte endArm, 
    byte spawnLane, Boolean bus, short ghgEmissions){
        this.id = id;
        this.spawnTime = spawnTime;
        this.startArm = startArm;
        this.endArm = endArm;
        this.spawnLane = spawnLane;
        this.bus = bus;
        numStops = 0; // might need to check if it is spawned into a traffic jam and
        //               is therefore stationary upon spawning, thus would be 1
        this.ghgEmissions = ghgEmissions;
    }
}
