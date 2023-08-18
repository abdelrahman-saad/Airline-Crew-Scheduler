package edu.unl.cse.csce361.airline_crew_scheduler.logic;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

import edu.unl.cse.csce361.airline_crew_scheduler.Airplane;
import edu.unl.cse.csce361.airline_crew_scheduler.Airport;
import edu.unl.cse.csce361.airline_crew_scheduler.Captain;
import edu.unl.cse.csce361.airline_crew_scheduler.FirstOfficer;
import edu.unl.cse.csce361.airline_crew_scheduler.Flight;
import edu.unl.cse.csce361.airline_crew_scheduler.FlightAttendant;
import edu.unl.cse.csce361.airline_crew_scheduler.GBR10Airplane;
import edu.unl.cse.csce361.airline_crew_scheduler.NU150Airplane;
import edu.unl.cse.csce361.airline_crew_scheduler.Person;
import edu.unl.cse.csce361.airline_crew_scheduler.StandbyCrew;
import edu.unl.cse.csce361.airline_crew_scheduler.backend.ParseData;

public class Logic {
	private static Logic instance = new Logic();
	private ArrayList<Flight> flightList = new ArrayList<Flight>();
	private ArrayList<Person> personList = new ArrayList<Person>();
	
	public static Logic getInstance() {
		return instance;
	}
	public Logic () {
		this.flightList = flightList();
		this.personList = personList();
	}
	public List<Flight> getFlightList() {
		return this.flightList;
	}
	
	
	public ArrayList<Person> personList(){
		ParseData parseData = ParseData.getInstance();
		ArrayList<Person> personList = new ArrayList<Person>();
		Set<Map<String, String>> personsFromFile = parseData.getPersons();
		String name = "";
		String role = "";
		String credentials = "";
		String origin = "";
		Captain newCaptain = null;
		FirstOfficer newFirstOfficer = null;
		FlightAttendant newFlightAttendant = null;
		StandbyCrew newStandbyCrew = null;
		
		for(Map<String, String> mapPersons : personsFromFile) {
			for(Map.Entry<String, String> mapValue : mapPersons.entrySet()) {
				if(mapValue.getKey().contains("Name")) {
					name = mapValue.getValue();
				}else if(mapValue.getKey().contains("Role")) {
					role = mapValue.getValue();
				}else if(mapValue.getKey().contains("Origin") && !(mapValue.getValue().isEmpty())) {
					origin = mapValue.getValue();
				}else if(mapValue.getKey().contains("Credentials")) {
					credentials = mapValue.getValue();
				}
			}
			
			if(role.contentEquals("C")) {
				newCaptain = new Captain(name, credentials, role);
				personList.add(newCaptain);
			}else if(role.contentEquals("FO")) {
				newFirstOfficer = new FirstOfficer(name, credentials, role);
				personList.add(newFirstOfficer);
			}else if(role.contentEquals("FA")) {
				newFlightAttendant = new FlightAttendant(name, role);
				personList.add(newFlightAttendant);
			}else if(role.contentEquals("SC")) {
				newStandbyCrew = new StandbyCrew(name, origin, role);
				personList.add(newStandbyCrew);
			}
		}
		return personList;
	}
	
