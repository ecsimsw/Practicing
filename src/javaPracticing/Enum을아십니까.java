package javaPracticing;

public class Enum을아십니까 {
    public static void main(String[] args){
        System.out.println(VehicleType.valueOf("BUS") == VehicleType.BUS);
        System.out.println(VehicleType.valueOf("BUS").equals(VehicleType.BUS));

        System.out.println(VehicleType.valueOf("BUS"));
        System.out.println(VehicleType.values());

        System.out.println(VehicleType.BUS.price);
        System.out.println(VehicleType.BUS.compareTo(VehicleType.TAXI));
        System.out.println(VehicleType.BUS.ordinal());
        System.out.println(VehicleType.BUS.name());
        System.out.println(VehicleType.BUS.calculateFee(3));
        VehicleType.BUS.run();
    }
}

enum VehicleType{
    BUS(1500, ()-> System.out.println("DRIVING")){
        @Override
        int calculateFee(int person) {
            return person * price;
        }
    },
    AIRPLANE(500000, ()->System.out.println("FLYING")){
        @Override
        int calculateFee(int person) {
            int additionalFee = 30000;
            return person * price + additionalFee*person;
        }
    },
    TAXI(30000, ()->System.out.println("DRIVING")) {
        @Override
        int calculateFee(int person) {
            return price;
        }
    };

//    private  int price;    Non-static field 'price' cannot be referenced from a static context
    protected int price;
    protected Runnable go;

    VehicleType(int price, Runnable go){
        this.price = price;
        this.go = go;
    }

    abstract int calculateFee(int person);

    void run(){
        go.run();
    }
}

class MyEnum을아십니까 {
    public static void main(String[] args){
        System.out.println(VehicleType.valueOf("BUS") == VehicleType.BUS);
        System.out.println(VehicleType.valueOf("BUS").equals(VehicleType.BUS));

        System.out.println(VehicleType.valueOf("BUS"));
        System.out.println(VehicleType.values());

        System.out.println(VehicleType.BUS.price);
        System.out.println(VehicleType.BUS.compareTo(VehicleType.TAXI));
        System.out.println(VehicleType.BUS.ordinal());
        System.out.println(VehicleType.BUS.name());
        System.out.println(VehicleType.BUS.calculateFee(3));
        VehicleType.BUS.run();

        MyVehicleType myVehicleType = MyVehicleType.BUS;

    }
}

abstract class MyEnum{
    private int index;
    int ordinal;
    String name;

    protected MyEnum(){ }

    protected String name(){
        return name;
    }

    protected int ordinal(){
        return ordinal;
    }
}

abstract class MyVehicleType extends MyEnum{
    static final MyVehicleType BUS = new MyVehicleType(1500, ()->System.out.println("DRIVING")){
        @Override
        int calculateFee(int person) {
            return person * price;
        }
    };
    public static final MyVehicleType AIRPLANE = new MyVehicleType(500000, ()-> System.out.println("FLYING")){
        @Override
        int calculateFee(int person) {
            int additionalFee = 30000;
            return person * price + additionalFee*person;
        }
    };
    public static final MyVehicleType TAXI = new MyVehicleType(30000, ()-> System.out.println("DRIVING")){
        @Override
        int calculateFee(int person) {
            return price;
        }
    };

    int price;
    Runnable go;

    MyVehicleType(int price, Runnable go){
        this.price = price;
        this.go = go;
    }

    abstract int calculateFee(int person);

    void run(){
        go.run();
    }
}

