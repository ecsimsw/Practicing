package 프로그래머스.LEVEL2;

public class 멀쩡한사각형 {
    public static void main(String[] args){

    }
    static long solution(long w,long h) {

        // make h longer
        if(w>h){
            long temp = h;
            h= w;
            w = temp;
        }
        long answer = w*h - (w+h -GCF(w,h));
        return answer;
    }
    static long GCF(long a, long b){
        while(a!=b)
        {
            if(b>a){
                long temp = a;
                a= b;
                b = temp;
            }

            a=a-b;
        }
        return a;
    }
}
