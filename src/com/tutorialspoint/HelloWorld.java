package com.tutorialspoint;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {
    private String message;

    public void getMessage() {
        System.out.println("Tu mensaje: "  + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @PostConstruct
    public void init() {
        System.out.println("Bean esta llamando init()");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Bean esta llamando destroy()");
    }
}
