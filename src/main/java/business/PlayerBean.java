package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import api.AbstractProfile;
import api.FacadeAPI;
import business.exceptions.BusinessException;
import model.entities.LolPlayer;
import model.entities.User;
import model.persistence.service.LolPlayerService;
import model.persistence.service.UserService;

@Stateless
public class PlayerBean {
	
	@EJB
	private LolPlayerService lolPlayerService;
	@EJB
	private UserService userService;

	public LolPlayer findById(Integer id) throws BusinessException {
		LolPlayer ab = lolPlayerService.findById(id);
		if (ab != null)
			return ab;
		else
			throw new BusinessException("Player não encotrado.");
	}

	public void incluirPlayer(User user, LolPlayer lolPlayer) throws Exception {
				
		FacadeAPI api = new FacadeAPI();
		AbstractProfile absProfile = api.getSummoner(lolPlayer.getPlayerName(), lolPlayer.getRegion().name());
		
		
		//lolPlayer.setIdUsuario(user.getIdUsuario());
		
		
		lolPlayer.setGamePlayerID(absProfile.getId());
		lolPlayer.setPlayerLevel(absProfile.getLevel());
		lolPlayer.setPlayerName(absProfile.getName());
		
		User auxUser = userService.findById(user.getIdUsuario());
		auxUser.setPlayer(lolPlayer);
		userService.update(auxUser);
	}

}