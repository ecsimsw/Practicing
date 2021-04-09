package 프로그래머스.깊이너비우선탐색;

import java.util.LinkedList;
import java.util.List;

public class 여행경로 {

    public static void main(String[] args) {
        tickets = new String[][]{
                {"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}
        };
        used = new boolean[tickets.length];

        List<String> visted = new LinkedList<>();
        visted.add("ICN");
        dfs("ICN", visted);

        String[] answer = answerList.toArray(new String[0]);

        System.out.println(answerList);
    }

    private static String[][] tickets;
    private static boolean[] used;
    private static List<String> answerList = new LinkedList<>();

    private static void dfs(String source, List<String> visited) {
        if (visited.size() == tickets.length + 1) {

            if (answerList.size() > 0) {
                answerList = compare(answerList, visited);
                return;
            }

            answerList = new LinkedList<>(visited);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (used[i]) {
                continue;
            }

            if (tickets[i][0].equals(source)) {
                used[i] = true;
                visited.add(tickets[i][1]);
                dfs(tickets[i][1], visited);
                used[i] = false;
                visited.remove(tickets[i][1]);
            }
        }
    }

    private static List<String> compare(List<String> first, List<String> second) {
        for (int i = 0; i < first.size(); i++) {
            String firstOne = first.get(i);
            String secondOne = second.get(i);

            if (firstOne.compareTo(secondOne) >= 1) {
                return new LinkedList<>(second);
            }

            if (firstOne.compareTo(secondOne) <= -1) {
                return new LinkedList<>(first);
            }
        }
        return new LinkedList<>(first);
    }
}
