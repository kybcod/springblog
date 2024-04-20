package com.springblog.controller.calculate;

public class Main {
    public static void main(String[] args) {

        Calculator proxyCalculator1 = new ExecutionTimeCalculator(new BasicCalculator());
        System.out.println(proxyCalculator1.factorial(20));

        Calculator proxyCalculator2 = new ExecutionTimeCalculator(new RecursiveCalculator());
        System.out.println(proxyCalculator2.factorial(20));
    }
}
