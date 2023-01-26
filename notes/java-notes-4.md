# Interface (_contrato_)

A interface especifica obrigações que a classe que a implementa **deve** especificar

```java
public interface TaxService {

  double tax(double amount);

}
```

```java
public class BrasilTaxService implements TaxService {

  public double tax(double amount){
    if(amount > 100.0)
      return 0.10*amount;

    return 0.15 * amount;
  }

}
```

```java
public class CarRentalService {

  private TaxService taxService;

  public CarRentalService(TaxService taxService) {
    this.taxService = taxService;
  }

}
```

```java
CarRentalService service = new CarRentalService(new BrasilTaxService());
```

# Programação Funcional

## Predicate<T, boolean>

Todo predicate será uma referência para uma função que recebe como parâmetro um tipo T e sempre retorna boolean.



## Action

## Function

# Streams in Java
