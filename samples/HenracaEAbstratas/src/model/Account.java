package model;
public abstract class Account {

    private static long idCounter = 1;
    private long id;
    protected boolean isActive;
    protected String holder;
    protected double balance;

    public Account () {
        id = idCounter++;
        isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    // contrato: assinatura do método
    public abstract boolean deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract boolean transfer(double amount, Account destinationAccount);

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", isActive=" + isActive +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}