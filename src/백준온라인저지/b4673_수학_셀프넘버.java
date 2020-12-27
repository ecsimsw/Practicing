package 백준온라인저지;

public class b4673_수학_셀프넘버 {
    public static void main(String[] args){
        N = 10000;

        arr = new boolean[N];

        for(int i=1; i<N; i++){
            if(arr[i] == true) continue;
            d(i);
        }

        for(int i=1; i<N; i++){
            if(arr[i] == true) continue;
            System.out.println(i);
        }
    }

    static boolean[] arr;
    static int N;

    static void d(int n){
        int sum = n;

        while(n>=1){
            sum += n%10;
            n /= 10;
        }
        if(sum > N-1) return;

        if(arr[sum] == true){ return; }
        else{ arr[sum] = true; d(sum); }
    }
}
