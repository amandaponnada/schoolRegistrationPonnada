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
import javax.persistence.TypedQuery;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.addGradePanel.ButtonListener;
import entities.grade;

public class remGradePanel extends JPanel {

	int removeGrade;
	JLabel gradeTitle = new JLabel("REMOVE GRADE");
	
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
	JButton remove = new JButton("Delete");
	
	public remGradePanel(grade g) {
		
		removeGrade = g.getgradeId();
		setLayout(new BorderLayout());
		ButtonListener updateButton = new ButtonListener();
		back.addActionListener(updateButton);
		remove.addActionListener(updateButton);

		gradeTitle.setFont(new Font("Serif", Font.BOLD, 14));
		add(gradeTitle, BorderLayout.NORTH);
		
		JPanel gradeLabel = new JPanel(new GridLayout(0,1));
		JPanel gradeTextAreas = new JPanel(new GridLayout(0,1));
		gradeLabel.add(gradeNameLabel);
		Name.setText(g.getgradeName());
		gradeTextAreas.add(Name);
		Name.setEditable(false);
		
		gradeLabel.add(gradeTeacherLabel);
		Teacher.setText(g.getgradeSubTeacherName());
		gradeTextAreas.add(Teacher);
		Teacher.setEditable(false);
		
		gradeLabel.add(gradeSubTeacherLabel);
		subTeacher.setText(g.getgradeSubTeacherName());
		gradeTextAreas.add(subTeacher);
		subTeacher.setEditable(false);

		gradeLabel.add(gradeSchoolNameLabel);
		school.setText(g.getgradeSchoolName());
		gradeTextAreas.add(school);
		school.setEditable(false);
		
		gradeLabel.add(gradeMascotLabel);
		mascot.setText(g.getgradeMascot());
		gradeTextAreas.add(mascot);
		mascot.setEditable(false);
		
		add(gradeLabel, BorderLayout.WEST);
		add(gradeTextAreas, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(remove);
		buttonPanel.add(back);
		
		add(buttonPanel, BorderLayout.SOUTH);

	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == remove) {
				String gName;
				String gTeacher;
				String gSubTeacher;
				String gSchool;
				String gMascot;
				
				EntityManagerFactory gradeFactory = Persistence.createEntityManagerFactory("studentPanelPonnada");
				EntityManager gr = gradeFactory.createEntityManager();
				gr.getTransaction().begin();
				
				grade toRemove = gr.find(grade.class, removeGrade);
				
				gr.remove(toRemove);
				gr.getTransaction().commit();
				gr.close();
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
