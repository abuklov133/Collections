package com.abuklov133.lesson.collections;

public class Car {
    private String brend;
    private int number;

    public Car(String brend, int number) {
        this.brend = brend;
        this.number = number;
    }

    public String getBrand() {
        return brend;
    }

    public int getNumber() {
        return number;
    }
}
