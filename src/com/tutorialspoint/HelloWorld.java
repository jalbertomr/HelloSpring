package com.tutorialspoint;

public class HelloWorld {
    private String message;

    public String getMessage() {
        return "Tu mensaje: "  + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {

        System.out.println(this.getClass().getSimpleName() + ": Bean esta llamando init() " );
    }

    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + ": Bean esta llamando destroy() ");
    }
}
