package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b5430_큐_AD {
    static public void main(String[] args ) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        for(int i = 0; i<n; i++){
            String line = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String arrString = br.readLine();

            LinkedList<Integer> queue = new LinkedList<>();

            if(count !=0) {
                String[] splited = arrString.split("\\[");
                splited = splited[1].split("\\]");

                String numString = splited[0];
                String[] numArr = numString.split(",");

                for (int j = 0; j < count; j++) {
                    queue.addLast(Integer.parseInt(numArr[j]));
                }
            }

            boolean isReversed = false;
            boolean instructionEnd = false;

            for(char c : line.toCharArray()){
                if(c == 'R'){
                    isReversed = isReversed == true ? false : true;
                }
                else if(c == 'D'){
                    if(queue.isEmpty()){
                        sb.append("error\n");
                        instructionEnd= true;
                        break;
                    }
                    if(!isReversed){ queue.pollFirst();}
                    if(isReversed){ queue.pollLast();}
                }
            }
            if(!instructionEnd){
                sb.append("[");

                if(!isReversed){
                    if(queue.size()>=1){
                        while(queue.size()>1){
                            sb.append(queue.pollFirst()+",");
                        }
                        sb.append(queue.pollFirst());
                    }
                    sb.append("]\n");
                }
                else if(isReversed){
                    if(queue.size()>=1){
                        while(queue.size()>1){
                            sb.append(queue.pollLast()+",");
                        }
                        sb.append(queue.pollLast());
                    }
                    sb.append("]\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