	public ArrayList<Flight> flightList() {
		
		ArrayList<StandbyCrew> standbyCrewList = new ArrayList<StandbyCrew>();
		
		ArrayList<Person> personList = new ArrayList<Person>();
		
		personList = personList();
		int i = 0;
		
		for(i = 0; i < personList.size(); i++) {
			if(personList.get(i).getRole().contentEquals("SC")) {
				standbyCrewList.add((StandbyCrew) personList.get(i));
			}
		}
		
		//Captains
		Captain stuDent = new Captain("Stu Dent", "both", "C");
		Captain robertTho = new Captain("Robert Tho", "NU-150", "C");
		Captain bradPitt = new Captain("Brad Pitt", "GBR-10", "C");
		Captain johnWall = new Captain("John Wall", "both", "C");
		Captain bryanCranston = new Captain("Bryan Cranston", "NU-150", "C");
		Captain jeffBezos = new Captain("Jeff Bezos", "GBR-10", "C");
		
		//First Officers
		FirstOfficer bobDan = new FirstOfficer("Bob Dan", "both", "FO");
		FirstOfficer roeWade = new FirstOfficer("Roe Wade", "NU-150", "FO");
		FirstOfficer leoDicaprio = new FirstOfficer("Leonardo Dicaprio", "GBR-10", "FO");
		FirstOfficer tomBrady = new FirstOfficer("Tom Brady", "both", "FO");
		FirstOfficer aaronPaul = new FirstOfficer("Aaron Paul", "NU-150", "FO");
		FirstOfficer scottFrost = new FirstOfficer("Scott Frost", "GBR-10", "FO");
		
		//Flight Attendants
		FlightAttendant joeLe = new FlightAttendant("Joe Le", "FA");
		FlightAttendant benDover = new FlightAttendant("Ben Dover", "FA");
		FlightAttendant tomHanks = new FlightAttendant("Tom Hanks", "FA");
		FlightAttendant lebronJames = new FlightAttendant("Lebron James", "FA");
		FlightAttendant paulRudd = new FlightAttendant("Paul Rudd", "FA");
		FlightAttendant ryanReynolds = new FlightAttendant("Ryan Reynolds", "FA");
		
		//StandbyCrew
		StandbyCrew janeDoe = new StandbyCrew("Jane Doe", "SC");
		StandbyCrew cliveJohn = new StandbyCrew("Clive John", "SC");
		StandbyCrew williamNelson = new StandbyCrew("William Nelson", "SC");
		StandbyCrew kobeBryant = new StandbyCrew("Kobe Bryant", "SC");
		StandbyCrew billGates = new StandbyCrew("Bill Gates", "SC");
		StandbyCrew blakeLively = new StandbyCrew("Blake Lively", "SC");
		StandbyCrew robbinWillaims = new StandbyCrew("Robbin Williams", "SC");
		StandbyCrew steveCorral = new StandbyCrew("Steve Corral", "SC");
		StandbyCrew billBurr = new StandbyCrew("Bill Burr", "SC");
		StandbyCrew larryTheCableGuy = new StandbyCrew("Larry The Cable Guy", "SC");
		StandbyCrew daveChappel = new StandbyCrew("Dave Chappel", "SC");
		StandbyCrew jamesFranco = new StandbyCrew("James Franco", "SC");
		StandbyCrew jonahHill = new StandbyCrew("Jonah Hill", "SC");
		StandbyCrew kitHarrington = new StandbyCrew("Kit Harrington", "SC");
		StandbyCrew jamesHarden = new StandbyCrew("James Harden", "SC");
		StandbyCrew lanzoBall = new StandbyCrew("Lanzo Ball", "SC");
		
		ArrayList<StandbyCrew> nebraskaStandbyCrew = new ArrayList<StandbyCrew>();
		ArrayList<StandbyCrew> iowaStandbyCrew = new ArrayList<StandbyCrew>();
		ArrayList<StandbyCrew> illinoisStandbyCrew = new ArrayList<StandbyCrew>();
		ArrayList<StandbyCrew> indianaStandbyCrew = new ArrayList<StandbyCrew>();
		
		nebraskaStandbyCrew.add(janeDoe);
		nebraskaStandbyCrew.add(cliveJohn);
		nebraskaStandbyCrew.add(williamNelson);
		iowaStandbyCrew.add(kobeBryant);
		iowaStandbyCrew.add(billGates);
		iowaStandbyCrew.add(blakeLively);
		illinoisStandbyCrew.add(robbinWillaims);
		illinoisStandbyCrew.add(steveCorral);
		illinoisStandbyCrew.add(billBurr);
		indianaStandbyCrew.add(larryTheCableGuy);
		indianaStandbyCrew.add(daveChappel);
		indianaStandbyCrew.add(jamesFranco);
		
		//Airports
		Airport nebraskaAirport = new Airport("Lincoln, Nebraska", nebraskaStandbyCrew);
		Airport iowaAirport = new Airport("Iowa City, Iowa", iowaStandbyCrew);
		Airport illinoisAirport = new Airport("Evanston, Illinois", illinoisStandbyCrew);
		Airport indianaAirport = new Airport("West Lafayette, Indiana", indianaStandbyCrew);
		
		
		
		//Airplanes
		GBR10Airplane gbr1 = new GBR10Airplane(45, "GBR-10-1", nebraskaAirport);
		NU150Airplane nu1 = new NU150Airplane(75, "NU-150-1", illinoisAirport);
		NU150Airplane nu2 = new NU150Airplane(75, "NU-150-2", iowaAirport);
		GBR10Airplane gbr2 = new GBR10Airplane(45, "GBR-10-2", indianaAirport);
		
		//Flights
		ArrayList<Flight> flightList = new ArrayList<Flight>();

		//nebraska flights
		LocalDateTime takeOff1 = LocalDateTime.of(2019, Month.DECEMBER, 13, 8, 00, 00);
		LocalDateTime landing1 = LocalDateTime.of(2019, Month.DECEMBER, 13, 11, 00, 00);
		LocalDateTime takeOff2 = LocalDateTime.of(2019, Month.DECEMBER, 13, 12, 00, 00);
		LocalDateTime landing2 = LocalDateTime.of(2019, Month.DECEMBER, 13, 13, 00, 00);
		LocalDateTime takeOff3 = LocalDateTime.of(2019, Month.DECEMBER, 13, 14, 00, 00);
		LocalDateTime landing3 = LocalDateTime.of(2019, Month.DECEMBER, 13, 18, 00, 00);
		
		//iowa flights
		LocalDateTime takeOff4 = LocalDateTime.of(2019, Month.DECEMBER, 13, 4, 00, 00);
		LocalDateTime landing4 = LocalDateTime.of(2019, Month.DECEMBER, 13, 8, 00, 00);
		LocalDateTime takeOff5 = LocalDateTime.of(2019, Month.DECEMBER, 13, 9, 00, 00);
		LocalDateTime landing5 = LocalDateTime.of(2019, Month.DECEMBER, 13, 13, 00, 00);
		
		//indian flights
		LocalDateTime takeOff6 = LocalDateTime.of(2019, Month.DECEMBER, 13, 0, 00, 00);
		LocalDateTime landing6 = LocalDateTime.of(2019, Month.DECEMBER, 13, 3, 00, 00);
		LocalDateTime takeOff7 = LocalDateTime.of(2019, Month.DECEMBER, 13, 4, 00, 00);
		LocalDateTime landing7 = LocalDateTime.of(2019, Month.DECEMBER, 13, 8, 00, 00);
		LocalDateTime takeOff8 = LocalDateTime.of(2019, Month.DECEMBER, 13, 9, 00, 00);
		LocalDateTime landing8 = LocalDateTime.of(2019, Month.DECEMBER, 13, 10, 00, 00);
		
		//Illinois flights
		LocalDateTime takeOff9 = LocalDateTime.of(2019, Month.DECEMBER, 13, 16, 00, 00);
		LocalDateTime landing9 = LocalDateTime.of(2019, Month.DECEMBER, 13, 19, 00, 00);
		LocalDateTime takeOff10 = LocalDateTime.of(2019, Month.DECEMBER, 13, 20, 00, 00);
		LocalDateTime landing10 = LocalDateTime.of(2019, Month.DECEMBER, 13, 21, 00, 00);
		LocalDateTime takeOff11 = LocalDateTime.of(2019, Month.DECEMBER, 13, 22, 00, 00);
		LocalDateTime landing11 = LocalDateTime.of(2019, Month.DECEMBER, 14, 2, 00, 00);
		
		Flight flightOne = new Flight("1", gbr1, stuDent, bobDan, joeLe, nebraskaAirport, illinoisAirport, nebraskaStandbyCrew, takeOff1, landing1);
		Flight flightTwo = new Flight("2", gbr1, stuDent, bobDan, joeLe, illinoisAirport, indianaAirport, illinoisStandbyCrew, takeOff2, landing2);
		Flight flightThree = new Flight("3", gbr1, stuDent, bobDan, joeLe, indianaAirport, nebraskaAirport, indianaStandbyCrew, takeOff3, landing3);
		Flight flightFour = new Flight("4", nu2, bradPitt, leoDicaprio, lebronJames, paulRudd, iowaAirport, illinoisAirport, iowaStandbyCrew, takeOff4, landing4);
		Flight flightFive = new Flight("5", nu2, bradPitt, leoDicaprio, lebronJames, paulRudd, illinoisAirport, iowaAirport, illinoisStandbyCrew, takeOff5, landing5);
		Flight flightSix = new Flight("6", gbr2, johnWall, tomBrady, ryanReynolds, indianaAirport, iowaAirport, indianaStandbyCrew, takeOff6, landing6);
		Flight flightSeven = new Flight("7", gbr2, johnWall, tomBrady, ryanReynolds, iowaAirport, illinoisAirport, iowaStandbyCrew, takeOff7, landing7);
		Flight flightEight = new Flight("8", gbr2, johnWall, tomBrady, ryanReynolds, illinoisAirport, indianaAirport, illinoisStandbyCrew, takeOff8, landing8);
		Flight flightNine = new Flight("9", nu1, robertTho, roeWade, benDover, tomHanks, illinoisAirport, nebraskaAirport, illinoisStandbyCrew, takeOff9, landing9);
		Flight flightTen = new Flight("10", nu1, robertTho, roeWade, benDover, tomHanks, nebraskaAirport, iowaAirport, nebraskaStandbyCrew, takeOff10, landing10);
		Flight flightEleven = new Flight("11", nu1, robertTho, roeWade, benDover, tomHanks, iowaAirport, illinoisAirport, iowaStandbyCrew, takeOff11, landing11);
		
		flightList.add(flightOne);
		flightList.add(flightTwo);
		flightList.add(flightThree);
		flightList.add(flightFour);
		flightList.add(flightFive);
		flightList.add(flightSix);
		flightList.add(flightSeven);
		flightList.add(flightEight);
		flightList.add(flightNine);
		flightList.add(flightTen);
		flightList.add(flightEleven);

		return flightList;
	}


