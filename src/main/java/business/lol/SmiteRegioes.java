package business.lol;

public enum SmiteRegioes {
	br("br1"), 
	eune("eune1"),
	euw("euw1"),
	jp("jp1"),
	kr("kr"),
	lan("la1"),
	las("la2"),
	na("na1"),
	oce("oce1"),
	ru("ru"),
	tr("tr1");

	private final String name;

	private SmiteRegioes(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
