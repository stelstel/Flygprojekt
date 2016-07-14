package food;

import java.util.ArrayList;
import flyace.SeatClass;

public class FoodMenu {

	private ArrayList<FoodItem> menu = new ArrayList<FoodItem>();

	public FoodMenu(SeatClass seatClass){
		if(seatClass == SeatClass.FIRST){
			menu.add(new FoodItem("1. Gratinerad hummer", 150));
			menu.add(new FoodItem("2. Oxfil� provencale", 200));
			menu.add(new FoodItem("3. Champagne", 250));			
		}
		else{
			menu.add(new FoodItem("1. Korv med br�d", 50));
			menu.add(new FoodItem("2. Blodpudding", 100));
			menu.add(new FoodItem("3. Vatten", 150));			
		}
	}

	public ArrayList<FoodItem> getMenu(){
		return menu;
	}
	
	public FoodItem getMenuItem(int menuItem){
		if(menuItem >= menu.size())
			return null;
		return menu.get(menuItem);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("Menu:\n");
		for(FoodItem food : menu){
			sb.append("    "+ food +"\n");
		}
		return sb.toString();
	}
}
