package 프로그래머스.LEVEL2;

public class 가장큰정사각형 {

    public int solution(int[][]board)
    {

        board = new int[][] {
                {1,1,0,0,1},
                {0,1,1,1,1},
                {1,1,0,0,1},
                {0,1,1,1,1}
        };

        int maxSize=0;
        for(int y=0; y< board.length; y++){
            for(int x=0; x<board[0].length; x++){
                if(board[y][x]== 0) continue;
                for(int n = Math.min(board[0].length-x, board.length-y); n>maxSize; n--){
                    if(checkSqr(x,y,n, board)){
                        maxSize = n;
                        break;}
                }
            }
        }

        return maxSize*maxSize;
    }

    public boolean checkSqr(int x, int y, int n, int[][] board){
        int min = Math.min(board[0].length, board.length);
        if(x+n > board[0].length || y+n > board.length) {return false;}
        else if(board[y][x] == 0) {return false;}

        for(int i=0; i<n; i++){
            if(board[y][x] == 0){return false;}
        }
        return true;
    }
}
