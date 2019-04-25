package com.excilys.formationSpringBoot.persistence;

import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.formationSpringBoot.model.Recipe;

@Repository
public class RecipeDAO {
	private Session currentSession;
	@SuppressWarnings("unused")
	private Transaction currentTransaction;
	private SessionFactory sessionFactory;
	
	private String GET_ALL_QUERY = "from recipe";
	private String GET_BY_ID_QUERY = "from recipe where id = :id";
	
	void setSessinFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Autowired
	SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private Session openSession() {
		return currentSession = getSessionFactory().openSession();
	}
	
	@SuppressWarnings("unused")
	private Transaction openSessionWithTransaction() {
		return currentTransaction = openSession().beginTransaction();
	}
	
	public List<Recipe> getAllRecipies() {
		openSession();
		@SuppressWarnings("unchecked")
		Query<Recipe> query = currentSession.createQuery(GET_ALL_QUERY);
		return query.list();
	}
	
	public Recipe getRecipyByid(Long id){
		openSession();
		@SuppressWarnings("unchecked")
		Query<Recipe> query = currentSession.createQuery(GET_BY_ID_QUERY);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

}
