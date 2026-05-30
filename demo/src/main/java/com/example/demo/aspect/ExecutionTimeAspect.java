package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Aspect
@Component
public class ExecutionTimeAspect {


    @Around("@annotation(com.example.demo.annotation.LogExecutionTime)")
    public Object printLogExecutionTime(ProceedingJoinPoint jpoint) throws Throwable {
        //before
        ZonedDateTime start = ZonedDateTime.now(ZoneId.systemDefault());
        //System.out.println("start logging");

        Object res = jpoint.proceed();
        //System.out.println("proceed method");
        //after
        ZonedDateTime end = ZonedDateTime.now(ZoneId.systemDefault());
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Logged Method: " + jpoint.getSignature() + "---" + "Start time: " + start + "---" + "End time: " + end + "---" + "Duration time: " + duration + " ms");

        return res;
    }
}
