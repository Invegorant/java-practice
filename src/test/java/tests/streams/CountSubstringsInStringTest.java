package tests.streams;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import main_package.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSubstringsInStringTest extends BaseTest {

    //задача создать метод которые будет принимать 2 строки, и считать вхождение второй в первую

    @Test
    void countStringTest() {
        int count = counterStringInString("aaewrsdfrewrte;lewrkjasdfewr", "ewr");
        System.out.println(count);
        Assertions.assertTrue(count == 4);
    }

    @Step
    int counterStringInString (String first, String second) {
        int countEqual =0;
        if (first != null) {
            if (second != null && second != "") {
                if (first.contains(second)) {
                    int firstLength = first.length();
                    int secondLength = second.length();
                    for (int i = 0; i < (firstLength - secondLength + 1); i++) {
                        String temprory = first.substring(i, i + secondLength);
                        if (temprory.contains(second)) {
                            countEqual ++;
                        }
                    }
                } else {
                    return 0;
                }
            }

        }
        return countEqual;
    }
}



