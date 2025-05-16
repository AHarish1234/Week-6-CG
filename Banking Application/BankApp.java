import java.util.*;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank nationalizedBank = new NationalizedBank("SBI", "Central");
        Bank cooperativeBank = new CooperativeBank("CoopBank", "West");
        Map<String, Account> accountMap = new HashMap<>(); // For lookup by account number

        while (true) {
            System.out.println("\n=== Bank Application Menu ===");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Display Bank and Account Details");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Select Bank: 1. Nationalized  2. Cooperative");
                    int bankChoice = scanner.nextInt();
                    scanner.nextLine();

                    Bank selectedBank = (bankChoice == 1) ? nationalizedBank : cooperativeBank;

                    System.out.println("Enter Account Holder Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Initial Balance:");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Select Account Type: 1. Savings  2. Current  3. Loan");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();

                    Account newAccount = null;
                    if (typeChoice == 1) newAccount = new SavingsAccount(name, balance);
                    else if (typeChoice == 2) newAccount = new CurrentAccount(name, balance);
                    else if (typeChoice == 3) newAccount = new LoanAccount(name, balance);

                    if (newAccount != null) {
                        selectedBank.openAccount(newAccount);
                        accountMap.put(newAccount.accountNumber, newAccount);
                        System.out.println("Account Created. Account Number: " + newAccount.accountNumber);
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNumDep = scanner.nextLine();
                    Account accDep = accountMap.get(accNumDep);
                    if (accDep != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = scanner.nextDouble();
                        scanner.nextLine();
                        accDep.deposit(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String accNumWith = scanner.nextLine();
                    Account accWith = accountMap.get(accNumWith);
                    if (accWith != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = scanner.nextDouble();
                        scanner.nextLine();
                        accWith.withdraw(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.println("Display for: 1. Nationalized Bank  2. Cooperative Bank");
                    int displayChoice = scanner.nextInt();
                    scanner.nextLine();
                    Bank selected = (displayChoice == 1) ? nationalizedBank : cooperativeBank;
                    selected.displayBankInfo();
                    for (Account acc : selected.getAccounts()) {
                        acc.showAccountType();
                        System.out.println("Account Number: " + acc.accountNumber);
                        System.out.println("Holder: " + acc.holderName);
                        System.out.println("Balance: " + acc.getBalance());
                        System.out.println("---");
                    }
                    break;

                case 5:
                    System.out.println("Exiting. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