	/*
	* 1- search by flight number
	* 2- search by crew member
	* 3- airport
	* 4- date range*/

	public String searchFlights(int i, String key){
		ArrayList<Flight> flights = flightList();
		String rand = "";
		rand += String.valueOf(LocalDateTime.now().getYear());
		rand += (String.valueOf( LocalDateTime.now().getMonth().getValue()));
		int n = (int) (Math.random() * (10));
		rand += (String.valueOf(n));
		StringBuilder sb = new StringBuilder();
    	sb.append(String.format("%-20s %-30s %-30s %-30s %15s\n", "Flight Number", "Origin Airport", "Destination Airport", 
    			"Scheduled Take Off", "Scheduled Touchdown", "Captain", "First Officer", "Duration"));
    	System.out.println(sb);
		switch (i){
			case 1:
				for (Flight flight:flights) {
					if(flight.getFlightNum().equals(key)) {
						flight.printAllDetails();
					}
				}
				return rand;
			case 2:
				for (Flight flight:flights) {
					for (StandbyCrew member: flight.getCrewMembersList()) {
						if(member.getName().equalsIgnoreCase(key)){
							flight.printAllDetails();
						}
					}
					if(flight.getCaptain().getName().equalsIgnoreCase(key)|| flight.getFlightAttendant1().getName().equalsIgnoreCase(key) ||
							(flight.getFlightAttendant2() != null && flight.getFlightAttendant2().getName().equalsIgnoreCase(key)) || flight.getFirstOfficer().getName().equalsIgnoreCase(key)) {
						flight.printAllDetails();
					}
				}
				return rand;
			case 3:
				for (Flight flight:flights) {
					if (flight.getOriginAirport().getAirPortName().equalsIgnoreCase(key) || flight.getDestinationAirport().getAirPortName().equalsIgnoreCase(key)){
						flight.printAllDetails();
					} 
				}
				return rand;
			case 4:
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
				Date dateformatter = new Date();
				try {
					 dateformatter = format.parse(key);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				LocalDateTime date = dateformatter.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				for (Flight flight:flights) {
					if (
							(date.compareTo(flight.getScheduledTakeOffTime()) >=0) &&
									(date.compareTo(flight.getScheduledTouchdownTime()) <=0)){ 
						flight.printAllDetails();
					}
				}
				return rand;
			default:
				return "Wrong number entered :(";
		}
	}

	public void showAllTrips(){
		ArrayList<Flight> flights = this.flightList;
		int i = 0;
		StringBuilder sb = new StringBuilder();
    	sb.append(String.format("%-20s %-30s %-30s %-30s %15s\n", "Flight Number", "Origin Airport", "Destination Airport", 
    			"Scheduled Take Off", "Scheduled Touchdown", "Captain", "First Officer", "Duration"));
    	System.out.println(sb);
		for (Flight flight: flights) {
			flight.printAllDetails();
			i++;
		}
	}

	public ArrayList<Flight> cancelFlight(String flightNum){
		for(int i = 0; i< this.flightList.size(); i++) {
			if(flightList.get(i).getFlightNum().equals(flightNum)) {
				this.flightList.remove(i);
				i++;
			}
		}
		return this.flightList;
	}
	
	public void changeCaptain(String name, String flightNumber) {
		ArrayList<Person> personList = personList();
		ArrayList<Flight> flightList = this.flightList;
		Captain captain = null;
	
		for(Person p: personList) {
			if(p.getName().equalsIgnoreCase(name)){
				captain = new Captain(p.getName(), p.getCredentials(), p.getRole());
			}
		}
		for(Flight f: this.flightList) {
			if(f.getFlightNum().equals(flightNumber)) {
				f.setCaptain(captain);
			}
		}
	}
	
	public void changeFirstOfficer(String name, String flightNumber) {
		ArrayList<Person> personList = personList();
		ArrayList<Flight> flightList = this.flightList;
		FirstOfficer firstOfficer = null;
	
		for(Person p: personList) {
			if(p.getName().equalsIgnoreCase(name)){
				firstOfficer = new FirstOfficer(p.getName(), p.getCredentials(), p.getRole());
			}
		}
		for(Flight f: flightList) {
			if(f.getFlightNum().equals(flightNumber)) {
				f.setFirstOfficer(firstOfficer);
			}
		}
	}
	
	public void changeFlightAttendant(String name, String flightNumber) {
		ArrayList<Person> personList = personList();
		ArrayList<Flight> flightList = this.flightList;
		FlightAttendant flightAttendant = null;
	
		for(Person p: personList) {
			if(p.getName().equalsIgnoreCase(name)){
				flightAttendant = new FlightAttendant(p.getName(), p.getRole());
			}
		}
		for(Flight f: flightList) {
			if(f.getFlightNum().equals(flightNumber)) {
				f.setFlightAttendant1(flightAttendant);
			}
		}
	}
}
