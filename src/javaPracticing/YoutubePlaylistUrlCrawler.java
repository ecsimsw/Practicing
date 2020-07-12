package javaPracticing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class YoutubePlaylistUrlCrawler {
    static String line;

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();

        try{
            File file = new File("fileDir");
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine()){
                try{
                    line = scan.nextLine();
                    if(line.contains("href=\"")){
                        String[] splited1 = line.split("href=\"");
                        if(splited1[0].contains("id=\"thumbnail\"")) continue;
                        String[] splited2 = splited1[1].split("\">");
                        sb.append("https://www.youtube.com/"+splited2[0]+"\n");
                    }
                }
                catch (Exception e){ }
            }
        }catch (FileNotFoundException e){ }

        System.out.println(sb);
    }
}
