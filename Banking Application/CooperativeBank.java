// CooperativeBank.java
public class CooperativeBank extends Bank {
    public CooperativeBank(String bankName, String branchName) {
        super(bankName, branchName);
    }

    @Override
    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened in Cooperative Bank.");
    }

    @Override
    public void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + getBankCode());
    }
}