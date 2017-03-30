package application;

import javax.swing.JFrame;
import javax.swing.*;

public class mainPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame gradeMaster = new JFrame();
		JPanel viewGrade = new viewGradePanel();
		gradeMaster.add(viewGrade);
		
		gradeMaster.setSize(600, 400);
		gradeMaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gradeMaster.setVisible(true);
	}

}
