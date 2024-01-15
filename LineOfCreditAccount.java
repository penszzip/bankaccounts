import java.time.LocalDate;

public class LineOfCreditAccount extends BankAccount {
    public LineOfCreditAccount(String name, int initialBalance, int creditLimit) {
        super(name, initialBalance, -creditLimit);
        
    }
    
    @Override
    public void performMonthEndTransactions() {
        if (balance < 0) {
            double interest = -balance * 0.07;
            int res = (int) interest;
            makeWithdrawal(res, LocalDate.now(), "Charge monthly interest");
        }
    }

    @Override
    protected Transaction checkWithdrawalLimit(boolean isOverdrawn) {
        if (isOverdrawn) {
            return new Transaction(-20, LocalDate.now(), "Apply overdraft fee");
        }
        return null;
    }
}