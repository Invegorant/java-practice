package tests.retry_failed_flaky;

import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import main_package.tools.Tools;
import main_package.tools.components.Randomizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;

import java.util.function.BooleanSupplier;

public class RetryingFlakyTests {
    private final Tools tools = new Tools();

    @Test
    @RetryingTest(value = 5)
    void junitPioneerRetryTest() {
        BooleanSupplier booleanSupplier = () -> tools.values.getRandomValueByType(Randomizer.RandomTypeEnum.Boolean);
        Assertions.assertTrue(booleanSupplier);
    }

    @Test
    @RepeatedIfExceptionsTest(repeats = 4)
    @Description("This library has bugs and it is not so cool decision to rerun failed test")
    void rerunnerJupiterTest() {
        BooleanSupplier booleanSupplier = () -> tools.values.getRandomValueByType(Randomizer.RandomTypeEnum.Boolean);
        Assertions.assertTrue(booleanSupplier);
    }
}
