package javaPracticing;

import java.util.ArrayList;
import java.util.List;

class Typesafe한_자바의Enum {
    public static void main(String[] args) {
//        UserInputButton input = getUserInput();
//
//        if(input == 0){
//            // Typesafe하지 않는, 0은 매직 넘버
//        }
//
//        if(input == MyErrorCode.IllegalArgumentException){
//            // Typesafe하지 않는, 비논리적
//        }
//
//        if(input == UserInputButton.Yes){
//            // Typesafe한
//        }
    }

    enum DayOfWeek {
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }

    enum Numbers {
        One,
        Two,
        Three,
        Four,
        Five
    }

    enum UserInputButton {
        Yes, No
    }
}


public class Enum을아십니까 {
    public static void main(String[] args) {
        System.out.println(VehicleType.valueOf("BUS") == VehicleType.BUS);
        System.out.println(VehicleType.valueOf("BUS").equals(VehicleType.BUS));

        System.out.println(VehicleType.values());

        System.out.println(VehicleType.BUS.price);
        System.out.println(VehicleType.BUS.ordinal());
        System.out.println(VehicleType.BUS.name());
        System.out.println(VehicleType.BUS.calculateFee(3));
        System.out.println(VehicleType.BUS.compareTo(VehicleType.TAXI));
        VehicleType.BUS.run();
    }
}

enum VehicleType {
    BUS(1500, () -> System.out.println("DRIVING")) {
        @Override
        int calculateFee(int person) {
            return person * price;
        }
    },
    AIRPLANE(500000, () -> System.out.println("FLYING")) {
        @Override
        int calculateFee(int person) {
            int additionalFee = 30000;
            return person * price + additionalFee * person;
        }
    },
    TAXI(30000, () -> System.out.println("DRIVING")) {
        @Override
        int calculateFee(int person) {
            return price;
        }
    };

    //    private  int price;    Non-static field 'price' cannot be referenced from a static context -> 익명클래스라
    protected int price;
    protected Runnable go;

    VehicleType(int price, Runnable go) {
        this.price = price;
        this.go = go;
    }

    abstract int calculateFee(int person);

    void run() {
        go.run();
    }
}

class MyEnum을아십니까 {
    public static void main(String[] args) {
        MyVehicleType bus = MyVehicleType.BUS;
        System.out.println(bus.equals(MyVehicleType.AIRPLANE));
        System.out.println(MyVehicleType.BUS.name());
        System.out.println(MyVehicleType.values());
        System.out.println(MyVehicleType.BUS.ordinal());
        System.out.println(MyVehicleType.AIRPLANE.ordinal());

        System.out.println(MyVehicleType.BUS.compareTo(MyVehicleType.AIRPLANE));
    }
}

abstract class MyEnum<T extends MyEnum> implements Comparable<T> {
    private static int index = 0;
    private static List<MyEnum> enumList = new ArrayList<>();
    private int ordinal;
    private String name;

    protected MyEnum(String name) {
        this.name = name;
        enumList.add(this);
        ordinal = index++;
    }

    protected String name() {
        return name;
    }

    protected int ordinal() {
        return ordinal;
    }

    @Override
    public boolean equals(Object object) {
        return object == this;
    }

    public static List<MyEnum> values() {
        return enumList;
    }

    public MyEnum valueOf(String name) {
        return enumList.stream()
                .filter(e -> e.name.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int compareTo(T o) {
        return this.ordinal - o.ordinal();
    }
}

abstract class MyVehicleType extends MyEnum {
    public static final MyVehicleType BUS = new MyVehicleType("BUS", 1500, () -> System.out.println("DRIVING")) {
        @Override
        int calculateFee(int person) {
            return person * price;
        }
    };
    public static final MyVehicleType AIRPLANE = new MyVehicleType("AIRPLANE", 500000, () -> System.out.println("FLYING")) {
        @Override
        int calculateFee(int person) {
            int additionalFee = 30000;
            return person * price + additionalFee * person;
        }
    };
    public static final MyVehicleType TAXI = new MyVehicleType("TAXI", 30000, () -> System.out.println("DRIVING")) {
        @Override
        int calculateFee(int person) {
            return price;
        }
    };

    protected int price;
    protected Runnable go;

    MyVehicleType(String name, int price, Runnable go) {
        super(name);
        this.price = price;
        this.go = go;
    }

    abstract int calculateFee(int person);

    void run() {
        go.run();
    }
}

