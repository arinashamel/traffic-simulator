public class Arm {
    
    private LaneObject incomingLanes;
    private LaneObject outGoingLanes;

    /**
     * <p> Method updates the structure of the lanes</p>
     * @param the number of lanes coming in and for each viable direction,
     * the number of lanes going there
     * @return void, maybe change to Boolean to show sucess or failure
     */
    public void updateLaneStructure(byte numLanesIn, byte numLanesCentre, 
    byte numLanesLeft, byte numLanesRight, Boolean pedestrianC, 
    Boolean busLane) throws IllegalArgumentException
    {
        try{
            if(numLanesLeft>0 && busLane){
                throw new IllegalArgumentException();
            }
            else{
                // call method in LaneObject to return the new LaneObject structure
                // and set it as that in the incomingLanes field
                // also need to do this for the opposite lanes as we not lane merging
                // therefore possibly return an integer to set the opposite outgoing
                // lanes to same number
            }
        }
        catch(IllegalArgumentException e){
            
            e.printStackTrace();
        }
    }
}
