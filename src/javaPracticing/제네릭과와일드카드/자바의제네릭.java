package javaPracticing.제네릭과와일드카드;

public class 자바의제네릭 {

    public static void main(String[] args) {

        Parent<Child> p1 = new Parent<>();
        Parent<Child> p2 = new Child();
        Child<Child> p3 = new Child();

        p1.print(new Child()); // 1
        p2.print(new Child()); // 1
        p3.print(new Child()); // 2
    }
}

class Parent<T> {
    public T print(T args) {
        System.out.println("1 : " + args + "");
        return args;
    }
}

class Child<T extends Child> extends Parent {
    public T print(T args) {
        System.out.println("2 : " + args + "");
        return args;
    }
}