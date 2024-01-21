package com.abuklov133.lesson.collections;

import java.util.Arrays;

public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index, array, index - 1, size - index);
        /*for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

         */
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    // @Override
    public boolean add(Car car, int index) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
        return true;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    public boolean contains(Car car) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(car)) {
                return true;
            }
        }
        return false;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public static void main(String[] args) {
        CarArrayList carArrayList = new CarArrayList();
        for (int i = 0; i < carArrayList.array.length; i++) {
            carArrayList.add(new Car("Brand" + i, i));
        }

        carArrayList.add(new Car("T", 10), 10);

        for (Car car : carArrayList.array) {
            System.out.println(car);
        }
    }
}
