package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
