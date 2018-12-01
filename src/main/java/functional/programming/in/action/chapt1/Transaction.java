package functional.programming.in.action.chapt1;

public class Transaction {
    String currency;

    double amount;

    public Transaction(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
