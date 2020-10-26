package javaPracticing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {
                long start = 0;
                long end = 0;

                int inRoopSize = 100;
                int maxRoopSize = 10000000;

                ArrayList<Integer> list = new ArrayList<Integer>();
                ArrayList<Double> result = new ArrayList<Double>();

                Double[] arr = new Double[10000000];

                for (int i = 0; i < maxRoopSize; i++)
                    list.add(i);

                // Iterator 사용 시 실행 시간
                Iterator<Integer> itr = list.iterator();
                int sum =0;
                int last = 0;
                while (itr.hasNext()) {
                    last = itr.next();
                }
                System.out.println("----Iterator 사용 시----" + last);
                for (int idx = 0; idx < inRoopSize; idx++) {
                    start = System.nanoTime(); // 시작시간
                    sum += last;
                    end = System.nanoTime(); // 끝나는 시간
                }

                System.out.println( ((double)(end - start)/100000) + "(sec)");
                System.out.println(sum);

                result = new ArrayList<Double>();

                // Size 받아온 코드 실행 시간

                sum = 0;
                System.out.println("-----Size 받아오는 방법 사용 시----- "+ list.get(list.size()-1));
                for (int idx = 0; idx < inRoopSize; idx++) {
                    start = System.nanoTime();
                    int size = list.size();
                    sum += list.get(size-1);
                    end = System.nanoTime();
                }

                System.out.println( ((double)(end - start)/100000) + "(sec)");
                System.out.println(sum);

    }

    static void setType(List<DashBoard> dashBoardList){
        ListIterator<DashBoard> iterator = dashBoardList.listIterator();

        DashBoard now;
        DashBoard prev;
        DashBoard next;

        int shortStack =0;
        int longStack =0;

        while(iterator.hasNext()){
            now=iterator.next();
            if(now.width.equals("wide")){
                now.type=0;
                shortStack =0;
                longStack =0;
            }
            else if(now.width.equals("narrow")){
                if(now.height.equals("short")){
                    if(longStack ==0){
                        now.type=0;
                        shortStack++;
                        if(shortStack == 4) shortStack=0;
                    }
                    else if(longStack == 1) {
                       if(iterator.hasNext()){
                           next = iterator.next();
                           if(next.width.equals("narrow") && next.height.equals("short")){
                               now.type =1;
                               next.type =2;
                               longStack=0;
                               shortStack =0;
                           }
                           else{
                               now.type = 0;
                               longStack =0;
                               shortStack =0;
                               iterator.previous();
                           }
                       }
                       else{
                           now.type = 0;
                           longStack =0;
                           shortStack =0;
                       }
                    }
                }
                else if(now.height.equals("long")){
                    if(shortStack ==0){
                        now.type =0;
                        longStack++;
                        if(longStack == 2){ longStack =0; }
                    }
                    else if(shortStack == 1){
                        now.type=0;
                        longStack =0;
                        shortStack =0;
                    }
                    else if(shortStack == 2){
                        now.type =0;
                        System.out.println("now "+now.width+" "+now.height + " : 0"+" "+now.hashCode());
                        prev = iterator.previous();
                        prev = iterator.previous();
                        prev.type=2;
                        System.out.println("prev "+prev.width+" "+prev.height + " : 2"+" "+prev.hashCode());
                        prev = iterator.previous();
                        prev.type =1;
                        System.out.println("prev "+prev.width+" "+prev.height + " : 1" + " "+prev.hashCode() );

                        iterator.next();
                        iterator.next();
                        longStack =0;
                        shortStack =0;
                    }
                    else if(shortStack == 3){
                        now.type =0;
                        shortStack=0;
                        longStack=1;
                    }
                }
            }

        }
    }
}


class DashBoard{
    static int h =0;

    String width;
    String height;
    int type;
    int hash;

    public DashBoard(String width, String height){
        this.width = width;
        this.height = height;
        this.hash = h++;
    }

    @Override
    public int hashCode(){
        return hash;
    }
}
