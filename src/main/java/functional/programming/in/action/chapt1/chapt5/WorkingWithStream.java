package functional.programming.in.action.chapt1.chapt5;

import functional.programming.in.action.chapt1.Utils;
import functional.programming.in.action.chapt1.chapt4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class covers
 * - Filtering, Slicing, and Matching
 * - Finding, matching, and reducing
 * - Using numeric streams such as ranges of numbers
 * - Creating streams from multiple sources
 * - Infinite streams
 */
public class WorkingWithStream {

    public static void main(String[] args) {

        filteringAndSlicing();

    }

    /**
     * Filtering and slicing
     */
    public static void filteringAndSlicing() {

        // initialize the menu
        List<Dish> menu = Utils.dishList();

        //Filtering with predicate
        System.out.println("\nVegetarian dishes :");
        System.out.println("-----------------------");

        menu.stream()
                .filter(dish -> dish.isVegetarian())
                .forEach(System.out::println);

        // Filtering unique elements
        System.out.println("\nUnique numbers :");
        System.out.println("--------------------");

        List<Integer> numbers = Arrays.asList(1,2,3,4,4,5,5,6,7,8,8);
        numbers.stream()
                .distinct()
                .forEach(System.out::println);

        // Ignoring few elements of a stream
        System.out.println("\nSkipping first two elements of a stream");
        numbers.stream()
                .skip(2)
                .forEach(System.out::println);

        // Truncating given streams to given size
        System.out.println("\nTruncating infinite stream to first 5 elements");
        numbers.stream()
                .limit(5)
                .forEach(System.out::println);
    }

}


