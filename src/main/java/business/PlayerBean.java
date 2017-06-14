package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import api.AbstractProfile;
import api.FacadeAPI;
import api.exceptions.ConnectionException;
import business.exceptions.BusinessException;
import model.entities.SmitePlayer;
import model.entities.User;
import model.persistence.service.SmitePlayerService;
import model.persistence.service.UserService;

@Stateless
public class PlayerBean {
	
	@EJB
	private SmitePlayerService smitePlayerService;
	@EJB
	private UserService userService;

	public SmitePlayer findById(Integer id) throws BusinessException {
		SmitePlayer ab = smitePlayerService.findById(id);
		if (ab != null)
			return ab;
		else
			throw new BusinessException("Player não encontrado.");
	}

	public void incluirPlayer(User user, SmitePlayer smitePlayer) throws ConnectionException {
				
		FacadeAPI api = new FacadeAPI();
		AbstractProfile absProfile = api.getProfile(smitePlayer.getPlayerName(), smitePlayer.getRegion().name());
		
		if(absProfile != null){
			
			smitePlayer.setGamePlayerID(absProfile.getId());
			smitePlayer.setPlayerLevel(absProfile.getLevel());
			smitePlayer.setPlayerName(absProfile.getName());
			
			User auxUser = userService.findById(user.getIdUsuario());
			auxUser.setPlayer(smitePlayer);
			userService.update(auxUser);
			
		}else{
			throw new ConnectionException("Game Profile não localizado.");
		}
		
	}
	
	public void atualizarPlayer(SmitePlayer player){
		smitePlayerService.update(player);
	}

}
