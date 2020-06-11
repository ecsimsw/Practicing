package AlgorithmicProblemSolvingStrategies.무식하게풀기;

import java.util.*;

public class 보글게임 {
static public void main(String[] args) {
    int[][] board = new int[][]{
                {1,2,3,4,5},
                {0,1,2,3,4},
                {5,0,5,4,7},
                {4,3,2,1,0},
                {1,1,1,2,1}};

    for(int s = 0; s<5; s++){
        for(int g =0; g<5; g++){
            if(hasWord(s,g,new LinkedList<>(Arrays.asList(new Integer[]{0,1,2,3,4})),-1, board)){
                System.out.println(s+ " "+ g );
            }
        }
    }
}

static boolean hasWord(int s, int g, LinkedList<Integer> word,int next, int[][] board){

    if(s<0 || g <0 || s>board.length-1 || g > board[0].length-1){
        return false;
    }

    if(word.get(0) != board[s][g]){
        return false;
    }

    if(word.size()==1){return true;}

    if(next == -1){
        for(int i = 0; i<nextG.length; i++){
            int temp = word.pollFirst();
            if(hasWord(s+nextS[i], g+nextG[i], word, i, board)){
                System.out.println(word.size()+" "+ i);
                return true;
            }
            word.offerFirst(temp);
        }
    }
    else{
        int temp = word.pollFirst();
        if(hasWord(s+nextS[next], g+nextG[next], word, next, board)){
            System.out.println(word.size()+" "+ next);
            return true;
        }
        word.offerFirst(temp);
    }

    return false;
}

static int[] nextS = new int[]{0,1,-1,0,1,-1,1,-1};
static int[] nextG = new int[]{1,0,0,-1,1,-1,-1,1};
}
