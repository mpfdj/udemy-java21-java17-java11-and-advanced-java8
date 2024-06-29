package lets_get_certified.streams;


import java.util.Objects;

public record Person(String firstname, String lastname, int age) {


    public Person {
        if (age < 10){
            throw new IllegalArgumentException("Minimum age is 10");
        }
    }


    public Person(String firstname, int age) {
        this(firstname, "De Jaeger", age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && firstname == person.firstname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, age);
    }
}
