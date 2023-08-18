package edu.unl.cse.csce361.airline_crew_scheduler;


public class FirstOfficer extends Person {


	public FirstOfficer(String name, String credentials, String role) {
		super(name, credentials, role);
	}

	@Override
	public String getRole() {
		return "FO";
	}

}

