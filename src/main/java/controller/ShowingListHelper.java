package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ShowingList;

public class ShowingListHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk7_Housing");

	public void addShowingList(ShowingList toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeShowingList(ShowingList toRemove) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ShowingList> typedQuery = em.createQuery("SELECT sl from ShowingList sl where sl.id= :selectedId", ShowingList.class);
		
		typedQuery.setParameter("selectedId", toRemove.getId());
		
		// Reminder to change if 1 doesn't work well.
		typedQuery.setMaxResults(1);
		ShowingList result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void editShowingList(ShowingList toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ShowingList> getShowingList() {
		EntityManager em = emfactory.createEntityManager();
		List<ShowingList> results = em.createQuery("SELECT sl FROM ShowingList sl").getResultList();
		return results;
	}

	public ShowingList findShowingListById(int toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ShowingList result = em.find(ShowingList.class, toFind);
		em.close();
		return result;
	}

}
