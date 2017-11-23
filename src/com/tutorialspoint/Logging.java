package com.tutorialspoint;

public class Logging {
    //Ejecutado antes del la ejecucion del metodo seleccionado
    public void beforeAdvice(){
        System.out.println("Logging>aop:beforeAdvice.");
    }

    //Ejecutado despues del la ejecucion del metodo seleccionado
    public void afterAdvice(){
        System.out.println("Logging>aop:afterAdvice.");
    }

    //Ejecutado cuando cualquier metodo regresa
    public void afterReturningAdvice(Object retVal){
        System.out.println("Logging>aop:afterReturning. Returning: " + retVal.toString());
    }

    //Ejecutado cuando una Exceptions en lanzada
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("Logging>aop:afterThrowing. Ha habido una exception: " + ex.toString());
    }
}
