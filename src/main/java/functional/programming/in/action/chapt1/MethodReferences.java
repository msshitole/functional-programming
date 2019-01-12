package functional.programming.in.action.chapt1;

import java.util.*;
import java.util.function.*;

public class MethodReferences {


    /**
     * The capability of referring to a constructor without
     * instantiating it enables interesting applications
     */
    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static void main(String[] args) {
        List<Apple> inventory = Utils.init();

        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);

        /**
         * Constructor reference with the Supplier functional interface
         * which is a no argument constructor
         */
        Supplier<Apple> c1 = () -> new Apple();
        Apple a1 = c1.get();

        c1 = Apple::new;
        a1 = c1.get();

        /**
         * Constructor refernce with the Function functional interface
         * which takes input as integer weight and returns an Apple
         */
        Function<Integer, Apple> function = (Integer weight) -> new Apple(weight);
        Apple a2 = function.apply(100);

        function = Apple::new;
        a2 = function.apply(101 );

        List<Integer> wieghtList = Arrays.asList(100, 120, 150, 160);
        List<Apple> apples = map(wieghtList, Apple::new);

        /**
         * Constructor reference when you have the
         * two argument constructor - we can use BiFunction functional interface
         */
        BiFunction<String, Integer, Apple> stringIntegerAppleBiFunction = (String color, Integer weight) -> new Apple(color, weight);
        stringIntegerAppleBiFunction = Apple::new;

        Apple apple = stringIntegerAppleBiFunction.apply("green", 150);


    }

    public Fruit getMeFruit(String fruitName) {
        return map.get(fruitName)
                  .apply(100);
    }

    /**
     * Each element of a List of Integers is
     * passed to the constructor of Apple
     */
    public static List<Apple> map(List<Integer> weightList, Function<Integer, Apple> function) {

        List<Apple> result = new ArrayList<>();

        for(Integer weight : weightList) {
            result.add(function.apply(weight));
        }

        return result;

    }
}
