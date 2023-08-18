package edu.unl.cse.csce361.airline_crew_scheduler;

public class GBR10Airplane extends Airplane {
    public GBR10Airplane(int numOfPAssengers, String airplaneName, Airport airport) {
        super(numOfPAssengers, airplaneName, airport);
    }

    @Override
    public int getNumOfPassengers() {
        return 45;
    }

    @Override
    public String getAirplaneType() {
        return "GBR";
    }
}

