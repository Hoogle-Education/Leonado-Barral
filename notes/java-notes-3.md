# Classes abstratas

São classes que não produzem objetos, servem apenas para serem herdadas.

## keyword `protected`


Contaimage.png
```cs
public abstract class Account {

  private String id;
  private boolean isActive;
  protected String holder;
  protected double balance;

  public boolean isActive() {
    return isActive;
  }

  // contrato: assinatura do método
  public boolean deposit(double amount);
  public boolean withdraw(double amount);
  public boolean transfer(double amount, Account destinationAccount);

}
```

```cs
public class BusinessAccount extends Account {

  private double initialLimit;
  private double limit;

  public BusinessAccount() {
    this.limit = random.nextDouble(100, 200);
    this.initialLimit = limit;
  }

  public boolean deposit(double amount) {
    if( !this.isActive ) 
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
    if( !this.isActive )
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

}
```