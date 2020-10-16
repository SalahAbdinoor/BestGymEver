import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Salah Abdinoor
 * 10/14/2020
 * 4:54 PM
 * BestGymEver3
 * Copyright: MIT
 */
public class IOUtil {

    /**
     * This method takes in the file of customers and creates a list of the Cumstomers.
     *
     * @param readFromFile
     * @return customerList
     */

    public List<Customer> readDataFromFile(String readFromFile) {

        List<Customer> customersList = new ArrayList<>();

        String[] nameAndSSN;
        String lastPayedDate = null;

        Path inFilePath = Paths.get(readFromFile);

        try (Scanner fileScanner = new Scanner(inFilePath)) {

            while (fileScanner.hasNext()) {

                nameAndSSN = fileScanner.nextLine().split(", ");

                if (fileScanner.hasNext()) {

                    lastPayedDate = fileScanner.nextLine();

                }

                Customer customer = new Customer(nameAndSSN[0], nameAndSSN[1], lastPayedDate);

                customersList.add(customer);

            }
        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fel på Arrayen, kolla indexeringen");
            e.printStackTrace();
            System.exit(0);
        }
        return customersList;
    }


    /**
     * This method logs the activity of the customer and reads the date/time into a file for the personal-trainer.
     *
     * @param writeToFile
     * @param customer
     */

    public void loggEntry(String writeToFile, Customer customer){

        String timeCheckedIn = LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        try (PrintWriter entry = new PrintWriter(
                new FileWriter(writeToFile, true))) {

            entry.println("Namn: " + customer.getName() + "\nPersonnummer: " + customer.getID() + "\nKom till Gymmet: " + timeCheckedIn + "\n");
            entry.flush();

        } catch (FileNotFoundException e) {
            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Det gick inte att skriva till fil");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
