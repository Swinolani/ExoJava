package com.swino.exoproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotificationAspect {

    private static final Logger logger = LoggerFactory.getLogger(NotificationAspect.class);

    @After("execution(* com.swino.exoproject.service.ProjectService.updateTask(..))")
    public void sendTaskUpdateNotification(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String taskId = (String) args[0];
        String newStatus = (String) args[1];
        logger.info("Sending notification: Task {} has been updated to {}", taskId, newStatus);

    }

    @After("execution(* com.swino.exoproject.service.ProjectService.updateProjectStatus(..))")
    public void sendProjectStatusUpdateNotification(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String projectId = (String) args[0];
        String newStatus = (String) args[1];
        logger.info("Sending notification: Project {} status updated to {}", projectId, newStatus);

    }
}