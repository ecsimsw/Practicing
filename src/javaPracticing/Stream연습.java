package javaPracticing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream연습 {
    public static void main(String[] args) throws Exception{

        // list 추가 동시에 초기화. Arrays.asList()
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,1,1));

        System.out.println(streamToList(list.stream()));

        System.out.println(removeDuplicateWithStream(list).size());

        System.out.println(removeDuplicateWithSet(list).size());

        for(int i : biggerThanThreshold(list, 2)){
            System.out.print(i + " ");
        }

        System.out.println();

        for(int i : sort(list)){
            System.out.print(i + " ");
        }

        System.out.println();

        for(int i : sortReverse(list)){
            System.out.print(i + " ");
        }

    }

    // collect(Collectors.toList) : stream to list
    public static List<Integer> streamToList(Stream<Integer> stream){
        return stream.collect(Collectors.toList());
    }

    // distinct : 중복 제거
    public static List<Integer> removeDuplicateWithStream(List<Integer> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static List<Integer> removeDuplicateWithSet(List<Integer> list){
        return new ArrayList(new HashSet(list));
    }

    // filter : 조건 불충족 인자 제거
    public static List<Integer> biggerThanThreshold(List<Integer> list, int threshold){
        return list.stream().filter(x -> x>= threshold).collect(Collectors.toList());
    }

    // sort : 정렬
    public static List<Integer> sort(List<Integer> list){
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> sortReverse(List<Integer> list){
        return list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

}
