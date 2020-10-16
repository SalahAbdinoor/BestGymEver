import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        runProgram();

    }

    public static void runProgram(){

        boolean runProgram = true;

        while (runProgram) {
            try {

                String readFromFilePath = "TextFiles/CustomerList.txt";
                String writeToFile = "TextFiles/Attendance.txt";

                Gym BestGymEver = new Gym();
                IOUtil ioUtil = new IOUtil();


                List<Customer> customerList = ioUtil.readDataFromFile(readFromFilePath);

                String nameOrSSN = JOptionPane.showInputDialog("Ange ett namn/personnummer");


                Customer customer = BestGymEver.findCustomerInList(customerList, nameOrSSN);

                String customerLastPayedDate = BestGymEver.findCustomerLastPayedDate(customer);

                boolean checkIfValid = BestGymEver.checkIfLastPayedDateIsValid(customerLastPayedDate, false);


                if (!checkIfValid) {

                    JOptionPane.showMessageDialog(null, customer.getName() + " måste förnya sitt medlemskap");
                    break;

                }

                if (checkIfValid) {

                    if (JOptionPane.showConfirmDialog(null, customer.getName() + " är aktiv.\nVill Du logga hens dagsaktivitet", "Registrera Aktivitet",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        ioUtil.loggEntry(writeToFile, customer);

                    } else {

                        JOptionPane.showMessageDialog(null, "Aktiviteten loggas inte");
                    }

                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
                System.exit(0);

            } catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, e.getMessage());

                e.printStackTrace();
                System.exit(0);
            }
            runProgram = false;
        }
    }
}
