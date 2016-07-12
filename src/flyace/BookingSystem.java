package flyace;

//Test Commit

import java.util.ArrayList;


public class BookingSystem {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private Company company;
        private Ticket ticket;
        private PassengerPlane plane;
        private int uniqueCustomerId;
        
	public BookingSystem(){
		this.company = new Company();
                uniqueCustomerId = 1;
		// Buy one initial plane to the company
		plane = new PassengerPlane("Boeing 747", 10);
		company.buyPlane(plane);
	}
	
//	public Customer addCustomer(String firstName, String lastName, SeatClass seatClass){
	public Ticket addCustomer(String firstName, String lastName, SeatClass seatClass){
		// Find a plane
		ArrayList<PassengerPlane> planes = company.getPlanes();
		if(planes.size() == 0){
			return null;
		}
		plane = planes.get(0);

		//Reserv a seat for the customer
		Customer customer = new Customer(firstName, lastName, String.valueOf(uniqueCustomerId));
      		//TODO: Use Ticket 
                ticket = new Ticket();
                ticket.setCustomer(customer);
                ticket.setSeatclass(seatClass);
                company.putCustomer(ticket);
                if(ticket.getSeat() == null){
System.out.println("BookingSystem: No Seat found in ticket");
                }
                else{
System.out.println("BookingSystem: Yes a Seat found in ticket");
                }
                //instead of this
//                plane.putCustomer(customer, seatClass);


		customers.add(customer);
                uniqueCustomerId++;
//		return customer;
		return ticket;
	}
       	public String showAllCustomers(){
                String header =  "Number  Class   Fist name           Last name\n";
                String header2 = "------  -----   ---------           ---------\n";
                String header3 = "                                               ";

       		StringBuilder sb = new StringBuilder(header);
                sb.append(header2);
                StringBuilder sb2 = new StringBuilder(header3);
                
		for(Customer c : customers){
                    sb2.insert(0, c.getPersonalNumber());
//                    sb2.insert(8, c.getClass());
                    sb2.insert(16, c.getFirstName());
                    sb2.insert(36, c.getsurname() +"\n");
                    sb.append(sb2.toString());
                    sb2.setLength(0);
                    sb2.append(header);
                }
		return sb.toString();
	}

}


