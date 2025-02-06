//** https://stackoverflow.com/questions/54630237/can-someone-please-tell-is-there-any-java-built-in-package-for-circular-queue
// link above is for a circular queue, needed for traffic light ordering
// |
// |
// \/
// import isn't working
// import org.apache.commons.collections.buffer.BoundedCircularFifoBuffer;
public class Junction {
    private Arm[] arms;
    private MoveableObject[][] cArea; //** Central junction area */
    private short nextSpawnID;

    // private Buffer circularQueue;
    private Boolean prioritsedTrafficFlow;
    // private Boolean perfectTrafficLights;
    private Boolean driveOnLeft;
    private Boolean uniformTrafficFlow;
    // private <int, long, long> simulationDuration;
    // ... cont with simulation parameters

    public Arm[] getArms(){
        return arms;
    }
    // don't need a setter for things like arms do we?

    public MoveableObject[][] getCArea(){
        return cArea;
    }

    // ... cont with getters and setters

    /**
     * <p> Method looks at the dimensions of the arms and
     * constructs a matrix of MoveableObject for the class
     * which represents the central junction area </p>
     * @param the number of lanes from each direction coming to the junction
     * @return 2d matrix of MoveableObject type
     */
    private MoveableObject[][] buildCentralArea(byte north, byte east, byte south, byte west){
        return new MoveableObject[0][0];
    }
}
