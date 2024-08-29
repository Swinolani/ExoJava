package com.swino.exoaspectlivre.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Pointcut("@annotation(com.swino.exoaspectlivre.annotation.Performance)")
    public void performanceMeasuredMethods() {}

    @Around("performanceMeasuredMethods()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        String methodName = joinPoint.getSignature().getName();
        logger.info("Execution time of method: {} is {} ms", methodName, duration);

        return result;
    }
}