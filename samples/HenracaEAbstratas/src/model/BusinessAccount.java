package model;

import java.util.Random;

public class BusinessAccount extends Account {

    private final double initialLimit;
    private double limit;
    private Random random = new Random();

    public BusinessAccount() {
        super();
        this.limit = random.nextInt(100, 200);
        this.initialLimit = limit;
    }

    public boolean deposit(double amount) {
        if( !isActive )
            return false;

        if(limit == initialLimit) {
            balance += amount;
            return true;
        }

        double delta = initialLimit - limit;

        if(amount < delta) {
            limit += amount;
            return true;
        }

        limit = initialLimit;
        amount -= delta;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if( !isActive )
            return false;

        if(limit + balance < amount)
            return false;

        if(amount <= balance) {
            balance -= amount;
            return true;
        }

        amount -= balance;
        balance = 0;
        limit -= amount;
        return true;
    }

    public boolean transfer(double amount, Account destinationAccount) {
        if(!destinationAccount.isActive)
            return false;

        if( !this.withdraw(amount) )
            return false;

        destinationAccount.deposit(amount);
        return true;
    }

    @Override
    public String toString() {
        return "BusinessAccount{" +
                "initialLimit=" + initialLimit +
                ", limit=" + limit +
                " " + super.toString() + "} ";
    }
}
