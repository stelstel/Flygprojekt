package food;

import java.util.ArrayList;
import flyace.SeatClass;

public class FoodMenu {

    private ArrayList<FoodItem> menu = new ArrayList<FoodItem>();

    public FoodMenu(SeatClass seatClass) {
        if (seatClass == SeatClass.FIRST) {
            menu.add(new FoodItem("1. Gratinerad hummer", 250));
            menu.add(new FoodItem("2. Oxfile provencale", 200));
            menu.add(new FoodItem("3. Plankad stek", 152));
            menu.add(new FoodItem("4. Sjötunga Walewska", 180));
            menu.add(new FoodItem("5. Vin \"Molto Bene\"", 85));
            menu.add(new FoodItem("6. Champagne", 120));
        } else {
            menu.add(new FoodItem("1. Makaroner med ketchup", 75));
            menu.add(new FoodItem("2. Makaroner utan ketchup", 70));
            menu.add(new FoodItem("3. Duck with orange", 120));
            menu.add(new FoodItem("4. Duck with cherries", 120));
            menu.add(new FoodItem("5. Duck Surprise", 100));
            menu.add(new FoodItem("6. Fanta", 30));
            menu.add(new FoodItem("7. Vatten", 10));
        }
    }

    public ArrayList<FoodItem> getMenu() {
        return menu;
    }

    public FoodItem getMenuItem(int menuItem) {
        if (menuItem >= menu.size()) {
            return null;
        }
        return menu.get(menuItem);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Menu:\n");
        for (FoodItem food : menu) {
            sb.append("    " + food + "\n");
        }
        return sb.toString();
    }
}
