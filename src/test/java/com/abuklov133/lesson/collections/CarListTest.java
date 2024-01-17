package com.abuklov133.lesson.collections;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }


    @Test
    void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Toyta", 15);
        carList.add(car);
        Assertions.assertThat(101).isEqualTo(carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());

    }

    @Test
    void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyta", 15);
        Assertions.assertThat(100).isEqualTo(carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    void whenListClearedThanSizeMustBeNull() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    /*    @Test
     *  void whenIndexOutOfBoundsThenThrownException() {
     * }
     */

    @Test
    void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    void insertIntoMiddle() {
        Car car = new Car("Toyota", 15);
        carList.add(car, 5);
        Car carFromList = carList.get(5);
        assertEquals(101, carList.size());
        assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    void insertIntoFirstPosition() {
        Car car = new Car("Toyota", 15);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals(101, carList.size());
        assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    void insertIntoLastPosition() {
        Car car = new Car("Toyota", 15);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals(101, carList.size());
        assertEquals("Toyota", carFromList.getBrand());
    }
}
