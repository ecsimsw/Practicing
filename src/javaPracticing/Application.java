package javaPracticing;


import java.util.*;

public class Application {
    public static void main(String[] args) {

        HashSet<Student> hs = new HashSet<>();

        Student a = new Student(1, "A");
        Student b = new Student(2, "B");
        Student A = new Student(1, "A");

        System.out.println(a.equals(A));
        System.out.println(a.hashCode());
        System.out.println(A.hashCode());

        hs.add(a);
        hs.add(b);
        hs.add(A);

        for(Student s : hs){
            System.out.print(s.name);
        }
    }
}

class Student{
    int number;
    String name;

    public Student(int number, String name){
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number && Objects.equals(name, student.name);
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
    */

}