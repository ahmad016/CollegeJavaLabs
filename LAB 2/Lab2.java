import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        //constants and initial variables not inputted by user
        final double minKilowatt = 0.0;
        final double maxKilowatt = 1000.0;
        final double lowRateKilowattMin = 200.0;
        final double lowRate = 0.08;
        final double highRate = 0.11;
        double totalOwed = 0.0;
        int numCustomers = 0;
        double amountOwed;

        // Prepare heading for later
        String heading = "Monthly Billing Report\n \n" + "Customer Number | Customer Name | Kilowatts Used | Amount Owed";

        //Variables inputted by user
        double kilowattsUsed;
        String customerName, customerNumber;

        //Ask for customer number to start off the loop, if the value is 'Quit' then the loop end
        customerNumber = (JOptionPane.showInputDialog(null, "What is the customer number? \nType 'QUIT' to exit", null, JOptionPane.INFORMATION_MESSAGE));
        while(!customerNumber.equalsIgnoreCase("QUIT"))
        {        
            //Show the user input for customer number
            JOptionPane.showMessageDialog(null, "Customer Number is " + customerNumber);
            do {
                
                //Type and show the user input for the customer's name
                customerName = JOptionPane.showInputDialog(null, "What is the customer name", null, JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Customer Name is " + customerName);

                //Type and show the user input for the kilowatts used
                kilowattsUsed = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the amount of killowats used?", null, JOptionPane.INFORMATION_MESSAGE));
                JOptionPane.showMessageDialog(null, "Killowats used is " + kilowattsUsed);

                //making sure killowats are valid
                if (kilowattsUsed < minKilowatt || kilowattsUsed >= maxKilowatt){
                    JOptionPane.showMessageDialog(null, "ERROR! Please enter a valid number of kilowatts");
                }

                //This can be an elseif but I already set it up like this and too tired to go back
                if (kilowattsUsed < lowRateKilowattMin){
                    amountOwed = kilowattsUsed * highRate;
                } else {
                    amountOwed = kilowattsUsed * lowRate;
                }              
                
                //Adds calculated total from the above if statement and adds it to the total bill
                totalOwed = totalOwed + amountOwed;
                numCustomers++;

                //Adds customer information for each loop into the heading variable
                heading += "\n" + customerNumber + " | " + customerName + " | " + kilowattsUsed + " | $" + String.format("%.2f", + amountOwed);

                customerNumber = (JOptionPane.showInputDialog(null, "What is the customer number \nType 'QUIT' to exit", null, JOptionPane.INFORMATION_MESSAGE));

            }          
                //Loop continues while these conditions are active  
                while (kilowattsUsed <= minKilowatt || kilowattsUsed > maxKilowatt);
        }

        if (numCustomers > 0){
            //Final heading
            JOptionPane.showMessageDialog(null, heading + "\n \n Number of Customers: " + numCustomers + "\n" + "Total Owed: $" + String.format("%.2f",totalOwed));
        } else {
            JOptionPane.showMessageDialog(null, "No Customers are Entered");
        }


    }
}
