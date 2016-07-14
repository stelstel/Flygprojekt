package food;

import java.util.ArrayList;

import flyace.SeatClass;

public class FoodOrder {

	private FoodMenu menu;
	private ArrayList<FoodItem> order = new ArrayList<FoodItem>();
	private int totalCost;
	private boolean payed = false;
	
	public FoodOrder(SeatClass seatClass){
		this.menu = new FoodMenu(seatClass);
	}
	
	public boolean order(FoodItem food){
		if(food == null)
			return false;
		order.add(food);
		totalCost += food.getPrice();
		return true;
	}

	public FoodMenu getMenu(){
		return menu;
	}
	
	public String showMenu(){
		return menu.toString();
	}
	
	public int getTotalCost(){
		return totalCost;
	}
	
	public void pay(){
		payed = true;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Ordered Food:\n");
		for(FoodItem food : order){
			sb.append("    "+ food +"\n");
		}
		sb.append("\n    Total Cost = "+ totalCost +"\n");
		sb.append("    Order payed: "+ payed +"\n");
		return sb.toString();
	}

}
