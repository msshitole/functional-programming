package functional.programming.in.action.chapt1;

import functional.programming.in.action.chapt1.chapt4.Dish;

import java.util.*;

public class Utils {
    public static List<Apple> init() {

        List<Apple> inventory = new ArrayList<Apple>();

        Apple greenApple1 = new Apple("green", 120);
        greenApple1.setCountry("India");
        Apple greenApple2 = new Apple("green", 150);
        greenApple2.setCountry("India");
        Apple greenApple3 = new Apple("green", 160);
        greenApple3.setCountry("India");

        Apple redApple1 = new Apple("red", 110);
        redApple1.setCountry("Germany");
        Apple redApple2 = new Apple("red", 170);
        redApple2.setCountry("Germany");
        Apple redApple3 = new Apple("red", 150);
        redApple3.setCountry("Germany");

        Apple brownApple1 = new Apple("brown", 120);
        brownApple1.setCountry("Switzerland");
        Apple brownApple2 = new Apple("brown", 110);
        brownApple2.setCountry("Switzerland");

        inventory.add(brownApple1);
        inventory.add(brownApple2);

        inventory.add(greenApple1);
        inventory.add(greenApple2);
        inventory.add(greenApple3);

        inventory.add(redApple1);
        inventory.add(redApple2);
        inventory.add(redApple3);


        return inventory;

    }

    public static List<Dish> dishList() {

        List<Dish> dishes = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        return dishes;
    }

    public static Map<String, List<Transaction>> initTransactions() {
        Map<String, List<Transaction>> transactionMap = new HashMap<>();

        Transaction transaction1 = new Transaction("EUR", 200);
        Transaction transaction2 = new Transaction("EUR", 500);

        List<Transaction> transactionList1 = new ArrayList<>();
        transactionList1.add(transaction1);
        transactionList1.add(transaction2);

        transactionMap.put("EUR", transactionList1);

        Transaction transaction3 = new Transaction("INR", 1200);
        Transaction transaction4 = new Transaction("INR", 300);

        List<Transaction> transactionList2 = new ArrayList<>();
        transactionList2.add(transaction3);
        transactionList2.add(transaction4);

        transactionMap.put("INR", transactionList2);

        return transactionMap;

    }

}
