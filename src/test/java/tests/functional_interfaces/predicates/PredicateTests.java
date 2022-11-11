package tests.functional_interfaces.predicates;

import io.qameta.allure.Description;
import main_package.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTests extends BaseTest {

    @Test
    @Description ("simple predicate test")
    void simplePredicateTest () {
        Predicate<Integer> isPositive = x->x>=0;
        Predicate<Integer> isNegative = x-> x<0;
        System.out.println("9 is positive " + isPositive.test(9));
        Assertions.assertTrue(isPositive.test(9));
        System.out.println("-5 is positive " + isPositive.test(-5));
        Assertions.assertFalse(isPositive.test(-5));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 8, 1, -2, 6, -50, 0, 1, 3));
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + " is positive " + isPositive.test(numbers.get(i)));
        }
        numbers.stream().filter(isPositive).forEach(System.out::println);
        numbers.stream().filter(isNegative).forEach(System.out::println);
        Set<Integer> uniqPositive = numbers.stream().filter(isPositive).collect(Collectors.toSet());
        Iterator<Integer> listIterator = uniqPositive.iterator();
        while (listIterator.hasNext()){
            Assertions.assertTrue(isPositive.test(listIterator.next()));
        }
    }
    
}
