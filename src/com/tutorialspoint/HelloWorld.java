package com.tutorialspoint;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HelloWorld {
    private String message;

    public String getMessage() {
        return "Tu mensaje: "  + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @PostConstruct
    public void init() {

        System.out.println(this.getClass().getSimpleName() + ": Bean esta llamando init() " );
    }
    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + ": Bean esta llamando destroy() ");
    }
}
