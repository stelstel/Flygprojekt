package flyace;
import java.util.LinkedHashMap;

/**
 * @author Stefan Elmgren
 * @version 1.33
 * Superclass
*/

public abstract class AirPlane implements Runnable{
    private String model; // Airplane model
    private String name; // Name of the airplane
    private PlaneStatus status;
    
    /**
     * @param customer Customer object
     * @param seatclass First or economy class 
     */
    
    abstract void fly();
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PlaneStatus getStatus() {
        return status;
    }

    public void setStatus(PlaneStatus status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
