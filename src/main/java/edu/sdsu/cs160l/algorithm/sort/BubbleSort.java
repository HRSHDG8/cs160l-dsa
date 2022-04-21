package edu.sdsu.cs160l.algorithm.sort;

import java.util.Comparator;

public class BubbleSort implements Sorter {
    @Override
    @SuppressWarnings("unchecked")
    public <T> void sort(T[] c) {
        Comparable[] comparable = (Comparable[]) c;
        sort(comparable, Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] c, Comparator<? super T> comparisonStrategy) {
        for (int i = 0; i < c.length ; i++) {
            for (int j = 0; j < c.length ; j++) {
                if (comparisonStrategy.compare(c[j], c[i]) > 0) {
                    swap(c, i, j);
                }
            }
        }
    }

    private <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
