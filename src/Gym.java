import org.w3c.dom.ranges.RangeException;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Salah Abdinoor
 * 10/13/2020
 * 11:33 AM
 * BestGymEver3
 * Copyright: MIT
 */

public class Gym {

    /**
     * This method checks if "String input" is a "customer" within our "customerList" and the returns the "customer" object.
     *
     * @param customerList
     * @param nameOrSSN
     * @return customer
     */

    public Customer findCustomerInList(List<Customer> customerList, String nameOrSSN) {

        // Input has to be > 3
        if (nameOrSSN.length() <= 3) {
            throw new IllegalArgumentException("Skriv in fler karaktärer");
        }

        // this checks if name/ID matches/contains any object in list
        for (Customer customer : customerList) {

            if (customer.getName().equalsIgnoreCase(nameOrSSN) || customer.getID().equalsIgnoreCase(nameOrSSN)) {

                return customer;

            } else if (customer.getName().contains(nameOrSSN)) {

                return customer;

            }
        }

        // This is for when input doesn't match costumers in list
        for (Customer customer : customerList){

          if (!customer.getName().contains(nameOrSSN) && !customer.getID().contains(nameOrSSN)){
                throw new NullPointerException("Denna kund existerar inte");
            }
        }
        return null;
    }

    /**
     * This method returns the date for the given customer
     *
     * @param customer
     * @return lastPayedDate
     */

    public String findCustomerLastPayedDate(Customer customer) {

        return customer.getPayedDate();
    }

    /**
     * This method checks if a lastPayedDate is still valid or not.
     * to classify a lastPayedDate as valid it has to be within 1 year.
     *
     * @param lastPayedDate
     * @return checkValidity
     */

    public boolean checkIfLastPayedDateIsValid(String lastPayedDate, boolean test) {

        LocalDate currentDate;

        LocalDate payedDate = LocalDate.parse(lastPayedDate);


        if (test){
             currentDate = LocalDate.parse("2020-10-15");

        } else
             currentDate = LocalDate.now();

        // this boolean is true if payed date is within a year of the current date.
        boolean isActive = payedDate.isAfter(currentDate.minusYears(1));

        return isActive;
    }
}

