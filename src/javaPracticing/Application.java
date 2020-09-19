package javaPracticing;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {
        List<DashBoard> dashBoardList = new ArrayList<>();

        dashBoardList.add(new DashBoard("narrow", "long"));
        dashBoardList.add(new DashBoard("narrow", "short"));
        dashBoardList.add(new DashBoard("narrow", "short"));
        //
        dashBoardList.add(new DashBoard("narrow", "short"));
        dashBoardList.add(new DashBoard("narrow", "short"));
        dashBoardList.add(new DashBoard("narrow", "long"));
        //
        dashBoardList.add(new DashBoard("narrow", "long"));
        dashBoardList.add(new DashBoard("narrow", "long"));
        //
        dashBoardList.add(new DashBoard("narrow", "long"));
        dashBoardList.add(new DashBoard("narrow", "short"));
        //
        dashBoardList.add(new DashBoard("narrow", "short"));
        dashBoardList.add(new DashBoard("narrow", "long"));
        //
        dashBoardList.add(new DashBoard("narrow", "long"));
        //
        dashBoardList.add(new DashBoard("wide", "short"));
        //
        dashBoardList.add(new DashBoard("narrow", "short"));
        dashBoardList.add(new DashBoard("narrow", "short"));
        dashBoardList.add(new DashBoard("narrow", "short"));
        dashBoardList.add(new DashBoard("narrow", "short"));

        setType(dashBoardList);

        for(DashBoard d : dashBoardList){
            System.out.println(d.width.charAt(0)+" "+ d.height.charAt(0)+" "+d.type);
        }
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
                        longStack =0;
                        shortStack =0;
                        prev = iterator.previous();
                        prev.type=2;
                        prev = iterator.previous();
                        prev.type =1;
                        iterator.next();
                        iterator.next();
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
    String width;
    String height;
    int type;

    public DashBoard(String w, String h){
        this.width = w;
        this.height = h;
    }
}
