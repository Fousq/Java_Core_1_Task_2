package kz.zhanbolat.array;

import java.util.Arrays;
import java.util.Objects;

public class DynamicDoubleArray {
    private double[] array;
    private int capacity;

    public DynamicDoubleArray() {
        array = new double[0];
    }

    public DynamicDoubleArray(int capacity) {
        array = new double[0];
        this.capacity = capacity;
    }

    public boolean add(double value) {
        if (array.length == 0) {
            array = new double[1];
            array[0] = value;
        }
        if (array.length == capacity) {
            return false;
        }
        double[] buffer = Arrays.copyOf(array, array.length);
        array = new double[array.length + 1];
        System.arraycopy(buffer, 0, array, 0, buffer.length);
        array[array.length - 1] = value;
        return true;
    }

    public double get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be below zero");
        }
        if (index > array.length) {
            throw new IndexOutOfBoundsException("Cannot get value beyond the capacity rage");
        }
        return array[index];
    }

    public boolean remove(int index) {
        if (index < 0) {
            return false;
        }
        if (index > array.length) {
            return false;
        }
        double[] buffer = Arrays.copyOf(array, array.length);
        array = new double[array.length - 1];
        for (int i = 0; i < buffer.length; i++) {
            if (i == index) {
                continue;
            }
            array[i] = buffer[i];
        }
        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DynamicDoubleArray{")
                .append("array=").append(array)
                .append("capacity=").append(capacity);
        return builder.toString();
    }

}
