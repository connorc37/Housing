package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.House;

public class HouseHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk7_Housing");
	
	public void addHouse(House toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeHouse(House toRemove) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<House> typedQuery = em.createQuery("select h from House h where h.number = :selectedNumber and h.street = :selectedStreet and h.city = :selectedCity and h.zip = :selectedZip", House.class);
		
		typedQuery.setParameter("selectedNumber", toRemove.getNumber());
		typedQuery.setParameter("selectedStreet", toRemove.getStreet());
		typedQuery.setParameter("selectedCity", toRemove.getCity());
		typedQuery.setParameter("selectedZip", toRemove.getZip());
		
		// Reminder to change if 1 doesn't work well.
		typedQuery.setMaxResults(1);
		House result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void editHouse(House toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<House> showAllHouses() {
		EntityManager em = emfactory.createEntityManager();
		List<House> results = em.createQuery("SELECT h FROM House h").getResultList();
		return results;
	}
	
	public House findHousesById(int toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		House result = em.find(House.class, toFind);
		em.close();
		return result;
	}
	
	public List<House> findHousesByNumber(int toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<House> typedQuery = em.createQuery("select h from House h where h.number = :selectedNumber", House.class);
		
		typedQuery.setParameter("selectedNumber", toFind);
		
		List<House> results = typedQuery.getResultList();
		em.close();
		return results;
	}
	
	public List<House> findHousesByStreet(String toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<House> typedQuery = em.createQuery("select h from House h where h.street = :selectedStreet", House.class);
		
		typedQuery.setParameter("selectedStreet", toFind);
		
		List<House> results = typedQuery.getResultList();
		em.close();
		return results;
	}
	
	public List<House> findHousesByCity(String toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<House> typedQuery = em.createQuery("select h from House h where h.city = :selectedCity", House.class);
		
		typedQuery.setParameter("selectedCity", toFind);
		
		List<House> results = typedQuery.getResultList();
		em.close();
		return results;
	}
	
	public List<House> findHousesByZip(int toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<House> typedQuery = em.createQuery("select h from House h where h.zip = :selectedZip", House.class);
		
		typedQuery.setParameter("selectedZip", toFind);
		
		List<House> results = typedQuery.getResultList();
		em.close();
		return results;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
