package lets_get_certified.streams;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceCollectExampleTest {

    @Test
    public void test() {

        // The difference between reduce and collect is that collect is an enhanced form of reduction that can deal with mutable objects in parallel.

        Stream<Integer> numbers;
        Supplier<Stream<Integer>> numbersSupplier = () -> Stream.of(1, 2, 3, 4, 5);
        Supplier<Stream<Integer>> numbersWithDuplicateSupplier = () -> Stream.of(1, 2, 3, 4, 5, 1, 2);

        numbers = numbersSupplier.get();
        Double average = numbers.collect(Collectors.averagingInt(i -> i));
        System.out.println("average: " + average);

        numbers = numbersSupplier.get();
        Optional<Integer> min = numbers.min((i1, i2) -> i1 - i2);
        min.ifPresent(i -> System.out.println("min: " + i));

        numbers = numbersSupplier.get();
        Optional<Integer> max = numbers.max((i1, i2) -> i1 - i2);
        max.ifPresent(i -> System.out.println("max: " + i));

        numbers = numbersWithDuplicateSupplier.get();
        List<Integer> list = numbers
                .distinct()
//                .toList()
                .collect(Collectors.toList());
        System.out.println("distinct list: " + list);


        Person papa = new Person("papa", 43);
        Person mama = new Person("mama", 41);
        Person kim = new Person("kim", 14);
        Person bella = new Person("bella", 10);

        Supplier<Stream<Person>> personSupplier = () -> Stream.of(papa, mama, kim, bella);
        Stream<Person> personStream;

        personStream = personSupplier.get();
        List<Person> personSortByFirstname = personStream
                .sorted((p1, p2) -> p1.firstname().compareTo(p2.firstname()))
                .toList();
//                .collect(Collectors.toList());
        System.out.println("personSortByFirstname: " + personSortByFirstname);

        personStream = personSupplier.get();
        Double averageAge = personStream.collect(Collectors.averagingDouble(p -> p.age()));
        System.out.println("averageAge: " + averageAge);

        personStream = personSupplier.get();
        Optional<Person> personStartsWithK = personStream
                .filter(p -> p.firstname().startsWith("k"))
                .findFirst();  // Returns an object
        personStartsWithK.ifPresent(p -> System.out.println("personStartsWithK: " + p));



        // stream() is a default method in the Collection interface and therefore
        // is inherited by all classes that implement Collection. Map is NOT one
        // of those i.e. Map is not a Collection. To bridge between the two, we
        // use the Map method entrySet() to return a Set view of the Map (Set
        // IS-A Collection).

        Map<String, Integer> nameAgeMap = new HashMap<>();
        nameAgeMap.put("Miel", 43);
        nameAgeMap.put("Efril", 41);
        nameAgeMap.put("Kim", 14);
        nameAgeMap.put("Bella", 10);

        Stream<Map.Entry<String, Integer>> nameAgeStream = nameAgeMap.entrySet().stream();
        Map<String, Integer> nameAgeMapFiltered = nameAgeStream
                .filter(e -> e.getValue() >= 18)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println("nameAgeMapFiltered: " + nameAgeMapFiltered);
    }


}
