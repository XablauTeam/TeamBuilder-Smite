package model.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.entities.SmitePlayer;

public class SmitePlayerDAO implements GenericDAO<SmitePlayer, Integer> {
	private Session currentSession;
	private Transaction currentTransaction;

	public SmitePlayerDAO() {
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
		Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
		configuration.addAnnotatedClass(SmitePlayer.class);
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

	public SmitePlayer findById(Integer id) {
		SmitePlayer player = (SmitePlayer) getCurrentSession().get(SmitePlayer.class, id);
		return player;
	}

	public void insert(SmitePlayer player) {
		getCurrentSession().save(player);
	}

	public void delete(SmitePlayer player) {
		getCurrentSession().delete(player);
	}

	public void update(SmitePlayer player) {
		getCurrentSession().update(player);
	}

	@SuppressWarnings("unchecked")
	public List<SmitePlayer> findAll() {
		List<SmitePlayer> players = (List<SmitePlayer>) getCurrentSession().createQuery("FROM SmitePlayer").list();
		return players;
	}
	
	public void deleteAll(){
		List<SmitePlayer> players = findAll();
		for (SmitePlayer player : players)
			delete(player);
	}
}
