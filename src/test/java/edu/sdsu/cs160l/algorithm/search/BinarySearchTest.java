package edu.sdsu.cs160l.algorithm.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static edu.sdsu.cs160l.TestUtils.printTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    private BinarySearch binarySearch;
    private List<Integer> numbers;

    @BeforeEach
    public void init() {
        binarySearch = new BinarySearch();
        numbers = IntStream
                .range(0, 10000000) //IntStream
                .filter(e -> e % 2 == 0) //IntStream
                .boxed() //Stream<Integer>
                .collect(Collectors.toList()); //List<Integer>
    }

    @Test
    public void search() {
        int index = printTime(()->binarySearch.search(numbers, 1000000));
        assertEquals(500000, index);
        index = printTime(()->binarySearch.search(numbers, 1));
        assertEquals(-1, index);
    }


}