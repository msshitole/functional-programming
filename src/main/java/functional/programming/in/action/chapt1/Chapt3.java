package functional.programming.in.action.chapt1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static functional.programming.in.action.chapt1.MyUtil.*;
import java.util.function.*;
import static java.util.Comparator.comparing;

/**
 * Putting Lambdas into practice
 * The execute around pattern
 */
public class Chapt3 {

    public static void main(String[] args) {

        try {

            System.out.println("Invoking the simple processFile method");
            System.out.println("=======================================");
            String text = processFile();
            System.out.println(text);

            System.out.println("The execute around pattern in action");
            System.out.println("=====================================");
            text = processFile(br -> br.readLine()+" "+br.readLine());
            System.out.println(text);

            System.out.println("Demonstrate the useful functional interfaces");
            System.out.println("============================================");

            Predicate<String> nonEmptyStringPredicate = value -> !value.isEmpty();
            List<String> stringList = Arrays.asList("hi", "hello", "", "hi", "there", "");
            List<String> nonEmptyStringList = filter(stringList, nonEmptyStringPredicate);
            System.out.println("Filter nonEmpty strings using predicate");
            System.out.println("=======================================");
            System.out.println(nonEmptyStringList);

            Function<String, Integer> stringToItsLengthFunction = value -> value.length();
            List<Integer> listWithItsLength = map(stringList, stringToItsLengthFunction);
            System.out.println("map the string to its length using Function interface");
            System.out.println("======================================================");
            System.out.println(listWithItsLength);

            System.out.println("Print the list using Consumer interface");
            System.out.println("=======================================");
            Consumer<String> printingConsumer = System.out::println;
            forEach(stringList, printingConsumer);

            System.out.println("\nPutting lambdas and method references into practice");
            System.out.println("====================================================");

            List<Apple> inventory = Utils.init();
            System.out.println(inventory);

            System.out.println("\nStep 1: Pass Code");
            System.out.println("-------------------");
            inventory.sort(new AppleComparator());
            System.out.println(inventory);

            System.out.println("\nStep 2: Use Anonymous class");
            System.out.println("-----------------------------");
            inventory.sort(new Comparator<Apple>() {
                @Override
                public int compare(Apple o1, Apple o2) {
                    return o1.getWeight().compareTo(o2.getWeight());
                }
            });
            System.out.println(inventory);

            System.out.println("\nStep 3: Use Lambda expression");
            System.out.println("-------------------------------");
            inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
            System.out.println(inventory);

            System.out.println("\n Make it even readable with the static comparing method");
            System.out.println("----------------------------------------------------------");
            inventory.sort(comparing(apple -> apple.getWeight()));
            System.out.println(inventory);

            System.out.println("\nStep 4: Use Method references - a syntactic sugar for Lambda expressions");
            System.out.println("---------------------------------------------------------------------------");
            inventory.sort(comparing(Apple::getWeight));
            System.out.println(inventory);
            System.out.println("\nCongratulations, this is your final solution!");
            System.out.println("=============================================");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the data.txt file
     * and return the firts line
     * @return
     * @throws IOException
     */
    public static String processFile() throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader("/Users/arya/devwork/functional-programming/src/main/java/functional/programming/in/action/chapt1/data.txt"))) {
            return br.readLine();
        }
    }

    /**
     * Only useful line is br.readLine
     * The init and cleanup code is redundant unnecessary code
     * We can pass the behavior and make use of the execute around pattern
     */
    @FunctionalInterface
    public interface BufferredReaderProcessor {
        String process(BufferedReader bufferedReader) throws IOException;
    }

    /**
     * Create a method which takes functional interface as argument
     * then we can easily make use of Lambda expressions
     * - Behavior parametrization
     * - execute the behavior
     */
    public static String processFile(BufferredReaderProcessor bufferredReaderProcessor) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/arya/devwork/functional-programming/src/main/java/functional/programming/in/action/chapt1/data.txt"))) {
            return bufferredReaderProcessor.process(br);
        }
    }
}
