package com.tutorialspoint;

public class HelloWorld2 {
    private String message;

    public void getMessage() {
        System.out.println("Tu mensaje: " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println(this.getClass().getSimpleName() + ": Bean esta llamando init() " );
    }

    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + ": Bean esta llamando destroy() ");
    }}
