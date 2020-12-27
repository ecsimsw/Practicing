package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1212_8진수2진수 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        if(n.equals(0)){
            System.out.println("0");
            return;
        }

        int i=0;
        while(i<(n.length())){
            int integer = Character.getNumericValue(n.charAt(i));

            String toBi = Integer.toBinaryString(integer);

            if(i==0){
                System.out.print(toBi);
            }
            else{
                if(toBi.length()==1){ System.out.print("00"+toBi); }
                else if(toBi.length() ==2 ){System.out.print("0"+toBi);}
                else{ System.out.print(toBi);}
            }

            i++;
        }
    }
}
