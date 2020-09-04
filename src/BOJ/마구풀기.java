package BOJ;

import java.io.*;
import java.util.*;

class b10815_숫자카드{
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(Integer.parseInt(nums[i]), true);
        }

        int n_ = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        nums = br.readLine().split(" ");
        for(int i=0; i<n_; i++){

            if(map.containsKey(Integer.parseInt(nums[i]))){
                sb.append("1 ");
            }

            else{
                sb.append("0 ");
            }
        }

        System.out.print(sb);
    }
}

class b5585_그리디_거스름돈{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] moneyList = new int[]{500,100,50,10,5,1};

        int n = 1000-Integer.parseInt(br.readLine());

        int cnt=0;
        int moneyIndex= 0;
        while(true){
            if(n>=moneyList[moneyIndex]){
                cnt++;
                n-=moneyList[moneyIndex];
            }
            else{
                moneyIndex++;
            }
            if(n ==0) break;
        }
        System.out.print(cnt);
    }
}


class b1085{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[2]);
        int h = Integer.parseInt(str[3]);

        int dif_x= Math.min(x-0,w-x);
        int dif_y = Math.min(y-0, h-y);

        System.out.print(Math.min(dif_x,dif_y));
    }
}

class b4153{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            if(a==0&&b==0&&c==0) break;

            boolean r1 = Math.pow(a,2) == Math.pow(b,2)+Math.pow(c,2);
            boolean r2 = Math.pow(b,2) == Math.pow(a,2)+Math.pow(c,2);
            boolean r3 = Math.pow(c,2) == Math.pow(a,2)+Math.pow(b,2);

            if(r1 || r2 || r3) sb.append("right \n");
            else sb.append("wrong \n");
        }

        System.out.print(sb);
    }
}

class b2164{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=n; i>=1; i--){
            list.add(i);
        }

        while(list.size()>1){
            list.removeLast();
            int temp = list.pollLast();
            list.addFirst(temp);
        }
        System.out.print(list.poll());
    }
}

class b2581_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] notPrime = new boolean[10001];

        for(int i=3; i<=N; i++){
            if(i%2 ==0) continue;
            if(notPrime[i]==true) continue;

            int m = 3;
            while(true){
                if(i*m > N) break;
                notPrime[i*m] = true;
                m+=2;
            }
        }
        int min=10000;
        int sum=0;
        if(M<3 && N>=2){
            //System.out.println("2");
            min =2;
            sum =2;
        }
        for(int i=M; i<=N; i++ ) {
            if(i==1) continue;
            if(notPrime[i]==false && i%2!=0){
                if(min>i) min =i;
                sum+=i;
            }
        }

        if(sum == 0){
            System.out.print("-1");
            return;
        }

        System.out.println(sum);
        System.out.print(min);
    }
}

class b1929_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numstr = br.readLine().split(" ");

        int M = Integer.parseInt(numstr[0]);
        int N = Integer.parseInt(numstr[1]);

        boolean[] notPrime = new boolean[1000001];

        StringBuilder sb = new StringBuilder();

        for(int i=3; i<=N; i++){
            if(i%2 ==0) continue;
            if(notPrime[i]==true) continue;

            int m = 3;
            while(true){
                if(i*m > N) break;
                notPrime[i*m] = true;
                m+=2;
            }
        }

        if(M<3 && N>=2) System.out.println("2");
        for(int i=M; i<=N; i++ ) {
            if(i==1) continue;
            if(notPrime[i]==false && i%2!=0){
                System.out.println(i);
            }
        }
    }
}

