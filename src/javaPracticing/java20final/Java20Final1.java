package javaPracticing.java20final;

public class Java20Final1 {
	public static void main(String[] args) {
		// load data to manager
		DietaryReferenceIntakeManager1 Dritm = new DietaryReferenceIntakeManager1("C:\\Users\\�輱ȫ\\Desktop\\java20-1-final-template\\JAVA20-FINAL.CSV");
		//csv������ �о���� �ڵ�� ������ ��ġ�� �����Ͽ� DietaryReferenceIntakeManager1�� �����ڸ� ���� ������ �о���� �� �� �ִ�.
		
		// start frame
		DieraryReferenceIntakeFindFrame1 Dritff = new DieraryReferenceIntakeFindFrame1("�赿��",Dritm);
		//Frame�� ����ϴ� ��ü�� �����Ͽ� �������� ȭ�鿡 ���� �ְ� �ϴ� �ڵ��̴�.
	}
}