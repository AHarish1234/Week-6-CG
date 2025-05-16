// CurrentAccount.java
public class CurrentAccount extends Account {
    public CurrentAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Current Account");
    }
}