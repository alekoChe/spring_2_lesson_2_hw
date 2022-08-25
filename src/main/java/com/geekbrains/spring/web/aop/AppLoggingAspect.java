package com.geekbrains.spring.web.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {

    @AfterReturning("execution(public * com.geekbrains.spring.web.services.UserService.loadUserByUsername(..))")
    public void catchClientLogIn(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("Клиент " + args[0] + " залогинился");
        }
    }


//    @AfterReturning("execution(public * com.geekbrains.spring.web.controllers.AuthController.*(..))")
//    public void beforeAnyMethodInUserDAOClassWithDetails_2(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("В AuthController был вызван метод: " + methodSignature);
//        Object[] args = joinPoint.getArgs();
//        if (args.length > 0) {
//            System.out.println("Аргументы:");
//            for (Object o : args) {
//                System.out.println(o);
//            }
//        }
//    }

//    @AfterReturning("execution(public * com.geekbrains.spring.web.controllers.AuthController.createAuthToken(..))")
//    public void beforeAnyMethodInUserDAOClassWithDetails_3(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();;
//
//        if (args.length > 0) {
//            System.out.println("Клиент " + args[0] + " залогинился");
//        }
//    }

}
