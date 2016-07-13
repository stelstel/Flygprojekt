package flyace;

import food.FoodOrder;

public class Customer {

    private String firstName;
    private String surname;
    private String personalNumber;
    private FoodOrder foodorder;
    
    /**
     * 
     * @param firstName First namen
     * @param surname Surname
     * @param pnumber Personal ID number
     */
    //********************* Contructors ****************************************
    public Customer(String firstName, String surname, String pnumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.personalNumber = pnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }   

    public FoodOrder getFoodorder() {
        return foodorder;
    }

    public void setFoodorder(FoodOrder foodorder) {
        this.foodorder = foodorder;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
