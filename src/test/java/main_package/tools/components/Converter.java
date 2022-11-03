package main_package.tools.components;

import java.util.function.Function;

public class Converter {
    public Function <Object, Integer> convertObjToInt = x -> Integer.parseInt(String.valueOf(x));
    public Function <Object, Long> convertObjToLong = x -> Long.parseLong(String.valueOf(x));
    public Function <Object, Double> convertObjToDouble = x -> Double.parseDouble(String.valueOf(x));
    public Function <Object, Float> convertObjToFloat = x -> Float.parseFloat(String.valueOf(x));
    public Function <Object, Boolean> convertObjToBoolean = x -> Boolean.parseBoolean(String.valueOf(x));
    public Function <Object, String> convertObjToString = String::valueOf;
}
