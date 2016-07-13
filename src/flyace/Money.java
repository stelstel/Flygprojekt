
//import flyace.SeatClass;
import flyace.Ticket;
import food.FoodOrder;


public class Money {

    private double saldo;
    private double income;
    private double cost;
   // Ticket ticketPrice = new Ticket();
   // FoodOrder food = new FoodOrder(SeatClass seatClass);  
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double calcSuldo() {
       return  food.getTotalCost() + ticketPrice.getPrice();
    }
}

//	saldo	
//	income()
