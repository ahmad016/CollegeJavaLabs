import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class AdvisingAppointmentTracker {
    public static void main(String[] args) {

        // Step 1: Set any constants needed for the program
        final int NUM_DAYS = 7;
        final int MIN_NUM_APPOINTMENTS = 0;

        // Step 2: Create an array that will hold the number of advising appointments per day
        int [] apt = new int [NUM_DAYS];


        // Step 3: Enter the number of advising appointments for all of the days
        for (int i = 0; i < NUM_DAYS; i++) {
            //Use of try/catch to make sure only integers are typed and program doesn't crash
            try {
                apt[i] = Integer.parseInt(JOptionPane.showInputDialog("What are the appointments for day " + (i + 1) + "?"));
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please input a valid numerical value");
                i--;
                continue;
            }

            //If value is less than 0, try again
            if (apt[i] < MIN_NUM_APPOINTMENTS){
                JOptionPane.showMessageDialog(null, "Value is less than 0, please try again for Day " + (i + 1) + "?");
                i--;
                continue;
            }

        }

        // Step 4: Find the average number of appointments

        // 4a) find sum
        double sum = 0;
        for (int i = 0; i < NUM_DAYS; i++){
            sum += apt[i];
        }
        // 4b use sum to find average
        sum /= (double) NUM_DAYS;
        // 4c (Extra): Convert average to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(sum);

        // Step 5: Output the average number of appointments
        JOptionPane.showMessageDialog(null, "The Average number of appointments in the last 7 days is: " + formatted);
    }
}
