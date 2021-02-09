package 알고리즘문제해결전략;

public class ProgrammerString {
    private static int[] arr = new int[26];
    private static char[] charArr;
    private static int startIndex = 0;
    private static int endIndex = 0;

    public static void main(String[] args) throws Exception {
        String s = "progxrammerrxproxgrammer";
        charArr = s.toCharArray();

        int first = 0;
        set();
        while (!check()) {
            forwardEnd();
            first = endIndex;
        }
        first++;

        int last = 0;
        set();
        startIndex = charArr.length - 1;
        endIndex = charArr.length - 1;
        while (!check()) {
            backStart();
            last = startIndex;
        }

        System.out.println(last - first + 1);
    }

    private static void backStart() {
        arr[charArr[startIndex] - 'a']--;
        startIndex--;
    }

    private static void forwardEnd() {
        arr[charArr[endIndex] - 'a']--;
        endIndex++;
    }

    private static boolean check() {
        if (arr['p' - 'a'] < 1
                && arr['r' - 'a'] < 3
                && arr['o' - 'a'] < 1
                && arr['g' - 'a'] < 1
                && arr['a' - 'a'] < 1
                && arr['m' - 'a'] < 2
                && arr['e' - 'a'] < 1) {
            return true;
        }
        return false;
    }

    private static void set() {
        arr['p' - 'a'] = 1;
        arr['r' - 'a'] = 3;
        arr['o' - 'a'] = 1;
        arr['g' - 'a'] = 1;
        arr['a' - 'a'] = 1;
        arr['m' - 'a'] = 2;
        arr['e' - 'a'] = 1;
    }
}
