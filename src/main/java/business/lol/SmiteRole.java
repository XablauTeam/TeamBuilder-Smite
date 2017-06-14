package business.lol;

public enum SmiteRole {
	SOLO("SOLO"),
	JUNGLER("JUNGLER"),
	MID("MID"),
	SUPPORT("SUPPORT"),
	BOTTOM("BOTTOM");
	
	private final String name;
	
	private SmiteRole(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	
}
