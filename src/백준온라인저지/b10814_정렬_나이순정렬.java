package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class b10814_정렬_나이순정렬 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Member_10814> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            int age = Integer.parseInt(str[0]);
            String name = str[1];

            list.add(new Member_10814(age, name));
        }

        Collections.sort(list);

        for (Member_10814 m : list) System.out.println(m.toString());
    }

    static class Member_10814 implements Comparable {
        int age;
        String name;

        public Member_10814(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int compareTo(Object o) {
            if (o instanceof Member_10814) {
                Member_10814 temp = (Member_10814) o;

                if (temp.age < this.age) return 1;
                else if (temp.age == this.age) return 0;
                else return -1;
            } else return 0;
        }

        public String toString() {
            return age + " " + name;
        }
    }
}
