package com.tutorialspoint;

import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {
    /*
        Definicion de un pointcut para seleccionar todos los metodos disponibles.
        de tal forma que el Advice sera llamado para todos los metodos
     */
    @Pointcut("execution(* com.tutorialspoint.*.*(..))")
    private void selectAll(){}

    //Ejecutado antes del la ejecucion del metodo seleccionado
    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Logging>aop:beforeAdvice.");
    }

    //Ejecutado despues del la ejecucion del metodo seleccionado
    @After("selectAll()")
    public void afterAdvice(){
        System.out.println("Logging>aop:afterAdvice.");
    }

    //Ejecutado cuando cualquier metodo regresa
    @AfterReturning( pointcut="selectAll()", returning="retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("Logging>aop:afterReturning. Returning: " + retVal.toString());
    }

    //Ejecutado cuando una Exceptions en lanzada
    @AfterThrowing( pointcut = "selectAll()", throwing="ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("Logging>aop:afterThrowing. Ha habido una exception: " + ex.toString());
    }
}
