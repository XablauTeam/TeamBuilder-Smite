package business.lol;

import javax.ejb.Stateless;

import business.exceptions.CannotInsertException;
import model.entities.AbstractPlayer;
import model.entities.AbstractTeam;
import model.entities.SmitePlayer;
import model.entities.SmiteTeam;

@Stateless
public class SmiteTeamProcessor {

	public void insertPlayerInTeam(AbstractPlayer player, AbstractTeam team) throws CannotInsertException {
		SmitePlayer smitePlayer = (SmitePlayer)player;
		SmiteTeam smiteTeam = (SmiteTeam)team;
		if (isRoleNeeded(smiteTeam, smitePlayer)){
			switch (smitePlayer.getRole()){
			case SOLO:
				smiteTeam.setSolo(smitePlayer);
				break;
			case JUNGLER:
				smiteTeam.setJungler(smitePlayer);
				break;
			case MID:
				smiteTeam.setMid(smitePlayer);
				break;
			case SUPPORT:
				smiteTeam.setSupport(smitePlayer);
				break;
			case BOTTOM:
				smiteTeam.setBottom(smitePlayer);
				break;
			default:
				break;
			}	
		}
		else{
			throw new CannotInsertException("Não foi possivel inserir o jogador no time");
		}
	}

	
	public void removePlayer(AbstractPlayer player, AbstractTeam team) {
		SmitePlayer smitePlayer = (SmitePlayer)player;
		SmiteTeam smiteTeam = (SmiteTeam)team;
		switch (smitePlayer.getRole()){
		case SOLO:
			smiteTeam.setSolo(null);
			break;
		case JUNGLER:
			smiteTeam.setJungler(null);
			break;
		case MID:
			smiteTeam.setMid(null);
			break;
		case SUPPORT:
			smiteTeam.setSupport(null);
			break;
		case BOTTOM:
			smiteTeam.setBottom(null);
			break;
		default:
			break;
		}

	}

	
	public boolean isRoleNeeded(AbstractTeam team, AbstractPlayer player) {
		SmitePlayer smitePlayer = (SmitePlayer)player;
		SmiteTeam smiteTeam = (SmiteTeam)team;
		switch (smitePlayer.getRole()){
			case SOLO:
				return smiteTeam.getSolo() == null;
			case JUNGLER:
				return smiteTeam.getJungler() == null;
			case MID:
				return smiteTeam.getMid() == null;
			case SUPPORT:
				return smiteTeam.getSupport() == null;
			case BOTTOM:
				return smiteTeam.getBottom() == null;
			default:
				return false;
		}
	}


	public boolean isComplete(AbstractTeam team) {
		SmiteTeam smiteTeam = (SmiteTeam)team;
		return (smiteTeam.getSolo() != null &&
				smiteTeam.getJungler() != null &&
				smiteTeam.getMid() != null &&
				smiteTeam.getSupport() != null &&
				smiteTeam.getBottom() != null);
	}
}