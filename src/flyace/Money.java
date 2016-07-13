package flyace;

import flyace.SeatClass;
import flyace.Ticket;
import food.FoodOrder;

public class Money {

    private double saldo;
    private double income;
    private double cost;
    
    
    Ticket ticketPrice = new Ticket();
    
    FoodOrder foodFirst = new FoodOrder(SeatClass.FIRST);
    FoodOrder foodEconomy = new FoodOrder(SeatClass.ECONOMY);
    
    // TODO commented out temporarly by Stefan
    // private double price = ticket.getSeat().getPrice();
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    

    // TODO commented out temporarly by Stefan
//    public double calcSuldo() {
//        return food.getTotalCost() + ticketPrice.getPrice();
//    }
}

