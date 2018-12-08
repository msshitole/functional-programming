package functional.programming.in.action.chapt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * - Coping with changing requirements
 * - Behavior parametrization
 * - Anonymous classes
 * - Preview of lambda expressions
 * - Real world examples : Comparator, Runnable, and GUI
 */
public class Chapt2 {

    public static void main(String[] args) {

        List<Apple> inventory = Utils.init();
        // First requirement : Filter gren apples
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println("Green Apples");
        System.out.println("=================");
        System.out.println(greenApples);

        // Second requirement : Filter red apples as well
        // Make the farmer happy, and call your method as follows
        greenApples = filterApplesByColor(inventory, "green");
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println("Filter apples by color");
        System.out.println("=========================");
        System.out.println(greenApples);
        System.out.println(redApples);

        // New change request : 3rd requirement : Good to differntiate light and heavy apples
        // Heavy apples are greater than equal to 150gm
        List<Apple> heavyApples = filterHeavyApples(inventory, 150);
        System.out.println("Heavy Apples");
        System.out.println("==================");
        System.out.println(heavyApples);

        System.out.println("Call generic filter method");
        // Filter green apples
        greenApples = filterApples(inventory, "green", 0, true);
        System.out.println("Green Apples");
        System.out.println("================");
        System.out.println(greenApples);

        System.out.println("Heavy apples");
        System.out.println("====================");
        heavyApples = filterApples(inventory, "", 150, false);
        System.out.println(heavyApples);

        System.out.println("\nFourth attempt : : Behavior parameterization");
        System.out.println("==============================================");
        greenApples = filterApples(inventory, new GreenApplePredicate());
        System.out.println("Green apples :: ");
        System.out.println(greenApples);
        heavyApples = filterApples(inventory, new HeavyApplePredicate());
        System.out.println(heavyApples);

        System.out.println("\nTackling verbocity");
        System.out.println("Sixth attempt, use anonymous classes");
        System.out.println("========================================");
        List<Apple> redAndHeavyApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equalsIgnoreCase(apple.getColor())
                        && apple.getWeight() >= 150;
            }
        });

        System.out.println("Red and heavy apples :: ");
        System.out.println(redAndHeavyApples);

        System.out.println("\nOne step further : Tackling verbocity with clean and concise code");
        System.out.println("The magic of Lambdas");
        System.out.println("=================================================================");
        System.out.println("Green apples :: ");
        greenApples = filterApples(inventory, apple -> "green".equalsIgnoreCase(apple.getColor()));
        System.out.println(greenApples);
        redAndHeavyApples = filterApples(inventory, apple -> "red".equalsIgnoreCase(apple.getColor()) && apple.getWeight() >= 150);
        System.out.println("Red and heavy apples :: ");
        System.out.println(redAndHeavyApples);

        System.out.println("\nThe Seventh attempt :: More abstraction, abstracting inventory list");
        System.out.println("=====================================================================");
        greenApples = filter(inventory, apple -> "green".equalsIgnoreCase(apple.getColor()));
        System.out.println("Green Apples :: ");
        System.out.println("-----------------");
        System.out.println(greenApples);

        System.out.println("\nEven Numbers :: ");
        System.out.println("----------------------");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);
        System.out.println(evenNumbers);


    }


    /**
     * First attempt: filtering green apples
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : inventory) {
            if("green".equalsIgnoreCase(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * Second attempt: parametrizing the color
     *
     * "A good prinicipal is this: after writing similar code, try to abstract"
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : inventory) {
            if(color.equalsIgnoreCase(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * Code duplication
     * @param inventory
     * @param weight
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : inventory) {
            if(apple.getWeight() >= weight) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * Third attempt : filtering with every attribute you can think of
     * Merge the code
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if((flag && color.equalsIgnoreCase(apple.getColor())
            || (!flag && apple.getWeight() >= weight))) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * Fourth attempt : Abstract the filtering criteria
     */
    public static interface ApplePredicate {
        boolean test(Apple apple);
    }

    public static class GreenApplePredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return "green".equalsIgnoreCase(apple.getColor());
        }
    }

    public static class HeavyApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() >= 150;
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * More abstraction : Generic and flexible
     */
    public static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T element : inventory ) {
            if(predicate.test(element)) {
                result.add(element);
            }
        }

        return result;
    }
}
