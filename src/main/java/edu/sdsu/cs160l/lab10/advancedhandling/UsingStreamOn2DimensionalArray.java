package edu.sdsu.cs160l.lab10.advancedhandling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsingStreamOn2DimensionalArray {
  private List<List<Integer>> numbers;

  public UsingStreamOn2DimensionalArray() {
    this.numbers = new ArrayList<>();
    List<Integer> row1 = new ArrayList<>(Arrays.asList(1, 6, 8, 5));
    List<Integer> row2 = new ArrayList<>(Arrays.asList(10, 2, 7, 11));
    List<Integer> row3 = new ArrayList<>(Arrays.asList(15, 4, 3, 14));
    List<Integer> row4 = new ArrayList<>(Arrays.asList(13, 12, 9, 16));
    numbers.add(row1);
    numbers.add(row2);
    numbers.add(row3);
    numbers.add(row4);
  }

  public List<Integer> flatten2DArrayTo1DArray() {
    return numbers
       .stream()
       .flatMap(list -> list.stream())
       .collect(Collectors.toList());
  }


  public List<Integer> sumOfEachRow() {
    return numbers
       .stream()
       .map(list -> list // since each row is a list or a collection you can invoke stream api on each row
          .stream()
          .mapToInt(value -> value.intValue()) // mapToInt changes Stream<Integer> to IntStream which has built in methods like sum
          .sum())
       .collect(Collectors.toList());
  }

  public List<Integer> maxInEachRow() {
    return numbers
       .stream()
       .map(list -> list // since each row is a list or a collection you can invoke stream api on each row
          .stream()
          .mapToInt(value -> value.intValue()) // mapToInt changes Stream<Integer> to IntStream which has built in methods like max
          .max()
          .orElse(0))
       .collect(Collectors.toList());
  }

  public List<Double> averageOfEachRow() {
    return numbers
       .stream()
       .map(list -> list // since each row is a list or a collection you can invoke stream api on each row
          .stream()
          .mapToInt(value -> value.intValue()) // mapToInt changes Stream<Integer> to IntStream which has built in methods like max
          .average()
          .orElse(0))
       .collect(Collectors.toList());
  }

  public List<Integer> firstSingleDigitInRow() {
    return numbers
       .stream()
       .map(list -> list // since each row is a list or a collection you can invoke stream api on each row
          .stream()
          .filter(e -> e < 10)
          .findFirst()
          .orElse(0))
       .collect(Collectors.toList());
  }

  public boolean rowWithMultipleOf5() {
    return numbers
       .stream()
       .anyMatch(integers -> integers // returns true if any one element passing the condition is found;
          .stream()
          .anyMatch(integer -> integer % 5 == 0));
  }

}
