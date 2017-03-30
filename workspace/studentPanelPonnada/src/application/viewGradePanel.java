package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class viewGradePanel extends JPanel {
	
	JButton add  = new JButton("Add a new Grade");
	JButton show = new JButton("Show Grades");
	
	public viewGradePanel() {
		
		add(add);
		add(show);
		
		ButtonHandler gButtonHandler = new ButtonHandler();
		add.addActionListener(gButtonHandler);
		show.addActionListener(gButtonHandler);
		
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == add) {
				System.out.println("You selected Adding new Grade");
				removeAll();
				JPanel newPanel = new addGradePanel();
				add(newPanel);
				revalidate();
			}
			
			if (e.getSource() == show) {
				System.out.println("Show available grades");
				removeAll();
				JPanel newPanel = new showGradesPanel();
				add(newPanel);
				revalidate();
			}
			
		}
		
		
	}
	

}
