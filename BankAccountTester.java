import java.io.Console;
import java.time.LocalDate;

public class BankAccountTester {
    public static void main(String[] args) {
        // BankAccount account1 = new BankAccount("Raj", 1000);
        // System.out.println("Owner:" + account1.owner);
        // System.out.println("Balance: " + account1.balance);
        // System.out.println("Number: " + account1.number);

        // BankAccount account2 = new BankAccount("Mike", 1000);
        // System.out.println("Owner:" + account2.owner);
        // System.out.println("Balance: " + account2.balance);
        // System.out.println("Number: " + account2.number);

        // GiftCardAccount giftCard = new GiftCardAccount("gift card", 100, 50);
        // giftCard.makeWithdrawal(20, LocalDate.now(), "get expensive coffee");
        // giftCard.makeWithdrawal(50, LocalDate.now(), "buy groceries");
        // giftCard.performMonthEndTransactions();
        // // can make additional deposits:
        // giftCard.makeDeposit(27, LocalDate.now(), "add some additional spending money");
        // System.out.println(giftCard.getAccountHistory());

        // InterestEarningAccount savings = new InterestEarningAccount("savings account", 10000);
        // savings.makeDeposit(750, LocalDate.now(), "save some money");
        // savings.makeDeposit(1250, LocalDate.now(), "Add more savings");
        // savings.makeWithdrawal(250, LocalDate.now(), "Needed to pay monthly bills");
        // savings.performMonthEndTransactions();
        // System.out.println(savings.getAccountHistory());

        LineOfCreditAccount lineOfCredit = new LineOfCreditAccount("line of credit", 0, 2000);
        lineOfCredit.makeWithdrawal(1000, LocalDate.now(), "Take out monthly advance");
        lineOfCredit.makeDeposit(50, LocalDate.now(), "Pay back small amount");
        lineOfCredit.makeWithdrawal(5000, LocalDate.now(), "Emergency funds for repairs");
        lineOfCredit.makeDeposit(150, LocalDate.now(), "Partial restoration on repairs");
        lineOfCredit.performMonthEndTransactions();
        System.out.println(lineOfCredit.getAccountHistory());
    }
}