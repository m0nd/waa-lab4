package waa.labs.lab4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionTrackerAspect {
    static int fakeId = 1;

    @Pointcut("within(waa.labs.lab4.controllers.*)")
    public void appMethodsPointcut() {}

    @AfterThrowing(value = "appMethodsPointcut()", throwing = "ex")
    public void saveException(JoinPoint joinPoint, Throwable ex) {
        // TODO: Save to the Exceptions table in the DB
        System.out.println("Saving Exception...");
        System.out.printf("Transaction ID: %d\nDate: %s\nTime: %s\nPrinciple: rbroome\nOperation: %s\nException Type: %s\n\n",
                fakeId++, LocalDate.now(), LocalTime.now(), joinPoint.getSignature().getName(), ex.getClass().getName());
    }
}
