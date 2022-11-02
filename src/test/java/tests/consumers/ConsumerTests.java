package tests.consumers;

import io.qameta.allure.Description;
import mainPackage.config.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class ConsumerTests extends BaseTest {

    @Test
    @Description("simple test - just print consumer")
    void simplePrintConsumerTest () {
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Moscow", "Kiev", "London", "NY");
        cities.forEach(printConsumer);
    }

    @Test
    @Description("composition of consumers test")
    void consumerCompositionTest () {
        List<String> cities = Arrays.asList("Sydney", "Moscow", "Kiev", "London", "NY", "Ganalulu");
        Consumer <List<String>> upperCaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);
        upperCaseConsumer
                .andThen(printConsumer).accept(cities);
    }

    @Test
    @Description("IntConsummer print test")
    void intConsumerTest () {
        int x = 635;
        IntConsumer printConsumer = t -> System.out.println(t)  ;
        printConsumer.accept(x);
    }

}
