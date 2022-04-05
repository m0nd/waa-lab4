package waa.labs.lab4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import waa.labs.lab4.domain.utils.ExceptionTracker;
import waa.labs.lab4.repositories.utils.IExceptionTrackerRepo;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionTrackerAspect {
    IExceptionTrackerRepo exceptionTrackerRepo;

    public ExceptionTrackerAspect(IExceptionTrackerRepo exceptionTrackerRepo) {
        this.exceptionTrackerRepo = exceptionTrackerRepo;
    }

    @Pointcut("within(waa.labs.lab4.controllers.*)")
    public void appMethodsPointcut() {}

    @AfterThrowing(value = "appMethodsPointcut()", throwing = "ex")
    public void saveException(JoinPoint joinPoint, Throwable ex) {
        LocalDate curDate = LocalDate.now();
        LocalTime curTime = LocalTime.now();
        this.saveException(curDate, curTime, ExceptionTracker.PRINCIPLE_NAME,
                joinPoint.getSignature().getName(), ex.getClass().getName());
        System.out.println("Saving an Exception...");
        System.out.printf("Date: %s\nTime: %s\nPrinciple: %s\nOperation: %s\nException Type: %s\n\n",
                curDate, curTime, ExceptionTracker.PRINCIPLE_NAME, joinPoint.getSignature().getName(),
                ex.getClass().getName());
    }

    public void saveException(LocalDate curDate, LocalTime curTime, String principle, String op, String exType) {
        ExceptionTracker exceptionTracker = new ExceptionTracker();
        exceptionTracker.setDate(curDate);
        exceptionTracker.setTime(curTime);
        exceptionTracker.setPrinciple(principle);
        exceptionTracker.setOperation(op);
        exceptionTracker.setExceptionType(exType);

        exceptionTrackerRepo.save(exceptionTracker);
    }
}
