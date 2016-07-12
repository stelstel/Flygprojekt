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

        public String toString(){
		StringBuilder sb = new StringBuilder("                                        ");
		sb.insert(0, item);
		sb.insert(30, String.valueOf(price) +" kr");
		return sb.toString();
	}

}
