package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10825_구현_국영수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            students[i] = new Student(
                    line[0],
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2]),
                    Integer.parseInt(line[3])
            );
        }
        Arrays.sort(students);
        for(Student s : students){
            System.out.println(s);
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int kor;
        int eng;
        int mat;

        public Student(String name, int kor, int eng, int mat){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }

        @Override
        public int compareTo(Student o) {
            if(this.kor == o.kor){
                if(this.eng == o.eng){
                    if(this.mat == o.mat){
                        return this.name.compareTo(o.name);
                    }else {
                        return o.mat - this.mat;
                    }
                }else{
                    return this.eng - o.eng;
                }
            }else{
                return o.kor - this.kor;
            }
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
