package javaPracticing;

interface Ifunction{
    int add(int a, int b);

    default int sub(int a, int b){
        return a-b;
    }

    static int mul(int a, int b){
        return a*b;
    }
}

public class PracticingLamda {
    public static void main(String[] args) {

        int x = 10;
        int y = 20;
        System.out.println(add(x,y,(a,b) -> a+b));

        Ifunction ifunction = (a,b) -> a+b;

        System.out.println(add(x,y,(a,b) -> a+b));

        System.out.println(Ifunction.mul(x,y));
    }

    static int add(int x, int y,Ifunction addFunction){
        return addFunction.add(x,y);
    }
}
