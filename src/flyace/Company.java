package flyace;

import java.util.ArrayList;

//Company
//	Selects the plane which is presently boarding
//	Adds the Company to the ticket
//	Sends the ticket to the Plane
//		plane.putCustomer(Ticket);
public class Company {

    private String name;
    private int money;
    private double profit = 0.3;
    private ArrayList<PassengerPlane> planes = new ArrayList<PassengerPlane>();

    //******************* Constructors *****************************************
    public Company(String name) {
        this.name = name;
    }

    public Company() {

    }

    public void addMoney(int mon) {
        this.money += mon;
    }

    void buyPlane(PassengerPlane plane) {
        planes.add(plane);
    }

    void sellPlane(PassengerPlane plane) throws NoPlanesExistsException {
        if (planes.size() > 0) {
            planes.remove(plane);
        } else {
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

    public int getNumberOfPlanes() {
        return planes.size();
    }

    public ArrayList<PassengerPlane> getPlanes() {
        return planes;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void putCustomer(Ticket ticket) {
        ticket.setCompany(this);
        //TODO now selects first plane. Maybe needed to select other plane
        PassengerPlane pPlane = this.getPlanes().get(0);
        pPlane.putCustomer(ticket);
        
    }

    //Company
    //	Selects the plane which is presently boarding
    //	Adds the Company to the ticket
    //	Sends the ticket to the Plane
    //		plane.putCustomer(Ticket);
}
