package edu.unl.cse.csce361.airline_crew_scheduler;
import edu.unl.cse.csce361.airline_crew_scheduler.Person.*;

import java.util.ArrayList;

public  class Airport {
    String airportName;
    ArrayList<StandbyCrew> StandbyCrewList;

    public String getAirPortName() {
        return this.airportName;
    }

    public void setAirPortName(String airportName) {
        this.airportName = airportName;
    }

    public Airport(String airportName, ArrayList<StandbyCrew> standbyCrewList) {
        this.airportName = airportName;
        this.StandbyCrewList = standbyCrewList;
    }
}


