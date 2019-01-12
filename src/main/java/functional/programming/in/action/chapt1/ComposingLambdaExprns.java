package functional.programming.in.action.chapt1;

import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

public class ComposingLambdaExprns {

    public static void main(String[] args) {
        System.out.println("Compose the Lambda expressions");
        System.out.println("================================");


        List<Apple> inventory = Utils.init();

        System.out.println("\nComposing comparators");
        System.out.println("------------------------");
        Comparator<Apple> comparator = Comparator.comparing(Apple::getWeight);
        inventory.sort(comparator);
        System.out.println(inventory);

        System.out.println("\nReversed order");
        System.out.println("-----------------");
        inventory.sort(comparator.reversed());
        System.out.println(inventory);

        System.out.println("\nChaining Comparators");
        System.out.println("-----------------------");
        inventory.sort(
                comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry)
        );
        System.out.println(inventory);

    }
}
