package Elements_Search;

public class Application {
    private static PeriodicElement[] elements = {
            new PeriodicElement(1, "H", "HYDROGEN", 1.008),
            new PeriodicElement(2, "HE", "HELIUM", 4.0026),
            new PeriodicElement(3, "LI", "LITHIUM", 6.94),
            new PeriodicElement(4, "BE", "BERYLLIUM,", 9.0122),
            new PeriodicElement(5, "B", "BORON", 10.81),
            new PeriodicElement(6, "C", "CARBON", 12.011),
            new PeriodicElement(7, "N", "NITROGEN", 14.007),
            new PeriodicElement(8, "O", "OXYGEN", 15.999),
            new PeriodicElement(9, "F", "FLUORINE", 18.998),
            new PeriodicElement(10, "NE", "NEON", 20.180),
            new PeriodicElement(11, "NA", "SODIUM", 22.990),
            new PeriodicElement(12, "MG", "MAGNESIUM", 24.305),
            new PeriodicElement(13, "AL", "ALUMINIUM", 26.982),
            new PeriodicElement(14, "SI", "SILICON", 28.085),
            new PeriodicElement(15, "P", "PHOSPHORUS", 30.974),
            new PeriodicElement(16, "S", "SULFUR", 32.06),
            new PeriodicElement(17, "CL", "CHLORINE", 35.45),
            new PeriodicElement(18, "AR", "ARGON", 39.948),
            new PeriodicElement(19, "K", "POTASSIUM", 39.098),
            new PeriodicElement(20, "CA", "CALCIUM", 40.078),
            new PeriodicElement(21, "SC", "SCANDIUM", 44.956),
            new PeriodicElement(22, "TI", "TITANIUM", 47.867),
            new PeriodicElement(23, "V", "VANADIUM", 50.942),
            new PeriodicElement(24, "CR", "CHROMIUM", 51.996),
            new PeriodicElement(25, "MN", "MANGANESE", 54.938),
            new PeriodicElement(26, "FE", "IRON", 55.845),
            new PeriodicElement(27, "CO", "COBALT", 58.933),
            new PeriodicElement(28, "NI", "NICKEL", 58.693),
            new PeriodicElement(29, "CU", "COPPER", 63.546),
            new PeriodicElement(30, "ZN", "ZINC", 65.38),
            new PeriodicElement(31, "GA", "GALLIUM", 69.723),
            new PeriodicElement(32, "GE", "GERMANIUM", 72.630),
            new PeriodicElement(33, "AS", "ARSENIC", 74.922),
            new PeriodicElement(34, "SE", "SELENIUM", 78.971),
            new PeriodicElement(35, "BR", "BROMINE", 79.904),
            new PeriodicElement(36, "KR", "KRYPTON", 83.798),
            new PeriodicElement(37, "RB", "RUBIDIUM", 85.468),
            new PeriodicElement(38, "SR", "STRONTIUM", 87.62),
            new PeriodicElement(39, "Y", "YTTRIUM", 88.906),
            new PeriodicElement(40, "ZR", "ZIRCONIUM", 91.224),
            new PeriodicElement(41, "NB", "NIOBIUM", 92.906),
            new PeriodicElement(42, "MO", "MOLYBDENUM", 95.95),
            new PeriodicElement(43, "TC", "TECHNETIUM", 98),
            new PeriodicElement(44, "RU", "RUTHENIUM", 101.07),
            new PeriodicElement(45, "RH", "RHODIUM", 102.91),
            new PeriodicElement(46, "PD", "PALLADIUM", 106.42),
            new PeriodicElement(47, "AG", "SILVER", 107.87),
            new PeriodicElement(48, "CD", "CADMIUM", 112.41),
            new PeriodicElement(49, "IN", "INDIUM", 114.82),
            new PeriodicElement(50, "SN", "TIN", 118.71)
    };

    // find utility method (PeriodicElement[] & Element -> PeriodicElement
    private static PeriodicElement getPeriodicElement(PeriodicElement[] array, Element e) {
        PeriodicElement element = null;
        int elementIndex = e.ordinal();
        element = array[elementIndex];
        return element;
    }

    static boolean isNumberic(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException NFE){
            return false;
        }
    }

    public static void main(String[] args) {
        do {
            System.out.print("Please enter [#] or [name] of PeriodicElement :");

            try {
                Element e = UserInput.getElement();
                PeriodicElement element = getPeriodicElement(elements, e);
                System.out.print(element + " ");

                State state = PeriodicElement.getState(element);
                System.out.println(state);
            }
            catch (IllegalArgumentException IAE){    /// 아까 날린 예외 (이름 잘못 예외)를 여기서 처리해
                System.out.println("Entered wrong name\n");
                continue;   // 다시 받기
            }
            catch (Exception exception){  /// 아까 날린 예외중 남은 예외를 여기서 처리해

                if(exception.getMessage().equals("wrong number")){ // 숫자 오류일 경우
                    System.out.println("Enter number fronm 1 to "+ elements.length+"\n");
                }
                else{   // 무슨 다른 알 수 없는 오류 일 경우
                    System.out.println(exception.getMessage()+"\n");
                }

                continue; // 다시 받기
            }

            System.out.println(); // 줄바꿈
        } while (!UserInput.getExitKey());
    }
}
