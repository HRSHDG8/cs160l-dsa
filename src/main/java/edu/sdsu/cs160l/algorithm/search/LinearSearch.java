package edu.sdsu.cs160l.algorithm.search;

import java.util.List;

public class LinearSearch implements Search {
    @Override
    public <T> int search(List<T> list, T t) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(t)) {
                return i;
            }
        }
        return -1;
    }
}
