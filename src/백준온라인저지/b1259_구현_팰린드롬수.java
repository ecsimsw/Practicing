package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1259_구현_팰린드롬수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while(true){
            line = br.readLine();

            if(line.equals("0") || Integer.parseInt(line) == 0){
                break;
            }

            if(isPallindrome(line)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    private static boolean isPallindrome(String line){

        for(int i =0; i<line.length()/2; i++){
            if(line.charAt(i) != line.charAt(line.length()-i-1)){
                return false;
            }
        }

        return true;
    }
}
