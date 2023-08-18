package edu.unl.cse.csce361.airline_crew_scheduler;

public class Captain extends Person{


	public Captain(String name, String credentials, String role) {
		super(name, credentials, role);
	}

	@Override
	public String getRole() {
		return "C";
	}

}


