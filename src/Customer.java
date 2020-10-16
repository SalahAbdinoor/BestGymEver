/**
 * Created by Salah Abdinoor
 * 10/13/2020
 * 11:33 AM
 * BestGymEver3
 * Copyright: MIT
 */

public class Customer {

    private String ID;
    private String name;
    private String payedDate;


    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPayedDate() {
        return payedDate;
    }


    public Customer(String ID, String name, String payedDate) {
        this.ID = ID;
        this.name = name;
        this.payedDate = payedDate;
    }

}
