package flyace;

//Test Commit
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class BookingSystem {
    private HashMap<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();

    private Company company;
    private Ticket ticket;
    private PassengerPlane plane;
    private int uniqueCustomerId;

    public BookingSystem() {
        this.company = new Company("Java Airlines");
        uniqueCustomerId = 1;
        // Buy one initial plane to the company
        plane = new PassengerPlane("Boeing747", 10);
        company.buyPlane(plane);
    }

    public Ticket addCustomer(String firstName, String lastName, SeatClass seatClass) {
        //Reserv a seat for the customer
        Customer customer = new Customer(firstName, lastName, String.valueOf(uniqueCustomerId));
        ticket = new Ticket();
        ticket.setCustomer(customer);
        ticket.setSeatClass(seatClass);
        company.putCustomer(ticket);
        //Check if the reservation was successful, if a Seat was reserved then the ticket is valid
        if(ticket.getSeat() != null){
            // If valid ticket, then add it to the tickets HashMap
            tickets.put(uniqueCustomerId, ticket);
            uniqueCustomerId++;
        }
        return ticket;
    }

    public Ticket findCustomerbyNumber(int customerNumber) {
        ticket = tickets.get(customerNumber);
        return ticket;
    }

    public String showTicketInformation(Ticket t) {
        Customer c = t.getCustomer();
        StringBuilder sb = new StringBuilder();
        sb.append(getTicketHeader());
        sb.append(getTicketContent(t));
        sb.append("\n");
        if(c.getFoodorder() != null){
            sb.append(c.getFoodorder());
        }
        return sb.toString();
    }

    public String showAllCustomers() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTicketHeader());
        for(int i=1; i-1 < tickets.size(); i++){
            ticket = tickets.get(i);
            sb.append(getTicketContent(ticket));
        }
        return sb.toString();
    }

    private StringBuilder getTicketHeader(){

        String header =  "Num. Fist name           Last name           Airplane            Seat Class     Price     Status    FoodOrder\n";
        String header2 = "---- ---------           ---------           --------            ---- -----     -----     ------    ---------\n";
        StringBuilder sb = new StringBuilder("\n\nFlight Tickets\n"+ company.getName() +"\n\n");
        sb.append(header);
        sb.append(header2);
        return sb;
    }

    private StringBuilder getTicketContent(Ticket t){
        Customer c = t.getCustomer();
        StringBuilder sb = new StringBuilder();
        sb.append(fixLengthString(c.getPersonalNumber(),5));
        sb.append(fixLengthString(c.getFirstName(),20));
        sb.append(fixLengthString(c.getSurname(),20));
        sb.append(fixLengthString(t.getPlane().getName(),20));
        sb.append(fixLengthString(String.valueOf(t.getSeat().getSeatNumber()),5));
        if(t.getSeat().getSeatclass() == SeatClass.FIRST)
            sb.append(fixLengthString("First",10));
        else
            sb.append(fixLengthString("Economy",10));
        sb.append(fixLengthString(String.valueOf(t.getSeat().getPrice()),10));
        if(t.getSeat().getSeatstatus() == SeatStatus.FREE)
            sb.append(fixLengthString("Expired",10));
        else
            sb.append(fixLengthString("Valid",10));
        if(c.getFoodorder() != null){
            sb.append(fixLengthString("Yes",5));
        } else {
            sb.append(fixLengthString("No",5));
        }
//sb.append(t.getSeat().getSeatstatus());
        sb.append("\n");

//t.getCompany().getMoneyObj().addToSaldo(Double.NaN);
        
        
        return sb;
    }

    public void buyPlane(String name){
        plane = new PassengerPlane(name, 10);
        company.buyPlane(plane);
    }
    
    public String showPlanes(){
        ArrayList<PassengerPlane> planes = company.getPlanes();
        String planeStr = "";
        for(PassengerPlane plane : planes){
            planeStr = planeStr.concat("    "+ plane.getName() +"\n");
        }
        return planeStr;
    }
    
//    public String showSeats(PassengerPlane plane){
    public String showSeats(int planeIndex){
        ArrayList<PassengerPlane> planes = company.getPlanes();
        if(planeIndex >= planes.size()){
            return "";
        }
        PassengerPlane plane = planes.get(planeIndex);
        LinkedHashMap<Integer, Seat> seats = plane.getSeats();;
        Seat seat;

        StringBuilder sb = new StringBuilder("Seats:\n    Num.    Class    Status\n");
        
        for(int i=0; i < seats.size(); i++){
            seat = seats.get(i);
            sb.append(fixLengthString(String.valueOf(seat.getSeatNumber()),5));
            sb.append(fixLengthString(String.valueOf(seat.getSeatclass()),20));
            sb.append(fixLengthString(String.valueOf(seat.getSeatstatus()),20));
            sb.append("\n");
        }
        return sb.toString();
    }

    public void income(Ticket t){
        
    }
    public void income(food.FoodOrder f){
        double totalCost = (double)f.getTotalCost();
        company.getMoneyObj().addToSaldo(totalCost);
    }

    public String showSaldo2(){
        String s = "\n\n"+ company.getName() +"\nCompany saldo:\n";
        s = s.concat(String.valueOf(company.getMoneyObj().getSaldo()));
        s = s.concat("Company profit:\n");
        s = s.concat(String.valueOf(company.getMoneyObj().getSaldo() * company.getProfitPart()));
        s = s.concat("\n");
        return s;
    }
    
    
    private String fixLengthString(String start, int length) {
        if (start.length() >= length) {
            return start.substring(0, length);
        } else {
            while (start.length() < length) {
                start += " ";
            }
            return start;
        }
    }

}
