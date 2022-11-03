package tests.functional_interfaces.suppliers;

import io.qameta.allure.Description;
import main_package.config.BaseTest;
import main_package.tools.Tools;
import main_package.tools.components.Randomizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.*;

public class SupplierTests extends BaseTest {

    private final Tools tools = new Tools();

    @Test
    @Description("simple supplier test with math random")
    void simpleSupplierTest() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println(doubleSupplier.get());
    }

    @Test
    @Description("doubleSupplier test")
    void doubleSupplierTest() {
        DoubleSupplier doubleSupplier = () -> tools.values.getRandomValueByType(Randomizer.RandomTypeEnum.Double);
        System.out.println(doubleSupplier.getAsDouble());
    }

    @Test
    @Description("IntSupplier test")
    void intSupplierTest() {
        IntSupplier intSupplier = () -> tools.values.getRandomValueByType(Randomizer.RandomTypeEnum.Int);
        System.out.println(intSupplier.getAsInt());
    }

    @Test
    @Description("LongSupplier test")
    void longSupplierTest() {
        LongSupplier longSupplier = () ->  tools.values.getRandomValueByType(Randomizer.RandomTypeEnum.Long);
        System.out.println(longSupplier.getAsLong());
    }

    @Test
    @Description("BooleanSupplier test")
    void booleanSupplierTest() {
        BooleanSupplier booleanSupplier = () -> tools.values.getRandomValueByType(Randomizer.RandomTypeEnum.Boolean);
        System.out.println(booleanSupplier.getAsBoolean());
    }

    @Test
    @Description("Supplier to uppercase test")
    void supplierToUpperCaseTest () {
        String expectedString = "ONE";
        String t = "One";
        Supplier<String> supplierString = () -> t.toUpperCase();
        String bigT = supplierString.get();
        System.out.println(supplierString.get());
        Assertions.assertFalse(t.contentEquals(expectedString));
        Assertions.assertTrue(bigT.contentEquals(expectedString));
    }

}
