package flyace;

import food.FoodOrder;

public class Money {

    private double saldo;
    private double income;
    private double profit;
    
    
    Ticket ticket;
    SeatClass seatClass;
    FoodOrder foodOrder;
    
    public double getSaldo() {
        saldo = foodOrder.getTotalCost() + ticket.getPrice();
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getIncome() {
        return income;
    }
    
    public void setIncome(double income) {
        this.income = income;
    }
    
    public double getProfit(double profit) {
        profit = 0.3 * income;
        return profit;
    }
}
