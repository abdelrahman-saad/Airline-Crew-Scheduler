package edu.unl.cse.csce361.airline_crew_scheduler;

public class NU150Airplane extends Airplane {
    public NU150Airplane(int numOfPAssengers, String airplaneName, Airport airport) {
        super(numOfPAssengers, airplaneName, airport);
    }

    @Override
    public int getNumOfPassengers() {
        return 75;
    }

    @Override
    public String getAirplaneType() {
        return "NU";
    }
}

