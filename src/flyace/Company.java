package flyace;

import java.util.ArrayList;

//Company
//	Selects the plane which is presently boarding
//	Adds the Company to the ticket
//	Sends the ticket to the Plane
//		plane.putCustomer(Ticket);

public class Company{

    private String name;
    private int money;
    private double profit = 0.3;
    private ArrayList<AirPlane> planes = new ArrayList<AirPlane>();

    //******************* Constructors *****************************************
    public Company(String name) {
        this.name = name;
    }

    public Company() {
    
    }
    
    public void addMoney(int mon) {
        this.money += mon;    }

    void buyPlane(AirPlane plane) {
        planes.add(plane);
    }

    void sellPlane(AirPlane plane) throws NoPlanesExistsException {
        if(planes.size() > 0){
            planes.remove(plane);    
        }
        else{
            throw new NoPlanesExistsException("The company owns no planes");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
    
    public int getNumberOfPlanes(){
        return planes.size();
    }

    public ArrayList<AirPlane> getPlanes() {
        return planes;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public void putCustomer(Ticket ticket){
    
    }

    
}
