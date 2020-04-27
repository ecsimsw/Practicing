package javaPracticing;


import java.util.*;

public class Application {
    public static void main(String[] args){

        Car[] cars = new Car[]{new Car(11,2),new Car(15,4), new Car(4,1), new Car(11,5)};

        Arrays.sort(cars);

        for(Car c : cars){
            System.out.print(c.fuelEfficiency + "   ");
        }
        System.out.println();

        Arrays.sort(cars, new CmpCarAges());

        for(Car c : cars){
            System.out.print(c.age + "   ");
        }
        System.out.println();

        CmpCarAges cmpCarAges = new CmpCarAges();
        System.out.print(cmpCarAges.compare(new Car(1,2) , new Car(1,3)));
    }
}
class Car implements Comparable{
    int fuelEfficiency;
    int age;

    @Override
    public int compareTo(Object o) {
        if(o instanceof Car){
            Car car = (Car)o;
            int originRule = (this.fuelEfficiency > car.fuelEfficiency)?1 : (this.fuelEfficiency<car.fuelEfficiency)? -1: 0;
            return -originRule;
        }
        return 0;
    }

    public Car(int fe, int age){
        this.fuelEfficiency = fe;
        this.age = age;
    }
}

class CmpCarAges implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Car && o2 instanceof Car)
            return ((Car) o1).age > ((Car) o2).age ? 1 : ((Car)o1).age < ((Car)o2).age ? -1 : 0;
        return 0;
    }
}