package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2953_구현_나는요리사다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int winnerScore = 0;
        int winnerIndex = 0;

        for (int i = 0; i < 5; i++) {
            String[] nums = br.readLine().split(" ");
            int score = 0;
            for (int j = 0; j < 4; j++) {
                score += Integer.parseInt(nums[j]);
            }

            if (score > winnerScore) {
                winnerScore = score;
                winnerIndex = i;
            }
        }

        System.out.println(winnerIndex + 1 + " " + winnerScore);
    }
}
