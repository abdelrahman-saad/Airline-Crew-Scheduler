package edu.unl.cse.csce361.airline_crew_scheduler;

//import edu.unl.cse.csce361.airline_crew_scheduler.Airport.String;

public class StandbyCrew extends Person {
	private String origin;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public StandbyCrew(String name,  String role) {
		super(name, role);
	}
	
	public StandbyCrew(String name, String originAirport, String role) {
		this(name, role);
		origin = originAirport;
	}

	@Override
	public String getRole() {
		return "SC";
	}

}

