import java.time.LocalDate;

public class InterestEarningAccount extends BankAccount {
    public InterestEarningAccount(String name, int initialBalance) {
        super(name, initialBalance);

    }

    @Override
    public void performMonthEndTransactions() {
        if (balance > 500) {
            double interest = balance * 0.02;
            int res = (int)interest;
            makeDeposit(res, LocalDate.now(), "Apply monthly interest");
        }
    }
}