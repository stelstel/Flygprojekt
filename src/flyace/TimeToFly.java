package flyace;

/**
 *
 * @author Stefan Elmgren
 * @version 1.00
 * Checks if all seats are occupied. If thats the case starts the flight
 */
public final class TimeToFly {
    
    /**
     * 
     * @param pPlane 
     * 
     * Checks if its time to fly
     */
    static public void checkIfItsTime(PassengerPlane pPlane){
        if( pPlane.getNrOfFreeSeats() == 0){
            pPlane.fly();
            
            for(int i = 0; i < 10; i++){ // TODO remove?
                System.out.println("PRIS PASSAGERARE " + i + ":" + pPlane.getSeats().get(0).getPrice() );
            }
            
            
        }
    }
}
