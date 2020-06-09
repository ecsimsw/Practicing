package javaPracticing;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.*;

public class ChemicalManagement{
    static public void main(String[] args){

        System.setProperty("file.encoding","UTF-8");
        try{
            Field charset = Charset.class.getDeclaredField("defaultCharset");
            charset.setAccessible(true);
            charset.set(null,null);
        }
        catch(Exception e){
        }

        printInfo();

        boolean onLoop = true;

        while(onLoop){
            System.out.print("Enter file path : ");

            Scanner sc = new Scanner(System.in);
            String filePath = sc.nextLine();
            try {
                java.net.URLDecoder.decode(filePath, "UTF-8");
            }catch (Exception e){
                e.printStackTrace();
            }

            List<String> lines = readText(filePath);

            if(lines != null){
                List<String> parsedLines = parseToCSV(lines);
                boolean result = saveAsCSV(defNewFilePath(filePath), parsedLines);
                printResult(result);
            }

            onLoop = askExecuteAgain();
        }
    }

    static List<String> readText(String filePath){
        List<String> loadedList = new LinkedList<String>();

        BufferedReader br = null;
        FileReader fr = null;
        try{
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);

            while(true) {
                String line = br.readLine();
                if (line==null) {break;}

                loadedList.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }finally {
            if (fr != null) {
                try { fr.close(); }catch (Exception e){ e.printStackTrace(); }
            }
            if (br != null) {
                try { br.close(); }catch (Exception e){ e.printStackTrace(); }
            }
        }
        return loadedList;
    }

    static boolean saveAsCSV(String filePath, List<String> csvLines){
        boolean result = true;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try{
            fos = new FileOutputStream(filePath);
            osw = new OutputStreamWriter(fos, "MS949");
            bw = new BufferedWriter(osw);

            for(String line : csvLines) {
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
            result = false;
        }finally {
            if (bw != null) {
                try { bw.close(); }catch (Exception e){ e.printStackTrace(); }
            }
            if (osw != null) {
                try { osw.close(); }catch (Exception e){ e.printStackTrace(); }
            }
            if (fos != null) {
                try { fos.close(); }catch (Exception e){ e.printStackTrace(); }
            }
        }

        return result;
    }

    static String parseString(String line){

        StringBuilder sb = new StringBuilder();

        try {
            String[] splitedNum = line.split("\\) ");

            String[] splitedNameKor = splitedNum[1].split("\\(");
            String nameKor = splitedNameKor[0];

            sb.append(nameKor);
            sb.append('!');

            String[] splitedNameEng = splitedNameKor[1].split("; ");
            String nameEng = splitedNameEng[0];
            sb.append(nameEng);
            sb.append('!');

            String[] splitedElementNum = splitedNameEng[1].split("\\)");
            String elementNum = splitedElementNum[0];
            if(elementNum.contains("등")){elementNum = elementNum.replaceAll("등","");}
            sb.append(elementNum);

        }catch (Exception e ){
            System.out.println("Error line : " + line);
            return line+"!Null!Null";
        }

        return sb.toString();
    }

    static List<String> parseToCSV(List<String> loadedList){
        List<String> csvLines = new LinkedList<String>();

        System.out.println("");

        for(String str : loadedList){
            csvLines.add(parseString(str));
        }

        return csvLines;
    }

    static String defNewFilePath(String filePath){
        String[] pathSpilted = filePath.split("\\\\");

        StringBuilder newFilePath = new StringBuilder();

        for(int index=0; index<pathSpilted.length-1; index++){
            newFilePath.append(pathSpilted[index]);
            newFilePath.append("\\");
        }

        newFilePath.append(pathSpilted[pathSpilted.length-1].split("\\.")[0] + ".csv");

        return newFilePath.toString();
    }

    static boolean askExecuteAgain(){
        Scanner sc = null;
        boolean again = true;

        while(true){
            System.out.print("\nTry again? ( Y / N ) ");
            sc = new Scanner(System.in);
            String input = sc.nextLine().toUpperCase();

            if(input.equals("Y")){break;}
            else if(input.equals("N")){ again = false; break;}
            else{ System.out.println("Wrong Input.");}
        }

        return again;
    }

    static void printInfo(){
        System.out.println("\nMade by Jinhwan");
        System.out.println("File is saved as CSV file with separator !\n");
    }

    static void printResult(boolean result){
        if(result){
            System.out.println("\nSucceed");
        }else{
            System.out.println("Fail");
        }
    }
}
