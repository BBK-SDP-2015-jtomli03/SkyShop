package com.springapp.dao;

import com.springapp.model.Product;
import com.springapp.model.ProductImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao implements DaoInterface<Product, String> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public ProductDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Product entity) {
		getCurrentSession().save(entity);
	}

	public void update(Product entity) {
		getCurrentSession().update(entity);
	}

	public Product findById(int id) {
		Product product = (ProductImpl) getCurrentSession().get(ProductImpl.class, id);
		return product; 
	}

	//TODO
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Product entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		List<Product> products = (List<Product>) getCurrentSession().createQuery("from Products").list();
		return products;
	}

	public void deleteAll() {
		List<Product> entityList = findAll();
		for (Product entity : entityList) {
			delete(entity);
		}
	}
}
