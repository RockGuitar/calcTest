package com.example.calctest.service;

import com.example.calctest.CalcServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalcServiceTest {
    public final CalcServiceImpl calculator = new CalcServiceImpl();
    public int numPositive1 = 5;
    public int numPositive2 = 4;
    public int numNegative1 = -10;
    public int numNegative2 = -9;
    public int numNull = 0;

    @Test
    public void calcGreetTest () {
        String actualResult = calculator.calcGreet();
        String expectedResult = "Привет, калькулятор!";
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void calcPlusTest () {
        int actualResult = calculator.calcPlus(numPositive1, numPositive2);
        int expectedResult = 9;
        assertEquals(expectedResult, actualResult);
        actualResult = calculator.calcPlus(numNegative1, numNegative2);
        expectedResult = -19;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcMinusTest () {
        int actualResult = calculator.calcMinus(numPositive1, numPositive2);
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
        actualResult = calculator.calcMinus(numNegative1, numNegative2);
        expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcMultiplyTest () {
        double actualResult = calculator.calcMultiply(numPositive1, numPositive2);
        double expectedResult = 20;
        assertEquals(expectedResult, actualResult);
        actualResult = calculator.calcMultiply(numNegative1, numNegative2);
        expectedResult = 90;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcDivisionTest () {
        float actualResult = calculator.calcDivide(numPositive1, numPositive2);
        float expectedResult = 1;
        assertEquals(expectedResult, actualResult);
        actualResult = calculator.calcDivide(numNegative1, numNegative2);
        expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcDivisionByNullError () {
        assertThrows(IllegalArgumentException.class, () -> calculator.calcDivide(numNegative1, numNull));
        assertThrows(IllegalArgumentException.class, () -> calculator.calcDivide(numPositive1, numNull));
    }
}
