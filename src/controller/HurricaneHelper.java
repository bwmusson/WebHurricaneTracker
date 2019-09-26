package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Hurricane;

public class HurricaneHelper {
	
	static EntityManagerFactory emfactory =	Persistence.createEntityManagerFactory("ConsoleHurricaneTracker");

	public void insertHurricane(Hurricane h) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		em.close();
	}
	public List<Hurricane> showAllHurricanes(){
		EntityManager em = emfactory.createEntityManager();
		List<Hurricane> allHurricanes = em.createQuery("SELECT h FROM Hurricane h").getResultList();
		return allHurricanes;
	}
	public void deleteItem(Hurricane toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Hurricane> typedQuery = em.createQuery("SELECT h FROM Hurricane h WHERE h.name = :selectedName AND h.year = :selectedYear AND h.category = :selectedCategory", Hurricane.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedCategory", toDelete.getCategory());
		typedQuery.setMaxResults(1);
		Hurricane result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public List<Hurricane> searchForHurricaneByName(String name){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Hurricane> typedQuery = em.createQuery("SELECT h from Hurricane h WHERE h.name = :selectedName", Hurricane.class);
		typedQuery.setParameter("selectedName", name);
		List<Hurricane> foundHurricanes = typedQuery.getResultList();
		em.close();
		return	foundHurricanes;
	}
	public List<Hurricane> searchForHurricaneByYear(int year){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Hurricane> typedQuery = em.createQuery("SELECT h from Hurricane h WHERE h.year = :selectedYear", Hurricane.class);
		typedQuery.setParameter("selectedYear", year);
		List<Hurricane> foundHurricanes = typedQuery.getResultList();
		em.close();
		return	foundHurricanes;
	}
	public List<Hurricane> searchForHurricaneByCategory(int cat){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Hurricane> typedQuery = em.createQuery("SELECT h from Hurricane h WHERE h.category = :selectedCategory", Hurricane.class);
		typedQuery.setParameter("selectedCategory", cat);
		List<Hurricane> foundHurricanes = typedQuery.getResultList();
		em.close();
		return	foundHurricanes;
	}
	public Hurricane searchForHurricaneById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Hurricane found = em.find(Hurricane.class, id);
		em.close();
		return	found;
	}
	public void updateHurricane(Hurricane toEdit){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public void cleanUp() {
		emfactory.close();
	}
}
