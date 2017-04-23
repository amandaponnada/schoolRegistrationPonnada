package registrationPonnada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class studentDAO {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("schoolRegistrationPonnada");
	
	public void insertStudent(student studentToAdd){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("schoolRegistrationPonnada");		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(studentToAdd);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
			
	}

	public List<student> getAllStudents() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String q = "select s from student s";
		TypedQuery<student> typedQuery = em.createQuery(q, student.class);
		List<student> all = typedQuery.getResultList();
		return all;
	

	}
}
