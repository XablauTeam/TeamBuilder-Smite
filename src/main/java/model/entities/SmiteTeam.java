package model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="smiteteam")
public class SmiteTeam extends AbstractTeam {
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "solo")
	private SmitePlayer solo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "jungler")
	private SmitePlayer jungler;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mid")
	private SmitePlayer mid;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "support")
	private SmitePlayer support;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bottom")
	private SmitePlayer bottom;
	
	public SmiteTeam(){
		super();
	}

	public SmitePlayer getSolo() {
		return solo;
	}

	public void setSolo(SmitePlayer top) {
		this.solo = top;
	}

	public SmitePlayer getJungler() {
		return jungler;
	}

	public void setJungler(SmitePlayer jungler) {
		this.jungler = jungler;
	}

	public SmitePlayer getMid() {
		return mid;
	}

	public void setMid(SmitePlayer mid) {
		this.mid = mid;
	}

	public SmitePlayer getSupport() {
		return support;
	}

	public void setSupport(SmitePlayer support) {
		this.support = support;
	}

	public SmitePlayer getBottom() {
		return bottom;
	}

	public void setBottom(SmitePlayer bottom) {
		this.bottom = bottom;
	}
}