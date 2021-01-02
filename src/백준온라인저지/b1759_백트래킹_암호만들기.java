package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class b1759_백트래킹_암호만들기 {
    private static final List<String> vowels = Arrays.asList(new String[]{"a", "e", "i", "o", "u"});
    private static final StringBuilder answers = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int L = Integer.parseInt(nums[0]);
        int C = Integer.parseInt(nums[1]);

        chars = br.readLine().split(" ");

        Arrays.sort(chars);

        isUsed = new boolean[C];

        makePw(L, 0, 0, new StringBuilder());

        System.out.print(answers.toString());
    }

    private static String[] chars;
    private static boolean[] isUsed;

    private static void makePw(int l, int i, int prevIndex, StringBuilder sb) {
        if (i == l) {
            String password = sb.toString();
            if (isValidatePassword(password)) {
                answers.append(password + "\n");
            }
            return;
        }

        for (int index = prevIndex; index < chars.length; index++) {
            if (isUsed[index] == false) {
                isUsed[index] = true;
                sb.append(chars[index]);
                makePw(l, i + 1, index, sb);
                sb.delete(sb.length() - 1, sb.length());
                isUsed[index] = false;
            }
        }
    }

    private static boolean isValidatePassword(String password) {
        int vowelsCnt = 0;
        int consonantsCnt = 0;

        for (String c : password.split("")) {
            if (vowels.contains(c)) {
                vowelsCnt++;
                continue;
            }

            consonantsCnt++;
        }

        if (vowelsCnt < 1 || consonantsCnt < 2) {
            return false;
        }

        return true;
    }
}
