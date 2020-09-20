package kz.zhanbolat.array;

import java.util.Arrays;

public class DynamicDoubleArray<T extends Number> {
    private T[] array;
    private int capacity;

    public DynamicDoubleArray() {
        array = (T[]) new Number[0];
    }

    public DynamicDoubleArray(int capacity) {
        array = (T[]) new Number[capacity];
        this.capacity = capacity;
    }

    public boolean add(T value) {
        if (array.length == 0) {
            array = (T[]) new Number[1];
            array[0] = value;
            return true;
        }
        if (array.length == capacity) {
            return false;
        }
        T[] buffer = Arrays.copyOf(array, array.length);
        array = (T[]) new Number[array.length + 1];
        System.arraycopy(buffer, 0, array, 0, buffer.length);
        array[array.length - 1] = value;
        return true;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be below zero");
        }
        if (index >= array.length) {
            throw new IndexOutOfBoundsException("Cannot get value beyond the capacity rage");
        }
        return array[index];
    }

    public boolean remove(int index) {
        if (index < 0) {
            return false;
        }
        if (index >= array.length) {
            return false;
        }
        if (array.length == 0) {
            return false;
        }
        T[] buffer = Arrays.copyOf(array, array.length);
        array = (T[]) new Number[array.length - 1];
        int shift = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                shift = 1;
            }
            array[i] = buffer[i + shift];
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("DynamicDoubleArray{")
                .append("array=").append(Arrays.toString(array))
                .append("capacity=").append(capacity).toString();
    }

}
