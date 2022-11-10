package main_package.config;

import main_package.tools.TestInfoUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class BaseTest {

    private final TestInfoUtils testInfoUtils = new TestInfoUtils();
    String description;

    @BeforeEach
    void beforeEachTest(TestInfo testInfo)
    {
        description = testInfoUtils.getCurrentTestMethodDescription(testInfo);
        System.out.println("\n###############################################################");
        System.out.println("Test Name: " + testInfo.getDisplayName());
        System.out.println("Test Description: " + description + "\n");
    }

    @AfterEach
    void afterEachTest()
    {
        System.out.println("\n###############################################################");
    }

}
