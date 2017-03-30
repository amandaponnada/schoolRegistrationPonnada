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

public class remStudentPanel extends JPanel {
	
	int remStudentID;
	int stdGradeID;
	grade stdGrade;
	
	JLabel sTitle = new JLabel("Remove Student Details");
	
	JLabel stdNameLabel = new JLabel("Name");
	JTextField Name = new JTextField(25);
	
	JLabel stdAgeLabel = new JLabel("Age");
	JTextField Age = new JTextField(25);

	JLabel stdMajorLabel = new JLabel("Major");
	JTextField Major = new JTextField(25);

	JLabel stdElectiveLabel = new JLabel("Elective");
	JTextField Elective = new JTextField(25);

	JButton back = new JButton("Back");
	JButton remove = new JButton("Remove");
	
	public remStudentPanel (grade g, student s) {
	
		stdGrade = g;
		remStudentID = s.getStudentId();
		stdGradeID = s.getStudentGradeId();
		setLayout(new BorderLayout());
		ButtonListener updButton = new ButtonListener();
		back.addActionListener(updButton);
		remove.addActionListener(updButton);
		
		sTitle.setFont(new Font("Serif", Font.BOLD, 14));
		add(sTitle, BorderLayout.NORTH);
		
		JPanel stdLabel = new JPanel(new GridLayout(0,1));
		JPanel stdTextArea = new JPanel(new GridLayout(0,1));
		stdLabel.add(stdNameLabel);
		Name.setText(s.getStudentName());
		Name.setEditable(false);
		stdTextArea.add(Name);
		
		stdLabel.add(stdAgeLabel);
		Age.setText(Integer.toString(s.getStudentAge()));
		stdTextArea.add(Age);
		Age.setEditable(false);
		
		stdLabel.add(stdMajorLabel);
		Major.setText(s.getStudentMajorSub());
		stdTextArea.add(Major);
		Major.setEditable(false);
		
		stdLabel.add(stdElectiveLabel);
		Elective.setText(s.getStudentElective());
		stdTextArea.add(Elective);
		Elective.setEditable(false);
		
		add(stdLabel, BorderLayout.WEST);
		add(stdTextArea, BorderLayout.CENTER);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.X_AXIS));
		ButtonPanel.add(remove);
		ButtonPanel.add(back);
		
		add(ButtonPanel, BorderLayout.SOUTH);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == remove) {
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
				EntityManager sr = stdFactory.createEntityManager();
				sr.getTransaction().begin();
				
				student remStudent = sr.find(student.class, remStudentID);
				
				sr.remove(remStudent);
				sr.getTransaction().commit();
				sr.close();
				stdFactory.close();
				
				removeAll();
				JPanel newPanel = new showStudentsPanel(stdGrade);
				add(newPanel);
				revalidate();
				newPanel.repaint();
				
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
