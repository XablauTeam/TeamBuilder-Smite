package model.persistence.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.entities.SmitePlayer;
import model.entities.SmiteTeam;

public class SmiteTeamDAO implements GenericDAO<SmiteTeam, Integer> {
	private Session currentSession;
	private Transaction currentTransaction;

	public SmiteTeamDAO() {
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
		configuration.addAnnotatedClass(SmiteTeam.class);
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

	public SmiteTeam findById(Integer id) {
		SmiteTeam player = (SmiteTeam) getCurrentSession().get(SmiteTeam.class, id);
		return player;
	}

	public List<SmiteTeam> findByField(String field, Object value){
		@SuppressWarnings("unchecked")
		ArrayList<SmiteTeam> arrayList = (ArrayList<SmiteTeam>) getCurrentSession().get(field, (Serializable) value);
		return arrayList;
	}
	
	public void insert(SmiteTeam player) {
		getCurrentSession().save(player);
	}

	public void delete(SmiteTeam player) {
		getCurrentSession().delete(player);
	}

	public void update(SmiteTeam player) {
		getCurrentSession().update(player);
	}

	@SuppressWarnings("unchecked")
	public List<SmiteTeam> findAll() {
		List<SmiteTeam> players = (List<SmiteTeam>) getCurrentSession().createQuery("FROM SmiteTeam").list();
		return players;
	}
	
	public void deleteAll(){
		List<SmiteTeam> players = findAll();
		for (SmiteTeam player : players)
			delete(player);
	}}