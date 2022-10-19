package mainPackage.config;

import mainPackage.tools.TestInfoUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {

    private final TestInfoUtils testInfoUtils = new TestInfoUtils();
    String description;

    @BeforeEach
    void beforeEachTest(TestInfo testInfo)
    {
        description = testInfoUtils.getCurrentTestMethodDescription(testInfo);
        System.out.println("###### " + testInfo.getDisplayName() + " ######");
        System.out.println("Test Description: " + description + "\n");
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo)
    {
        System.out.println("\n###### " + testInfo.getDisplayName() + " ######\n");
    }
}
