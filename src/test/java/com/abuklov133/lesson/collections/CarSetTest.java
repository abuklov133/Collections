package com.abuklov133.lesson.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarSet carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("BMW" + i, i));
        }

    }

    @Test
    void WhenAddTheSameElementTheSizeDoesNotIncrease() {
        Assertions.assertSame(100, carSet.size());
        Assertions.assertFalse(carSet.add(new Car("BMW1", 1)));
        Assertions.assertSame(100, carSet.size());
    }

    @Test
    public void whenAdd2SimilarObjectsThenSizeIncreaseBy1() {
        Assertions.assertEquals(100, carSet.size());
        Assertions.assertTrue(carSet.add(new Car("BMW", 10)));
        Assertions.assertFalse(carSet.add(new Car("BMW", 10)));
        Assertions.assertEquals(101, carSet.size());
    }


    @Test
    void whenDeleteElementThenSizeWillDecrease() {
        Assertions.assertSame(100, carSet.size());
        Assertions.assertTrue(carSet.remove(new Car("BMW10", 10)));
        Assertions.assertSame(99, carSet.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecreased() {
        Assertions.assertTrue(carSet.remove(new Car("BMW30", 30)));
        Assertions.assertSame(99, carSet.size());
        Assertions.assertFalse(carSet.remove(new Car("BMW30", 30)));
        Assertions.assertSame(99, carSet.size());
    }

        @Test
        void whenDeleteNonExistentElementThenSizeWillNotDecrease() {
            Car car = new Car("Toyota", 1);
            Assertions.assertFalse(carSet.remove(car));
            Assertions.assertSame(100, carSet.size());
        }

        @Test
        void whenAddUniqueElementThenSizeIncreases () {
            Car car = new Car("Toyota", 1);
            carSet.add(car);
            Assertions.assertSame(101, carSet.size());

        }

        @Test
        void whenSetClearedThenSizeMustBe0 () {
            carSet.clear();
            Assertions.assertSame(0, carSet.size());
        }
    }