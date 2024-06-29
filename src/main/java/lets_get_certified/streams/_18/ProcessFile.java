package lets_get_certified.streams._18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Cat{
    private String name, colour;
    Cat(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }
    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", colour=" + colour + '}';
    }
}
public class ProcessFile {
    public static void main(String []args){
        List<Cat> cats = loadCats("C:\\Users\\TO11RC\\OneDrive - ING\\miel\\workspace\\Java\\udemy-java21-java17-java11-and-advanced-java8\\src\\main\\java\\lets_get_certified\\streams\\_18\\Cats.txt");
        cats.forEach(System.out::println);// just print the Cat
    }
    public static List<Cat> loadCats(String filename){
        List<Cat> cats = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(filename))){
            stream.forEach(line -> {
                String[] catsArray = line.split("/");
                cats.add(new Cat(catsArray[0], catsArray[1]));
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cats;
    }
}





