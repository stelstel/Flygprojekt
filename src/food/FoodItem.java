package food;

public class FoodItem {

	private String item;
	private int price;
	
	public FoodItem(String item, int price){
		this.item = item;
		this.price = price;
	}
	
	public String getItem(){
		return item;
	}

	public int getPrice(){
		return price;
	}

}
