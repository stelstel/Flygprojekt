package view;

import java.util.Scanner;
import flyace.BookingSystem;
import flyace.Customer;
import flyace.PassengerPlane;
import flyace.SeatClass;
import flyace.Ticket;
import flyace.TimeToFly;
import food.*;

public class UI {

    // Declare BookingSystem
    static BookingSystem booking;
    static Customer customer;
    static Ticket ticket;

    // Create a scanner for user input
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a BookingSystem
        booking = new BookingSystem();

        mainMenu();
        System.exit(0);
    }

    public static void mainMenu() {

        booking = new BookingSystem();

        int selection;
        boolean continue1 = true;
        while (continue1) {
            System.out.println("\nWelcome to FlightProject Booking System\n");
            System.out.println("\nSelect from menu");
            System.out.println("=================");
            System.out.println("1. Handle passengers");
            System.out.println("2. Company issues");
            System.out.println("0. Exit\n");
            System.out.println("Insert the number of your choice: ");

            selection = getSelection();

            switch (selection) {
                case 1:
                    continue1 = flightMenu();
                    break;
                case 2:
                    continue1 = companyMenu();
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

    public static boolean flightMenu() {
        int selection;
        boolean continue1 = true;
        while (continue1) {
            System.out.println("\nSelect from menu");
            System.out.println("=================");
            System.out.println("1. Register New Passenger");
            System.out.println("2. Show/edit Passenger");
            System.out.println("3. Show all passengers");
            System.out.println("4. Register Group of Passengers");
            System.out.println("5. Show Planes and Seats");
            System.out.println("6. Food menus");
            System.out.println("7. Show Food Orders");
            System.out.println("8. Return to main menu");
            System.out.println("0. Avsluta");
            System.out.println("Insert the number of your choice: ");

            selection = getSelection();

            switch (selection) {
                case 1:
                    continue1 = newPassenger();
                    break;
                case 2:
                    showPassenger();
                    break;
                case 3:
                    showAllPassengers();
                    break;
                case 4:
                    continue1 = addGroupOfPassengers();
                    break;
                case 5:
                    showPlanesAndSeats();
                    break;
                case 6:
                    showFoodMenus();
                    break;
                case 7:
                    //TODO:
                    System.out.println("TODO:");
                    break;
                case 8:
                    return true;
                case 0:
                    return false;
                default:
                    System.out.println("Invalid choice, try again.");
            }

        }
        return continue1;
    }

    public static boolean newPassenger() {
        // Get all needed parameters
        String firstName;
        String lastName;
        SeatClass seatClass = SeatClass.ECONOMY;
        try {
            System.out.println("First name: ");
            firstName = getStringForced();

            System.out.println("Last name: ");
            lastName = getStringForced();

            System.out.println("Select seat class: ");
            System.out.println("1. First Class");
            System.out.println("2. Economy Class");
            switch (getSelection()) {
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
            if (ticket.getSeat() == null) {
                System.out.println("Sorry no seat available for seatClass " + seatClass);
                //TODO: Check if idle seats available for the other class
                PassengerPlane plane = (PassengerPlane) ticket.getPlane();
                if (plane.getNrOfFreeSeats() == 0) {
                    System.out.println("There are no seats at all. Goodbye");
                    getString(1);
                    return true;
                }
                System.out.println("Do you accept to change seatClass?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                switch (getSelection()) {
                    case 1:
                        if(seatClass == SeatClass.FIRST)
                           seatClass = SeatClass.ECONOMY; 
                        else
                           seatClass = SeatClass.FIRST; 
                        ticket = booking.addCustomer(firstName, lastName, seatClass);
                        if (ticket.getSeat() == null) {
                            System.out.println("ERROR! This should not happend!!!");
                            getString(1);
                            return true;
                        }
                        System.out.println("A ticket has been created successfully");
                        booking.income(ticket);
                        orderFood(ticket, seatClass);
                        return true;
                    default:
                        System.out.println("OK. Goodbye");
                        getString(1);
                        return true;
                }

            } else {
                System.out.println("A ticket has been created successfully");
                booking.income(ticket);
            }
            getString(1);
        } catch (EmptyStringException e) {
            getString(1);
            return true;
        }
        orderFood(ticket, seatClass);
        return true;
    }

    public static boolean orderFood(Ticket ticket, SeatClass seatClass) {
        System.out.println("Order food: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        switch (getSelection()) {
            case 1:
                break;
            default:
                getString(1);
                return true;
        }

        // Select food items from menu
        System.out.println("Please select from this menu:");
        FoodOrder foodOrder = new FoodOrder(seatClass);
        System.out.println(foodOrder.showMenu() + "\n Enter your choise: ");
        int selection = 1;
        while (true) {
            selection = getSelection();
            if (selection == 0) {
                break;
            }
            if (foodOrder.order(foodOrder.getMenu().getMenuItem(selection - 1)) == false) {
                System.out.println("Invalid choise, try again");
            }
            System.out.println(foodOrder.showMenu() + "\n Select more food or press 0 to exit: ");
        }
        System.out.println("Your food order is completed (too late to change now):");
        System.out.println(foodOrder);
        System.out.println("Do you want to pay?");
        System.out.println("1. Yes");
//		System.out.println("2. No");
        selection = getSelection();
        if (selection == 1) {
            System.out.println("Your order, " + foodOrder.getTotalCost() + "kr is payed. Thank you!");
            foodOrder.pay();
            booking.income(foodOrder);
        } else {
            System.out.println("Thanks for nothing you cheap bastard");
        }
        if(foodOrder.getTotalCost() > 0)
            ticket.getCustomer().setFoodorder(foodOrder);
        getString(1);
        return true;

    }

    public static boolean addGroupOfPassengers() {
        SeatClass seatClass = SeatClass.FIRST;
        System.out.println("Select number of passengers:");
        int numberOfPassengers = getSelection();
        System.out.println("Select seat class: ");
        System.out.println("1. First Class");
        System.out.println("2. Economy Class");
        switch (getSelection()) {
            case 1:
                seatClass = SeatClass.FIRST;
                break;
            case 2:
                seatClass = SeatClass.ECONOMY;
                break;
            default:
                break;
        }
        for (int i = 0; i < numberOfPassengers; i++) {
            ticket = booking.addCustomer("Matt", "Greencroft", seatClass);
            if (ticket.getSeat() == null) {
                System.out.println("Sorry no seat available for seatClass " + seatClass);
                //TODO: Check if idle seats available for the other class
            } else {
                System.out.println("A ticket has been created successfully");
//                // TODO Kent, check if this is the correct line for this line of code!
//                TimeToFly.checkIfItsTime(ticket.getPlane()); 
                  booking.income(ticket);
            }
        }
        getString(1);
        return true;
    }

    public static boolean showAllPassengers() {
        System.out.println(booking.showAllCustomers());
        getString(1);
        return true;

    }

    public static boolean showPassenger() {
        System.out.println("Select passenger number:");
        int number = getSelection();
        Ticket t = booking.findCustomerbyNumber(number);
        if (t == null) {
            System.out.println("Passenger " + number + " could not be found. Sorry!");
            return true;
        }
        System.out.println(booking.showTicketInformation(t));
        getString(1);
        return true;
    }

    public static boolean showFoodMenus() {
        System.out.println("\nSelect menu:");
        System.out.println("1. Fist class menu");
        System.out.println("2. Economy class menu");
        int selection = getSelection();
        switch (selection) {
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

    private static boolean companyMenu() {
        while(true){
            System.out.println("\nSelect menu:");
            System.out.println("1. Show economical status");
            System.out.println("2. Show airplanes");
            System.out.println("3. Buy new airplane");
            System.out.println("4. Return to main menu");
            System.out.println("0. Avsluta");
        
            int selection = getSelection();
            switch (selection) {
                case 1:
                    System.out.println(booking.showSaldo2());
                    break;
                case 2:
                    showPlanesAndSeats();
                    break;
                case 3:
                     // Buy plane to the company
                    System.out.println("Enter name of the new airplane");
                    String planeName = getString();
                    if(planeName.length() == 0)
                        planeName = "DC10";
                    booking.buyPlane(planeName);
                    break;
                case 4:
                    return true;
                case 5:
                    return false;
                default:
                    return false;
            }
            getString(1);
        }
    }

    private static void showPlanesAndSeats(){
        System.out.println(booking.showPlanes());
        System.out.println("Select number of the plane to see the seats");
        int i = getSelection();
        System.out.println(booking.showSeats(i-1));                    
        getString(1);
    }
    
    
    
    
    
    
    
    // Helpers
    public static int getSelection() {
        int selection;
        try {
            selection = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("You must assign a digit! Try again");
            selection = 99;
            sc.nextLine();
        }
        sc.nextLine();
        return selection;

    }

    public static String getString() {
        String userString;
        try {
            userString = sc.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Exception");
            userString = "";
            sc.nextLine();
        }
        return userString;
    }

    public static String getString(int i) {
        System.out.println("\nPress Enter to continue\n");
        return getString();
    }

    public static String getStringForced() throws EmptyStringException {
        String userString = sc.nextLine();
        if (userString.equals("")) {
            throw new EmptyStringException();
        }
        return userString;
    }

}
