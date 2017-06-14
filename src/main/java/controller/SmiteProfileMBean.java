package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import business.PlayerBean;
import business.PlayerStatus;
import business.exceptions.BusinessException;
import business.lol.SmiteRegioes;
import business.lol.SmiteRole;
import business.lol.SoloTeamBean;
import model.entities.SmitePlayer;
import model.entities.SmiteTeam;
import model.entities.User;

@ManagedBean(name = "smiteProfileMBean")
@SessionScoped
public class SmiteProfileMBean extends GenericMBean {

	@ManagedProperty("#{loginMBean.user}")
	private User user;

	private SmitePlayer player;

	private SmiteTeam team;

	@EJB
	PlayerBean playerBean;

	@EJB
	SoloTeamBean teamBean;

	@PostConstruct
	public void onLoad() {
		try {
			this.player = playerBean.findById(user.getIdUsuario());
			team = teamBean.findTeamByID(this.player.getTeamID());
		} catch (BusinessException e) {
			player = new SmitePlayer();
		}
	}

	public String cadastrarPlayer() {
		try {
			player.setStatus(PlayerStatus.SEARCHING_TEAM);
			playerBean.incluirPlayer(user, player);
			user.setPlayer(player);
		} catch (Exception e) {
			incluirErro(e.getMessage());
		}
		return "";
	}

	public String procurarTime() {
		try {
			if(user.getPlayer().getTeamID() != 0)
				teamBean.removePlayerFromTeam(player);
			team = (SmiteTeam) teamBean.findTeam(player);
			if(team == null)
				team = (SmiteTeam) teamBean.createNewTeam(player);
			teamBean.insertPlayerInTeam(player, team);
		} catch (Exception e) {
			incluirErro(e.getMessage());
		}
		return "";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SmitePlayer getPlayer() {
		return player;
	}

	public void setPlayer(SmitePlayer player) {
		this.player = player;
	}

	public SmiteTeam getTeam() {
		return team;
	}

	public void setTeam(SmiteTeam team) {
		this.team = team;
	}

	public List<PlayerStatus> getPlayerStatus() {
		List<PlayerStatus> itens = new ArrayList<PlayerStatus>();
		for (PlayerStatus stat : PlayerStatus.values()) {
			itens.add(stat);
		}
		return itens;
	}

	public List<SmiteRole> getRoles() {
		List<SmiteRole> itens = new ArrayList<SmiteRole>();
		for (SmiteRole role : SmiteRole.values()) {
			itens.add(role);
		}
		return itens;
	}

	public List<SmiteRegioes> getRegioes() {
		List<SmiteRegioes> itens = new ArrayList<SmiteRegioes>();
		for (SmiteRegioes regiao : SmiteRegioes.values()) {
			itens.add(regiao);
		}
		return itens;
	}

}