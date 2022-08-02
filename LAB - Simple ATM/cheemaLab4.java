import javax.swing.JOptionPane;

public class cheemaLab4 {
    public static void main(String[] args) {
        int numDeposits = 0;
        int numWithdrawals = 0;
        double initialBalance = getAccountBalance();
        double accountBalance = initialBalance;
        String transactionAction = getTransactionAction();

        while (!transactionAction.equals("Q")) {
            if (transactionAction.equals("D")) {
                numDeposits++;
            } else if (transactionAction.equals("W")) {
                numWithdrawals++;
            }

            double transactionAmount = getTransactionAmount();
            accountBalance = calculateNewAccountBalance(transactionAction, transactionAmount, accountBalance);
            printAccountBalance(accountBalance);

            transactionAction = getTransactionAction();

        }
        printTransactionSummary(initialBalance, accountBalance, numDeposits, numWithdrawals);

    }

    public static double getAccountBalance() {

        while (true) {
            
            try{
                int accountBalance = Integer.parseInt(JOptionPane.showInputDialog("What is the account balance?"));

                if (accountBalance < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Error! Account balance must be a number greater than or equal to 0.");
                } else {
                    return accountBalance;
                }

            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error, please enter a valid numerical value");
            }
            
        }
    }

    public static String getTransactionAction() {
        while (true) {
            String transactionAction = JOptionPane.showInputDialog(
                    "What is the transaction action? 'W' for withdraw, 'D' for deposit, 'Q' to quit");
            if (!transactionAction.equals("W") && !transactionAction.equals("D") && !transactionAction.equals("Q")) {
                JOptionPane.showMessageDialog(null,
                        "Error! Please enter (D) for Deposit, (W) for Withdrawal, or (Q) for Quit");
            } else {
                return transactionAction;
            }
        }
    }

    public static double getTransactionAmount() {
        while (true) {
            try{
                    double transactionAmount = 
                    Double.parseDouble(JOptionPane.showInputDialog("What is the transaction amount?"));
                if (transactionAmount <= 0) {
                    JOptionPane.showMessageDialog(null, "Error! Transaction amounts must be a number greater than 0.");
                } else {
                    return transactionAmount;
                }
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error, please enter a valid numerical value");
            }

        }
    }

    public static Double calculateNewAccountBalance(String transactionAction, double transactionAmount, double accountBalance) {
        if (transactionAction.equals("D")) {
            accountBalance += transactionAmount;
        } else if (transactionAction.equals("W")) {
            accountBalance -= transactionAmount;
        }
        return accountBalance;
    }

    public static void printAccountBalance(double accountBalance) {
        JOptionPane.showMessageDialog(null, "The balance in your account is: " + accountBalance);
    }

    public static void printTransactionSummary(double initialBalance, double accountBalance, int numDeposits, int numWithdrawals) {
        JOptionPane.showMessageDialog(null, "The initial ballance in your account was: " + initialBalance
                + "\n The final balance in your account is: " + accountBalance + "\n Number of Deposits: " + numDeposits + "\n Number of Withdrawals: " + numWithdrawals);
    }

}
