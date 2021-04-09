package 프로그래머스.깊이너비우선탐색;

public class 단어변환 {
    public static void main(String[] args) {
        source = "hit";
        target = "cog";
        words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

        used = new boolean[words.length];
        dfs(source, 1);

        System.out.println(min);
    }

    private static String source;
    private static String target;
    private static String[] words;

    private static boolean used[];
    private static int min = Integer.MAX_VALUE;

    private static void dfs(String source, int count) {
        for (int i = 0; i < words.length; i++) {
            if (used[i] || !isConvertable(source, words[i])) {
                continue;
            }

            if(words[i].equals(target)){
                min = Math.min(min, count);
            }

            used[i] = true;
            dfs(words[i], count+1);
            used[i] = false;
        }
    }

    private static boolean isConvertable(final String source, final String target) {
        int dif = 0;

        char[] sources = source.toCharArray();
        char[] targets = target.toCharArray();

        for (int i = 0; i < sources.length; i++) {
            if (sources[i] != targets[i]) {
                dif++;
            }

            if (dif > 2) {
                return false;
            }
        }

        return dif == 1;
    }
}
