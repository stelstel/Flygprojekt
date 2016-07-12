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
		String orderString = "Ordered Food:\n";
		for(FoodItem food : order){
			orderString = orderString.concat("    "+ food.getItem().toString() +"  "+ food.getPrice() +"kr\n");
		}
		orderString = orderString.concat("    Total Cost = "+ totalCost +"\n");
		orderString = orderString.concat("    Order payed: "+ payed);
		return orderString;
		
	}

}
