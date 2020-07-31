package BOJ;

import java.io.*;
import java.util.Stack;

class b2493{
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] tower = new int[n];

        String[] numbers = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            tower[i] = Integer.parseInt(numbers[i]);
        }

        Stack<Integer> stack_h = new Stack<>();
        Stack<Integer> stack_i = new Stack<>();

        int[] ans = new int[n];

        for(int i = n-1; i>-1; i--){
            if(stack_h.isEmpty()) {
                stack_h.push(tower[i]);
                stack_i.push(i);
                continue;
            }
            while(stack_h.peek() < tower[i]){
                ans[stack_i.pop()] = i+1;
                stack_h.pop();
                if(stack_h.isEmpty())break;
            }
            stack_h.push(tower[i]);
            stack_i.push(i);
        }

        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}

class b1330 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] n = br.readLine().split(" ");

        int a= Integer.parseInt(n[0]);
        int b= Integer.parseInt(n[1]);

        if(a==b) System.out.print("==");
        else if(a<b) System.out.print("<");
        else if(a>b) System.out.print(">");
    }
}

class b10951 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals("0 0")) break;
            String[] strings = str.split(" ");
            int a= Integer.parseInt(strings[0]);
            int b= Integer.parseInt(strings[1]);

            if(a ==0 && b==0) break;
            System.out.println(a+b);
        }
    }
}

class b2588 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int three = n * (m%10);
        int four = n * ((m/10)%10);
        int five = n * ((m/100)%10);

        System.out.println(three);
        System.out.println(four);
        System.out.println(five);
        System.out.println(n*m);
    }
}

class b2446 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a = 2*n-1;
        for(int count=0; count<n; count++){
            for(int i=0; i<count; i++){ System.out.print(" "); }
            for(int i=0; i<a -count*2; i++){ System.out.print("*"); }
            System.out.println();
        }
        for(int count=n-2; count>-1; count--){
            for(int i=0; i<count; i++){ System.out.print(" "); }
            for(int i=0; i<a -count*2; i++){ System.out.print("*"); }
            if(count != 0) System.out.println();
        }
    }
}

class b2523 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a;
        for(a =1; a<n; a++) {
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(a =n; a>0; a--) {
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class b1712 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        if(c-b<1){
            System.out.print("-1");
            return;
        }
        int n = (a/(c-b))+1;
        System.out.print(n);
    }
}

class b5543 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min_burger=2001;

        for(int i=0; i<3; i++){
            int a = Integer.parseInt(br.readLine());

            if(a<min_burger){
                min_burger= a;
            }
        }

        int min_drink=2001;

        for(int i=0; i<2; i++){
            int a = Integer.parseInt(br.readLine());

            if(a<min_drink){
                min_drink= a;
            }
        }

        System.out.print(min_drink+min_burger-50);
    }
}

class b10818 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");

        int max=-1000000;
        int min= 1000000;

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(numbers[i]);

            if(a>max){
                max = a;
            }

            if(a<min){
                min = a;
            }
        }

        System.out.print(min + " "+max);
    }
}
