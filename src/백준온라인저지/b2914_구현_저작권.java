package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class b2914_구현_저작권 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AI = br.readLine().split(" ");
        int A = Integer.parseInt(AI[0]);
        int I = Integer.parseInt(AI[1]);

        System.out.println(A*(I-1)+1);
    }
}

class b10886_구현_notCuteOrCute{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] votes = new int[2];

        for(int i=0; i<n; i++){
            votes[Integer.parseInt(br.readLine())]++;
        }

        if(votes[0] < votes[1]){
            System.out.println("Junhee is cute!");
        }else{
            System.out.println("Junhee is not cute!");
        }
    }
}

class b2752_구현_세수정렬{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];

        String[] nums = br.readLine().split(" ");

        for(int i=0; i<3; i++){
            int n = Integer.parseInt(nums[i]);

            arr[i] = n;
        }

        Arrays.sort(arr);

        for(int i : arr){
            System.out.print(i+ " ");
        }
    }
}

class b5337_구현_웰컴{
    public static void main(String[] args) throws Exception{
        System.out.print(".  .   .\n" +
                "|  | _ | _. _ ._ _  _\n" +
                "|/\\|(/.|(_.(_)[ | )(/.");
    }
}

class b5086_구현_배수와약수{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] NM = br.readLine().split(" ");
            int n = Integer.parseInt(NM[0]);
            int m = Integer.parseInt(NM[1]);

            if(n == 0 && m ==0){
                break;
            }

            if(n%m == 0 || m%n ==0){
                if(n % m ==0 && m % n ==0){
                    throw new Exception();
                }

                if(n % m == 0){
                    System.out.println("multiple");
                }

                if(m % n == 0){
                    System.out.println("factor");
                }

                continue;
            }

            System.out.println("neither");
        }

        System.out.println(sb.toString());
    }
}

class b10789_구현_세로읽기{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        String[] lines = new String[5];

        for(int i =0; i<5; i++){
            lines[i] = br.readLine();
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                if(lines[j].length() <= i){
                    continue;
                }
                ans.append(lines[j].charAt(i));
            }
        }

        System.out.println(ans.toString());
    }
}

