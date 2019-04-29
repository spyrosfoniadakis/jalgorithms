package misc;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 * A class needed for test purposes
 */
public class Person implements Comparable{

    private final String firstName;
    private final String lastName;
    private final Date birthDate;

    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o)) {
            return 0;
        }

        Person other = (Person) o;
        int onLastName = this.lastName.compareTo(other.lastName);
        if(onLastName != 0){
            return onLastName;
        }
        return this.firstName.compareTo(other.firstName);
    }

    public static Person from(String firstName, String lastName, Date birthDate){
        return new Person(firstName, lastName, birthDate);
    }

    public static class AgeComparator<T extends Person> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getBirthDate().getTime(), o2.getBirthDate().getTime());
        }
    }

    public static AgeComparator<Person> newAgeComparator(){
        return new AgeComparator<>();
    }
}
