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

import entities.grade;

public class showGradesPanel extends JPanel {
	
	Container c = getRootPane();
	
	JLabel gListTitle = new JLabel("VIEW GRADES");
	
	JButton back = new JButton("Back");
	JButton remove = new JButton("Remove");
	JButton update = new JButton("Update");
	JButton students = new JButton("Grade Students");
	
	JList gList;
	List<grade>results;
	
	public showGradesPanel() {
		setLayout(new BorderLayout());
		
		EntityManagerFactory gvfactory = Persistence.createEntityManagerFactory("studentPanelPonnada");
		EntityManager gv = gvfactory.createEntityManager();
		gv.getTransaction().begin();

		TypedQuery<grade> sgradesQuery = gv.createQuery("select g from grade g", grade.class);
		results = sgradesQuery.getResultList();

		gList = new JList(results.toArray());

		gv.close();
		gvfactory.close();

/*		for(grade a : results) {
			System.out.println(a.toString());
		}
*/		
		JScrollPane gScroll = new JScrollPane(gList);
		
		gScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		gScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		gScroll.setPreferredSize(new Dimension(400,200));
		
		add(gListTitle, BorderLayout.NORTH);
		add(gScroll, BorderLayout.CENTER);
		
		ButtonListener gListener = new ButtonListener();
		back.addActionListener(gListener);
		update.addActionListener(gListener);
		remove.addActionListener(gListener);
		students.addActionListener(gListener);
		
		JPanel gButtonPanel = new JPanel();
		
		gButtonPanel.add(back);
		gButtonPanel.add(update);
		gButtonPanel.add(remove);
		gButtonPanel.add(students);
		
		add(gButtonPanel,BorderLayout.SOUTH);
		
		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new viewGradePanel();
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
			if(e.getSource() == update) {
				removeAll();
				int gIndex = gList.getSelectedIndex();
				System.out.println("Grade Name : " + results.get(gIndex));
				JPanel newPanel = new updGradePanel(results.get(gIndex));
				add(newPanel);
				revalidate();
				newPanel.repaint();

			}
			if (e.getSource() == remove) {
				removeAll();
				int gIndex = gList.getSelectedIndex();
				System.out.println("Grade Name : " + results.get(gIndex));
				JPanel newPanel = new remGradePanel(results.get(gIndex));
				add(newPanel);
				revalidate();
				newPanel.repaint();
 			}
 			if(e.getSource() == students) {
				removeAll();
				int gIndex = gList.getSelectedIndex();
				System.out.println("Grade Name : " + results.get(gIndex));
				JPanel newPanel = new showStudentsPanel(results.get(gIndex));
				add(newPanel);
				revalidate();
				newPanel.repaint();
				
			}  
		}

	}
}
