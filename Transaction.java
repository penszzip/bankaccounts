import java.time.LocalDate;

public class Transaction {
    public int amount;
    public LocalDate date;
    public String notes;

    public Transaction(int amount, LocalDate date, String note) {
        this.amount = amount;
        this.date = date;
        this.notes = note;
    }
}