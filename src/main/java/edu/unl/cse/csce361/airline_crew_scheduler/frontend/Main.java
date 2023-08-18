package edu.unl.cse.csce361.airline_crew_scheduler.frontend;

import java.util.Scanner;

import edu.unl.cse.csce361.airline_crew_scheduler.logic.Logic;

public class Main {
    public static void main(String[] args) {
    	Logic logic = Logic.getInstance();
    	Scanner scanner = new Scanner(System.in);
    	boolean run = true;
	        System.out.println("Welcome to the Airline Flight Scheduler!");
	        while(run) {
	        System.out.println("Select an option to start: (Ex: 1)\n");
	        System.out.println("1. View all Flights");
	        System.out.println("2. Search for a flight");
	        System.out.println("3. Cancel a flight");
	        System.out.println("4. Change crew member");
	        System.out.println("5. Exit");
	        String userInput = scanner.next(); 
	        String userInput2 = "";
        	String userValue = "";
	        if(userInput.contentEquals("1")) {
	        	logic.showAllTrips();
	        } else if(userInput.contentEquals("2")) {
	        	System.out.println("\nWhat would you like to search? (Ex: 1)\n");
	        	System.out.println("1. search by flight number");
	        	System.out.println("2. search by crew member");
	        	System.out.println("3. Search by airport");
	        	System.out.println("4. Search by time");
	        	int userSelection = scanner.nextInt();
	        	scanner = new Scanner(System.in);
	        	if(userSelection == 1) {
	        		System.out.println("\nInput flight number: ");
	        		userValue = String.valueOf(scanner.nextInt());
	        	}else if(userSelection == 2) {
	        		System.out.println("\nInput name of crew member: (First name & Last name)");
	        		userValue = scanner.nextLine();
	        	} else if(userSelection == 3) {
	        		System.out.println("\nInput name of airport: (Ex: Lincoln, Nebraska)");
	        		userValue = scanner.nextLine();
	        	} else if(userSelection == 4) {
	        		System.out.println("\nInput time: (dd-mmm-yyyy hh:mm:ss) hint* 3 chars for the ");
	        		userValue = scanner.nextLine();
	        	} else {
	        		System.out.println("Invalid number was entered");
	        	}
	        	logic.searchFlights(userSelection, userValue);
	        } else if(userInput.contentEquals("3")) {
	        	System.out.println("\nInput flight number that you would like to cancel: (Ex: 1)\n");
	        	userInput = scanner.next();
	        	logic.cancelFlight(userInput);
	        }else if(userInput.contentEquals("4")) {
	        	System.out.println("\nInput what position the crew member is in: (Ex: captain)\n");
	        	scanner = new Scanner(System.in);
	        	userValue = scanner.nextLine();
	        	if(userValue.equalsIgnoreCase("captain")) {
	        		System.out.println("\nInput name of person that is replacing the crew member: (First name & Last name)\n");
	        		userInput = scanner.nextLine();
	        	userValue = scanner.next();
        		userValue += scanner.nextLine();
	        	if(userValue.equalsIgnoreCase("captain")) {
	        		System.out.println("\nInput name of person that is replacing the crew member: (First name & Last name)\n");
	        		userValue = scanner.next();
	        		userValue += scanner.nextLine();
	        		System.out.println("\nInput flight number for crew member to switch with: (Ex: 1)\n");
	        		userInput2 = scanner.nextLine();
	        		logic.changeCaptain(userInput, userInput2);
	        	}else if(userValue.equalsIgnoreCase("first officer")) {
	        		System.out.println("\nInput name of person that is replacing the crew member: (First name & Last name)\n");
	        		userValue = scanner.next();
	        		userValue += scanner.nextLine();
	        		System.out.println("\nInput flight number for crew member to switch with: (Ex: 1)\n");
	        		userInput2 = scanner.nextLine();
	        		logic.changeFirstOfficer(userInput, userInput2);
	        	}else if(userValue.equalsIgnoreCase("flight attendant")) {
	        		System.out.println("\nInput name of person that is replacing the crew member: (First name & Last name)\n");
	        		userValue = scanner.next();
	        		userValue += scanner.nextLine();
	        		System.out.println("\nInput flight number for crew member to switch with: (Ex: 1)\n");
	        		userInput2 = scanner.nextLine();
	        		logic.changeFlightAttendant(userInput, userInput2);
	        	}
	        } else if(userInput.contentEquals("5")) {
	        	System.out.println("Thank you for using Airline Flight Scheduler!");
	        	run = false;
	        } else if(userInput != null){
	        	System.out.println("Invalid number was entered");
	        }
    	}
    }
}
