package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1076_구현_저항 {
    private static String[] colors= new String[]{
            "black", "brown", "red", "orange", "yellow",
            "green", "blue", "violet", "grey", "white"
    };

    private static Resitance[] resitances = new Resitance[10];

    public static void main(String[] args) throws Exception{
        int ten = 10;
        for(int i=0; i<colors.length; i++){
            resitances[i] = new Resitance(colors[i], i, (long)Math.pow(ten, i));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Resitance r1 = getByColor(br.readLine());
        Resitance r2 = getByColor(br.readLine());
        Resitance r3 = getByColor(br.readLine());

        long ans =0;
        ans += r1.val;
        ans *= 10;
        ans += r2.val;
        ans *= r3.mul;

        System.out.print(ans);
    }

    private static Resitance getByColor(String color){
        for(int i=0; i<resitances.length; i++){
            if(resitances[i].color.equals(color)){
                return resitances[i];
            }
        }
        return null;
    }

    static class Resitance{
        String color;
        int val;
        long mul;

        public Resitance(String color, int val, long mul){
            this.color = color;
            this.val = val;
            this.mul = mul;
        }
    }
}
