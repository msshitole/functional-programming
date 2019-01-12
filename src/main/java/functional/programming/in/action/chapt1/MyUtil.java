package functional.programming.in.action.chapt1;

import java.util.ArrayList;
import java.util.List;

import java.util.function.*;
public class MyUtil {



    public static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T e : inventory) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();

        for (T e : list) {
            result.add(function.apply(e));
        }

        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            consumer.accept(e);
        }
    }


}
