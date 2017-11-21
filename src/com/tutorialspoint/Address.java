package com.tutorialspoint;

public class Address {
    private String Calle;
    private int CodigoPostal;

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        CodigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Calle='" + Calle + '\'' +
                ", CodigoPostal=" + CodigoPostal +
                '}';
    }
}
