/**
 * @author Stefan Elmgren
 * @version 1.00
 */
package flyace;

/**
 *
 * @author User
 */

//Seat					Stefan
	//seatClass = First or Economy [Titta på var customer sitter i Passangerplane, 0-5 first class, 6-10 economy class]
	//seatNumber = 1-10 
	//status = idle or Customer object [om indexet tomt, ingen customer]
	//price = 20000kr or 5000kr [se ovan First or economy]
	//assignCustomer() [putCustomer i PassengerPlane]
	//removeCustomer() [freeSeat i PassengerPlane]

//Mark the seat as occupied and saves reference to the Ticket object.
//		(Ticket this.ticket = ticket)
//	and return the ticket, all the way back to BookingSystem

public class Seat {
    Ticket ticket;
    
    //****************** Constructors ******************************************
    public Seat(Ticket ticket){
        this.ticket = ticket;
    }
    
}
