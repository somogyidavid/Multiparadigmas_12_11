package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralCalculator {
    private static final Map<Integer, String> ROMAN_NUMERALS;

    static {
        ROMAN_NUMERALS = new HashMap<>();
        ROMAN_NUMERALS.put(1, "I");
        ROMAN_NUMERALS.put(5, "V");
        ROMAN_NUMERALS.put(10, "X");
        ROMAN_NUMERALS.put(50, "L");
        ROMAN_NUMERALS.put(100, "C");
        ROMAN_NUMERALS.put(500, "D");
        ROMAN_NUMERALS.put(1000, "M");
    }

    public String calculate(int number) throws IllegalArgumentException{
        String romanNumber = "";
        if(number > 3999 || number < 1){
            throw new IllegalArgumentException("A szám értéke csak 1-3999 lehet!");
        }

        int thousands = number / 1000;
        int hundreds = number / 100 % 10;
        int tens = number / 10 % 10;
        int ones = number % 10;

        romanNumber += concat(thousands, ROMAN_NUMERALS.get(1000)) +
                concatRomanNumber(hundreds, ROMAN_NUMERALS.get(100), ROMAN_NUMERALS.get(500), ROMAN_NUMERALS.get(1000)) +
                concatRomanNumber(tens, ROMAN_NUMERALS.get(10), ROMAN_NUMERALS.get(50), ROMAN_NUMERALS.get(100)) +
                concatRomanNumber(ones, ROMAN_NUMERALS.get(1), ROMAN_NUMERALS.get(5), ROMAN_NUMERALS.get(10));

        return romanNumber;
    }

    private String concat(int positionalNotationCount, String romanValue){
        String result = "";
        for(int i = 0; i < positionalNotationCount; i++){
            result += romanValue;
        }
        return result;
    }

    private String concatRomanNumber(int positionalNotationCount, String firstRomanValue, String secondRomanValue, String thirdRomanValue){
        switch (positionalNotationCount) {
            case 1:
            case 2:
            case 3: return concat(positionalNotationCount,firstRomanValue);
            case 4: return firstRomanValue + secondRomanValue;
            case 5:
            case 6:
            case 7:
            case 8: return secondRomanValue + concat(positionalNotationCount - 5, firstRomanValue);
            case 9: return firstRomanValue + thirdRomanValue;
            case 0:
            default: return "";
        }
    }
}
