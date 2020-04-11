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


    public static boolean getExitKey() {
        System.out.print("Press q-key to exit or enter-key to continue : ");
        String str = input.nextLine();
        if(str.contentEquals("q"))
            return true;
        else
            return false;
    }

    //getElement from user input(String -> Element)  "1" or "HYDROGEN" -> HYDROGEN
    public static Element getElement() throws Exception {
        Element element = null;

        int inputNumber = 0;
        String inputName ="";

        String str = input.nextLine();

        if(Application.isNumberic(str)){  ///// 입력받은게 숫자인지 문자인지 알아야 HYDROGEN인지 1 인지 알거아니야아ㅣㅓㄴㅇ리ㅏㅓㄴㅇㅁ러ㅣㅏ 그래서 내가 만들었다. 어디에? Application에
            inputNumber = Integer.parseInt(str);  /// 숫자면 숫자로 바꿔

            Element[] elements = Element.values(); /// Element 요소를 쭉 배열로 받아. 그럼 HYDROGEN이 배열 몇번이겠어? 0번 인덱스지? 그래서 inputNumber가 1이면 배열의 0번방을 꺼내는거야

            if(inputNumber<1 || inputNumber > elements.length)  /// 입력받은 숫자가 1미만이거나, 요소 개수보다 많으면 돼 안돼? 안돼지 그럼 예외를 날려 어디로 main으로!
            {
                throw new Exception("wrong number");
            }

            element = elements[inputNumber-1];

            return element;
        }
        else{
            inputName = str.toUpperCase();  ////////////////////////// 다 대문자로 바꿔버려@!!!!! 이렇게하면 대소문자 노상관이라구 어이어이

            try{
                element = Element.valueOf(inputName); ////// inputName에 해당 하는 값을 받아, HYDROGEN이면 1
            }
            catch (IllegalArgumentException IAE){ /// 원소가 아닌 이름이 입력되면 예외를 넘기는거야 어디로? main문으로
                 throw IAE;
            }

            System.out.println(element);
        }

        return element;
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


