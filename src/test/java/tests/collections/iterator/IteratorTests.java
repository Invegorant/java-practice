package tests.collections.iterator;

import io.qameta.allure.Description;
import mainPackage.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class IteratorTests extends BaseTest {

    private static ArrayList<String> states;
    private final Consumer<ArrayList<String>> printStates = System.out::println;

    @BeforeAll
    static void beforeAll() {
        states = new ArrayList<>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");
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
}
