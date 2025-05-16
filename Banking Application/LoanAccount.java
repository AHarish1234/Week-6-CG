// LoanAccount.java
public class LoanAccount extends Account {
    public LoanAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Loan Account");
    }
}