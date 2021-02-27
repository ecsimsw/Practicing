package 프로그래머스.codingTest.SM;

import java.util.*;
import java.util.stream.Collectors;

class SM_2 {
    static String[] nameList;
    static Map<String, Integer> names;
    static boolean[][] board;
    static List<String> skillTrees = new ArrayList<>();
    static LinkedList<Integer> beforeSkills = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        nameList = sc.nextLine().split(" ");
        names = new HashMap<>();

        int index = 0;
        for (String name : nameList) {
            names.put(name, index++);
        }
        board = new boolean[nameList.length][nameList.length];

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");

            int beforeIndex = names.get(line[0]);
            int afterIndex = names.get(line[1]);

            board[beforeIndex][afterIndex] = true;
        }

        List<Integer> rootSkills = findRootSkill();

        for (int rootIndex : rootSkills) {
            link(rootIndex);
        }

        for (String skillLine : skillTrees) {
            System.out.println(skillLine);
        }
    }

    static List<Integer> findRootSkill() {
        List<Integer> rootSkills = new ArrayList<>();

        for (int g = 0; g < board.length; g++) {
            boolean flag = true;
            for (int s = 0; s < board.length; s++) {
                if (board[s][g] == true) {
                    flag = false;
                }
            }
            if (flag) {
                rootSkills.add(g);
            }
        }
        return rootSkills;
    }

    static void link(int beforeIndex) {

        int count = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[beforeIndex][i] == true) {
                beforeSkills.offerLast(beforeIndex);
                link(i);
                count++;
                beforeSkills.pollLast();
            }
        }

        if (count == 0) {
            if (beforeSkills.size() == 0) {
                return;
            }

            beforeSkills.offerLast(beforeIndex);
            skillTrees.add(indexToString());
            beforeSkills.pollLast();
        }
    }

    static String indexToString() {
        return beforeSkills.stream()
                .map(index -> nameList[index])
                .collect(Collectors.joining(" "));
    }
}
