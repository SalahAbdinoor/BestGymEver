import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Salah Abdinoor
 * 10/14/2020
 * 5:05 PM
 * BestGymEver3
 * Copyright: MIT
 */

class IOUtilTest {

    IOUtil testUtil = new IOUtil();

    String inFile = "TextFiles/CustomerListTest.txt";



    @Test
    public final void readDataFromFileTest() {

        List<Customer> customers = testUtil.readDataFromFile(inFile);


        assertEquals(customers.size(), 3);
        assertFalse(customers.size() == 5);

        assertEquals(customers.get(0).getName(), "Greger Ganache");
        assertEquals(customers.get(1).getName(), "Hilmer Heur");
        assertEquals(customers.get(2).getName(), "Ida Idylle");

        assertNotEquals(customers.get(0).getName(), "Ida Idylle");

        assertEquals(customers.get(0).getID(), "7512166544");
        assertEquals(customers.get(0).getPayedDate(), "2020-03-23");

    }

}