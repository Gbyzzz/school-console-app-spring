package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
public class LoggingAspect {
    @Pointcut("execution(* ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command..*(..))")
    public void controllerPointcut(){}
    @Pointcut("execution(* ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service..*(..))")
    public void servicePointcut(){}
    @Pointcut("execution(* ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao..*(..))")
    public void daoPointcut(){}


    @Before("controllerPointcut()")
    public void beforeEachMethodLoggerAdvice(JoinPoint joinPoint){
        log.info("Starting execution of '" + joinPoint.getSignature().getName() + "' method in '"+ joinPoint.getTarget().getClass().getSimpleName() +"' class" );
    }

    @Around("daoPointcut()")
    public Object beforeEachDaoMethodLoggerAdvice(ProceedingJoinPoint proceedingJoinPoint){
        log.info("executing method '" + proceedingJoinPoint.getSignature().getName() + "' method");

        Object targetResult;

        try {
            targetResult = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.error("Error: " + e);
            throw new RuntimeException(e);
        }

        log.info("Method '" + proceedingJoinPoint.getSignature().getName() +
                "' executed successfully");
        if(targetResult != null) {
            log.info("Method returned: " + targetResult.getClass().getSimpleName());
        }

        return targetResult;
    }

    @AfterThrowing(pointcut = "controllerPointcut()", throwing = "exception")
    public void afterThrowingLoggingAdvice(Throwable exception){
        log.error("Error: " + exception);
    }

}
