package waa.labs.lab4.aspects;

import net.bytebuddy.implementation.bytecode.Throw;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(waa.labs.lab4.aspects.annotations.ExecutionTime)")
    public void annotationPointcut() {}

    @Around("annotationPointcut()")
    public void calcExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // get time
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        System.out.printf("\n*** %s took %dms to execute ***\n", proceedingJoinPoint.getSignature().getName(), System.currentTimeMillis() - startTime);
    }
}
