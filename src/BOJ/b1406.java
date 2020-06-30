package BOJ;
import java.io.*;
import java.util.*;

public class b1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        int n = Integer.parseInt(in.readLine());

        String[] command = new String[n];

        for(int i=0; i<n; i++){
            command[i] = in.readLine();
        }

        LinkedList<String> strList = new LinkedList<>(Arrays.asList(str.split("")));

        int cursor = strList.size();

        for(String c : command){
            String[] splitedCommand = c.split(" ");

            switch (splitedCommand[0]) {
                case "L":
                    cursor = cursor > 0 ? cursor - 1 : cursor;
                    break;
                case "D":
                    cursor = cursor < strList.size() ? cursor + 1 : cursor;
                    break;
                case "B":
                    if (cursor != 0) {
                        strList.remove(cursor-1);
                        cursor--;
                    }
                    break;
                case "P":
                    strList.add(cursor, splitedCommand[1]);
                    cursor++;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();

        for(String s : strList){
            sb.append(s);
        }
        System.out.print(sb.toString());
    }
}