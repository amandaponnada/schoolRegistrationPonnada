package application;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.updStudentPanel.ButtonListener;
import entities.grade;
import entities.student;

public class addStudentPanel extends JPanel {
	
	JLabel sTitle = new JLabel("Add Student Details");
	
	JLabel stdNameLabel = new JLabel("Name");
	JTextField Name = new JTextField(25);
	
	JLabel stdAgeLabel = new JLabel("Age");
	JTextField Age = new JTextField(25);

	JLabel stdMajorLabel = new JLabel("Major");
	JTextField Major = new JTextField(25);

	JLabel stdElectiveLabel = new JLabel("Elective");
	JTextField Elective = new JTextField(25);

	JButton back = new JButton("Back");
	JButton add = new JButton("Add");

	grade stdGrade;
	int stdGradeID;
	
	public addStudentPanel(grade g) {
		stdGrade = g;
		stdGradeID = g.getgradeId();
		
		setLayout(new BorderLayout());
		
		ButtonListener updButton = new ButtonListener();
		back.addActionListener(updButton);
		add.addActionListener(updButton);
		
		sTitle.setFont(new Font("Serif", Font.BOLD, 14));
		add(sTitle, BorderLayout.NORTH);
		
		JPanel stdLabel = new JPanel(new GridLayout(0,1));
		JPanel stdTextArea = new JPanel(new GridLayout(0,1));

		stdLabel.add(stdNameLabel);
		stdTextArea.add(Name);
		
		stdLabel.add(stdAgeLabel);
		stdTextArea.add(Age);
		
		stdLabel.add(stdMajorLabel);
		stdTextArea.add(Major);
		
		stdLabel.add(stdElectiveLabel);
		stdTextArea.add(Elective);
		
		add(stdLabel, BorderLayout.WEST);
		add(stdTextArea, BorderLayout.CENTER);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.X_AXIS));
		ButtonPanel.add(add);
		ButtonPanel.add(back);
		
		add(ButtonPanel, BorderLayout.SOUTH);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == add) {
				String sName;
				int sAge;
				int sGradeID;
				String sMajor;
				String sElective;
				
				sName = Name.getText();
				sAge = Integer.valueOf(Age.getText());
				sGradeID = stdGradeID;
				sMajor = Major.getText();
				sElective = Elective.getText();

				EntityManagerFactory stdFactory = Persistence.createEntityManagerFactory("studentPanelPonnada");
				EntityManager sa = stdFactory.createEntityManager();
				sa.getTransaction().begin();
				
				student newStudent  = new student(sName, sAge, sGradeID, sMajor, sElective);
				
				sa.persist(newStudent);
				
				sa.getTransaction().commit();
				sa.close();
				stdFactory.close();

				Name.setEditable(false);
				Age.setEditable(false);
				Major.setEditable(false);
				Elective.setEditable(false);

				add.setVisible(false);
				revalidate();
				
			}
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new showStudentsPanel(stdGrade);
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
			
		}	
	}
}
