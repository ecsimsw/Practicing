package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class b1717_유니온파인드_중복탐색제거 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] table;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        table = new int[n + 1];
        Arrays.fill(table, -1);

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            calculateLine(line);
        }

        System.out.print(sb.toString());
    }

    private static void calculateLine(String line) {
        String[] nums = line.split(" ");

        int type = Integer.parseInt(nums[0]);
        int a = Integer.parseInt(nums[1]);
        int b = Integer.parseInt(nums[2]);

        if (type == 0) {
            sumSet(a, b);
            return;
        }

        if (type == 1) {
            printIsSameSet(a,b);
        }
    }

    private static void printIsSameSet(int a, int b) {
        if(a == b){
            sb.append("YES\n");
            return;
        }

        int a_now = a;
        int a_next = table[a];

        while (a_next != -1) {
            if(a_next == b){
                sb.append("YES\n");
                return;
            }
            a_now = a_next;
            a_next = table[a_now];
        }

        int b_now = b;
        int b_next = table[b_now];
        while (b_next != -1) {
            if(b_next == a){
                sb.append("YES\n");
                return;
            }
            b_now = b_next;
            b_next = table[b_now];
        }

        if(b_now == a_now){
            sb.append("YES\n");
            return;
        }

        sb.append("NO\n");
    }

    private static void sumSet(int a, int b) {
        if(a == b){
            return;
        }

        int a_now = a;
        int a_next = table[a];

        while (a_next != -1) {
            if(a_next == b){
                return;
            }
            a_now = a_next;
            a_next = table[a_now];
        }

        int b_now = b;
        int b_next = table[b_now];
        while (b_next != -1) {
            if(b_next == a){
                return;
            }
            b_now = b_next;
            b_next = table[b_now];
        }

        if(a_now < b_now){
            table[b_now] = a_now;
            return;
        }

        if(a_now > b_now){
            table[a_now] = b_now;
            return;
        }
    }
}

class b1717_유니온파인드_집합의표현_시간초과 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        String[] strs;
        int a, b;
        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            a = Integer.parseInt(strs[1]);
            b = Integer.parseInt(strs[2]);
            if (strs[0].equals("0")) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    static int[] arr;

    static int find(int x) {
        if (x == arr[x]) {
            return x;
        } else {
            return find(arr[x]);
        }
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }

        return;
    }

}

class b1717_set_집합의표현_메모리초과 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        LinkedList<Set<Integer>> setList = new LinkedList<>();

        String[] nums;
        int a = 0, b = 0;
        for (int i = 0; i < m; i++) {
            nums = br.readLine().split(" ");

            a = Integer.parseInt(nums[1]);
            b = Integer.parseInt(nums[2]);

            Set<Integer> a_set = null, b_set = null;

            for (Set<Integer> s : setList) {
                if (s.contains(a)) {
                    a_set = s;
                }
                if (s.contains(b)) {
                    b_set = s;
                }
            }

            if (nums[0].equals("0")) {
                if (a_set == null && b_set == null) {
                    HashSet<Integer> new_set = new HashSet<>();
                    new_set.add(a);
                    new_set.add(b);
                    setList.add(new_set);
                } else if (a_set == null) {
                    b_set.add(a);
                } else if (b_set == null) {
                    a_set.add(b);
                } else {
                    HashSet<Integer> sum_set = new HashSet<>();
                    for (int in : a_set) {
                        sum_set.add(in);
                    }
                    for (int in : b_set) {
                        sum_set.add(in);
                    }

                    setList.remove(a_set);
                    setList.remove(b_set);
                    setList.add(sum_set);
                }
            } else if (nums[0].equals("1")) {
                if (a_set == b_set) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}