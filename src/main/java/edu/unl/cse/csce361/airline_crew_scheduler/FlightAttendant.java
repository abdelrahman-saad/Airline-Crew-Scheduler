package edu.unl.cse.csce361.airline_crew_scheduler;

public class FlightAttendant extends Person {

	public FlightAttendant(String name, String role) {
		super(role, role);
	}

	@Override
	public String getRole() {
		return "FA";
	}
}
