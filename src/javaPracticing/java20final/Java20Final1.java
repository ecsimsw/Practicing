package javaPracticing.java20final;

public class Java20Final1 {
	public static void main(String[] args) {
		// load data to manager
		DietaryReferenceIntakeManager1 Dritm = new DietaryReferenceIntakeManager1("C:\\Users\\김선홍\\Desktop\\java20-1-final-template\\JAVA20-FINAL.CSV");
		//csv파일을 읽어오는 코드로 파일의 위치를 지정하여 DietaryReferenceIntakeManager1의 생성자를 통해 파일을 읽어옴을 알 수 있다.
		
		// start frame
		DieraryReferenceIntakeFindFrame1 Dritff = new DieraryReferenceIntakeFindFrame1("김동현",Dritm);
		//Frame을 상속하는 객체를 생성하여 프레임을 화면에 띄울수 있게 하는 코드이다.
	}
}