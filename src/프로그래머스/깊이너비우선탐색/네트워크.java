package 프로그래머스.깊이너비우선탐색;

public class 네트워크 {
    public static void main(String[] args) {

        n= 3;
        board = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        used = new boolean[n];

        for(int i =0; i<n; i++){
            if(used[i] == false){
                count ++;
                used[i] = true;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static int n;
    private static int board[][];

    private static int count =0;
    private static boolean[] used;

    private static void dfs(int source){
        for(int target = 0; target<n; target++){
            if(target == source){
                continue;
            }

            if(used[target] == true){
                continue;
            }

            if(board[source][target] == 1){
                used[target] = true;
                dfs(target);
            }
        }
    }
}
