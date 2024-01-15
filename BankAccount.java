import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static int accountNumberSeed = 1234567890;
    public String number;
    public String owner;
    public int balance;
    private final int minimumBalance;

    public BankAccount(String name, int initialBalance) {
        this(name, initialBalance, 0);
    }

    public BankAccount(String name, int initialBalance, int minimumBalance) {
        number = Integer.toString(accountNumberSeed);
        accountNumberSeed++;
        
        owner = name;
        
        this.minimumBalance = minimumBalance;
        if (initialBalance > 0) {
            makeDeposit(initialBalance, LocalDate.now(), "Initial balance");
        }
    }

    private List<Transaction> allTransactions = new ArrayList<Transaction>();

    public int getBalance() {
        balance = 0;
        for (Transaction t : allTransactions) {
            balance += t.amount;
        }    
        return balance;
    }

    public void makeDeposit(int amount, LocalDate date, String note) {
        if (amount <= 0) {
            throw new RuntimeException("Amount of deposit must be positive");
        }
        Transaction deposit = new Transaction(amount, date, note);
        allTransactions.add(deposit);
    };

    public void makeWithdrawal(int amount, LocalDate date, String note) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount of withdrawal must be positive");
        }

        Transaction overdraftTransaction = checkWithdrawalLimit(getBalance() - amount < minimumBalance);
        Transaction withdrawal = new Transaction(-amount, date, note);

        allTransactions.add(withdrawal);

        if (overdraftTransaction != null) {
            allTransactions.add(overdraftTransaction);
        }
    }

    protected Transaction checkWithdrawalLimit(boolean isOverdrawn) {
        if (isOverdrawn) {
            throw new IllegalStateException("Not sufficient funds for this withdrawal");
        } else {
            return null;
        }
    }

    public String getAccountHistory() {
        StringBuilder report = new StringBuilder();

        int balance = 0;
        report.append("Date\t\tAmount\tBalance\tNote\n");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        for (Transaction item : allTransactions) {
            balance = balance + item.amount;
            report.append(String.format("%s\t%s\t%s\t%s\n",
                    item.date.format(dateFormat),
                    item.amount,
                    balance,
                    item.notes));
        }

        return report.toString();
    }

    public void performMonthEndTransactions() {
        
    }
}