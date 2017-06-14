package model.persistence.service;

import java.util.List;

import javax.ejb.Stateless;

import model.entities.SmitePlayer;
import model.persistence.dao.SmitePlayerDAO;

@Stateless
public class SmitePlayerService {
	
	private static SmitePlayerDAO lolplayerDAO;
	
	
	public SmitePlayerService() {
		lolplayerDAO = new SmitePlayerDAO();
	}

	public void insert(SmitePlayer player) {
		lolplayerDAO.openCurrentSessionwithTransaction();
		lolplayerDAO.insert(player);
		lolplayerDAO.closeCurrentSessionwithTransaction();
	}

	public void update(SmitePlayer player) {
		lolplayerDAO.openCurrentSessionwithTransaction();
		lolplayerDAO.update(player);
		lolplayerDAO.closeCurrentSessionwithTransaction();
	}

	public SmitePlayer findById(Integer id) {
		lolplayerDAO.openCurrentSession();
		SmitePlayer player = lolplayerDAO.findById(id);
		lolplayerDAO.closeCurrentSession();
		return player;
	}

	public void delete(Integer id) {
		lolplayerDAO.openCurrentSessionwithTransaction();
		SmitePlayer player = lolplayerDAO.findById(id);
		lolplayerDAO.delete(player);
		lolplayerDAO.closeCurrentSessionwithTransaction();
	}

	public List<SmitePlayer> findAll() {
		lolplayerDAO.openCurrentSession();
		List<SmitePlayer> players = lolplayerDAO.findAll();
		lolplayerDAO.closeCurrentSession();
		return players;
	}

	public void deleteAll() {
		lolplayerDAO.openCurrentSessionwithTransaction();
		lolplayerDAO.deleteAll();
		lolplayerDAO.closeCurrentSessionwithTransaction();
	}



	public SmitePlayerDAO usuarioDAO() {
		return lolplayerDAO;
	}
}