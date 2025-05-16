// Account.java (Abstract Class)
public abstract class Account implements AccountOperations {
    protected static int accountCounter = 1;
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String holderName, double balance) {
        this.accountNumber = "ACC" + accountCounter++;
        this.holderName = holderName;
        this.balance = balance;
    }

    public abstract void showAccountType();

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}