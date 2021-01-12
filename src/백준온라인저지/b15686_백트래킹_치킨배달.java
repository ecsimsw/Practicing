package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class b15686_백트래킹_치킨배달 {
    private static int min = 2000000;
    private static int m;
    private static boolean[] isUsed;

    private static ArrayList<Dot> houses = new ArrayList<>();
    private static ArrayList<Dot> chickens = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int temp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                temp = Integer.parseInt(st.nextToken());
                if (temp == 1) houses.add(new Dot(i, j));
                else if (temp == 2) chickens.add(new Dot(i, j));
            }
        }

        isUsed = new boolean[chickens.size()];

        track(0, 0);
        System.out.print(min);
    }

    private static int getDistance(Dot x, Dot y) {
        return Math.abs(x.g - y.g) + Math.abs(x.s - y.s);
    }

    private static int getScore() {
        int score = 0;
        for (Dot house : houses) {
            int shortest = 2000000;
            for (int c = 0; c < chickens.size(); c++) {
                if (isUsed[c] == true) {
                    shortest = Math.min(shortest, getDistance(chickens.get(c), house));
                }
            }
            score += shortest;
        }
        return score;
    }

    private static void track(int start, int count) {
        if (count == m) {
            min = Math.min(min, getScore());
            return;
        }

        /*
           track의 시작을 0에서 하는 게 아니라, 이전 선택 값 이후부터
           0부터 시작한다면 순열로 중복된 치킨 집을 선택할 것이다. (2번 치킨집 - 1번 치킨집 , 1번 치킨집 - 2번 치킨집)
           i = start로 조합을 구해 치킨 집의 중복을 제거한다. (1번 치킨집 - 2번 치킨집)
         */

        for (int i = start; i < chickens.size(); i++) {
            if (isUsed[i] == false) {
                isUsed[i] = true;
                track(i+1, count + 1); /// ** track(i+1, count+1) 꼴 잘보기
                isUsed[i] = false;
            }
        }
    }

    static class Dot {
        int s;
        int g;

        public Dot(int s, int g) {
            this.s = s;
            this.g = g;
        }
    }
}

class b15686_백트래킹_치킨배달_시간초과1 {
    private static int min = 2000000;
    private static int m;
    private static boolean[] isUsed;

    private static ArrayList<Dot> houses = new ArrayList<>();
    private static ArrayList<Dot> chickens = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int temp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                temp = Integer.parseInt(st.nextToken());
                if (temp == 1) houses.add(new Dot(i, j));
                else if (temp == 2) chickens.add(new Dot(i, j));
            }
        }

        isUsed = new boolean[chickens.size()];

        track(0);
        System.out.print(min);
    }

    private static int getDistance(Dot x, Dot y) {
        return Math.abs(x.g - y.g) + Math.abs(x.s - y.s);
    }

    private static int getScore() {
        int score = 0;
        for (Dot house : houses) {
            int shortest = 2000000;
            for (int c = 0; c < chickens.size(); c++) {
                if (isUsed[c] == true) {
                    shortest = Math.min(shortest, getDistance(chickens.get(c), house));
                }
            }
            score += shortest;
        }
        return score;
    }

    private static void track(int count) {
        if (count == m) {
            min = Math.min(min, getScore());
            return;
        }

        for (int i = 0; i < chickens.size(); i++) {  /// track의 시작을 0에서 하는 게 아니라, 이전 선택 값 이후부터
            if (isUsed[i] == false) {
                isUsed[i] = true;
                track(count + 1); /// ** track(i+1, count+1) 꼴 잘보기
                isUsed[i] = false;
            }
        }
    }

    static class Dot {
        int s;
        int g;

        public Dot(int s, int g) {
            this.s = s;
            this.g = g;
        }
    }
}

class b15686_백트래킹_치킨배달_시간초과2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        m = Integer.parseInt(NM[1]);

        board = new int[N][N];

        int houseCnt = 0;
        int chickenCnt = 0;

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(nums[j]);
                if (board[i][j] == 1) {
                    houseCnt++;
                } else if (board[i][j] == 2) {
                    chickenCnt++;
                }
            }
        }

        houseS = new int[houseCnt];
        houseG = new int[houseCnt];

        chickenS = new int[chickenCnt];
        chickenG = new int[chickenCnt];

        int houseIndex = 0;
        int chickenIndex = 0;

        for (int s = 0; s < N; s++) {
            for (int g = 0; g < N; g++) {
                if (board[s][g] == 1) {
                    houseS[houseIndex] = s;
                    houseG[houseIndex] = g;
                    houseIndex++;
                } else if (board[s][g] == 2) {
                    chickenS[chickenIndex] = s;
                    chickenG[chickenIndex] = g;
                    chickenIndex++;
                }
            }
        }

        isUsed = new boolean[chickenCnt];
        choosen = new int[m];

        track(0);

        System.out.print(min);
    }

    private static int min = 2000000;
    private static int m;
    private static int[][] board;

    private static int[] houseS;
    private static int[] houseG;

    private static int[] chickenS;
    private static int[] chickenG;

    private static boolean[] isUsed;
    private static int[] choosen;

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    private static int getScore() {
        int score = 0;
        for (int i = 0; i < houseS.length; i++) {
            int shortest = 2000000;
            for (int c = 0; c < m; c++) {
                shortest = Math.min(shortest, getDistance(chickenS[choosen[c]], chickenG[choosen[c]], houseS[i], houseG[i]));
            }
            score += shortest;
        }
        return score;
    }

    private static void track(int count) {
        if (count == m) {
            int score = getScore();
            min = Math.min(min, score);
            return;
        }

        for (int i = 0; i < chickenS.length; i++) {
            if (isUsed[i] == false) {
                isUsed[i] = true;
                choosen[count] = i;
                track(count + 1);
                isUsed[i] = false;
            }
        }
    }
}
