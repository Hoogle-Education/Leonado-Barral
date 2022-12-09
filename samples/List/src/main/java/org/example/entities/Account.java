package org.example.entities;

import java.util.Objects;

public class Account {

    // attributes
    private long id;
    private User user;
    private double balance;
    private boolean enabled;

    // constructor
    public Account(long id, String email, String holder, String pasword) {
        this.user = new User();
        this.id = id;
        this.user.holder = holder;
        this.user.password = pasword;
        this.user.email = email;
        this.balance = 0.0;
        this.enabled = true;
    }

    public Account(long id, String email, String holder, String password, String nickname) {
        this(id, email, holder, password);
        this.user.nickname = nickname;
    }

    // getter and setter
    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isEnabled() {
        return enabled;
    }

    // methods
    // deposit
    protected void deposit(double amount){
        balance += amount;
    }

    // withdraw
    protected boolean withdraw(double amount){
        if(balance < amount)
            return false;

        balance -= amount;
        return true;
    }

    // transfer
    protected boolean transfer(double amount, Account destinationAccount){
        if( this.withdraw(amount) ){
            destinationAccount.deposit(amount);
            return true;
        }

        return false;
    }

    // to string

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user=" + user +
                ", balance=" + balance +
                ", enabled=" + enabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (Double.compare(account.balance, balance) != 0) return false;
        if (enabled != account.enabled) return false;
        return Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}
