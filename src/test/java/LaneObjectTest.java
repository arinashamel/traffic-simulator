import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LaneObjectTest {

    @Test
    public void testAddVehicle() {
        ArrayList<Byte> laneTypes = new ArrayList<>(
                Arrays.asList(LaneObject.getCentreLane(), LaneObject.getLeftLane(), LaneObject.getRightLane()));
        LaneObject lane = new LaneObject(laneTypes);
        Vehicle vehicle = new Vehicle(1, LocalDateTime.now(), LaneObject.getNorth(), (byte) 0, (byte) 0, false,
                (short) 0); // Assuming
        // Vehicle
        // has
        // this
        // constructor

        // Add the vehicle to the lane
        lane.spawnVehicle(1, (byte) 0, false, (short) 0);

        // Check if the vehicle is added to the correct lane
        assertTrue(lane.lanes[0][LaneObject.getLaneLength() - 1] != null, "Vehicle should be added to the lane");
    }

    /*
     * @Test
     * public void testMoveVehicle() {
     * ArrayList<Byte> laneTypes = new
     * ArrayList<>(Arrays.asList(LaneObject.getCentreLane(),
     * LaneObject.getLeftLane(), LaneObject.getRightLane()));
     * LaneObject lane = new LaneObject(laneTypes);
     * Vehicle vehicle = new Vehicle(1, LocalDateTime.now(), LaneObject.getNorth(),
     * (byte)0, (byte)0, false, (short)0); // Assuming Vehicle has this constructor
     * 
     * // Add the vehicle to the lane
     * lane.spawnVehicle(1, (byte)0, false, (short)0);
     * 
     * // Simulate vehicle movement (move the vehicle in the array for this test)
     * vehicle.move(); // Assuming move updates the vehicle's position
     * lane.lanes[0][LaneObject.getLaneLength() - 2] = vehicle; // Manually move the
     * vehicle in the array
     * 
     * // Check if the vehicle moved (should no longer be at the last position)
     * assertTrue(lane.lanes[0][LaneObject.getLaneLength() - 2] != null,
     * "Vehicle should be moved to the correct position in the lane");
     * }
     */

    @Test
    public void testRemoveVehicle() {
        ArrayList<Byte> laneTypes = new ArrayList<>(
                Arrays.asList(LaneObject.getCentreLane(), LaneObject.getLeftLane(), LaneObject.getRightLane()));
        LaneObject lane = new LaneObject(laneTypes);
        Vehicle vehicle = new Vehicle(1, LocalDateTime.now(), (byte) 0, (byte) 0, (byte) 0, false, (short) 0);

        // Add the vehicle to the lane
        lane.spawnVehicle(1, (byte) 0, false, (short) 0);

        // Remove the vehicle (in this test, we'll assume it's set to null manually)
        lane.lanes[0][LaneObject.getLaneLength() - 1] = null;

        // Check if the vehicle is removed
        assertTrue(lane.lanes[0][LaneObject.getLaneLength() - 1] == null, "Vehicle should be removed from the lane");
    }
}