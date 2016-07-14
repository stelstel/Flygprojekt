package flyace;

import food.FoodOrder;

public class Money {

    private double saldo;
            
    Ticket ticket;
    SeatClass seatClass;
    SeatStatus seatStatus;
    Seat seat;
    FoodOrder foodOrder;
    PassengerPlane pPlane;
    
    public void addToSaldo(Double moneyToAdd){
        saldo += moneyToAdd;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getFoodPrice() {
        return ticket.getCustomer().getFoodorder().getTotalCost();
    }
}