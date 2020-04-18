package Elements_Search;

import java.util.Scanner;
public class UserInput {
    private static Scanner input = new Scanner(System.in);

    public static String getString() {
        return input.nextLine();
    }

    public static int getInteger() {
        int value = 0;
        value = Integer.parseInt(input.nextLine());
        return value;
    }


    public static double getDouble() {
        double value = 0.0;
        value = Double.parseDouble(input.nextLine());
        return value;
    }

    public static char getKey() {
        System.out.println("Press q-key to exit or enter-key to continue : ");
        String str = input.nextLine();
        if(str.contentEquals("q"))
            return 'q';
        else if(str.contentEquals("p"))
            return 'p';
        else if(str.contentEquals("n"))
            return 'n';
        else
            return ' ';

    }

    public static boolean getExitKey() {
        System.out.print("Press q-key to exit or enter-key to continue : ");
        String str = input.nextLine();
        if(str.contentEquals("q"))
            return true;
        else
            return false;
    }

    //getElement from user input(String -> Element)  "1" or "HYDROGEN" -> HYDROGEN
    public static Element getElement() {
        Element element = null;

        int inputNumber = 0;
        String inputName ="";

        String str = input.nextLine();

        if(Application.isNumberic(str)){
            inputNumber = Integer.parseInt(str);

            Element[] elements = Element.values();

            if(inputNumber<1 || inputNumber > elements.length)
            {
                return null;
            }

            element = elements[inputNumber-1];

            return element;
        }

        else{
            inputName = str.toUpperCase();

            Element[] elements = Element.values();

            boolean inElement = false;

            for(Element e : elements){
                if(e.name().equals(inputName)){
                    inElement = true;
                    break;
                }
            }

            if(inElement){
                element = Element.valueOf(inputName);
                return element;
            }
            else{
                return null;
            }
        }
    }

    public static String getString1() {
        return input.next();
    }

    public static int getInteger1() {
        int value = 0;
        value = input.nextInt();
        return value;
    }

    public static double getDouble1() {
        double value = 0.0;
        value = input.nextDouble();
        return value;
    }
}


