package cs400.Stream;

import java.io.File;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<Integer> intStream = Stream.iterate(1, i -> i + 2);
        intStream
                .takeWhile(i -> i < 10)
                .map(i -> i + 1).forEach(i -> System.out.print(i));
        // .reduce( (x,y) -> x+y ).get()
    }
}
