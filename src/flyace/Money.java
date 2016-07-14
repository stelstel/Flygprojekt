package flyace;

import food.FoodOrder;

public class Money {

    private double saldo;
    private double income;
    private double profit;
        
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
    
//    public double getSaldo() {
//        saldo = foodOrder.getTotalCost() + ticket.getPrice();
//        return saldo;
//    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getIncome() {
        // Price of the tickets + price of food items of all passengers
        income = getFoodPrice() + getTicketPrice();
        return income;
    }
    
    public void setIncome(double income) {
        this.income = income;
    }
    
    public double getProfit() {
        profit = 0.3 * income;
        return profit;
    }
    
    public void setProfit(double profit) {
        this.profit = profit;
    }
    
    public double getTicketPrice() {
        int nrOfOccupiedSeats = 0;
        int nrOfSeats = ticket.getPlane().getNrOfSeats();
        double ticketPrice = 0;
        // Loop through all the seats
        for (int i = 0; i < nrOfSeats; i++) {
            if (pPlane.getSeats().get(i).getSeatstatus() == seatStatus.OCCUPIED) {
                nrOfOccupiedSeats++;
                // Loop through all the occupied seats
                for (int j = 0; j < nrOfOccupiedSeats; j++) {
                    ticketPrice = pPlane.getSeats().get(j).getPrice();
                }
            }
        }
        return ticketPrice;
    }
    
    public double getFoodPrice() {
        return ticket.getCustomer().getFoodorder().getTotalCost();
    }
}