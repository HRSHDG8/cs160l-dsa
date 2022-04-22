package edu.sdsu.cs160l.algorithm.search;

import java.util.List;

/**
 * An interface to create common abstraction for searching
 */
public interface Search {
    <T> int search(List<T> list, T t);
}
