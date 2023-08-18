package edu.unl.cse.csce361.airline_crew_scheduler.backend;

import java.util.Map;
import java.util.Set;

public class ParseData {
	
	private static ParseData instance = new ParseData();
	
	public static ParseData getInstance() {
		return instance;
	}

	public Set<Map<String, String>> getFlights(){
		return CSVReaderWriter.readCSV("flights.csv");
	}
	
	public Set<Map<String, String>> getPersons(){
		return CSVReaderWriter.readCSV("persons.csv");
	}

}
