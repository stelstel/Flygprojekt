package flyace;

//Test Commit
import java.util.HashMap;

public class BookingSystem {
    private HashMap<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();

    private Company company;
    private Ticket ticket;
    private PassengerPlane plane;
    private int uniqueCustomerId;

    public BookingSystem() {
        this.company = new Company();
        uniqueCustomerId = 1;
        // Buy one initial plane to the company
        plane = new PassengerPlane("Boeing 747", 10);
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
        StringBuilder sb = new StringBuilder();
        sb.append(getTicketHeader());
        sb.append(getTicketContent(t));
        sb.append("\n");
        return sb.toString();
    }


    public String showTicketInformation2(Ticket t) {
        Customer c = t.getCustomer();
        String header =  "Num. Fist name           Last name           Airplane            Seat Class     Price     Status\n";
        String header2 = "---- ---------           ---------           --------            ---- -----     -----     ------\n";
        StringBuilder sb = new StringBuilder(header);
        sb.append(header2);
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
            sb.append(fixLengthString("Free",10));
        else
            sb.append(fixLengthString("Occupied",10));
        //TODO: Add if FoodOrderExist or not
        sb.append("\n");
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
        String header =  "Num. Fist name           Last name           Airplane            Seat Class     Price     Status\n";
        String header2 = "---- ---------           ---------           --------            ---- -----     -----     ------\n";
        StringBuilder sb = new StringBuilder(header);
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
            sb.append(fixLengthString("Free",10));
        else
            sb.append(fixLengthString("Occupied",10));
        //TODO: Add if FoodOrderExist or not
        sb.append("\n");
        return sb;
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
