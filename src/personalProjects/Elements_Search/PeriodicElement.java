package personalProjects.Elements_Search;

public class PeriodicElement {
    private int number;
    private String symbol;
    private String name;
    private double weight;

    //constructor
    public PeriodicElement(int number, String symbol, String name, double weight) {
        super();
        this.number = number;
        this.symbol = symbol;
        this.name = name;
        this.weight = weight;
    }


    //getter and setter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override //object toString() override
    public String toString() {
        return "PeriodicElement [number=" + number + ", symbol=" + symbol + ", name=" + name + ", weight=" + weight+ "]";
    }

    public static State getState(PeriodicElement element) {
        if(element.number==35)
            return State.LIQUID;
        else if(element.number==1 || element.number==2 ||element.number==7 ||
                element.number==8 ||element.number==9 ||element.number==10 ||
                element.number==17 ||element.number==18 ||element.number==36)
            return State.GAS;
        else return State.SOLID;
    }

//utility method (String -> PeriodicElement) 1 H 수소 1.008 =>PeriodicElement

    public static PeriodicElement parasePeriodicElement(String line) {
        PeriodicElement element=null; //local variable
        String[] fields = line.split(" ");
        //...
        return element;
    }
}
