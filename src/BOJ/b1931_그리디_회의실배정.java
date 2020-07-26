package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1931_그리디_회의실배정 {
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
