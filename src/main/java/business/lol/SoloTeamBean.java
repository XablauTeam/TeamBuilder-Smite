package business.lol;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.PlayerBean;
import business.PlayerStatus;
import business.TeamStatus;
import business.exceptions.CannotInsertException;
import model.entities.AbstractPlayer;
import model.entities.AbstractTeam;
import model.entities.SmitePlayer;
import model.entities.SmiteTeam;
import model.persistence.service.SmiteTeamService;

@Stateless
public class SoloTeamBean {

	@EJB
	private SmiteTeamService smiteTeamService;
	@EJB
	private SmiteTeamProcessor smiteTeamProcessor;
	@EJB
	private PlayerBean playerBean;
	
	
	
	public AbstractTeam findTeam(AbstractPlayer player) {
		ArrayList<SmiteTeam> teamList = (ArrayList<SmiteTeam>) smiteTeamService.findAll();
		if (!teamList.isEmpty()) {
			for (SmiteTeam teamAnalyzed : teamList) {
				if (teamAnalyzed.getStatus() != TeamStatus.COMPLETE && 
						smiteTeamProcessor.isRoleNeeded(teamAnalyzed, player)) {
					return teamAnalyzed;
				}
			}
		}

		return null;
	}

	public AbstractTeam createNewTeam(AbstractPlayer player) {
		SmiteTeam smiteTeam = new SmiteTeam();
		smiteTeamService.insert(smiteTeam);
		return smiteTeam;
	}

	public void insertPlayerInTeam(AbstractPlayer player, AbstractTeam team) throws CannotInsertException {
		smiteTeamProcessor.insertPlayerInTeam(player, team);
		smiteTeamService.update((SmiteTeam) team);
		player.setTeamID(team.getIdTime());
		player.setStatus(PlayerStatus.IN_TEAM);
		playerBean.atualizarPlayer((SmitePlayer)player);
	}

	public boolean playerHasTeam(AbstractPlayer player) {
		return player.getTeamID() != 0;
	}

	public boolean removePlayerFromTeam(AbstractPlayer player) {
		SmiteTeam team;
		if (player.getTeamID() != 0) {
			team = smiteTeamService.findById(player.getTeamID());
			smiteTeamProcessor.removePlayer(player, team);
			smiteTeamService.update(team);
			return true;
		}
		return false;
	}
	
	public SmiteTeam findTeamByID(Integer playerID){
		return smiteTeamService.findById(playerID);
	}

}