package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private long id;
    private String name;
    private List<Account> accounts;

    public Bank(long id, String name) {
        this.id = id;
        this.name = name;
        accounts = new ArrayList<>();
    }

    public void registrateAccount(String name, String passwod, String email) {
        registrateAccount(name, null);
    }

    public void registrateAccount(String name, String nickname) {
        accounts.add(new Account(accounts.size(), name, nickname));
    }



}
