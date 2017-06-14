package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import business.lol.SmiteRegioes;
import business.lol.SmiteRole;

@Entity
@Table(name="SMITEPLAYER")
public class SmitePlayer extends AbstractPlayer {
	
	@Column(name = "smiterole")
	@Enumerated(EnumType.STRING)
	private SmiteRole role;
	
	@Column(name = "smiteregion")
	@Enumerated(EnumType.STRING)
	private SmiteRegioes region;

	
	public SmiteRole getRole() {
		return role;
	}

	public void setRole(SmiteRole role) {
		this.role = role;
	}

	public SmiteRegioes getRegion() {
		return region;
	}

	public void setRegion(SmiteRegioes region) {
		this.region = region;
	}

	
	
	
}
