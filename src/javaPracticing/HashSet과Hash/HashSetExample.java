package javaPracticing.HashSet과Hash;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(10);
        hashSet.add(11111);
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("10");
        hashSet.add("1003230");
        hashSet.add("1103230");
        hashSet.add("1113230");
        hashSet.add("1013230");

        for (Object o : hashSet) {
            System.out.println(o);
        }
    }
}
