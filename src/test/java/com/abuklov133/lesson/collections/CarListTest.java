package com.abuklov133.lesson.collections;


//import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void contains() {
        Assertions.assertTrue(carList.contains(new Car("Brand20", 20)));
        Assertions.assertFalse(carList.contains(new Car("Brand", 150)));
    }


    @Test
    void whenAdded100ElementsThenSizeMustBe100() {
        Assertions.assertSame(100, carList.size());
    }

    @Test
    void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        Assertions.assertTrue(carList.removeAt(5));
        assertSame(99, carList.size());
    }

    @Test
    void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carList.add(car);
        Assertions.assertSame(101, carList.size());
        assertTrue(carList.remove(car));
        Assertions.assertSame(100, carList.size());

    }

    @Test
    void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        Assertions.assertSame(100, carList.size());
        Assertions.assertFalse(carList.remove(car));
        Assertions.assertSame(100, carList.size());
    }

    @Test
    void whenListClearedThanSizeMustBeNull() {
        carList.clear();
        Assertions.assertSame(0, carList.size());
    }

    @Test
    void whenIndexOutOfBoundsThenThrownException() {
        Car car = new Car("T-34", 110);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                carList.add(car, 102));

    }


    @Test
    void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        Assertions.assertEquals("Brand0", car.getBrand());
    }

    @Test
    void insertIntoMiddle() {
        Car car = new Car("Toyota", 15);
        carList.add(car, 5);
        Car carFromList = carList.get(5);
        Assertions.assertSame(101, carList.size());
        Assertions.assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    void insertIntoFirstPosition() {
        Car car = new Car("Toyota", 15);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        Assertions.assertSame(101, carList.size());
        Assertions.assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    void insertIntoLastPosition() {
        Car car = new Car("Toyota", 15);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        Assertions.assertSame(101, carList.size());
        Assertions.assertEquals("Toyota", carFromList.getBrand());
    }
    @Test
    void testForeach() {
        Assertions.assertSame(100, carList.size());
    }
}
