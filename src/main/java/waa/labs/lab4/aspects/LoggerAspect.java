package waa.labs.lab4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    static int fakeId = 1;

    @Pointcut("execution(* waa.labs.lab4.controllers.*.*(..))")
    public void operationsPointCut() {}

    @After("operationsPointCut()")
    public void logOperation(JoinPoint joinPoint) {
        // loggerService.save(LocalDate.now(), LocalTime.now(), "rbroome", joinPoint.getSignature().getName())
        System.out.println("Performing Logging...");
        System.out.printf("Transaction ID: %d\nDate: %s\nTime: %s\nPrinciple: raymond\nOperation: %s\n\n",
                fakeId++, LocalDate.now(), LocalTime.now(), joinPoint.getSignature().getName());
    }
}
