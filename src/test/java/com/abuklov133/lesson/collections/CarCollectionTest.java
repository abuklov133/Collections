package com.abuklov133.lesson.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {
    private CarCollection carCollection;

    @BeforeEach
    void setUp() {
        carCollection = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void contains() {
        Assertions.assertSame(100, carCollection.size());
        Car carFromCollection = new Car("Brand10", 10);
        Assertions.assertTrue(carCollection.contains(carFromCollection));
    }
}