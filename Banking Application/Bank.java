import java.util.ArrayList;
import java.util.List;

public abstract class Bank {
    protected String bankName;
    protected String branchName;
    protected static final String BANK_CODE_PREFIX = "BANK-";
    private static int bankCounter = 1;
    private String bankCode;

    protected List<Account> accounts;

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.bankCode = generateBankCode();
        this.accounts = new ArrayList<>();
    }

    private String generateBankCode() {
        return BANK_CODE_PREFIX + bankCounter++;
    }

    public String getBankCode() {
        return bankCode;
    }

    public abstract void openAccount(Account account);

    public abstract void displayBankInfo();

    public List<Account> getAccounts() {
        return accounts;
    }
}
