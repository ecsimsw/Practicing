package javaPracticing.java20final;

public enum AgeRange1 {
	AGE_6_TO_8, 
	AGE_9_TO_11,
	AGE_12_TO_14, 
	AGE_15_TO_18,
	AGE_19_TO_29, 
	AGE_30_TO_49,
	AGE_50_TO_64, 
	AGE_65_TO_74,
	AGE_75_HIGHER;

	// String "6~8" -> AgeRange AGE_6_TO_8
	public static AgeRange1 nameOf(String value) {
	switch(value) {
	case "6~8":
	return AGE_6_TO_8;
	case "9~11":
	return 	AGE_9_TO_11;
	case "12~14":
	return 	AGE_12_TO_14;
	case "15~18":
	return 	AGE_15_TO_18;
	case "19~29":
	return 	AGE_19_TO_29;
	case "30~49":
	return 	AGE_30_TO_49;
	case "50~64":
	return 	AGE_50_TO_64;
	case "65~74":
	return 	AGE_65_TO_74;
	case "75~":
	return 	AGE_75_HIGHER;
	
	default : return null;
	}
	}	//nameOf메서드는 csv파일에서 읽어온 나이의 범위를 String 타입으로 받아옴을 알 수 있다 그러한 데이터를 enum형식의 데이터로 변경하여 반환하는 메서드이다.
}
