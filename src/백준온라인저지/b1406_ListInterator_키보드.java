package 백준온라인저지;
import java.io.*;
import java.util.*;

public class b1406_ListInterator_키보드 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        int n = Integer.parseInt(in.readLine());

        LinkedList<Character> characters = new LinkedList<>();
        ListIterator<Character> iter = characters.listIterator();

        for(char chars : str.toCharArray()){
            iter.add(chars);
        }

        for(int i=0; i<n; i++){
            char[] splitedCommand = in.readLine().toCharArray();

            switch (splitedCommand[0]) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(splitedCommand[2]);
                    break;
            }
        }
        for(char c : characters){
            System.out.print(c);
        }
    }

    public static class b1541_그리디_잃어버린괄호 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = br.readLine();

            String[] splited = line.split("-");

            int sum =0;

            for(String s : splited[0].split("\\+")) {
                sum += Integer.parseInt(s);
            }

            for(int i =1; i<splited.length; i++){
                String[] number = splited[i].split("\\+");

                int sumOfPlus =0;
                for(String s : number){
                    sumOfPlus += Integer.parseInt(s);
                }

                sum-=sumOfPlus;
            }

            System.out.print(sum);
        }
    }

    public static class b1931_그리디_회의실배정 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            Class[] classes = new Class[n];

            for(int i =0; i<n; i++) {
                String[] line = br.readLine().split(" ");

                int s = Integer.parseInt(line[0]);
                int e = Integer.parseInt(line[1]);

                classes[i] = new Class(s,e);
            }

            Arrays.sort(classes);

            int preEnd =0;
            int index = 0;
            int cnt =0;
            while (index < n) {
                // 이전 수업이 끝나는 시간 이후 끝나는 시간이 가장 이른것을 찾음
                if(classes[index].start>=preEnd){
                    preEnd = classes[index].end;
                    cnt++;
                }
                index++;

                // 끝나는 시간이 가장 이른 수업이 이전과 바뀌지 않으면 더 이상 수업이 없다는 것을 의미
                if (index == n) break;
            }

            System.out.print(cnt);
        }

        static class Class implements Comparable<Class>{
            int start;
            int end;

            public Class(int s, int e){
                start = s;
                end = e;
            }

            public int compareTo(Class obj){
                if(this.end > obj.end){
                    return 1;
                }
                else if(this.end == obj.end){
                    return this.start > obj.start ? 1 : -1;
                }
                else return -1;
            }
        }
    }

    public static class b2271_그리디_로프 {
        static public void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            Integer[] arr = new Integer[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr,Collections.reverseOrder());

            int max = arr[0];
            int cnt = 1;

            for(int i=cnt; i<n; i++){
                cnt++;
                if(arr[i]*cnt>max){
                    max = arr[i]*cnt;
                }
            }

            System.out.print(max);
        }
    }

    public static class b10610_그리디_30 {
        static public void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] numbers = br.readLine().split("");

            boolean isZero= false;
            for(int i=0; i<numbers.length; i++){
                if(Integer.parseInt(numbers[i]) == 0){
                    isZero =true;
                    break;
                }
            }
            if(!isZero) {System.out.print("-1"); return;}

            int sum =0;
            for(int i=0; i<numbers.length; i++){
                sum+=Integer.parseInt(numbers[i]);
            }
            if(sum%3!=0) {System.out.print("-1"); return;}

            Arrays.sort(numbers, Collections.reverseOrder());
            for(String s : numbers){
                System.out.print(s);
            }
        }
    }

    public static class b11047_그리디_동전 {
        static public void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] line =  br.readLine().split(" ");
            int n= Integer.parseInt(line[0]);
            int k= Integer.parseInt(line[1]);
            int[] coins = new int[n];

            for(int i=0; i<n; i++){
                coins[i] = Integer.parseInt(br.readLine());
            }

            int cnt=0;
            int left = k;

            while(left!=0){
                int i;
                for(i=n-1; i>-1; i--) {
                    if(coins[i]<=left){
                        break;
                    }
                }
                int numberOfCoin =  (left / coins[i]);
                left = left - coins[i]*numberOfCoin;
                cnt += numberOfCoin;
            }

            System.out.print(cnt);
        }
    }

    public static class b11399_그리디_ATM {
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



            int n= Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] waits = new int[n];

            for(int i =0; i<n; i++){
                waits[i] = Integer.parseInt(line[i]);
            }

            Arrays.sort(waits);

            int sum =0;
            int waitTime =0;
            for(int w : waits){
                waitTime += w;
                sum += waitTime;
            }
            System.out.print(sum);
        }
    }
}

/*
public class b1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        int n = Integer.parseInt(in.readLine());

        LinkedList<Character> characters = new LinkedList<>();
        for(char chars : str.toCharArray()){
            characters.add(chars);
        }

        int cursor = characters.size();
        int len = cursor;

        for(int i=0; i<n; i++){
            char[] splitedCommand = in.readLine().toCharArray();

            switch (splitedCommand[0]) {
                case 'L':
                    cursor = cursor != 0 ? cursor - 1 : cursor;
                    break;
                case 'D':
                    cursor = cursor != len ? cursor + 1 : cursor;
                    break;
                case 'B':
                    if (cursor != 0) {
                        characters.remove(--cursor);
                    }
                    break;
                case 'P':
                    characters.add(cursor++, splitedCommand[2]);
                    len++;
                    break;
            }
        }
        for(char c : characters){
            System.out.print(c);
        }
    }
}
*/