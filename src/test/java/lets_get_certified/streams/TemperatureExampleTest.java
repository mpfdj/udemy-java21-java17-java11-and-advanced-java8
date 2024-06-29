package lets_get_certified.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TemperatureExampleTest {


    @Test
    public void test() {

        List<Double> temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);

        Stream<Double> stream = temps.stream();

        long count = stream.peek(t -> System.out.println("Temp before filter: " + t))
                .filter(t -> t > 100)
                .peek(t -> System.out.println("Temp after filter: " + t))
                .count();

        System.out.println("Found " + count + " temperatures above 100.");

        System.out.println(temps);  // Source List is not changed!
    }

}
