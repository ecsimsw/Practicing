package java20final;

public class DietaryReferenceIntake1 {
	private Gender1 gender;
	private AgeRange1 age;
	private int protein; // (g)
	private int fiber; // (g)
	private int water; // (ml)
	private int vitaminC; // (mg) 
	private double thiamine; // (mg) vitamin B1 C12H17N4OS+ 265.35 g 
	private double riboflavin; // (mg) vitamin B2 C17H20N4O6
	private int niacin; // (mg NE) vitamin B3 C6H5NO2
	private double vitaminB6; // (mg) vitamin B6
	private int folacin; // (μg DFE) vitamin B9
	private double vitaminB12; // (μg) 
	private int pantothenic; // (mg) vitamin B5
	private int biotin; // (μg) vitamin B7
	private int vitaminA; // (μg RAE) 
	private int vitaminD; // (μg) 
	private int vitaminE; // (mg α-TE) 
	private int vitaminK; // (μg)
	private int calcium; // (mg)	
	private int phosphorus; // (mg)
	private double sodium; // (g)
	private double chlorine; // (g)
	private double potassium; // (g)
	private int magnesium; // (mg)
	private int iron; // (mg)
	private int zinc; // (mg)
	private int copper; // (μg)
	private double fluorine; // (mg)
	private double manganese; // (mg)
	private int iodine; // (μg)
	private int selenium; // (μg)
	
	//생성자로 모든 변수를 매개변수로 받아 각각의 데이터를 this변수에 넣어주는 코드
	public DietaryReferenceIntake1(Gender1 gender, AgeRange1 age, int protein, int fiber, int water, int vitaminC,
			double thiamine, double riboflavin, int niacin, double vitaminB6, int folacin, double vitaminB12,
			int pantothenic, int biotin, int vitaminA, int vitaminD, int vitaminE, int vitaminK, int calcium,
			int phosphorus, double sodium, double chlorine, double potassium, int magnesium, int iron, int zinc,
			int copper, double fluorine, double manganese, int iodine, int selenium) {
		this.gender = gender;
		this.age = age;
		this.protein = protein;
		this.fiber = fiber;
		this.water = water;
		this.vitaminC = vitaminC;
		this.thiamine = thiamine;
		this.riboflavin = riboflavin;
		this.niacin = niacin;
		this.vitaminB6 = vitaminB6;
		this.folacin = folacin;
		this.vitaminB12 = vitaminB12;
		this.pantothenic = pantothenic;
		this.biotin = biotin;
		this.vitaminA = vitaminA;
		this.vitaminD = vitaminD;
		this.vitaminE = vitaminE;
		this.vitaminK = vitaminK;
		this.calcium = calcium;
		this.phosphorus = phosphorus;
		this.sodium = sodium;
		this.chlorine = chlorine;
		this.potassium = potassium;
		this.magnesium = magnesium;
		this.iron = iron;
		this.zinc = zinc;
		this.copper = copper;
		this.fluorine = fluorine;
		this.manganese = manganese;
		this.iodine = iodine;
		this.selenium = selenium;
	}
	
	@Override
	public String toString() {
		return  protein + ","+ fiber + "," + water + "," + vitaminC + "," + thiamine + ","
				+ riboflavin + "," + niacin + "," + vitaminB6 + "," + folacin
				+ "," + vitaminB12 + "," + pantothenic + "," + biotin + ","
				+ vitaminA + "," + vitaminD + "," + vitaminE + "," + vitaminK
				+ "," + calcium + "," + phosphorus + "," + sodium + ","
				+ chlorine + "," + potassium + "," + magnesium + "," + iron + ","
				+ zinc + "," + copper + "," + fluorine + "," + manganese + ","
				+ iodine + "," + selenium ;
	}	//toString은 textfields를 set하기위해 사용할 코드로 gender와 age의 값은 넣어주지 않았다.

