package com.tutorialspoint;

public class HelloWorld {
    private String message;

    public void getMessage() {
        System.out.println("Tu mensaje: "  + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("Bean esta llamando init()");
    }

    public void destroy() {
        System.out.println("Bean esta llamando destroy()");
    }
}
