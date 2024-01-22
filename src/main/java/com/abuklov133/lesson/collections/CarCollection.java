package com.abuklov133.lesson.collections;

public interface CarCollection extends Iterable<Car> {

    boolean contains(Car car);

    boolean add(Car car);

    boolean remove(Car car);

    int size();

    void clear();
}
