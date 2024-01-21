package com.abuklov133.lesson.collections;

public interface CarCollection {

    boolean contains(Car car);
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
}
