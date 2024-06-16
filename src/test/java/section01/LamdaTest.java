package section01;

import org.junit.Test;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class LamdaTest {

    @Test
    public void testWithLambda() {

        HashMap<String, String> m = new HashMap<>();
        m.put("One", "Hello");
        m.put("Two", "Bye");

        BiConsumer<String, String> c = (key, value) -> System.out.printf("Key: %s Value: %s\n", key, value);

        m.forEach(c);


    }

}
