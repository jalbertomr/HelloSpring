package com.tutorialspoint;

public class HelloWorld {
    private String message;
    private String message2;

    public String getMessage() {
        return "World mensaje: "  + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage2() {
        return "World mensaje2: " + message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
}
