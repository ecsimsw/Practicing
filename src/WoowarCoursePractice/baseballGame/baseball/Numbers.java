package WoowarCoursePractice.baseballGame.baseball;

import java.util.List;
import java.util.stream.Stream;

public class Numbers {
    public static int MIN = 1;
    public static int MAX = 9;
    public static int LEN = 3;

    private final List<Integer> numberList;

    public Numbers(List numberList){
        this.numberList = numberList;
    }

    public Stream<Integer> getStream(){
        return numberList.stream();
    }

    public int get(int index){
        return numberList.get(index);
    }

    public int indexOf(int object){
        return numberList.indexOf(object);
    }

    public boolean contains(int object){
        return numberList.contains(object);
    }
}
