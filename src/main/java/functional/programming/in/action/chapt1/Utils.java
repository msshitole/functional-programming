package functional.programming.in.action.chapt1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static List<Apple> init() {

        List<Apple> inventory = new ArrayList<Apple>();

        Apple greenApple1 = new Apple("green", 120);
        Apple greenApple2 = new Apple("green", 150);
        Apple greenApple3 = new Apple("green", 160);
        Apple redApple1 = new Apple("red", 110);
        Apple redApple2 = new Apple("red", 170);
        Apple redApple3 = new Apple("red", 150);
        Apple brownApple1 = new Apple("brown", 120);
        Apple brownApple2 = new Apple("brown", 110);

        inventory.add(greenApple1);
        inventory.add(greenApple2);
        inventory.add(greenApple3);

        inventory.add(redApple1);
        inventory.add(redApple2);
        inventory.add(redApple3);

        inventory.add(brownApple1);
        inventory.add(brownApple2);

        return inventory;

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
