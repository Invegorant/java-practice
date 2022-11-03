package tests.functional_interfaces.functions;

import io.qameta.allure.Description;
import main_package.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionTests extends BaseTest {
    @Test
    @Description("Simple Function change Integer to String")
    void simpleFunctionTest() {
        String expectedString = "10 dollars";
        Function<Integer, String> convertFunction = x -> x + " dollars";
        String resultString = convertFunction.apply(10);
        Assertions.assertTrue(expectedString.equals(resultString));
        System.out.println(convertFunction.apply(8));
    }

    @Test
    @Description("Function change Integer to String andThan String to char Array")
    void functionTestAndThen() {
        String expectedString = "10 dollars";
        Function<Integer, String> convertFunction = x -> x + " dollars";
        Function<String, List<Character>> converStrToCharArray = x -> {
            char[] charsArray = x.toCharArray();
            List<Character> characterList = new ArrayList<>();
            for (char charElement : charsArray) {
                characterList.add(charElement);
            }
            return characterList;
        };
        String resultString = convertFunction.apply(10);
        Assertions.assertTrue(expectedString.equals(resultString));
        List<Character> resultList = convertFunction.andThen(converStrToCharArray).apply(10);
        System.out.println(resultList);
        Assertions.assertTrue(resultList.size() > 0);
    }

    @Test
    @Description("function convert string to char array")
    void functionConvertStringToCharArray() {
        String firstString = "101313 million dollars";
        Function<String, char[]> convertStrToChar = x -> x.toCharArray();
        char[] s = convertStrToChar.apply(firstString);
        for (char element : s) {
            System.out.println(element);
        }
    }
}
