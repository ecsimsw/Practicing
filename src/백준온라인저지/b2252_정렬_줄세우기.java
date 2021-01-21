package 백준온라인저지;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

class b2252_위상정렬_줄세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        Student[] students = new Student[n];

        for(int i =0; i< n; i++){
            students[i] = new Student(i+1);
        }

        for(int i=0; i<m; i++){
            String[] AB = br.readLine().split(" ");
            students[Integer.parseInt(AB[1])-1].front(students[Integer.parseInt(AB[0])-1]);
            students[Integer.parseInt(AB[0])-1].back(students[Integer.parseInt(AB[1])-1]);
        }

        Arrays.sort(students);

        for(int i=0; i< n; i++){
            System.out.print(students[i].num + " ");
        }
    }

    static class Student implements Comparable<Student>{
        int num;
        HashSet<Student> front;
        HashSet<Student> back;

        public Student(int num){
            this.num = num;
        }

        public void front(Student s){
            if(front == null){
                front = new HashSet<>();
            }
            front.add(s);
        }

        public void back(Student s){
            if(back == null){
                back = new HashSet<>();
            }
            back.add(s);
        }

        @Override
        public int compareTo(Student o) {
            if(this.front == null){
                return -1;
            }

            if(this.back == null){
                return 1;
            }

            if(this.front.contains(o)){
                return 1;
            }

            if(this.back.contains(o)){
                return -1;
            }

            return 0;
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof Student){
                if(((Student) o).num == this.num){
                    return true;
                }
            }
            return false;
        }
    }
}
