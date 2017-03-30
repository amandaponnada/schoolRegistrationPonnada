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

import application.addGradePanel.ButtonListener;
import entities.grade;

public class updGradePanel extends JPanel {

	int updGradeID;
	JLabel gradeTitle = new JLabel("Update Grade");
	
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
	JButton update = new JButton("Update");

	public updGradePanel(grade g) {

		updGradeID = g.getgradeId();
		setLayout(new BorderLayout());
		ButtonListener updateButton = new ButtonListener();
		back.addActionListener(updateButton);
		update.addActionListener(updateButton);

		gradeTitle.setFont(new Font("Serif", Font.BOLD, 14));
		add(gradeTitle, BorderLayout.NORTH);
		
		JPanel gradeLabel = new JPanel(new GridLayout(0,1));
		JPanel gradeTextAreas = new JPanel(new GridLayout(0,1));
		gradeLabel.add(gradeNameLabel);
		Name.setText(g.getgradeName());
		gradeTextAreas.add(Name);
		
		gradeLabel.add(gradeTeacherLabel);
		Teacher.setText(g.getgradeSubTeacherName());
		gradeTextAreas.add(Teacher);
		
		gradeLabel.add(gradeSubTeacherLabel);
		subTeacher.setText(g.getgradeSubTeacherName());
		gradeTextAreas.add(subTeacher);

		gradeLabel.add(gradeSchoolNameLabel);
		school.setText(g.getgradeSchoolName());
		gradeTextAreas.add(school);
		
		gradeLabel.add(gradeMascotLabel);
		mascot.setText(g.getgradeMascot());
		gradeTextAreas.add(mascot);

		add(gradeLabel, BorderLayout.WEST);
		add(gradeTextAreas, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(update);
		buttonPanel.add(back);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == update) {
				String gName;
				String gTeacher;
				String gSubTeacher;
				String gSchool;
				String gMascot;
				
				gName = Name.getText();
				gTeacher = Teacher.getText();
				gSubTeacher = subTeacher.getText();
				System.out.println("Sub teacher : " + gSubTeacher);
				gSchool = school.getText();
				gMascot = mascot.getText();
				
				EntityManagerFactory gradeFactory = Persistence.createEntityManagerFactory("studentPanelPonnada");
				EntityManager gu = gradeFactory.createEntityManager();
				gu.getTransaction().begin();
				
				grade updGrade = gu.find(grade.class, updGradeID);
				updGrade.setgradeName(gName);
				updGrade.setgradeTeacherName(gTeacher);
				updGrade.setgradeSubTeacherName(gSubTeacher);
				updGrade.setgradeSchoolName(gSchool);
				updGrade.setgradeMascot(gMascot);
				
				
				gu.getTransaction().commit();
				gu.close();
				gradeFactory.close();
				
				removeAll();
				JPanel newPanel = new showGradesPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
				
			}
			
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new showGradesPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
		}
		
	}
	
}
