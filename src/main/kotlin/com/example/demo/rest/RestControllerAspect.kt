package com.example.demo.rest

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component


@Aspect
@Component
class RestControllerAspect {

    @Before("execution(public * com.example.demo.rest.**.*Controller.*(..))")
    fun logBeforeRestCall(pjp: JoinPoint) {
        println("***************** :::::AOP Before REST call:::::" + pjp);
    }

    @After("execution(public * com.example.demo.rest.**.*Controller.*(..))")
    fun logAfterRestCall(pjp: JoinPoint) {
        println("***************** :::::AOP After REST call:::::" + pjp);
    }

    @Around("execution(public * com.example.demo.rest.**.*Controller.*(..))")
    fun logAroundRestCall(pjp: ProceedingJoinPoint) {
        println("***************** :::::AOP Around REST call:::::" + pjp);
        pjp.proceed();
    }

    @AfterThrowing("execution(public * com.example.demo.rest.**.*Controller.*(..))", throwing = "t")
    fun logAfterThrowing(t: Throwable) {
        println("***************** :::::AOP After Throwing exception REST call:::::");
    }
}