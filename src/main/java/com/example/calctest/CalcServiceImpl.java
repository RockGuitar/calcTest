package com.example.calctest;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    public String calcGreet () {
        return "Привет, калькулятор!";
    }

    public int calcPlus ( int num1, int num2 ) {
        int sum = num1 + num2;
        return sum;
    }

    public int calcMinus ( int num1, int num2 ) {
        int diff = num1 - num2;
        return diff;
    }

    public double calcMultiply ( int num1, int num2 ) {
        double multiply = num1 * num2;
        return multiply;
    }

    public float calcDivide ( int num1, int num2 ) {
        float division = num1 / num2;
        return division;
    }
}
