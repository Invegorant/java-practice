package tests.fibonacci_numbers;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FibonacciNumbersTests {

    @Test
    @Description("Make a method which returns Fibonacci number by index")
    void fibonacciNumbersTest() {
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
        int [] ints = new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        int firstNumber = getFibonacciNumberByIndex(18);
        int secondNumber = getFibonacciNumberByIndex(8);
        Assertions.assertEquals(1597, firstNumber);
        Assertions.assertEquals(13, secondNumber);
    }

    private int getFibonacciNumberByIndex(int requiredNumber)
    {
        int firstNumber = 0;
        int secondNumber = 1;

        // Init intArray and add first two numbers -> 0,1
        int[] integerArray = new int[requiredNumber];
        integerArray[0] = firstNumber;
        integerArray[1] = secondNumber;
        System.out.println("BEFORE CYCLE => " + Arrays.toString(integerArray));

        // Add the rest of the numbers until requiredNumber is reached and return number by index
        for (int i = 2; i < requiredNumber; i++)
        {
            integerArray[i] = integerArray[i - 1] + integerArray[i - 2];
        }
        System.out.println("AFTER CYCLE => " + Arrays.toString(integerArray));
        return integerArray[requiredNumber - 1];
    }
}
