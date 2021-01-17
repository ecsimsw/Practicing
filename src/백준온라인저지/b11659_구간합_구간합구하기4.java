package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b11659_구간합_구간합구하기4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        int[] sumArr = new int[n];

        String[] stringNums = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            if(i == 0){
                sumArr[i] = Integer.parseInt(stringNums[i]);
                continue;
            }
            sumArr[i] = sumArr[i-1] + Integer.parseInt(stringNums[i]);
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<m; i++){
            String[] FT = br.readLine().split(" ");
            int front = Integer.parseInt(FT[0]);
            int back = Integer.parseInt(FT[1]);

            if(front == 1 ){
                sb.append(sumArr[back-1]+"\n");
                continue;
            }

            sb.append(sumArr[back-1] - sumArr[front-2]+"\n");
        }

        System.out.print(sb.toString());
    }
}

class b11659_구현_구간합구하기4_메모리초과 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        int[] nums = new int[n];

        String[] stringNums = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(stringNums[i]);
        }

        int[][] board = new int[n][n];

        for(int start =0; start<n; start++){
            for(int end = start; end < n; end++){
                if(end == 0){
                    board[start][end] = nums[start];
                    continue;
                }
                board[start][end] = board[start][end-1] + nums[end];
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<m; i++){
            String[] FT = br.readLine().split(" ");
            int from = Integer.parseInt(FT[0])-1;
            int to = Integer.parseInt(FT[1])-1;

            sb.append(board[from][to]+"\n");
        }

        System.out.print(sb.toString());
    }
}

class b11659_구현_구간합구하기_시간초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        int[] arr = new int[n];

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] FT = br.readLine().split(" ");
            int from = Integer.parseInt(FT[0]) - 1;
            int to = Integer.parseInt(FT[1]);

            int sum = 0;
            for (int index = from; index < to; index++) {
                sum += arr[index];
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb.toString());
    }
}