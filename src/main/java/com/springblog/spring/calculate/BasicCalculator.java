package com.springblog.spring.calculate;

import org.springframework.stereotype.Component;

@Component
public class BasicCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        long result = 1;

        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
