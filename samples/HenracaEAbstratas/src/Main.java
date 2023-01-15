import model.Account;
import model.BusinessAccount;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Account acc1 = new BusinessAccount();
        Account acc2 = new BusinessAccount();
        Account acc3 = new BusinessAccount();

        System.out.println(acc1);
        
        acc1.deposit(200);
        System.out.println(acc1);

        acc1.withdraw(310);
        System.out.println(acc1);

        System.out.println(acc2);
        System.out.println(acc3);

    }


}