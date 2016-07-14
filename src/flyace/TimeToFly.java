package flyace;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan Elmgren
 * @version 1.01 Checks if all seats are occupied. If thats the case starts the
 * flight
 */
public final class TimeToFly implements Runnable{
    
    /**
     *
     * @param pPlane
     *
     * Checks if its time to fly
     */
    PassengerPlane pPlane;
    
    public void checkIfItsTime(PassengerPlane pPlane){

        this.pPlane = pPlane;
        if( pPlane.getNrOfFreeSeats() == 0){
//            pPlane.fly();
            
//            for(int i = 0; i < 10; i++){ // TODO remove?
//                System.out.println("PRIS PASSAGERARE " + i + ":" + pPlane.getSeats().get(0).getPrice() );
//            }
            Thread flyThread = new Thread(this);
            flyThread.start();
            
            
        }
    }
    	@Override
	public void run() {
  
        /*
        REFUELLING, 2  minuter
        BOARDING,   8 minuter 
        TAKEOFF,    1 sekund
        INFLIGHT,   35 sekunder
        LANDING,    1 sekund
        DEBARKING,   10 minuter
        INACTIVE    ?
        */
        System.out.println(pPlane.getName() + " is refuelling");
        pPlane.setStatus(PlaneStatus.REFUELLING);
        try {
            //Thread.sleep(2*60*1000); //Sleep 2 minutes
            Thread.sleep(1 * 1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(pPlane.getName() + " is boarding");
        pPlane.setStatus(PlaneStatus.BOARDING);
        
        try {
            //Thread.sleep(8 * 60 * 1_000); // Sleep 8 minutes
            Thread.sleep(2 * 1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(pPlane.getName() + " is taking off");
        pPlane.setStatus(PlaneStatus.TAKEOFF);
        
        try {
            Thread.sleep(7 * 1000); //Sleep 1 second
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(pPlane.getName() + " is in flight");
        pPlane.setStatus(PlaneStatus.INFLIGHT);
        
        try {
            // Thread.sleep(35 * 1000); //Sleep 37 seconds
            Thread.sleep(10 * 1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(pPlane.getName() + " is landing");
        pPlane.setStatus(PlaneStatus.LANDING);
        
        try {
            Thread.sleep(10 * 1000); //Sleep 1 second
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(pPlane.getName() + " is debarking");
        pPlane.setStatus(PlaneStatus.DEBARKING);
        
        try {
            //Thread.sleep(10*60*1000); //Sleep 10 minutes
            Thread.sleep(2 * 1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pPlane.freeAllSeats();
        System.out.println(pPlane.getName() + " is inactive");
        pPlane.setStatus(PlaneStatus.INACTIVE);            
            
        }


}
