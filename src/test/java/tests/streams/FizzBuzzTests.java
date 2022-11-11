package tests.streams;

import io.qameta.allure.Description;
import main_package.config.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FizzBuzzTests extends BaseTest {

    public int startNumber = 0;
    public int lastNumber = 1500000;

    @Test
    @Tag("FizzBuzz")
    @Description("task fizz buzz for interview")
    void fizzBazzTest () {
        IntStream.rangeClosed(startNumber,lastNumber).mapToObj(u -> u%3==0  ?  (u%5==0 ? "fizzbuzz" : "fizz") : (u%5==0 ? "buzz" : u))
                .forEach(System.out::println);
    }

    @Test
    @Tag("FizzBuzz")
    @Description("task fizz buzz with predicate for interview")
    void fizzBazzPredicateTest () {
        Predicate<Integer> multipleOf3 = x->x%3==0;
        Predicate<Integer> multipleOf5 = x->x%5==0;
        IntStream.rangeClosed(startNumber,lastNumber).mapToObj(u -> multipleOf3.test(u)  ?  (multipleOf5.test(u) ? "fizzbuzz" : "fizz") : (multipleOf5.test(u) ? "buzz" : u))
                .forEach(System.out::println);
    }

    @Test
    @Tag("FizzBuzz")
    @Description("task fizz buzz with function for interview")
    void fizzBazzFunctionTest () {
        Function<Integer, String> convertIntToString = u -> u%3==0  ?  (u%5==0 ? "fizzbuzz" : "fizz") : (u%5==0 ? "buzz" : String.valueOf(u));
        IntStream.rangeClosed(startNumber,lastNumber).mapToObj(u->convertIntToString.apply(u))
                .forEach(System.out::println);
    }

    @Test
    @Tag("FizzBuzz")
    @Description("task fizz buzz with FORMAT for interview")
    void fizzBazzFormatTest () {
        IntStream.rangeClosed(startNumber,lastNumber).forEach(
                i -> System.out.format("%s%s%n",
                        (i % 3 == 0 ? "Fizz": ""),
                        (i % 5 == 0 ? "Buzz": (i % 3 == 0 ? "" : i))
                )
        );
    }

    @Test
    @Tag("FizzBuzz")
    @Description("task fizz buzz with predicate new for interview")
    void fizzBazzPredicateNewTest () {
        Predicate<Integer> multipleOf3 = x->x%3==0;
        Predicate<Integer> multipleOf5 = x->x%5==0;
        Predicate<Integer> doesntDivide = multipleOf3.negate().and(multipleOf5.negate());
        IntStream.rangeClosed(startNumber,lastNumber).forEach(i -> {
            StringBuffer bfr = new StringBuffer();

            if (multipleOf3.test(i)) bfr.append("Fizz");
            if (multipleOf5.test(i)) bfr.append("Buzz");
            if (doesntDivide.test(i)) bfr.append(i);

            System.out.println(bfr);});
    }

    @Test
    @Tag("FizzBuzz")
    @Description("task fizz buzz WITHOUT STREAM for interview")
    void fizzBazzWithoutStreamTest () {
        for (int i = startNumber; i <= lastNumber; i++) {
            if (0 == i % 3) {
                if (0 == i % 5) {
                    System.out.println("FizzBuzz");
                } else {
                    System.out.println("Fizz");
                }
            } else if (0 == i % 5) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    @Test
    @Tag("FizzBuzz")
    @Description("task fizz buzz WITHOUT STREAM WITH LONG PRINT")
    void fizzBazzWithoutStreamWithLongPrintTest () {
        for(int i = startNumber; i <= lastNumber - 15; i +=15) {
            System.out.printf("%d\n"     +     // 1
                    "%d\n"  +        // 2
                    "Fizz\n"  +      // 3
                    "%d\n"    +      // 4
                    "Buzz\n"  +      // 5
                    "Fizz\n"  +      // 6
                    "%d\n"    +      // 7
                    "%d\n"    +      // 8
                    "Fizz\n"  +      // 9
                    "Buzz\n"   +     // 10
                    "%d\n"    +      // 11
                    "Fizz\n"   +     // 12
                    "%d\n"    +      // 13
                    "%d\n"    +      // 14
                    "FizzBuzz\n",   // 15
                    i, i+1, i+3, i+6, i+7, i+10, i+12, i+13
            );
        }
    }
}
