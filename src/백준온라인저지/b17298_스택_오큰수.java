package 백준온라인저지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class b17298_스택_오큰수 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int[] oNums;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        readNums(n);

        initializeONums(n);

        setONums();

        for (int o : oNums) {
            sb.append(o + " ");
        }
        System.out.print(sb.toString());
    }

    private static void readNums(int n) throws IOException {
        String[] nums = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
    }

    private static void initializeONums(int n) {
        oNums = new int[n];
        Arrays.fill(oNums, -1);
    }

    private static void setONums() {
        Stack<Integer> stack = new Stack<>();

        int searchIndex = 0;
        stack.push(searchIndex);

        for (searchIndex = 1; searchIndex < arr.length; searchIndex++) {
            while (arr[stack.peek()] < arr[searchIndex]) {
                oNums[stack.pop()] = arr[searchIndex];
                if (stack.isEmpty()) {
                    break;
                }
            }
            stack.push(searchIndex);
        }
    }
}


class b17298_구현_오큰수_시간초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] oNums = new int[n];
        Arrays.fill(oNums, -1);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            int one = arr[i];
            for (int j = i; j < n; j++) {
                if (arr[j] > one) {
                    oNums[i] = arr[j];
                    break;
                }
            }
        }

        for (int o : oNums) {
            System.out.print(o + " ");
        }
    }
}
