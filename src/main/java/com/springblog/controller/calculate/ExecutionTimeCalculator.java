package com.springblog.controller.calculate;

public class ExecutionTimeCalculator implements Calculator{

    // 구현체의 의존성을 주입받을 필드
    private final Calculator delegate;

    // 외부에서 구현체의 의존성을 주입
    public ExecutionTimeCalculator(Calculator calculator) {
        this.delegate = calculator;
    }

    @Override
    public long factorial(final long num) {
        // 실행 시간 측정
        long start = System.currentTimeMillis();

        // 외부에서 주입받은 객체에게 위임
        long result = delegate.factorial(num);

        // 실행 시간 측정
        long end = System.currentTimeMillis();
        System.out.printf("%s의 factorial(%d) Execution Time > %d\n",
                delegate.getClass().getSimpleName(),
                num,
                (end - start));
        return result;
    }
}
