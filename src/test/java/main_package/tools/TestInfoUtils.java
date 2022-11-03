package main_package.tools;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.TestInfo;

public class TestInfoUtils {

    @Step
    public String getCurrentTestMethodDescription(TestInfo testInfo)
    {
        if (testInfo.getTestMethod().get().isAnnotationPresent(Description.class))
        {
            return testInfo.getTestMethod().get().getAnnotation(Description.class).value();
        }
        return "No Test Description";
    }
}
