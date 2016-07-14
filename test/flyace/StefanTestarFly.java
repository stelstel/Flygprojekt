package flyace;

import flyace.Fly;
import flyace.PassengerPlane;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan Elmgren
 */
// Testing the fly method of PassengerPlane to get 3 planes in 3 threads flying
public class StefanTestarFly {
    public static void main(String[] args) {
        PassengerPlane pPlane = new PassengerPlane("Stukka", 12);
        Fly fly = new Fly(pPlane.getName());        
        
        // * 1 * Make a runnable object (the threads job)
        Runnable plane1 = new PassengerPlane("Plane ONE", 10);
        Runnable plane2 = new PassengerPlane("Plane TWO", 10);
        Runnable plane3 = new PassengerPlane("Plane THREE", 10);
        
        // * 2 * Make a Thread object (the worker) and give it a Runnable (the job)
        Thread thread1 = new Thread(plane1);
        Thread thread2 = new Thread(plane2);
        Thread thread3 = new Thread(plane3);
        
        // * 3 * Start the Thread
        thread1.start();
        
        Random rand = new Random();
        
        try {
            Thread.sleep(rand.nextInt(1000) + 1); //Random 0-1 second
        } catch (InterruptedException ex) {
            Logger.getLogger(StefanTestarFly.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        thread2.start();
        
        try {
            Thread.sleep(rand.nextInt(1000) + 1); //Random 0-1 second
        } catch (InterruptedException ex) {
            Logger.getLogger(StefanTestarFly.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        thread3.start();
    }
}
