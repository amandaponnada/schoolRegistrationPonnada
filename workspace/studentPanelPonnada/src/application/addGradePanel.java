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

import entities.grade;

public class addGradePanel extends JPanel {
	
	JLabel gradeTitle = new JLabel("Add a new Grade");
	
	JLabel gradeNameLabel = new JLabel("Name");
	JTextField Name = new JTextField(25);
	
	JLabel gradeTeacherLabel = new JLabel("Teacher's Name");
	JTextField Teacher = new JTextField(25);

	JLabel gradeSubTeacherLabel = new JLabel("Substitute Teacher's Name");
	JTextField subTeacher = new JTextField(25);

	JLabel gradeSchoolNameLabel = new JLabel("School's Name");
	JTextField school = new JTextField(25);

	JLabel gradeMascotLabel = new JLabel("Masoct's Name");
	JTextField mascot = new JTextField(25);
	
	JButton back = new JButton("Back");
	JButton add = new JButton("Add");
	
	public addGradePanel () {
		
		setLayout(new BorderLayout());
		ButtonListener addButton = new ButtonListener();
		back.addActionListener(addButton);
		add.addActionListener(addButton);
		
		gradeTitle.setFont(new Font("Serif", Font.BOLD, 14));
		add(gradeTitle, BorderLayout.NORTH);
		
		JPanel gradeLabel = new JPanel(new GridLayout(0,1));
		JPanel gradeTextAreas = new JPanel(new GridLayout(0,1));
		gradeLabel.add(gradeNameLabel);
		gradeTextAreas.add(Name);
		
		gradeLabel.add(gradeTeacherLabel);
		gradeTextAreas.add(Teacher);
		
		gradeLabel.add(gradeSubTeacherLabel);
		gradeTextAreas.add(subTeacher);

		gradeLabel.add(gradeSchoolNameLabel);
		gradeTextAreas.add(school);
		
		gradeLabel.add(gradeMascotLabel);
		gradeTextAreas.add(mascot);

		add(gradeLabel, BorderLayout.WEST);
		add(gradeTextAreas, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(add);
		buttonPanel.add(back);
		
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == add) {
				System.out.println(" Creating a new Grade");
				
				String gName;
				String gTeacher;
				String gSubTeacher;
				String gSchool;
				String gMascot;
				
				gName = Name.getText();
				gTeacher = Teacher.getText();
				gSubTeacher = subTeacher.getText();
				gSchool = school.getText();
				gMascot = mascot.getText();
				
				EntityManagerFactory gradeFactory = Persistence.createEntityManagerFactory("studentPanelPonnada");
				EntityManager gf = gradeFactory.createEntityManager();
				gf.getTransaction().begin();
				
				grade newGrade = new grade(gName, gTeacher, gSubTeacher, gSchool, gMascot);
				
				gf.persist(newGrade);
			
				gf.getTransaction().commit();
				gf.close();
				gradeFactory.close();
				
				Name.setEditable(false);
				Teacher.setEditable(false);
				subTeacher.setEditable(false);
				school.setEditable(false);
				mascot.setEditable(false);
				
				add.setVisible(false);
				revalidate();
				
			}
			
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new viewGradePanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
				
			}
			
		}
		
	}
}
