package banking;

import java.util.Scanner;

public class BankApp {
    private static int accCounter = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = null;

        System.out.println("Choose Bank Type: 1. Nationalized  2. Cooperative");
        int bankChoice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Bank Name: ");
        String bankName = sc.nextLine();
        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();

        bank = (bankChoice == 1) ? new NationalizedBank(bankName, branchName) : new CooperativeBank(bankName, branchName);

        while (true) {
            System.out.println("\n1. Open Account  2. Deposit  3. Withdraw  4. Show All Accounts  5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select Account Type: 1. Savings  2. Current  3. Loan");
                    int accType = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String holder = sc.nextLine();
                    System.out.print("Enter Initial Amount: ");
                    double amount = sc.nextDouble();
                    String accNum = "ACC" + (++accCounter);
                    Account acc = switch (accType) {
                        case 1 -> new SavingsAccount(accNum, holder, amount);
                        case 2 -> new CurrentAccount(accNum, holder, amount);
                        case 3 -> new LoanAccount(accNum, holder, amount);
                        default -> null;
                    };
                    if (acc != null) {
                        bank.openAccount(acc);
                        System.out.println("Account Number: " + accNum);
                    } else {
                        System.out.println("Invalid account type.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depNum = sc.next();
                    System.out.print("Enter Amount: ");
                    double depAmt = sc.nextDouble();
                    for (Account a : bank.getAccounts()) {
                        if (a.accountNumber.equals(depNum)) {
                            a.deposit(depAmt);
                            System.out.println("Deposit successful. New Balance: ₹" + a.getBalance());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String wNum = sc.next();
                    System.out.print("Enter Amount: ");
                    double wAmt = sc.nextDouble();
                    for (Account a : bank.getAccounts()) {
                        if (a.accountNumber.equals(wNum)) {
                            a.withdraw(wAmt);
                            System.out.println("Updated Balance: ₹" + a.getBalance());
                        }
                    }
                    break;

                case 4:
                    bank.displayBankInfo();
                    for (Account a : bank.getAccounts()) {
                        System.out.println("\n--- Account Details ---");
                        a.showAccountType();
                        System.out.println("Holder: " + a.holderName);
                        System.out.println("Account Number: " + a.accountNumber);
                        System.out.println("Balance: ₹" + a.getBalance());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
