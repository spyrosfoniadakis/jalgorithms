package misc;

import KeyedElement.IntKeyedElement;
import KeyedElement.LongKeyedElement;
import utils.DateUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class PersonUtils {
    public static IntKeyedElement<Person>[] createIntKeyedElementsArrayFrom(Person[] people) {
        return Arrays.stream(people)
                    .map(p -> IntKeyedElement.from(p.getAgeInMonths(), p))
                    .collect(Collectors.toList())
                    .toArray(new IntKeyedElement[people.length]);
    }

    public static Person[] getPeople() {
        return new Person[]{
                    Person.from("John", "Doe", DateUtils.getDateFrom(1980, 7, 19)),
                    Person.from("Jack", "Brown", DateUtils.getDateFrom(1990, 8, 14)),
                    Person.from("Joe", "Black", DateUtils.getDateFrom(1997, 3, 20)),
                    Person.from("Hank", "Smith", DateUtils.getDateFrom(1972, 10, 30)),
                    Person.from("Tim", "Johnson", DateUtils.getDateFrom(1979, 1, 22)),
                    Person.from("George", "Edison", DateUtils.getDateFrom(1992, 12, 7)),
                    Person.from("Alan", "Edison", DateUtils.getDateFrom(1990, 9, 7))
            };
    }

    public static LongKeyedElement<Person>[] createLongKeyedElementsArrayFrom(Person[] people) {
        return Arrays.stream(people)
                .map(p -> LongKeyedElement.from(((long)p.getAgeInMonths()), p))
                .collect(Collectors.toList())
                .toArray(new LongKeyedElement[people.length]);
    }
}
