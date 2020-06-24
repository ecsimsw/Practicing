package java20final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DietaryReferenceIntakeManager1 {
	private List<DietaryReferenceIntake1> list = new ArrayList<>();
	private String[] titles = new String[29];

	// constructor load data and set list & titles
	public DietaryReferenceIntakeManager1(String filename) {	//�������̸� �Ű����ڷ� ������ ��θ� �޾� ���Ͽ� �ִ� ������ �޾ƿ��� �ڵ��̴�.
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filename);			//File io�� ����ϱ����� �о���� FileReader�� ����					
			br = new BufferedReader(fr);						
			String str = br.readLine();							//title�� �����ϱ����� ���� ������ �켱 �о�´�.
			String[] b = str.split(",");						//�о�� �����͸� ,���� �����Ͽ� String[]�� ����
			int c = 0;											//�ε��� ������ ���� ���� ����
			
			for(int j = 2; j<b.length;j++) {					//protein���� �����͸� �����ϱ����� �ε��� 2���� �����ϴ� j���� ����
				titles[c++]= b[j];								//b[j]�� protein titles[c++]�� �ε���0���� �����ϱ����� �ڵ�
			}
			
			while(true) {																		
			str = br.readLine();								//�� �ٿ��� �̹� ������ �о��⿡ �����ٺ��ʹ� �ʿ��� ������ �̴�.							
	
			if(str==null) break;								//�������ٱ��� �� ���� ��� null�� �Ѿ���⶧���� �ݺ��� ����						
			String[] a=str.split(",");							//, ���� �����Ͽ� str�� String[]�� ����		
			list.add(DietaryReferenceIntake1.parse(a));			// ������ String�� DietaryReferenceIntake1 ���·� ��ȯ�Ͽ� list�� ����				
			
			}
		}catch(Exception e) {									//File io�� ����ϱ����ؼ��� ������ try-catch������ ����ؾ� �Ѵ�		
			e.toString();
		}
		
    }
    
	// getTitles
	public String[] getTitles() {	//title�� ����Ǿ� �ִ� ���� ��ȯ�ϴ� �޼���
		return titles;
	}

	// print
	public void print() {	//for-each���� ���� list�� �ִ� �����͸� �ܼ�â�� ����ϴ� �ڵ�
		for (DietaryReferenceIntake1 e : this.list) {
			System.out.println(e);
		}
	}

	// find
	public DietaryReferenceIntake1 find(Predicate<DietaryReferenceIntake1> predicate) {	//predicate�� Ȱ���� ���ǿ� �´� �����͸� ã�� �޼���
		for(DietaryReferenceIntake1 e : list) {											//for-each���� ���� list�� �ϳ��ϳ� e�� �����ϴ� �ڵ�
			if(predicate.test(e))														//predicate.test() �޼��带 �̿��� ���ǿ� ������ if���� �����ϴ� �ڵ�
				return e;																//������ ������ �� �����͸� ��ȯ�ϴ� �ڵ�
		}
		return null;
	}
}
