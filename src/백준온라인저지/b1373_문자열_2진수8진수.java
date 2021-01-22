package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b1373_문자열_2진수8진수 {
    public static void main(String [] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        if (n%3 == 1) {
            System.out.print(s.charAt(0));
        } else if (n%3 == 2) {
            System.out.print((s.charAt(0)-'0')*2 + (s.charAt(1)-'0'));
        }
        for (int i=n%3; i<n; i+=3) {
            System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
        }
    }
}

class b1373_문자열_2진수8진수_시간초과 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        int left = s.length()%3;
        for(int i = s.length()-1; i>left; i-=3){
            int sum = (s.charAt(i-2)-'0')*4 + (s.charAt(i-1)-'0')*2 + (s.charAt(i)-'0');

            sb.insert(0,  sum);
        }

        if(left !=0){
            String temp ="";
            for(int i =0; i<s.length()%3; i++){
                temp += s.charAt(i);
            }
            sb.insert(0,Integer.toOctalString(Integer.parseInt(temp,2)));
        }

        System.out.print(sb.toString());
    }
}


class b1373_API_2진수8진수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        long s = Long.parseLong(line, 2);

        System.out.print(Long.toOctalString(s));
    }
}
