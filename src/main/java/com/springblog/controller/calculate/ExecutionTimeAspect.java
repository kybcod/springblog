package com.springblog.controller.calculate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ExecutionTimeAspect {

    @Pointcut("execution(* fact*(..))")
    private void publicTarget(){}

    // 메서드 실행 전, 후 또는 익셉션 발생시점(Advice 정의)
    // 따라서 타깃 호출 전, 후에 실행 시간 측정
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed(); // 타킷 호출
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            Signature signature = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행시간 : %d \n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    signature.getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    (finish-start));
        }
    }
}
