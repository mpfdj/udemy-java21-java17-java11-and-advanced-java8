package lets_get_certified.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazinessExampleTest {


    @Test
    public void test() {
        List<String> names = Arrays.asList("Alex", "David", "April", "Edward");
        Stream<String> stream = names.stream();

        stream.filter(n -> {
            System.out.println("Filtering " + n);
            return true;
        })
        .forEach(n -> System.out.println("For each " + n));
    }


    @Test
    public void test2() {

        // Stream are lazy and dont process the whole List

        List<String> names = Arrays.asList("Alex", "David", "April", "Edward");
        Stream<String> stream = names.stream();

        stream.map(n -> {
                    System.out.println("map " + n);
                    return n.toUpperCase();
                })
                .anyMatch(n -> {
                    System.out.println("anyMatch " + n);
                    return n.startsWith("A");
                });
    }

}
