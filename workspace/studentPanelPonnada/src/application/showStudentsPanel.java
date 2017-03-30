package application;

import java.util.List;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import application.showGradesPanel.ButtonListener;
import entities.student;
import entities.grade;
public class showStudentsPanel extends JPanel {
	
	Container c = getRootPane();
	
	JButton back = new JButton("Back");
	JButton remove = new JButton("Remove");
	JButton update = new JButton("Update");
	JButton addStudent = new JButton("Add");
	
	JList sList;
	grade stdG;
	List<student>sResults;

	public showStudentsPanel(grade g) {
		stdG = g;
		setLayout(new BorderLayout());
		
		int sGradeID;
		
		JLabel stdTitle = new JLabel("VIEW STUDENTS OF GRADE : " + g.getgradeName());
		sGradeID = g.getgradeId();
		
		EntityManagerFactory svfactory = Persistence.createEntityManagerFactory("studentPanelPonnada");
		EntityManager sv = svfactory.createEntityManager();
		sv.getTransaction().begin();
		
		TypedQuery<student> stdQuery = sv.createQuery("select s from student s where s.studentGradeId = :selectedGrade", student.class);
		stdQuery.setParameter("selectedGrade", sGradeID);
		sResults = stdQuery.getResultList();
		
		sv.close();
		svfactory.close();
		
		sList = new JList(sResults.toArray());

		JScrollPane sScroll = new JScrollPane(sList);
		
		sScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sScroll.setPreferredSize(new Dimension(400,200));
		
		add(stdTitle, BorderLayout.NORTH);
		add(sScroll, BorderLayout.CENTER);
		
		ButtonListener sListener = new ButtonListener();
		back.addActionListener(sListener);
		update.addActionListener(sListener);
		remove.addActionListener(sListener);
		addStudent.addActionListener(sListener);
		
		JPanel gButtonPanel = new JPanel();
		
		gButtonPanel.add(back);
		gButtonPanel.add(update);
		gButtonPanel.add(remove);
		gButtonPanel.add(addStudent);
		
		add(gButtonPanel,BorderLayout.SOUTH);
		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new showGradesPanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
			
			if (e.getSource() == update) {
				removeAll();
				int sIndex = sList.getSelectedIndex();
				JPanel newPanel = new updStudentPanel(stdG, sResults.get(sIndex));
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
			
			if (e.getSource() == remove) {
				removeAll();
				int sIndex = sList.getSelectedIndex();
				JPanel newPanel = new remStudentPanel(stdG, sResults.get(sIndex));
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
			
			if (e.getSource() == addStudent) {
				removeAll();
				int sIndex = sList.getSelectedIndex();
				JPanel newPanel = new addStudentPanel(stdG);
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
		}
		
	}
}
