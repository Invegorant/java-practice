package tests.functional_interfaces.functions;

import io.qameta.allure.Description;
import main_package.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class FunctionTests extends BaseTest {
    @Test
    @Description ("Simple Function change Integer to String")
    void simpleFunctionTest () {
        String expectedString = "10 dollars";
        Function<Integer, String> convertFunction = x -> x + " dollars";
        String resultString = convertFunction.apply(10);
        Assertions.assertTrue(expectedString.equals(resultString));
        System.out.println(convertFunction.apply(8));
    }
}