/*
class b1929_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numstr = br.readLine().split(" ");

        int M = Integer.parseInt(numstr[0]);
        int N = Integer.parseInt(numstr[1]);

        int[] prime = new int[1000000];
        int primeCnt =0;
        for(int i=M; i<=N; i++){
            if(i % 2 ==0|| i % 3 ==0|| i % 5==0 || i %7==0 || i% 11==0 || i %13==0){
                continue;
            }
            boolean isPrime = true;
            for(int p=0; p<primeCnt; p++){
                if(i%prime[p]==0){ isPrime = false; }
            }
            if(isPrime){ prime[primeCnt++] = i;
            System.out.println(i);}
        }

        int[] beforePrime = new int[]{2,3,5,7,11,13};

        for(int b : beforePrime){
            if(b<M) continue;
            System.out.println(b);
        }
        for(int p : prime) {
            if (p == 0) break;
            System.out.println(p);
        }
    }
}
*/
class b1978_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        int cnt=0;

        String[] numstr = br.readLine().split(" ");

        int index =0;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(numstr[i]);
            if(num == 1) continue;
            if(num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num ==13){
                cnt++;
                continue;
            }
            if(num <= 13) continue;
            nums[index++] = num;
        }

        Arrays.sort(nums);

        int[] prime = new int[1000];
        int primeCnt =0;
        for(int i=2; i<=1001; i++){
            if(i % 2 ==0|| i % 3 ==0|| i % 5==0 || i %7==0 || i% 11==0 || i %13==0){
                continue;
            }
            boolean isPrime = true;
            for(int p=0; p<primeCnt; p++){
                if(i%prime[p]==0){
                    isPrime = false;
                }
            }
            if(isPrime){
                prime[primeCnt++] = i;
            }

            if(i == nums[nums.length-1]) break;
        }

        for(int i : nums){
            boolean isPrime = true;
            for(int p :prime ){
                if(i<p)break;
                if(i == p){
                    cnt++;
                    break;
                }
            }
        }
        System.out.print(cnt);

    }
}

class b1003_재귀_피보나치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        zeroCnt = new int[45];
        oneCnt = new int[45];

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for(int i =0; i<n; i++){
            nums[i] =  Integer.parseInt(br.readLine());
        }
        for(int i =0; i<n; i++) {
            System.out.print(funcZero(nums[i])+" ");
            System.out.println(funcOne(nums[i]));
        }
    }

    static int[] zeroCnt;
    static int[] oneCnt;

    static int funcOne(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else if(n==2) return 1;
        else if(n==3) return 2;
        else if(n==4) return 3;

        if(oneCnt[n]!=0) return oneCnt[n];

        int result =  funcOne(n-1) + funcOne(n-2);
        oneCnt[n] = result;
        return result;
    }

    static int funcZero(int n){
        if(n==0) return 1;
        else if(n==1) return 0;
        else if(n==2) return 1;
        else if(n==3) return 1;
        else if(n==4) return 2;

        if(zeroCnt[n]!=0) return zeroCnt[n];

        int result =  funcZero(n-1) + funcZero(n-2);
        zeroCnt[n] = result;
        return result;
    }
}


class b2309_그리디_일곱난쟁이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[9];
        boolean[] isThere = new boolean[101];

        for(int i=0; i<9; i++){
            nums[i] = Integer.parseInt(br.readLine());
            isThere[nums[i]] = true;
        }

        int sum=0;
        for(int i: nums) sum+=i;
        int dif = sum-100;
        int[] notDwarf = new int[2];

        for(int i =0; i<9; i++){
            if(dif == 2*nums[i]) continue;
            if(isThere[dif-nums[i]]) {
                notDwarf[0] = nums[i];
                notDwarf[1] = dif-nums[i];
                break;
            }
        }
        int[] dwarf = new int[7];
        int index=0;
        for(int i=0; i<9; i++){
            if(nums[i]== notDwarf[0] || nums[i] == notDwarf[1]){
                continue;
            }
            dwarf[index++]= nums[i];
        }

        Arrays.sort(dwarf);
        for(int i : dwarf) System.out.println(i);

    }
}


class b1463_bfs{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int cnt=0;
        boolean finish= false;
        while(true){
            int cycle = queue.size();
            for(int i=0; i<cycle; i++) {
                n = queue.poll();
                if (n == 1) {
                    finish =true;
                    break;
                }

                if (n % 3 == 0) queue.offer(n / 3);
                if (n % 2 == 0) queue.offer(n / 2);
                queue.offer(n - 1);
            }
            if(finish) break;
            cnt++;
        }
        System.out.print(cnt);
    }
}
class b19532{
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long[] nums = new Long[6];
        String[] numbers = br.readLine().split(" ");
        for(int i=0; i<6; i++){
            nums[i] = Long.parseLong(numbers[i]);
        }

