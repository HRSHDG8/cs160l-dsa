package edu.sdsu.cs160l.datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        // put adds an element takes O(1) time
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // remove takes O(1) time
        map.remove(0);

        //get take O(1) time

        String value = map.get(1); //value is "One"
        String value1 = map.getOrDefault(4, "Not Present"); //value is "Not Present"

        //containsKey - O(1) time

        map.containsKey(2);

        //containsValue - O(n) time
        map.containsValue("Three");
    }
}
