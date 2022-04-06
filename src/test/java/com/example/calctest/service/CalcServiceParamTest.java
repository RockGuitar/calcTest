package com.example.calctest.service;


import com.example.calctest.CalcServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalcServiceParamTest {
    public final CalcServiceImpl calculator = new CalcServiceImpl();

    public static Stream<Arguments> provideParamsForSum () {
        return Stream.of(
                Arguments.of(4, 5, 9),
                Arguments.of(-9, -10, -19)
        );
    }

    public static Stream<Arguments> provideParamsForMinus () {
        return Stream.of(
                Arguments.of(4, 5, -1),
                Arguments.of(-9, -10, 1)
        );
    }

    public static Stream<Arguments> provideParamsForMultiply () {
        return Stream.of(
                Arguments.of(4, 5, 20),
                Arguments.of(-9, -10, 90)
        );
    }

    public static Stream<Arguments> provideParamsForDivision () {
        return Stream.of(
                Arguments.of(4, 5, 0),
                Arguments.of(-20, -10, 2),
                Arguments.of(5, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSum")
    public void calcPlusTest ( int num1, int num2, int expected ) {
        int result = calculator.calcPlus(num1, num2);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinus")
    public void calcMinusTest ( int num1, int num2, int expected ) {
        int result = calculator.calcMinus(num1, num2);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiply")
    public void calcMultiplyTest ( int num1, int num2, double expected ) {
        double result = calculator.calcMultiply(num1, num2);
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivision")
    public void calcDivideTest ( int num1, int num2, float expected ) {
        if (num2 == 0) {
            assertThrows(IllegalArgumentException.class, () -> calculator.calcDivide(num1, num2));
        } else {
            float result = calculator.calcDivide(num1, num2);
            assertEquals(result, expected);
        }
    }
}
