package StringClass_analysis;


public class Application {
    public static void main(String[] args){
        int a[] = new int[0];
        int b[] = new int[]{};
        int c[] = {};

        String str ="";


        System.out.println(a.length);
        System.out.println(b.length);
        System.out.println(c.length);
        System.out.println(str.length());

        char[] chars = new char[]{'d','e','s'};

        String s2 = new String(chars);

        System.out.println(s2.length());
    }
}
