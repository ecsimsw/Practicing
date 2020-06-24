package java20final;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class DieraryReferenceIntakeFindFrame1 extends JFrame implements ActionListener {
	
	static final int NUM = 29; 
	DietaryReferenceIntakeManager1 manager = null; // manager
	
	JPanel panel = new JPanel(new BorderLayout()); // main panel
	JLabel label = new JLabel("Find the dietary reference intake"); 
	JPanel rpanel = new JPanel(); // rpanel
	JRadioButton[] rbuttons = new JRadioButton[2];
	ButtonGroup rgroup = new ButtonGroup();
	String[] agenames = {"6~8", "9~11", "12~14", "15~18", "19~29", "30~49", "50~64", "65~74", "75~"};
	JComboBox<String> combobox = new JComboBox<>(agenames);
	JButton button = new JButton("Find");

	JPanel fpanel = new JPanel(new GridLayout(NUM, 2)); // found panel
	JLabel[] labels = new JLabel[NUM]; 
	JTextField[] textfields = new JTextField[NUM];
	String[] titles = {
			"protein", "fiber", "water", "vitaminC", "thiamine", "riboflavin", "niacin", 
			"vitaminB6", "folacin", "vitaminB12", "pantothenic", "biotin", "vitaminA", "vitaminD",
			"vitaminE", "vitaminK", "calcium", "phosphorus", "sodium", "chlorine", "potassium",
			"magnesium", "iron", "zinc", "copper", "fluorine", "manganese", "iodine", "selenium"};
	
	public DieraryReferenceIntakeFindFrame1(String name, DietaryReferenceIntakeManager1 manager) {
		super(name);
		this.manager = manager;
		//this.titles = manager.getTitles();
		
		// panel add label
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);		
		// rpanel add rbuttons
		rbuttons[0] = new JRadioButton("MALE", true);
		rbuttons[1] = new JRadioButton("FEMALE");
		rgroup.add(rbuttons[0]);
		rgroup.add(rbuttons[1]);
		rpanel.add(rbuttons[0]);
		rpanel.add(rbuttons[1]);
		// rpanel add combobox
		rpanel.add(new JLabel("Age"));
		rpanel.add(combobox);
		// rpanel add button
		rpanel.add(button);
		// panel add rpanel
		panel.add(rpanel, BorderLayout.CENTER);		

		// fpanel add labels & textfields
		for (int i=0; i<NUM; i++) {
			labels[i] = new JLabel(titles[i]);
			textfields[i] = new JTextField(10);
			fpanel.add(labels[i]);
			fpanel.add(textfields[i]);
		}
		// panel add fpanel
		panel.add(fpanel, BorderLayout.SOUTH);

		// event listener
		button.addActionListener(this);
		
		/*InnerclassListener c1 = new InnerclassListener();
		button.addActionListener(c1);*/	
		//inner class button event�� ���� button�� listener�� �߰��ϴ� �ڵ� inner class�� �̿��ϱ����ؼ� DieraryReferenceIntakeFindFrame1 Ŭ�������� actionlistener�� implements�� ���־��Ѵ�.
		
		
		
		// generate button click event
		//button.doClick();

		this.add(panel);
		this.setSize(350, 750);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	//inner class
	/*private class InnerclassListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (manager == null) return;
			if (button == (JButton)e.getSource()) {
				DietaryReferenceIntake1 drit1 = null;
				AgeRange1 ar = AgeRange1.nameOf(combobox.getSelectedItem().toString());
				// get gender
				
			if(rbuttons[0].isSelected()==true)
				drit1 = manager.find(DietaryReferenceIntake1 ->DietaryReferenceIntake1.getGender()==Gender1.MALE && 
				DietaryReferenceIntake1.getAge()==ar);
				
			else
				drit1 = manager.find(DietaryReferenceIntake1 ->DietaryReferenceIntake1.getGender()==Gender1.FEMALE && 
				DietaryReferenceIntake1.getAge()==ar);
				// get age range
			
				// find DietaryReferenceIntake by gender & age
			
				// set textfields
			if(drit1 !=null) {
				int count = 0;
				String[] str = drit1.toString().split(",");
				for(String a : str) {
					textfields[count++].setText(a);
				}
			}
			
			}
		}
		
	}*/	// inner class button even end
	// �̰� ���� ���� �־�? ������ �� �϶󳪴°��� �𸣰ھ� �̰�
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (manager == null) return;
		if (button == (JButton)e.getSource()) {
			DietaryReferenceIntake1 drit1 = null;
			
			// get age range
			AgeRange1 ar = AgeRange1.nameOf(combobox.getSelectedItem().toString());
			//getSelectedItem() �޼���� combobox���� ���õ� ������ ObjectŸ������ ��ȯ�� �Ѵ�.
			//toString()�� ���� Object�� �Ѿ�� ��ü�� String Ÿ������ ��ȯ�Ͽ���.
			//��ȯ�� StringŸ���� AgeRange1.nameOf�� ���� AgeRangeŸ������ ��ȯ�Ͽ� �����Ͽ���.
			
			// get gender
		if(rbuttons[0].isSelected()==true)
			// find DietaryReferenceIntake by gender & age
			drit1 = manager.find(DietaryReferenceIntake1 ->DietaryReferenceIntake1.getGender()==Gender1.MALE && 
			DietaryReferenceIntake1.getAge()==ar);	//���ٽ��� ���� predicate�� ������ �־��־���.
		//isSelected() �޼���� rbuttons[0]�� �ִ� ���� üũ�Ǿ����� true�� ��ȯ�ϴ� �޼����̴�.
			
		else
			// find DietaryReferenceIntake by gender & age
			drit1 = manager.find(DietaryReferenceIntake1 ->DietaryReferenceIntake1.getGender()==Gender1.FEMALE && 
			DietaryReferenceIntake1.getAge()==ar);
			
			// set textfields
		if(drit1 !=null) {	//�������� ������ drit1�� ���� ������ ������� �ʰ� �ۼ��Ͽ���.
			int count = 0;									//�ε��� ǥ�ø� ���� ���� ����
			String[] str = drit1.toString().split(",");		//,���� �����Ͽ� drit1�� ���� String[]Ÿ������ ��ȯ�Ͽ���.
			for(String a : str) {							
				textfields[count++].setText(a);				//for-each�������� ��ȯ�� String�迭�� setText�޼��带 ���� textfields�� ���� �־��ִ� �ڵ�
			}
		}
		
		}
	}//button event end	
	
} //end

