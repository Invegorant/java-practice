package tests.streams;

import io.qameta.allure.Description;
import main_package.config.BaseTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatableWordsTests  extends BaseTest
{
    @Test
    @Description("Print amount for every word")
    void countWordsTest()
    {
        String str = "I am java learning java learning java programming";
        String [] words = str.split(" ");
        Map<String, Integer > stringIntegerMap = new HashMap<>();
        Arrays.stream(words)
                .forEachOrdered(x -> stringIntegerMap.put(x, stringIntegerMap.getOrDefault(x, 0) +1));
        System.out.println(stringIntegerMap);
    }
}
