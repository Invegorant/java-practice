package tests.streams;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import mainPackage.config.BaseTest;
import mainPackage.providers.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//ToDo Replace System.out.println with somethings else
//ToDo Show in log values before stream and after
//ToDo Move methods to another separate package in mainPackage/???
public class StreamTests extends BaseTest {

    @Test
    @Order(1)
    @Description("Print from 1 to 9 in the stream using range")
    void integerStreamRangeTest()
    {
        // 1. Integer Stream with range
        IntStream
                .range(1,10)
                .forEach(System.out::print);
    }

    @Test
    @Order(2)
    @Description("Print from 1 to 10 in the stream using rangeClosed")
    void integerStreamRangeClosesTest()
    {
        // 2. Integer Stream with rangeClosed
        IntStream
                .rangeClosed(1,10)
                .forEach(System.out::print);
    }

    @Test
    @Order(3)
    @Description("Skip 5 values in the stream and print the rest values")
    void integerStreamWithSkipTest()
    {
        // 2. Integer Stream with skip
        IntStream
                .range(1,10)
                .skip(5) // skips first 5 values
                .forEach(System.out::println);
    }

    @Test
    @Order(4)
    @Description("Sums all values in the stream and print them")
    void integerStreamWithSumTest()
    {
        // 3. Integer Stream with sum
        System.out.println(IntStream
                .range(1,5)
                .sum()); // sums all values in stream
    }

    @Test
    @Order(5)
    @Description("Sort and print first element of the stream")
    void streamOfWithSortingAndFindFirstTest()
    {
        // 4. Stream.of, sorted and findFirst
        Stream.of("Comedy", "Fiction", "Horror")
                .sorted()
                .findFirst() // returns first element in stream
                .ifPresent(System.out::println); // ????
    }

    @Test
    @Order(6)
    @Description("Create array of names, find all names that starts with S, sort and print them")
    void streamFromArraySortingFilterAndPrintTest()
    {
        // 5. Stream from Array, sort, filter and print
        String [] names = {"Egor", "Kristina", "Sonya", "Sergey", "Maxim", "Alexey"};
        Arrays.stream(names) // same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    @Order(7)
    @Description("Square each element of the sprint, find average and print it")
    void streamFromArrayAverageOfSquaresTest()
    {
        // 6. Average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x) // ????
                .average() // ????
                .ifPresent(System.out::println);
    }

    @Test
    @Order(8)
    @Description("Create list of people, make strings LowerCase and print people with S char on start")
    void streamFromListFilterAndPrintTest()
    {
        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Egor", "Kristina", "Sonya", "Sergey", "Maxim", "Alexey");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("S"))
                .forEach(System.out::println);
    }

    @Test
    @Order(9)
    @Description("Create list of phrases, replace all spaces with underscore and make strings UpperCase")
    void StreamTest()
    {
        List <String> phrases = Arrays.asList("Goob job bro!", "LMAO that is bad", "code is good", "QA automation", "Alexey is a Qa Mobile Automation Engineer", "AQA");
        System.out.println(returnToUpperCaseWithSymbol(phrases));
    }

    @Test
    @Order(10)
    @Feature("Stream API: Conversions")
    @DisplayName("Create users List and convert it to Map")
    @Description("Create users List out of UserDTO, convert it to map and display print it as 'userId, UserDTO'")
    void usersListToMapTest()
    {
        List<UserDTO> users = Arrays.asList(
                new UserDTO(1L, "Bob", "Taylor", 30),
                new UserDTO(2L, "Tom", "Richard", 32),
                new UserDTO(3L, "Bob", "Wills", 31),
                new UserDTO(4L, "Nick", "Jackson", 29),
                new UserDTO(5L, "john", "Anderson", 31),
                new UserDTO(6L, "Tom", "Taylor", 30),
                new UserDTO(7L, "Bob", "Mills", 29)
        );
        Map<Long, String> usersMapWithLastName = returnListAsMapWithLastName(users);
        System.out.println(usersMapWithLastName);

        Map<Long, UserDTO> usersMap = returnUsersListAsMap(users);
        System.out.println(usersMap);
    }

    @Step
    private List<String> returnToUpperCaseWithSymbol(List<String> stringList)
    {
        return stringList.stream()
                .map(x -> x.replace(" ", "_").toUpperCase())
                .collect(Collectors.toList());
    }

    @Test
    void repeatableItemsStreamTest()
    {
        List<String> stringList = Arrays.asList("john", "doe", "doe", "tom");
        System.out.println(getRepeatableWordsInString(stringList));
    }

    @Step
    private Set<String> getRepeatableWordsInString(List<String> string)
    {
        Set<String> items = new HashSet<>();
        return string.stream().filter(n -> !items.add(n))
                .collect(Collectors.toSet());
    }

    @Test
    void mapToSetTest()
    {

    }

    @Test
    void listToSetTest()
    {

    }



    @Step
    private Map<Long, String> returnListAsMapWithLastName(List<UserDTO> users)
    {
        return users
                .stream()
                .collect(Collectors.toMap(UserDTO::getId, UserDTO::getLastName));
    }

    @Step
    private Map<Long, UserDTO> returnUsersListAsMap(List<UserDTO> users)
    {
        return users
                .stream()
                .collect(Collectors.toMap(UserDTO::getId, Function.identity()));

    }
}
