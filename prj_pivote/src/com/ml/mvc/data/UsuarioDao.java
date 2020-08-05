package com.ml.mvc.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ml.mvc.data.model.Menus;
import com.ml.mvc.data.model.Usuario;

public class UsuarioDao implements MenusDaoInterface<Usuario, Integer> {

	private Session currentSession;

	private Transaction currentTransaction;

	public UsuarioDao() {
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
	public void persist(Usuario entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Usuario entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Usuario findById(Integer id) {
		Usuario usuario = (Usuario) getCurrentSession().get(Usuario.class, id);
		return usuario;
	}

	@Override
	public void delete(Usuario entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		List<Usuario> usuarios = (List<Usuario>) getCurrentSession().createQuery("from Usuario").list();
		return usuarios;
	}
	
	public Usuario findByName(String name) {
		Usuario usuario = (Usuario) getCurrentSession()
				.createQuery("from Usuario where nombre = :name")
				.setParameter("name", name)
				.uniqueResult();
		return usuario;
	}

	@Override
	public void deleteAll() {
		List<Usuario> entityList = findAll();
		for (Usuario entity : entityList) {
			delete(entity);
		}

	}

}
