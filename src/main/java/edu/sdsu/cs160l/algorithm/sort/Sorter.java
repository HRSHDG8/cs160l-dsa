package edu.sdsu.cs160l.algorithm.sort;

import java.util.Comparator;

public interface Sorter {

    <T> void sort(T[] collection);

    <T> void sort(T[] collection, Comparator<? super T> comparisonStrategy);
}