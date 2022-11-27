package com.skypro.calculator;

import com.skypro.calculator.exception.IllegalNumberException;
import com.skypro.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testPlus() {
        int num1 = 3;
        int num2 = 6;
        int result = 9;
        Assertions.assertEquals(result, calculatorService.plus(num1,num2));
    }
    @Test
    public void testMinus() {
        int num1 = 10;
        int num2 = 6;
        int result = 4;
        Assertions.assertEquals(result, calculatorService.minus(num1,num2));
    }
    @Test
    public void testMultiply() {
        int num1 = 7;
        int num2 = 10;
        int result = 70;
        Assertions.assertEquals(result, calculatorService.multiply(num1,num2));
    }
    @Test
    public void testDivide() {
        int num1 = 90;
        int num2 = 9;
        int result = 10;
        Assertions.assertEquals(result, calculatorService.divide(num1,num2));
    }
    @Test
    public void divideByZeroException() {
    Assertions.assertThrows(IllegalNumberException.class,() -> calculatorService.divide(1,0));
    }

    @ParameterizedTest
    @MethodSource ("plusTestSuites")
    public void plusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1,num2));
    }

    public static List<Arguments> plusTestSuites() {
        return List.of(Arguments.of(10,5,15),
        Arguments.of(-5,3,-2),
                Arguments.of(0,0,0));
    }
    @ParameterizedTest
    @MethodSource ("minusTestSuites")
    public void minusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.minus(num1,num2));
    }

    public static List<Arguments> minusTestSuites() {
        return List.of(Arguments.of(10,5,5),
                Arguments.of(-5,3,-8),
                Arguments.of(0,0,0));
    }
    @ParameterizedTest
    @MethodSource ("multiplyTestSuites")
    public void multiplyTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.multiply(num1,num2));
    }

    public static List<Arguments> multiplyTestSuites() {
        return List.of(Arguments.of(10,5,50),
                Arguments.of(-5,3,-15),
                Arguments.of(0,0,0));
    }
    @ParameterizedTest
    @MethodSource ("divideTestSuites")
    public void divideTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.divide(num1,num2));
    }

    public static List<Arguments> divideTestSuites() {
        return List.of(Arguments.of(10,5,2),
                Arguments.of(-5,1,-5),
                Arguments.of(0,2,0));
    }

}
