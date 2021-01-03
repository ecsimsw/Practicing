package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1946_그리디_신입사원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            Score[] scores = new Score[m];

            for (int j = 0; j < m; j++) {
                String[] nums = br.readLine().split(" ");

                int a = Integer.parseInt(nums[0]);
                int b = Integer.parseInt(nums[1]);

                scores[j] = new Score(a, b);
            }

            Arrays.sort(scores);

            int count = 1;
            int minSecond = scores[0].second;
            for (int index = 1; index < m; index++) {
                if (minSecond > scores[index].second) {
                    minSecond = scores[index].second;
                    count++;
                }
            }

            sb.append(count + "\n");
        }

        System.out.print(sb.toString());
    }

    static class Score implements Comparable<Score> {
        int first;
        int second;

        public Score(int f, int s) {
            this.first = f;
            this.second = s;
        }

        @Override
        public int compareTo(Score score) {
            return this.first - score.first;
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }
}

class b1946_그리디_신입사원_시간초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            int[] first = new int[m];
            int[] second = new int[m];

            for (int j = 0; j < m; j++) {
                String[] nums = br.readLine().split(" ");

                int a = Integer.parseInt(nums[0]);
                int b = Integer.parseInt(nums[1]);

                first[j] = a;
                second[j] = b;
            }

            int count = 0;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (first[j] > first[k] && second[j] > second[k]) {
                        count++;
                        break;
                    }
                }
            }

            sb.append(m - count + "\n");
        }

        System.out.print(sb.toString());
    }
}
