package tests.retry_failed_flaky;

import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import main_package.config.BaseTest;
import main_package.tools.Tools;
import main_package.tools.components.Randomizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

public class RerunnerJupiterTests extends BaseTest {
    private final Tools tools = new Tools();

    @Test
    @RepeatedIfExceptionsTest(repeats = 4)
    @Description("This library has bugs and it is not so cool decision to rerun failed test")
    void rerunnerJupiterTest() {
        BooleanSupplier booleanSupplier = () -> tools.values.getRandomValueByType(Randomizer.RandomTypeEnum.Boolean);
        Assertions.assertTrue(booleanSupplier);
    }
}
