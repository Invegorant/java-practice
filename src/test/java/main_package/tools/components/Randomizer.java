package main_package.tools.components;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public enum RandomTypeEnum
    {
        Int,
        Long,
        Double,
        Float,
        Boolean,
        String
    }

    public <T> T getRandomValueByType(RandomTypeEnum typeEnum) {
        Converter converter = new Converter();
        Object result = null;
        switch (typeEnum) {
            case Int:
                result = converter.convertObjToInt.apply(ThreadLocalRandom.current().nextInt());
                break;
            case Long:
                result = converter.convertObjToLong.apply(ThreadLocalRandom.current().nextLong());
                break;
            case Double:
                result = converter.convertObjToDouble.apply(ThreadLocalRandom.current().nextDouble());
                break;
            case Float:
                result = converter.convertObjToFloat.apply(ThreadLocalRandom.current().nextFloat());
                break;
            case Boolean:
                result = converter.convertObjToBoolean.apply(ThreadLocalRandom.current().nextBoolean());
                break;
            case String:
                result = RandomStringUtils.random(5, true, false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typeEnum);
        }
        return (T) result;
    }
}
