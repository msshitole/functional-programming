package functional.programming.in.action.chapt1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static functional.programming.in.action.chapt1.Utils.*;
public class Chapt1InAction {

    public static void main(String[] args) {

        List<Apple> inventory = init();

        System.out.println("Green Apples");
        System.out.println("================");
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        System.out.println("Heavy Apples");
        System.out.println("================");
        List<Apple> heavyApples = filterHeavyApples(inventory);
        System.out.println(heavyApples);

        System.out.println("Smart filter");
        System.out.println("================");
        System.out.println("Green apples :: ");
        System.out.println("-------------------");
        greenApples = filterApples(inventory, Apple::isGreenApple);
        System.out.println(greenApples);

        System.out.println("Heavy Apples");
        System.out.println("---------------");
        heavyApples = filterApples(inventory, Apple::isHeavyApple);
        System.out.println(heavyApples);

        System.out.println("Grouping By example");
        System.out.println("=====================");
        Transaction transaction1 = new Transaction("EUR", 1800);

        Transaction transaction3 = new Transaction("DOLLAR", 700);
        Transaction transaction4 = new Transaction("INR", 3800);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction3);
        transactions.add(transaction4);

        Map<String, List<Transaction>> transactionsByCurrencies = groupTransactions(transactions);
        //System.out.println(transactionsByCurrencies);

        transactionsByCurrencies = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        transactionsByCurrencies = initTransactions();
        System.out.println(transactionsByCurrencies);

    }

    public static Map<String, List<Transaction>> groupTransactions(List<Transaction> transactions){
        Map<String, List<Transaction>> transactionsByCurrencies = initTransactions();

        for (Transaction transaction : transactions) {
                String currency = transaction.getCurrency();

                List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);

                if(transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    transactionsForCurrency.add(transaction);

                    transactionsByCurrencies.put(currency, transactionsForCurrency);
                } else {
                    transactionsForCurrency.add(transaction);
                    transactionsByCurrencies.put(currency, transactionsForCurrency);
                }
        }

        return transactionsByCurrencies;

    }


    /**
     * Filter green apples
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if("green".equalsIgnoreCase(apple.getColor())) {
                result.add(apple);
            }

        }

        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(apple.getWeight() >= 150) {
                result.add(apple);
            }

        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(predicate.test(apple)) {
                result.add(apple);
            }

        }

        return result;
    }

}
