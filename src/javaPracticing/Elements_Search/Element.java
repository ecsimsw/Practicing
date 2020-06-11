package javaPracticing.Elements_Search;

public enum Element {
    HYDROGEN(1),
    HELIUM(2),
    LITHIUM(3),
    BERYLLIUM(4),
    BORON(5),
    CARBON(6),
    NITROGEN(7),
    OXYGEN(8),
    FLUORINE(9),
    NEON(10),
    SODIUM(11),
    MAGNESIUM(12),
    ALUMINIUM(13),
    SILICON(14),
    PHOSPHORUS(15),
    SULFUR(16),
    CHLORINE(17),
    ARGON(18),
    POTASSIUM(19),
    CALCIUM(20),
    SCANDIUM(21),
    TITANIUM(22),
    VANADIUM(23),
    CHROMIUM(24),
    MANGANESE(25),
    IRON(26),
    COBALT(27),
    NICKEL(28),
    COPPER(29),
    ZINC(30),
    GALLIUM(31),
    GERMANIUM(32),
    ARSENIC(33),
    SELENIUM(34),
    BROMINE(35),
    KRYPTON(36),
    RUBIDIUM(37),
    STRONTIUM(38),
    YTTRIUM(39),
    ZIRCONIUM(40),
    NIOBIUM(41),
    MOLYBDENUM(42),
    TECHNETIUM(43),
    RUTHENIUM(44),
    RHODIUM(45),
    PALLADIUM(46),
    SILVER(47),
    CADMIUM(48),
    INDIUM(49),
    TIN(50);

    private final int value;

    Element(int value){
        this.value = value;
    }

    //get value
    public int getValue() {
        return value;
    }
}
