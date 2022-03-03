package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Realtor;

public class RealtorHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk7_Housing");

	public void addRealtor(Realtor toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Realtor> showAllRealtors() {
		EntityManager em = emfactory.createEntityManager();
		List<Realtor> allRealtors = em.createQuery("SELECT r FROM Realtor r").getResultList();
		return allRealtors;
	}

	public Realtor findRealtor(String toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Realtor> typedQuery = em.createQuery("select r from Realtor r where r.name = :selectedName",Realtor.class);
		
		typedQuery.setParameter("selectedName", toFind);
		
		// Reminder to change if 1 doesn't work well.
		typedQuery.setMaxResults(1);
		Realtor result;
		
		try {
			result = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			result = new Realtor(toFind);
		}
		em.close();

		return result;
	}

}
