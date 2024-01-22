package com.abuklov133.lesson.collections;

import java.util.Iterator;

public class CarLinkedList implements CarList {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNod(index).value;
    }


    @Override
    public boolean add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        checkIndex(index);
        if (index == size) {
            return add(car);
        }
        Node nodNext = getNod(index);
        Node nodPrevious = nodNext.previous;
        Node newNode = new Node(nodPrevious, car, nodNext);
        nodNext.previous = newNode;
        if (nodPrevious != null) {
            nodPrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        int index = findIndex(car);
        if (index != -1) {
            return removeAt(index);
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNod(index);
        Node nodPrevious = node.previous;
        Node nodNext = node.next;
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
    public boolean contains(Car car) {
    return findIndex(car) != -1;
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

    private Node getNod(int index) {
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private int findIndex(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            private Node node = first;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
