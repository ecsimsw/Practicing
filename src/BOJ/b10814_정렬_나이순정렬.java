package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class b10814_정렬_나이순정렬 {

    static class Member implements Comparable{
        int age;
        String name;

        public Member(int age, String name){
            this.age= age;
            this.name = name;
        }

        public int compareTo(Object o){
            if(o instanceof Member){
                Member temp = (Member)o;

                if(temp.age < this.age) return 1;
                else if(temp.age == this.age) return 0;
                else return -1;
            }
            else return 0;
        }

        public String toString(){
            return age+" "+name;
        }
    }

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Member> list = new LinkedList<>();

        for(int i =0; i<n; i++){
            String[] str = br.readLine().split(" ");

            int age = Integer.parseInt(str[0]);
            String name = str[1];

            list.add(new Member(age,name));
        }

        Collections.sort(list);

        for(Member m : list) System.out.println(m.toString());
    }
}
