package edu.unl.cse.csce361.airline_crew_scheduler;

public abstract class Airplane {
	private int numOfPassengers;
	private Airport airport;
	private String airplaneName;

	public Airplane(int numOfPAssengers, String airplaneName, Airport airport) {
		this.numOfPassengers = numOfPAssengers;
		this.airport = airport;
		this.airplaneName = airplaneName;
	}

	public Airport getAirport() {
		return this.airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public abstract int getNumOfPassengers();

	public abstract String getAirplaneType();

}
