package com.abuklov133.lesson.collections;

public class CarLinkedList implements CarList {

    private Nod first;
    private Nod last;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNod(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            first = new Nod(null, car, null);
            last = first;
        } else {
            Nod secondLast = last;
            last = new Nod(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        checkIndex(index);
        if (index == size) {
            add(car);
            return;
        }
        Nod nodNext = getNod(index);
        Nod nodPrevious = nodNext.previous;
        Nod newNod = new Nod(nodPrevious, car, nodNext);
        nodNext.previous = newNod;
        if (nodPrevious != null) {
            nodPrevious.next = newNod;
        } else {
            first = newNod;
        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        Nod nod = first;
        for (int i = 0; i < size; i++) {
            if (nod.value.equals(car)) {
                return removeAt(i);
            }
            nod = nod.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Nod nod = getNod(index);
        Nod nodPrevious = nod.previous;
        Nod nodNext = nod.next;
        if (nodNext != null) {
            nodNext.previous = nodPrevious;
        } else {
            last = nodPrevious;
        }
        if (nodPrevious != null) {
            nodPrevious.next = nodNext;
        } else {
            first = nodNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Nod getNod(int index) {
        checkIndex(index);
        Nod nod = first;
        for (int i = 0; i < index; i++) {
            nod = nod.next;
        }
        return nod;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Nod {
        private Nod previous;
        private Car value;
        private Nod next;

        public Nod(Nod previous, Car value, Nod next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
