package com.example.springbootdemo.commons.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Around("@annotation(com.example.springbootdemo.annotations.log.Loggable)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String classNameAndMethodName= String.format("%s.%s", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
        log.debug("Iniciando {}, Parametros: {}", classNameAndMethodName, joinPoint.getArgs());
        try {
            Object result = joinPoint.proceed();
            log.debug("Finalizando {}, Respuesta: {}, Tiempo: {} ms.", classNameAndMethodName, result,
                    (System.currentTimeMillis() - startTime));
            return result;
        } catch (Exception e) {
            log.error("Error {}, Excepción: {}, Tiempo: {} ms.", classNameAndMethodName, e.getMessage(),
                    (System.currentTimeMillis() - startTime));
            throw e;
        }
    }
}
