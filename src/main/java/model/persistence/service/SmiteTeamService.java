package model.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import business.TeamStatus;
import model.entities.SmiteTeam;
import model.persistence.dao.SmiteTeamDAO;

@Stateless
public class SmiteTeamService {

	private static SmiteTeamDAO lolteamDAO;

	public SmiteTeamService() {
			lolteamDAO = new SmiteTeamDAO();
		}

	public void insert(SmiteTeam team) {
		lolteamDAO.openCurrentSessionwithTransaction();
		lolteamDAO.insert(team);
		lolteamDAO.closeCurrentSessionwithTransaction();
	}

	public void update(SmiteTeam team) {
		lolteamDAO.openCurrentSessionwithTransaction();
		lolteamDAO.update(team);
		lolteamDAO.closeCurrentSessionwithTransaction();
	}

	public SmiteTeam findById(Integer id) {
		lolteamDAO.openCurrentSession();
		SmiteTeam team = lolteamDAO.findById(id);
		lolteamDAO.closeCurrentSession();
		return team;
	}
	
	public List<SmiteTeam> findIncompleteTeams(){
		lolteamDAO.openCurrentSession();
		ArrayList<SmiteTeam> teamList = (ArrayList<SmiteTeam>) lolteamDAO.findByField("status_time", TeamStatus.INCOMPLETE);
		lolteamDAO.closeCurrentSession();
		return teamList;
	}
	
	public void delete(Integer id) {
		lolteamDAO.openCurrentSessionwithTransaction();
		SmiteTeam team = lolteamDAO.findById(id);
		lolteamDAO.delete(team);
		lolteamDAO.closeCurrentSessionwithTransaction();
	}

	public List<SmiteTeam> findAll() {
		lolteamDAO.openCurrentSession();
		List<SmiteTeam> teams = lolteamDAO.findAll();
		lolteamDAO.closeCurrentSession();
		return teams;
	}

	public void deleteAll() {
		lolteamDAO.openCurrentSessionwithTransaction();
		lolteamDAO.deleteAll();
		lolteamDAO.closeCurrentSessionwithTransaction();
	}

	public SmiteTeamDAO usuarioDAO() {
		return lolteamDAO;
	}
}
