package com.example.calctest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class Controller {
    private final CalcService calcService;

    public Controller ( CalcService calcService ) {
        this.calcService = calcService;
    }

    @GetMapping
    public String greet () {
        return calcService.calcGreet();
    }

    @GetMapping("/plus")
    public int plus ( @RequestParam int num1, @RequestParam int num2 ) {
        return calcService.calcPlus(num1, num2);
    }

    @GetMapping("/minus")
    public int minus ( @RequestParam int num1, @RequestParam int num2 ) {
        return calcService.calcMinus(num1, num2);
    }

    @GetMapping("/multiply")
    public double multiply ( @RequestParam int num1, @RequestParam int num2 ) {
        return calcService.calcMultiply(num1, num2);
    }

    @GetMapping("/divide")
    public float divide ( @RequestParam int num1, @RequestParam int num2 ) {
        return calcService.calcDivide(num1, num2);
    }
}