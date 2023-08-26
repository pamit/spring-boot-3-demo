package com.pamit.springbootdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GlobalLogger {

    @Before("execution(public void save(..))")
    public void infoAdviceBefore(JoinPoint joinPoint) {
        System.out.println("\n[GlobalLogger] >>>>>>>> infoAdviceBefore... " + joinPoint.getSignature().getName() + "()" +
                " | args: " + Arrays.stream(joinPoint.getArgs()).toList());
    }

    @AfterReturning("execution(public void save(..))")
    public void infoAdviceAfter(JoinPoint joinPoint) {
        System.out.println("\n[GlobalLogger] >>>>>>>> infoAdviceAfter... " + joinPoint.getSignature().getName() + "()" +
                " | args: " + Arrays.stream(joinPoint.getArgs()).toList());
    }

    @AfterReturning("execution(public void com.pamit.springbootdemo.dao.StudentDAO.save(..))")
    public void infoStudentDAOAdviceAfter(JoinPoint joinPoint) {
        System.out.println("\n[GlobalLogger] >>>>>>>> infoStudentDAOAdviceAfter... " + joinPoint.getSignature().getName() + "()" +
                " | args: " + Arrays.stream(joinPoint.getArgs()).toList());
    }

    @Before("execution(* add*(com.pamit.springbootdemo.entity.Student, ..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n[GlobalLogger] >>>>>>>> Executing @Before advice on any add*() method with any return type\n");
    }

    //////////////////////////////////
    // Reusing expressions as PointCut

    @Pointcut("execution(* com.pamit.springbootdemo.dao.*.*(..))")
    private void forDAOPackage() {}

    @After("forDAOPackage()")
    @Order(2)
    public void afterAnyMethodInPackageAdvice(JoinPoint joinPoint) {
        System.out.println("\n[GlobalLogger] >>>>>>>> Executing forDAOPackage advice on com.pamit.springbootdemo.dao." +
                joinPoint.getSignature().getName() + "()");
    }

    @After("forDAOPackage()")
    @Order(1)
    public void afterAnyMethodInPackageAdvice2(JoinPoint joinPoint) {
        System.out.println("\n[GlobalLogger] >>>>>>>> Executing forDAOPackage advice2 on com.pamit.springbootdemo.dao." +
                joinPoint.getSignature().getName() + "()");
    }
}
