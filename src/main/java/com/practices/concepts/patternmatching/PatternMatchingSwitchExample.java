package com.practices.concepts.patternmatching;

public class PatternMatchingSwitchExample {

    public static void main(String[] args) {
        Object obj = "12345";

        double value1 = oldImplementation(obj);
        double value2 = newImplementation(obj);

        System.out.println(value1 +", "+ value2);
    }

    private static double newImplementation(Object obj) {
        return switch (obj) {
            case Integer num -> num.doubleValue();
            case Float num -> num.doubleValue();
            case Long num -> num.doubleValue();
            case Double num -> num.doubleValue();
            // Guarded check where case statement can be written with conditional expressions
//            case String (num && num.length() > 0) -> Double.valueOf(num);
            case null -> -1d;
            default -> 0d;
        };
    }

    private static double oldImplementation(Object obj) {
        double result;
        if (obj instanceof Integer) {
            result = ((Integer) obj).doubleValue();
        } else if (obj instanceof Float) {
            result = ((Float) obj).doubleValue();
        } else if (obj instanceof String) {
            if (((String) obj).length() > 0)
                result = Double.parseDouble(((String) obj));
            else result = 0d;
        } else if (obj == null) {
            result = -1d;
        } else result = 0d;
        return result;
    }
}
