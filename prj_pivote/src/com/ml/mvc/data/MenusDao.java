package com.ml.mvc.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ml.mvc.data.model.Menus;

public class MenusDao implements MenusDaoInterface<Menus, Integer> {

	private Session currentSession;

	private Transaction currentTransaction;

	public MenusDao() {
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

	@Override
	public void persist(Menus entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Menus entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Menus findById(Integer id) {
		Menus menu = (Menus) getCurrentSession().get(Menus.class, id);
		return menu;
	}

	@Override
	public void delete(Menus entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	public List<Menus> findAll() {
		List<Menus> menus = (List<Menus>) getCurrentSession().createQuery("from Menus").list();
		return menus;
	}
	

	

	@Override
	public void deleteAll() {
		List<Menus> entityList = findAll();
		for (Menus entity : entityList) {
			delete(entity);
		}

	}

}
