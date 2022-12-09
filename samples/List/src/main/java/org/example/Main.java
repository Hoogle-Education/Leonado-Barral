package org.example;

import org.example.entities.Account;
import org.example.entities.Bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Bank bank = new Bank(1, "bytebank");

        bank.registrateAccount("Hugo");
        bank.registrateAccount("Jhon");

        bank.transfer()

    }
}