package edu.sdsu.cs160l;

import java.util.function.Function;
import java.util.function.Supplier;

public class TestUtils {

    public static <T> T printTime(Supplier<T> fn){
        long startTime = System.nanoTime();
        T o = fn.get();
        long timeEnd = System.nanoTime();
        System.out.println("Time to execute :: "+ (timeEnd-startTime)/1000+ " milliseconds");
        return o;
    }
}
