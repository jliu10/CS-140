import java.util.*;

class Tester {
    public static void printTransactions(ArrayList<Transaction> trans) {
        System.out.print("{");
        for(Transaction t : trans) {
            // System.out.println("ran once");
            System.out.print("\t" + t + " // \n");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        try {
            BankAccount ba = new BankAccount("Itch", "Gabe");
            EnhancedBankAccount eba = new EnhancedBankAccount("Xina", "Zhong");

            System.out.println("BANK ACCOUNT");
            System.out.println(ba);
            ba.depositToChecking(1000);
            ba.depositToSavings(500);
            System.out.println("Deposits:");
            System.out.println(ba);
            ba.withdrawFromChecking(1001);
            ba.withdrawFromSavings(1000);
            System.out.println("Failed withdrawals:");
            System.out.println(ba);
            ba.withdrawFromChecking(10);
            ba.withdrawFromSavings(25);
            System.out.println("Withdrawals");
            System.out.println(ba);
            ba.transferFromCheckingToSavings(10000);
            ba.transferFromSavingsToChecking(100);
            System.out.println("Transfers:");
            System.out.println(ba);


            System.out.println();
            System.out.println("ENHANCED");
            System.out.println(eba);
            System.out.println("Transactions:");
            System.out.println("\tFAILED:");
            printTransactions(eba.getAllFailedTransactions());
            System.out.println("\tSUCCESS:");
            printTransactions(eba.getAllSuccessfulTransactions());
            eba.depositToChecking(1000);
            eba.depositToSavings(500);
            System.out.println("Deposits:");
            System.out.println(eba);
            eba.withdrawFromChecking(1001);
            eba.withdrawFromSavings(1000);
            System.out.println("Failed withdrawals:");
            System.out.println(eba);
            eba.withdrawFromChecking(10);
            eba.withdrawFromSavings(25);
            System.out.println("Withdrawals");
            System.out.println(eba);
            eba.transferFromCheckingToSavings(10000);
            eba.transferFromSavingsToChecking(100);
            System.out.println("Transfers:");
            System.out.println(eba);
            System.out.println("Transactions:");
            System.out.println("\tFAILED:");
            printTransactions(eba.getAllFailedTransactions());
            System.out.println("\tSUCCESS:");
            printTransactions(eba.getAllSuccessfulTransactions());

            System.out.println("# of accounts: " + ba.getBankAccountCount());
            System.out.println();

            System.out.println("TRANSACTIONS TEST:");
            System.out.println("YESTERDAY'S TRANSACTIONS:");
            System.out.println("\tFAILED:");
            printTransactions(eba.getFailedTransactions(new Date(0, 0, 0), new Date(122, 1, 21)));
            System.out.println("\tSUCCESS:");
            printTransactions(eba.getSuccessfulTransactions(new Date(0, 0, 0), new Date(122, 1, 21)));
            System.out.println("TODAY'S TRANSACTIONS:");
            System.out.println("\tFAILED:");
            printTransactions(eba.getFailedTransactions(new Date(122, 1, 22), new Date(122, 1, 22, 23, 59)));
            System.out.println("\tSUCCESS:");
            printTransactions(eba.getSuccessfulTransactions(new Date(122, 1, 22), new Date(122, 1, 22, 23, 59)));
            System.out.println("TOMORROW'S TRANSACTIONS:");
            System.out.println("\tFAILED:");
            printTransactions(eba.getFailedTransactions(new Date(122, 1, 23), new Date(122, 1, 23)));
            System.out.println("\tSUCCESS:");
            printTransactions(eba.getSuccessfulTransactions(new Date(222, 1, 22), new Date(222, 1, 22)));
            System.out.println("YESTERDAY-TOMORROW'S TRANSACTIONS");
            System.out.println("\tFAILED:");
            printTransactions(eba.getFailedTransactions(new Date(122, 1, 21), new Date(122, 1, 23)));
            System.out.println("\tSUCCESS:");
            printTransactions(eba.getSuccessfulTransactions(new Date(122, 1, 21), new Date(122, 1, 23)));

            System.out.println();
            System.out.println(new Date().compareTo(new Date(122, 1, 21)) >= 0 && new Date().compareTo(new Date(122, 1, 23)) <= 0);

        } catch(Exception e) {

        }

    }

}
