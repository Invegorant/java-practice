package tests.collections.iterator;

import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import main_package.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class IteratorTests extends BaseTest {

    private ArrayList<String> states = new ArrayList<>(Arrays.asList("Germany", "France", "Italy", "Spain"));
    private ArrayList<Integer> numbers;
    private final Consumer<ArrayList<String>> printStates = System.out::println;
    private final Consumer printT = System.out::println;

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    @Order(1)
    @Description("Print every element from ArrayList using Iterator")
    void simpleIteratorTest() {
        Iterator<String> iter = states.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
   // @RepeatedIfExceptionsTest(repeats = 4)
    @RetryingTest(value = 3)
    @Order(2)
    @Description("Print every element from ArrayList using Iterator, change last value and print every value in vice-versa order")
    void simpleListIteratorTest() {
        ListIterator<String> listIter = states.listIterator();

        System.out.println("BEFORE CHANGING THE ELEMENT");
        while (listIter.hasNext()) {

            System.out.println(listIter.next());
        }
        System.out.print("\n");

        // current element of ArrayList -> Spain
        // let's change current value to Russia
        listIter.set("Russia");
        // let's print every value in vice-versa order
        System.out.println("AFTER CHANGING THE ELEMENT");
        while (listIter.hasPrevious()) {
            System.out.println(listIter.previous());
        }

        Assertions.assertTrue(states.contains("Russia"));
        Assertions.assertFalse(states.contains("Spain"));
        Assertions.assertEquals(4, states.size());
    }

    @Test
    @Order(3)
    @Description("Print every element from ArrayList using ListIterator, delete on element and print every value")
    void listIteratorRemoveTest() {
        System.out.println("BEFORE DELETING THE ELEMENT");
        printStates.accept(states);

        ListIterator<String> listIter = states.listIterator();

        while (listIter.hasNext()) {
            String element = listIter.next();
            if (element.equals("Italy")) {
                listIter.remove();
                break;
            }
        }

        System.out.println("AFTER DELETING THE ELEMENT");
        printStates.accept(states);
        Assertions.assertFalse(states.contains("Italy"));
        Assertions.assertEquals(3, states.size());
    }

    @Test
    @Description("Print every element from ArrayList using consumer without defined type and set MAP with Iterator")
    void consumerWithoutDefinedTypeAndSetMapWithIteratorTest () {
        numbers = new ArrayList<>();
        for (int i = 0; i<10; i ++) {
            numbers.add(i, ThreadLocalRandom.current().nextInt(0, 6547831));
        }
        printT.accept(numbers);
        numbers.forEach(printT);
        ListIterator<Integer> listIterator = numbers.listIterator();
        Map<Integer, Integer> numbersMap = new HashMap<>();
        while (listIterator.hasNext()){
            int index = listIterator.nextIndex();
            int value = listIterator.next();
            if (index !=3) {
                numbersMap.put(index, value);
            }
        }
        printT.accept(numbersMap);
        Assertions.assertTrue(numbersMap.size() < numbers.size());
        Assertions.assertTrue(
                !numbersMap.containsKey(3)
        );
    }
}
