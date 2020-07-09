package javaPracticing;

public class Application {
    public static void main(String[] args) {
        func(5,new MyClass());
    }

    static MyClass A = new MyClass();

    public static void func(int i, MyClass B){

        //A = new MyClass();

        if(i == 1){return;}

        i--;
        System.out.println("1 : "+B.value);
        A.value = B.value +1;
        System.out.println("2 : "+B.value);


        func(i, B);
    }
}

class MyClass{
    int value = 5;
}