	//변수들을 각각 반환하고 지정하는 getter/setter 코드
	public Gender1 getGender() {
		return gender;
	}
	
	public void setGender(Gender1 gender) {
		this.gender = gender;
	}

	public AgeRange1 getAge() {
		return age;
	}

	public void setAge(AgeRange1 age) {
		this.age = age;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getFiber() {
		return fiber;
	}

	public void setFiber(int fiber) {
		this.fiber = fiber;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getVitaminC() {
		return vitaminC;
	}

	public void setVitaminC(int vitaminC) {
		this.vitaminC = vitaminC;
	}

	public double getThiamine() {
		return thiamine;
	}

	public void setThiamine(double thiamine) {
		this.thiamine = thiamine;
	}

	public double getRiboflavin() {
		return riboflavin;
	}

	public void setRiboflavin(double riboflavin) {
		this.riboflavin = riboflavin;
	}

	public int getNiacin() {
		return niacin;
	}

	public void setNiacin(int niacin) {
		this.niacin = niacin;
	}

	public double getVitaminB6() {
		return vitaminB6;
	}

	public void setVitaminB6(double vitaminB6) {
		this.vitaminB6 = vitaminB6;
	}

	public int getFolacin() {
		return folacin;
	}

	public void setFolacin(int folacin) {
		this.folacin = folacin;
	}

	public double getVitaminB12() {
		return vitaminB12;
	}

	public void setVitaminB12(double vitaminB12) {
		this.vitaminB12 = vitaminB12;
	}

	public int getPantothenic() {
		return pantothenic;
	}

	public void setPantothenic(int pantothenic) {
		this.pantothenic = pantothenic;
	}

	public int getBiotin() {
		return biotin;
	}

	public void setBiotin(int biotin) {
		this.biotin = biotin;
	}

	public int getVitaminA() {
		return vitaminA;
	}

	public void setVitaminA(int vitaminA) {
		this.vitaminA = vitaminA;
	}

	public int getVitaminD() {
		return vitaminD;
	}

	public void setVitaminD(int vitaminD) {
		this.vitaminD = vitaminD;
	}

	public int getVitaminE() {
		return vitaminE;
	}

	public void setVitaminE(int vitaminE) {
		this.vitaminE = vitaminE;
	}

	public int getVitaminK() {
		return vitaminK;
	}

	public void setVitaminK(int vitaminK) {
		this.vitaminK = vitaminK;
	}

	public int getCalcium() {
		return calcium;
	}

	public void setCalcium(int calcium) {
		this.calcium = calcium;
	}

	public int getPhosphorus() {
		return phosphorus;
	}

	public void setPhosphorus(int phosphorus) {
		this.phosphorus = phosphorus;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	public double getChlorine() {
		return chlorine;
	}

	public void setChlorine(double chlorine) {
		this.chlorine = chlorine;
	}

	public double getPotassium() {
		return potassium;
	}

	public void setPotassium(double potassium) {
		this.potassium = potassium;
	}

	public int getMagnesium() {
		return magnesium;
	}

	public void setMagnesium(int magnesium) {
		this.magnesium = magnesium;
	}

	public int getIron() {
		return iron;
	}

	public void setIron(int iron) {
		this.iron = iron;
	}

	public int getZinc() {
		return zinc;
	}

	public void setZinc(int zinc) {
		this.zinc = zinc;
	}

	public int getCopper() {
		return copper;
	}

	public void setCopper(int copper) {
		this.copper = copper;
	}

	public double getFluorine() {
		return fluorine;
	}

	public void setFluorine(double fluorine) {
		this.fluorine = fluorine;
	}

	public double getManganese() {
		return manganese;
	}

	public void setManganese(double manganese) {
		this.manganese = manganese;
	}


	public int getIodine() {
		return iodine;
	}

	public void setIodine(int iodine) {
		this.iodine = iodine;
	}

	public int getSelenium() {
		return selenium;
	}

	public void setSelenium(int selenium) {
		this.selenium = selenium;
	}
	
	// String[] toTextfields()
	public String[] toTextfields() {
		String[] results = new String[29];
		results[0] = "" + protein;
		results[1] = "" + fiber;
		results[2] = "" + water;
		results[3] = "" + vitaminC;
		results[4] = "" + thiamine;
		results[5] = "" + riboflavin;
		results[6] = "" + niacin;
		results[7] = "" + vitaminB6;
		results[8] = "" + folacin;
		results[9] = "" + vitaminB12;
		results[10] = "" + pantothenic;
		results[11] = "" + biotin;
		results[12] = "" + vitaminA;
		results[13] = "" + vitaminD;
		results[14] = "" + vitaminE;
		results[15] = "" + vitaminK;
		results[16] = "" + calcium;
		results[17] = "" + phosphorus;
		results[18] = "" + sodium;
		results[19] = "" + chlorine;
		results[20] = "" + potassium;
		results[21] = "" + magnesium;
		results[22] = "" + iron;
		results[23] = "" + zinc;
		results[24] = "" + copper;
		results[25] = "" + fluorine;
		results[26] = "" + manganese;
		results[27] = "" + iodine;
		results[28] = "" + selenium;
		return results;
	}
	
	// utility method (String[] -> DietaryReferenceIntake)
	//String[] 타입으로 받은 정보를 DietaryReferenceIntake 타입으로 변환하여 반환하는 코드
	public static DietaryReferenceIntake1 parse(String[] fields) {
		 Gender1 gender = fields[0].equals("FEMALE") ? Gender1.FEMALE : Gender1.MALE;	
         AgeRange1 age = AgeRange1.nameOf(fields[1]);
         int protein = Integer.parseInt(fields[2]);
         int fiber = Integer.parseInt(fields[3]);
         int water = Integer.parseInt(fields[4]);
         int viaminC = Integer.parseInt(fields[5]);
         double thiamine = Double.parseDouble(fields[6]);
         double riboflavin = Double.parseDouble(fields[7]);
         int niacin = Integer.parseInt(fields[8]);
         double vitaminB6= Double.parseDouble(fields[9]);
         int folacin = Integer.parseInt(fields[10]);
          double vitaminB12 = Double.parseDouble(fields[11]);
          int pantothenic = Integer.parseInt(fields[12]);
          int biotin = Integer.parseInt(fields[13]);
          int vitaminA = Integer.parseInt(fields[14]);
          int vitaminD = Integer.parseInt(fields[15]);
          int vitaminE = Integer.parseInt(fields[16]); 
          int vitaminK = Integer.parseInt(fields[17]);
          int calcium = Integer.parseInt(fields[18]);   
          int phosphorus = Integer.parseInt(fields[19]);
          double sodium = Double.parseDouble(fields[20]);
          double chlorine = Double.parseDouble(fields[21]);
          double potassium = Double.parseDouble(fields[22]);
          int magnesium = Integer.parseInt(fields[23]);
          int iron = Integer.parseInt(fields[24]);
          int zinc = Integer.parseInt(fields[25]);
          int copper = Integer.parseInt(fields[26]);
          double fluorine = Double.parseDouble(fields[27]);
          double manganese = Double.parseDouble(fields[28]);
          int iodine = Integer.parseInt(fields[29]);
          int selenium = Integer.parseInt(fields[30]);
      
         return new DietaryReferenceIntake1(gender, age, protein, fiber, water, viaminC, thiamine, riboflavin,  niacin,  vitaminB6,  folacin,  vitaminB12,
                pantothenic,  biotin,  vitaminA,  vitaminD,  vitaminE,  vitaminK,  calcium,
                phosphorus,  sodium,  chlorine,  potassium,  magnesium,  iron,  zinc,
                copper,  fluorine,  manganese,  iodine,  selenium);
      }
	}