        Long a,b,c,d,e,f;

        a = nums[0];
        b = nums[1];
        c = nums[2];
        d = nums[3];
        e = nums[4];
        f = nums[5];

        Long a_ = a*d;
        Long b_ = b*d;
        Long c_ = c*d;

        Long d_ = d*a;
        Long e_ = e*a;
        Long f_ = f*a;

        Long y_ = b_-e_;
        Long i_ = c_-f_;

        if(a ==0){
            if(b == 0){
                System.out.print(0+" "+0);
                return;
            }
            long y = c/b;
            long x = (f-e*y)/d;

            System.out.print(x+" "+y);
            return;
        }

        if(y_==0) {
            long y = 0l;
            long x = c/a;

            System.out.print(x+" "+y);
            return;
        }

        double y = (double)i_/y_;
        double x = (-b*y+c)/a;

        System.out.print((long)x+" "+(long)y);
    }
}

class b2493_stack{
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] tower = new int[n];

        String[] numbers = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            tower[i] = Integer.parseInt(numbers[i]);
        }

        Stack<Integer> stack_h = new Stack<>();
        Stack<Integer> stack_i = new Stack<>();

        int[] ans = new int[n];

        for(int i = n-1; i>-1; i--){
            if(stack_h.isEmpty()) {
                stack_h.push(tower[i]);
                stack_i.push(i);
                continue;
            }
            while(stack_h.peek() < tower[i]){
                ans[stack_i.pop()] = i+1;
                stack_h.pop();
                if(stack_h.isEmpty())break;
            }
            stack_h.push(tower[i]);
            stack_i.push(i);
        }

        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}

class b1330 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] n = br.readLine().split(" ");

        int a= Integer.parseInt(n[0]);
        int b= Integer.parseInt(n[1]);

        if(a==b) System.out.print("==");
        else if(a<b) System.out.print("<");
        else if(a>b) System.out.print(">");
    }
}

class b10951 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals("0 0")) break;
            String[] strings = str.split(" ");
            int a= Integer.parseInt(strings[0]);
            int b= Integer.parseInt(strings[1]);

            if(a ==0 && b==0) break;
            System.out.println(a+b);
        }
    }
}

class b2588 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int three = n * (m%10);
        int four = n * ((m/10)%10);
        int five = n * ((m/100)%10);

        System.out.println(three);
        System.out.println(four);
        System.out.println(five);
        System.out.println(n*m);
    }
}

class b2446 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a = 2*n-1;
        for(int count=0; count<n; count++){
            for(int i=0; i<count; i++){ System.out.print(" "); }
            for(int i=0; i<a -count*2; i++){ System.out.print("*"); }
            System.out.println();
        }
        for(int count=n-2; count>-1; count--){
            for(int i=0; i<count; i++){ System.out.print(" "); }
            for(int i=0; i<a -count*2; i++){ System.out.print("*"); }
            if(count != 0) System.out.println();
        }
    }
}

class b2523 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a;
        for(a =1; a<n; a++) {
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(a =n; a>0; a--) {
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class b1712 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        if(c-b<1){
            System.out.print("-1");
            return;
        }
        int n = (a/(c-b))+1;
        System.out.print(n);
    }
}

class b5543 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min_burger=2001;

        for(int i=0; i<3; i++){
            int a = Integer.parseInt(br.readLine());

            if(a<min_burger){
                min_burger= a;
            }
        }

        int min_drink=2001;

        for(int i=0; i<2; i++){
            int a = Integer.parseInt(br.readLine());

            if(a<min_drink){
                min_drink= a;
            }
        }

        System.out.print(min_drink+min_burger-50);
    }
}

class b10818 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");

        int max=-1000000;
        int min= 1000000;

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(numbers[i]);

            if(a>max){
                max = a;
            }

            if(a<min){
                min = a;
            }
        }

        System.out.print(min + " "+max);
    }
}
