package javaPracticing.스트림사용시주의점;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream사용시주의할점 {
}

class 재사용스트림문제 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 2);
        intStream.forEach(System.out::println);

        // stream has already been operated upon or closed
        intStream.forEach(System.out::println);
    }
}

class 닫힌범위 {
    public static void main(String[] args) {
        IntStream.range(1, 2).forEach(System.out::println); // 1

        IntStream.rangeClosed(1, 2).forEach(System.out::println); // 1 2
    }
}

class 연산횟수제한 {
    public static void main(String[] args) {
        IntStream.range(1, 5).limit(3).forEach(System.out::println);

        IntStream intStream = new Random().ints(3, 7).limit(5);
        intStream.forEach(System.out::println);

        intStream = new Random().ints(5, 3, 7);
        intStream.forEach(System.out::println);
    }
}

class 직접원하는값넣기 {
    public static void main(String[] args) {
        Stream.of(1, 3, 4, 5).forEach(System.out::println);

        Stream stream = Stream.builder().add(1).add(2).add(3).build();

        stream.forEach(System.out::println);
    }
}

class 헷갈리는동작순서_findFirst {
    public static void main(String[] args) {
        Arrays.stream(new String[]{"c", "python", "java"})
                .filter(word -> {
                    System.out.println("Call filter method: " + word);
                    return word.length() > 3;
                })
                .map(word -> {
                    System.out.println("Call map method: " + word);
                    return word.substring(0, 3);
                }).findFirst();

        /*
        Call filter method: c
        Call filter method: python
        Call map method: python

        수행에 맞는 결과를 하나라도 찾는다면 이후 요소를 연산하지 않는다.
         */
    }
}

class Stream은Loop가아니다 {
    public static void main(String[] args) {
        usingFindFirst();
    }

    public static void till99() {
        IntStream.range(1, 100).forEach(i -> {
            //Do Something
            if (i > 50) {
                System.out.println(i);
                return;
            }
        });
    }

    public static void usingFindFirst() {
        IntStream.range(1, 100)
                .peek(System.out::println)
                .filter(i -> i >= 50)
                .findFirst();
    }
}