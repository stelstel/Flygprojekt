package flyace;

import java.util.ArrayList;


public class BookingSystem {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private Company company;
	private AirPlane plane;
	
	public BookingSystem(){
		this.company = new Company();

		// Buy one initial plane to the company
		plane = new PassengerPlane("Boeing 747", 10);
		company.buyPlane(plane);
	}
	
	public Customer addCustomer(String firstName, String lastName, SeatClass seatClass){
		// Find a plane
		ArrayList<AirPlane> planes = company.getPlanes();
		if(planes.size() == 0){
			return null;
		}
		plane = planes.get(0);

		//Reserv a seat for the customer
		//TODO: Add personal number argument
		Customer customer = new Customer(firstName, lastName, "12345");
		plane.putCustomer(customer, seatClass);
		
		customers.add(customer);
		return customer;
	}
}


