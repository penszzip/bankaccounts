import java.time.LocalDate;

public class GiftCardAccount extends BankAccount {
    private final int monthlyDeposit;
    public GiftCardAccount(String name, int initialBalance) {
        super(name, initialBalance);
        monthlyDeposit = 0;
    }
    public GiftCardAccount(String name, int initialBalance, int monthlyDeposit) {
        super(name, initialBalance);
        this.monthlyDeposit = monthlyDeposit;
    }
    @Override
    public void performMonthEndTransactions() {
        if (monthlyDeposit != 0) {
            makeDeposit(monthlyDeposit, LocalDate.now(), "Add monthly deposit");
        }
    }
}