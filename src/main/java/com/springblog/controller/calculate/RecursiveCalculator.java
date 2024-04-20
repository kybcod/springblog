package com.springblog.controller.calculate;

import org.springframework.stereotype.Component;

@Component
public class RecursiveCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        if(num == 0){
            return 1;
        }
        return num * factorial(num -1);
    }
}

