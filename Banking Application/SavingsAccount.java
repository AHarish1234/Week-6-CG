// SavingsAccount.java
public class SavingsAccount extends Account {
    public SavingsAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Savings Account");
    }
}
