package functional.programming.in.action.chapt1.chapt4;

import functional.programming.in.action.chapt1.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingWithStreams {

    public static void main(String[] args) {

        System.out.println("\nStream processing");
        System.out.println("====================");

        List<Dish> dishes = Utils.dishList();
        System.out.println(getViaFunctionalStyleSortedLowCaloricDishNames(dishes));
    }

    /**
     * Java 7 way
     * Return the names of dishes that are low in calories,
     * sorted by no. of calories
     */
    public static List<String> getSortedLowCaloricDisheNames(List<Dish> dishes) {

        // Accumulator
        List<Dish> lowCaloryDishes = new ArrayList<>();

        for (Dish dish : dishes) {
            if(dish.getCalories() < 400) {
                lowCaloryDishes.add(dish);
            }
        }

        // Sort the lowCaloricDishes
        lowCaloryDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return ((Integer)o1.getCalories()).compareTo(o2.getCalories());
            }
        });

        // Extract the dish names of low caloric dishes
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : lowCaloryDishes) {
            dishNames.add(dish.getName());
        }

        return dishNames;
    }

    /**
     * Java 8 way
     * Return the names of dishes that are low in calories,
     * sorted by no. of calories
     */
    public static List<String> getViaFunctionalStyleSortedLowCaloricDishNames(List<Dish> menu) {
         return menu.parallelStream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
