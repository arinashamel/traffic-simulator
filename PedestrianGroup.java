import java.time.LocalDateTime;
public class PedestrianGroup extends MoveableObject{
    private short numPedestrians;
    private byte currentPosOnCrossing;

    public PedestrianGroup(int id, LocalDateTime spawnTime, short numPedestrians){
        this.id = id;
        this.spawnTime = spawnTime;
        this.numPedestrians = numPedestrians;
        currentPosOnCrossing = -1;
    }
    
    public short getNumPedestrians(){
        return numPedestrians;
    }
    public void setNumPedestrians(short num){ // remove if not used
        numPedestrians = num;
    }
    public void addToNumPedestrians(short num){
        numPedestrians += num;
    }
}
