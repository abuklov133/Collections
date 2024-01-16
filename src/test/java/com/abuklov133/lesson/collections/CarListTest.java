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
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }
}
