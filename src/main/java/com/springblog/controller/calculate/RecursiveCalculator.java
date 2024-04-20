package com.springblog.controller.calculate;

public class RecursiveCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        if(num == 0){
            return 1;
        }
        return num * factorial(num -1);
    }
}

