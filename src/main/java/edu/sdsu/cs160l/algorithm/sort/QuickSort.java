package edu.sdsu.cs160l.algorithm.sort;

import java.util.Comparator;

/**
 * In class explanation + demonstration
 * encompasses use of generics and quick-sort algorithm
 */
public class QuickSort implements Sorter {
    @Override
    @SuppressWarnings("unchecked")
    public <T> void sort(T[] c) {
        Comparable[] comparable = (Comparable[]) c;
        sort(comparable, Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] collection, Comparator<? super T> comparisonStrategy) {
        quickSort(collection, 0, collection.length - 1, comparisonStrategy);
    }


    private <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private <T> int partition(T[] arr, int low, int high, Comparator<T> comparisonStrategy) {
        T pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // arr[j] < pivot (if you are sorting integer array, below is generic implementation)
            if (comparisonStrategy.compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private <T> void quickSort(T[] arr, int low, int high, Comparator<T> comparisonStrategy) {
        if (low < high) {
            int pi = partition(arr, low, high, comparisonStrategy);
            quickSort(arr, low, pi - 1, comparisonStrategy);
            quickSort(arr, pi + 1, high, comparisonStrategy);
        }
    }
}
