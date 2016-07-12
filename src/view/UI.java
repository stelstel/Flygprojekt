package view;

import java.util.Scanner;
import flyace.BookingSystem;
import flyace.Customer;
import flyace.SeatClass;
import flyace.Ticket;
import food.*;

public class UI {

	// Declare BookingSystem
	static BookingSystem booking;
	Customer customer;
        static Ticket ticket;
        
	// Create a scanner for user input
	static Scanner sc= new Scanner(System.in);
	
	
	

	public static void main(String[] args) {
		// Create a BookingSystem
		booking = new BookingSystem();
		
		mainMenu();
		
	}

	public static void mainMenu(){

		booking = new BookingSystem();

		int selection;
		boolean continue1 = true;
		while(continue1){
			System.out.println("\nWelcome to FlightProject Booking System\n");
			System.out.println("\nSelect from menu");
			System.out.println("=================");
			System.out.println("1. Handle passengers");
			System.out.println("2. Company issues");
			System.out.println("0. Exit\n");
			System.out.println("Insert the number of your choise: ");

			selection = getSelection();

			switch(selection){
				case 1:
					continue1 = flightMenu();
					break;
				case 2:
					//TODO:
					System.out.println("TODO:");
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid choise, try again.");
			}
		}
		System.out.println("Exit");
		sc.close();
	}
	
	public static boolean flightMenu(){
		int selection;
		boolean continue1 = true;
		while(continue1){
			System.out.println("\nSelect from menu");
			System.out.println("=================");
			System.out.println("1. Register New Passenger");
			System.out.println("2. Show/edit Passenger");
			System.out.println("3. Show all passengers");
			System.out.println("4. Show Planes");
			System.out.println("5. Show Seats");
			System.out.println("6. Show Ticktes");
			System.out.println("7. Food menus");
			System.out.println("8. Show Food Orders");
			System.out.println("9. Return to main menu");
			System.out.println("0. Avsluta");
			System.out.println("Insert the number of your choise: ");

			selection = getSelection();

			switch(selection){
				case 1:
					continue1 = newPassenger();
					break;
				case 2:
					//TODO:
					System.out.println("TODO:");
					break;
				case 3:
					showAllCustomers();
					System.out.println("TODO:");
					break;
				case 4:
					//TODO:
					System.out.println("TODO:");
					break;
				case 5:
					//TODO:
					System.out.println("TODO:");
					break;
				case 6:
					//TODO:
					System.out.println("TODO:");
					break;
				case 7:
					showFoodMenus();
					break;
				case 8:
					//TODO:
					System.out.println("TODO:");
					break;
				case 9:
					return true;
				case 0:
					return false;
				default:
					System.out.println("Invalid choise, try again.");
			}

		}
		return continue1;
	}

	public static boolean newPassenger(){
//		int selection;
//		boolean continue1 = true;
		
		// Get all needed parameters
//		int employeeID = 0;
		String firstName = "";
		String lastName = "";
		SeatClass seatClass = SeatClass.FIRST;
		try{
			System.out.println("First name: ");
			firstName = getStringForced();
			
			System.out.println("Last name: ");
			lastName = getStringForced();
	
			System.out.println("Select seat class: ");
			System.out.println("1. First Class");
			System.out.println("2. Economy Class");
			switch(getSelection()){
				case 1:
					seatClass = SeatClass.FIRST;
					break;
				case 2:
					seatClass = SeatClass.ECONOMY;
					break;
				default:
					break;
			}
			ticket = booking.addCustomer(firstName, lastName, seatClass);
                        if(ticket.getSeat() == null){
                            System.out.println("Sorry no seat available for seatClass "+ seatClass);
                        }
                        else{
                            System.out.println("A ticket has been created successfully");
                        }    
        		getString(1);
                        
                        
			System.out.println("Order food: ");
			System.out.println("1. Yes");
			System.out.println("2. No");
			switch(getSelection()){
				case 1:
					orderFood(seatClass);
					break;
				case 2:
					break;
				default:
					break;
			}
		}
		catch(EmptyStringException e){
			getString(1);
			return true;
		}

		getString(1);
		return true;
		
	}
	
	public static boolean orderFood(SeatClass seatClass){
		// Select food items from menu
		System.out.println("Please select from this menu:");
		FoodOrder foodOrder = new FoodOrder(seatClass);
		System.out.println(foodOrder.showMenu() +"\n Enter your choise: ");
		int selection = 1;
		while(true){
			selection = getSelection();
                        if(selection == 0)
                            break;
                        if(foodOrder.order(foodOrder.getMenu().getMenuItem(selection-1)) == false){
				System.out.println("Invalid choise, try again");
			}
			System.out.println(foodOrder.showMenu() +"\n Select more food or press 0 to exit: ");
		}
		System.out.println("Your food order is completed (too late to change now):");
		System.out.println(foodOrder);
		System.out.println("Do you want to pay?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		selection = getSelection();
		if(selection == 1){
			System.out.println("Your order, "+ foodOrder.getTotalCost() +" is payed. Thank you!");
			foodOrder.pay();
		}
//		getString(1);
		return true;
		
	}

	public static boolean showAllCustomers(){
		System.out.println(booking.showAllCustomers());
		getString(1);
		return true;

	}

	
	
	public static boolean showFoodMenus(){
		System.out.println("\nSelect menu:");
		System.out.println("1. Fist class menu");
		System.out.println("2. Economy class menu");
		int selection = getSelection();
		switch(selection){
			case 1:
				System.out.println(new FoodMenu(SeatClass.FIRST));
				break;
			case 2:
				System.out.println(new FoodMenu(SeatClass.ECONOMY));
				break;
			default:
				break;
				
		}
		getString(1);
		return true;
		
	}
	

	
	
	
	// Helpers
	public static int getSelection(){
		int selection;
		try{
			selection= sc.nextInt( );
		} catch(java.util.InputMismatchException e){
			System.out.println("You must assign a digit! Try again");
			selection = 99;
			sc.nextLine();
		}
		sc.nextLine();
		return selection;
		
	}

	public static String getString(){
		String userString;
		try{
			userString = sc.nextLine( );
		} catch(java.util.InputMismatchException e){
			System.out.println("Exception");
			userString = "";
			sc.nextLine();
		}
		return userString;
	}

	public static String getString(int i){
		System.out.println("\nPress Enter to continue\n");
		return getString();
	}

	public static String getStringForced() throws EmptyStringException{
		String userString = sc.nextLine( );
		if(userString.equals("")){
			throw new EmptyStringException();
		}
		return userString;
	}

}
