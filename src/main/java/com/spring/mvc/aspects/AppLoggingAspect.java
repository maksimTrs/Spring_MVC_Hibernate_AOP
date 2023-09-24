package com.spring.mvc.aspects;

import com.spring.mvc.entities.Employee;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.stream.Stream;


@Component
@Aspect
public class AppLoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(Employee.class);


    @Around("execution(* com.spring.mvc.dao.*.*(..) )")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        LOGGER.info("<<<<< " + methodName + " was started!" + " >>>>>");

        Object targetMethodResult = proceedingJoinPoint.proceed();

        LOGGER.info("<<<<< " + methodName + " was finished!" + " >>>>>");

        return targetMethodResult;
    }
}
