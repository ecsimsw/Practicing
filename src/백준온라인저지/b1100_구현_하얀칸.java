package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1100_구현_하얀칸 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        boolean isOddSpace = false;

        for (int i = 0; i < 8; i++) {
            result += countOn(isOddSpace, br.readLine());
            isOddSpace = !isOddSpace;
        }

        System.out.print(result);
    }

    private static int countOn(boolean matchWithOdd, String line) {
        String[] spaces = line.split("");
        int sum = 0;
        for (int index = 0; index < spaces.length; index++) {
            if (isOdd(index) == matchWithOdd && spaces[index].equals("F")) {
                sum++;
            }
        }
        return sum;
    }

    private static boolean isOdd(int i) {
        return i % 2 != 0;
    }

}
