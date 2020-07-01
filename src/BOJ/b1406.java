package BOJ;
import java.io.*;
import java.util.*;

public class b1406 {
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