package javaPracticing.제네릭과와일드카드;

public class 자바의제네릭 {

    public static void main(String[] args) {

        Parent<Integer> p1 = new Parent<>();
        Parent<Child> p2 = new Child();

        p2.print();
        p2.print(new Child());

        Child<Child> p3 = new Child();
        p3.print(new Child());
    }
}

class Parent<T> {
    public void print() {
        System.out.println("이것은 Parent다");
    }

    public T print(T args) {
        System.out.println("1 : " + args + "");
        return args;
    }
}

class Child<T extends Child> extends Parent {
    @Override
    public void print() {
        System.out.println("이것은 child다");
    }

    public T print(T args) {
        System.out.println("2 : " + args + "");
        return args;
    }
}