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