package functional.programming.in.action.chapt1;

import java.util.ArrayList;
import java.util.List;

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
}
