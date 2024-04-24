package com.springblog.controller.calculate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExecutionTimeAspectTest {

    @Autowired
    private Calculator basicCalculator;

    @Autowired
    private Calculator recurCalculator;

    @Test
    public void test(){
        long factorialAnswer = basicCalculator.factorial(5);
        System.out.printf("factorial 결과 : %d \n", factorialAnswer);
        System.out.printf("실행된 객체 : %s \n", basicCalculator.getClass().getName());

        System.out.println("=======================================");

        long factorialAnswer2 = recurCalculator.factorial(5);
        System.out.printf("factorial 결과 : %d \n", factorialAnswer2);
        System.out.printf("실행된 객체 : %s \n", recurCalculator.getClass().getName());

    }
}
