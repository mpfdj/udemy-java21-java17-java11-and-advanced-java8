package lets_get_certified.lambdas;

import org.junit.Test;

import java.util.function.Consumer;

public class MielLamdaSnippetsTest {


    public static void print(String s) {
        System.out.println(s);
    }



    @Test
    public void testWithConsumer1() {
        Consumer<String> c = System.out::println;
        c.accept("hello");
    }


    @Test
    public void testWithConsumer2() {
        Consumer<String> c = MielLamdaSnippetsTest::print;
        c.accept("hello");
    }

}
