package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralCalculatorTest {
    private RomanNumeralCalculator romanNumeralCalculator;

    @BeforeEach
    void setUp(){
        romanNumeralCalculator = new RomanNumeralCalculator();
    }

    @Test
    void shouldThrowExceptionIfNumberIsHigh(){
        int highNumber = 4400;
        assertThrows(IllegalArgumentException.class, ()-> romanNumeralCalculator.convertNumberToRoman(highNumber));
    }

    @Test
    void shouldThrowExceptionIfNumberIsNegative(){
        int lowNumber = -10;
        Assertions.assertThrows(IllegalArgumentException.class, ()-> romanNumeralCalculator.convertNumberToRoman(lowNumber));
    }

    @Test
    void shouldThrowExceptionIfNumberIsZero(){
        int zeroNumber = 0;
        Assertions.assertThrows(IllegalArgumentException.class, ()-> romanNumeralCalculator.convertNumberToRoman(zeroNumber));
    }

    @Test
    void testNumberBetweenOneAndTen(){
        int number = 6;
        String actual = romanNumeralCalculator.convertNumberToRoman(number);
        String expected = "VI";
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberBetweenTenAndFifty(){
        int number = 43;
        String actual = romanNumeralCalculator.convertNumberToRoman(number);
        String expected = "XLIII";
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberBetweenFiftyAndOneHundred(){
        int number = 78;
        String actual = romanNumeralCalculator.convertNumberToRoman(number);
        String expected = "LXXVIII";
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberBetweenOneHundredAndFiveHundred(){
        int number = 385;
        String actual = romanNumeralCalculator.convertNumberToRoman(number);
        String expected = "CCCLXXXV";
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberBetweenFiveHundredAndOneThousand(){
        int number = 743;
        String actual = romanNumeralCalculator.convertNumberToRoman(number);
        String expected = "DCCXLIII";
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testNumberBetweenOneThousandAndThreeThousandNineHundredNinetyNine(){
        int number = 2785;
        String actual = romanNumeralCalculator.convertNumberToRoman(number);
        String expected = "MMDCCLXXXV";
        Assertions.assertEquals(expected,actual);
    }
}