package 프로그래머스.codingTest.kakaocommerce;

public class t3 {

    public static void main(String[] args) {

        passenger = new int[]{1,1,1,1,1,1};
        train = new int[][]{
                {1,2},
                {1,3},
                {1,4},
                {3,5},
                {3,6}
        };

        n = passenger.length;
        map = new boolean[n+1][n+1];

        for(int i =0; i< train.length; i++){
            map[train[i][0]][train[i][1]] = true;
            map[train[i][1]][train[i][0]] = true;
        }

        used = new boolean[passenger.length+1];

        used[1] = true;
        dfs(1, passenger[0]);

        System.out.println(finalStation + " "+max);
    }

    public static boolean[][] map;
    public static int[] passenger;
    public static int[][] train;
    public static int n;

    public static boolean[] used;
    public static int max= 0;
    public static int finalStation = 0;

    public static void dfs(int source, int score){
        boolean noElseToGo = true;

        for(int i =1; i<= n; i++){
            if(used[i] == true){
                continue;
            }

            if(map[source][i] == true){
                noElseToGo = false;
                used[i] = true;
                dfs(i, score+passenger[i-1]);
                used[i] = false;
            }
        }

        if(noElseToGo){
            if(score > max){
                max = score;
                finalStation = source;
                return;
            }

            if(score == max){
                finalStation = Math.max(finalStation, source);
                return;
            }
        }
    }
}
