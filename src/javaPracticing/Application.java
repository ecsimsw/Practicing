package javaPracticing;


import java.util.*;

public class Application {
    public static void main(String[] args){
        LinkedList<Integer> linkedlist = new LinkedList<>();

        linkedlist.offer(1);
        linkedlist.add(2);
        linkedlist.addFirst(3);
        linkedlist.addLast(4);
        linkedlist.addAll(linkedlist);

        for(int i : linkedlist){
            System.out.print(i);
        }
        System.out.println();

        HashSet<Integer> hashSet1 = new HashSet<>(linkedlist);
        for(int i : hashSet1){
            System.out.print(i);
        }

        System.out.println();


        HashSet<Integer> hashSet2 = new LinkedHashSet<>(linkedlist);
        for(int i : hashSet2){
            System.out.print(i);
        }

        System.out.println();

Student A = new Student(1,"apple");
Student B = new Student(2,"banana");
Student C = new Student(3,"grape");
Student D = new Student(1,"apple");

HashSet<Student> class1 = new HashSet<>();

class1.add(A);
class1.add(B);
class1.add(C);
class1.add(D);

        for(Student s : class1){
            System.out.print(s.name+ "   ");
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

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}