package hello.hellosping.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 시간측정 aop
// 공통로직(각 단계 시간 측정)과 핵심로직(각 단계 로직)을 분리할 수 있다.
@Aspect
@Component
public class TimeTraceAop {

    // aop targeting
    @Around("execution(* hello.hellosping..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: "+joinPoint.toString());
        try {
            return joinPoint.proceed(); // 다음 단계로 넘어감 제어문으로 인터셉트 가능
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("END: "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
