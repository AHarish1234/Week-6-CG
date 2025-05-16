package banking;

public class LoanAccount extends Account {
    public LoanAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        balance -= amount;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals not allowed in Loan Account");
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Loan Account");
    }
}
