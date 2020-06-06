package codingTest;

import java.util.*;

public class DevMatching_2020APP {


}
// 1번 문제

class Solution1 {
    public int solution(String[] moves) {
        int answer = 0;
        int nowX=0;
        int nowY=0;

        Set<Point> points = new HashSet<>();
        Set<Line> Glines = new HashSet<>();
        Set<Line> Slines = new HashSet<>();

        for(String s : moves){
            if(s.equals("U")){
                nowY++;
                Slines.add(new Line(new Point(nowX, nowY)));
            }
            else if(s.equals("D")){
                Slines.add(new Line(new Point(nowX, nowY)));
                nowY--;
            }
            else if(s.equals("R")){
                Glines.add(new Line(new Point(nowX, nowY)));
                nowX++;
            }
            else if(s.equals("L")) {
                nowX--;
                Glines.add(new Line(new Point(nowX, nowY)));
            }
        }

        for(Line l : Slines)
            System.out.println(l.p.x+" "+l.p.y);

        for(Line l : Slines){
            if(Slines.contains(new Line(new Point(l.p.x+1, l.p.y))))
                if(Glines.contains(new Line(new Point(l.p.x, l.p.y))))
                    if(Glines.contains(new Line(new Point(l.p.x, l.p.y-1))))
                        answer++;
        }

        return answer;
    }
}

class Line{
    public Point p;

    public Line(Point p){
        this.p = p;
    }
    public int hashCode(){
        return this.p.x*1000+this.p.y;
    }
    public boolean equals(Object l){
        if(l instanceof Line && l != null)
            return this.p.equals(((Line)l).p);
        else
            return false;
    }
}

class Point{
    public int x;
    public int y;

    public Point(int x, int y){
        this.x= x;
        this.y= y;
    }
    public boolean equals(Object p){
        if(p instanceof Point && p != null)
            return (this.x == ((Point)p).x && this.y == ((Point)p).y);
        else
            return false;
    }
}

// 2번 문제

class Solution2 {
    public int solution(int[][] board) {

        for(int x=0; x< 15; x++){
            for(int y=0; y<15; y++){
                if(check(board[y][x],y,x, board)) return board[y][x];
            }
        }

        return -1;
    }

    public boolean check(int stone, int y, int x, int[][] board ){
        if(stone ==0) return false;
        if(y > 10  || x> 10) return false;

        // 가로 체크
        if(board[y][x+1] == stone && board[y][x+2] == stone && board[y][x+3] == stone && board[y][x+4] == stone)
        {
            if(x == 0){
                if(board[y][x+5] != stone) return true;
            }
            else if(x == 10){
                if(board[y][x-1] != stone) return true;
            }
            else{
                if(board[y][x-1] != stone && board[y][x+5] != stone) return true;
            }
        }

        // 세로 체크
        if(board[y+1][x] == stone && board[y+2][x] == stone && board[y+3][x] == stone && board[y+4][x] == stone)
        {
            if(y == 0){
                if(board[y+5][x] != stone) return true;
            }
            else if(y == 10){
                if(board[y-1][x] != stone) return true;
            }
            else{
                if(board[y-1][x] != stone && board[y+5][x] != stone)  return true;
            }
        }

        // 대각 체크
        if(board[y+1][x+1] == stone && board[y+2][x+2] == stone && board[y+3][x+3] == stone && board[y+4][x+4] == stone)
        {
            if(y == 10 && x==0){ return true;}
            else if(y == 0 && x==10) {return true;}
            else if(y==0 || x ==0) {if(board[y+5][x+5] != stone) return true;}
            else if(y==10 || x ==10) {if(board[y-1][x-1] != stone) return true;}
            else{
                if(board[y-1][x-1] != stone && board[y+5][x+5] != stone) return true;
            }
        }

        return false;
    }
}