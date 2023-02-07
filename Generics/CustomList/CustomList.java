package Generics.CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {

    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);

        E firstElement = this.data.get(firstIndex);
        E secondElement = this.data.get(secondIndex);
        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int countGreaterThan(E element) {
        int count = 0;
        for (E el : this.data) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public E getMax() {
        checkEmpty();
        E max = this.data.get(0);
        for (E el : this.data) {
            if (el.compareTo(max) > 0) {
                max = el;
            }
        }
        return max;
    }

    public E getMin() {
        checkEmpty();
        E min = this.data.get(0);
        for (E el : this.data) {
            if (el.compareTo(min) < 0) {
                min = el;
            }
        }
        return min;
    }

    public int size() {
        return this.data.size();
    }
    public E get(int index) {
        checkIndex(index);
        return this.data.get(index);
    }

        private void checkIndex(int index) {
            if (index < 0 || index >= this.data.size()) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }

        private void checkEmpty() {
            if (this.data.isEmpty()) {
                throw new IllegalStateException("List is empty");
            }
        }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public E next() {
                return data.get(index++);
            }
        };
    }
}

