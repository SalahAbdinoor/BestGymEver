import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Salah Abdinoor
 * 10/15/2020
 * 2:26 PM
 * BestGymEver
 * Copyright: MIT
 */
class GymTest {
    IOUtil util = new IOUtil();

    Gym gym = new Gym();

    String inFile = "TextFiles/CustomerListTest.txt";

    List<Customer> customers = util.readDataFromFile(inFile);

    @Test
    public final void findCustomerInList() {

        String greger = "Greger Ganache";
        String greg = "Greg";

        String notGreg = "Ida Idylle";

        assertEquals(customers.get(0), gym.findCustomerInList(customers, greger));
        assertEquals(customers.get(0), gym.findCustomerInList(customers, greg));

        assertNotEquals(customers.get(0), gym.findCustomerInList(customers, notGreg));

        String gregerID = "7512166544";
        String notGregerID = "8906138493";


        assertEquals(customers.get(0), gym.findCustomerInList(customers, gregerID));

        assertNotEquals(customers.get(0), gym.findCustomerInList(customers, notGregerID));


    }


    @Test
    public final void findCustomerLastPayedDate() {


        assertEquals(gym.findCustomerLastPayedDate(customers.get(0)), "2020-03-23");
        assertNotEquals(gym.findCustomerLastPayedDate(customers.get(0)), "2020-03-24");

        assertEquals(gym.findCustomerLastPayedDate(customers.get(2)), "2017-03-07");
        assertNotEquals(gym.findCustomerLastPayedDate(customers.get(2)), "2020-03-24");


    }

    @Test
    public final void checkIfLastPayedDateIsValid() {

        String gregerDate = customers.get(0).getPayedDate();
        String hilmerDate = customers.get(1).getPayedDate();
        String idaDate = customers.get(2).getPayedDate();


        assertTrue(gym.checkIfLastPayedDateIsValid(gregerDate, true));

        assertFalse(gym.checkIfLastPayedDateIsValid(hilmerDate, true));

        assertFalse(gym.checkIfLastPayedDateIsValid(idaDate, true));



    }

}