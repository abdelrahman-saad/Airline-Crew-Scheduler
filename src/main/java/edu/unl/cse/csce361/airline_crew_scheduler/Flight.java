package edu.unl.cse.csce361.airline_crew_scheduler;

import edu.unl.cse.csce361.airline_crew_scheduler.Airplane.*;
import edu.unl.cse.csce361.airline_crew_scheduler.Airport.*;
import edu.unl.cse.csce361.airline_crew_scheduler.Person.*;
//import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class Flight{
    private  LocalDateTime scheduledTouchdownTime;
    private String flightNumber;
    private Airplane airplane;
    private Captain captain;
    private FirstOfficer firstOfficer;
    private FlightAttendant flightAttendant1;
    private FlightAttendant flightAttendant2;
    private int numberofPassengers;

    private Airport originAirport;
    private Airport destinationAirport;
    private ArrayList<StandbyCrew> crewMembers;
    private LocalDateTime scheduledTakeOffTime;
    private LocalDateTime estimatedTakeOff;
    private LocalDateTime actualTakeOff;
    private LocalDateTime touchdownTime;
    private LocalDateTime estimatedTouchdownTime;
    private LocalDateTime actualTouchdownTime;
    private Long duration;


    public Flight(String flightNumber, Airplane airplane, Captain captain, FirstOfficer firstOfficer, FlightAttendant flightAttendant1, FlightAttendant flightAttendant2, Airport originAirport,
                  Airport destinationAirport, ArrayList<StandbyCrew> crewMembers, LocalDateTime scheduledTakeOffTime, LocalDateTime scheduledTouchdownTime) {
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.captain = captain;
        this.firstOfficer = firstOfficer;
        this.flightAttendant1 = flightAttendant1;
        this.flightAttendant2 = flightAttendant2;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.crewMembers = crewMembers;
        this.scheduledTakeOffTime = scheduledTakeOffTime;
        this.scheduledTouchdownTime = scheduledTouchdownTime;
    }
    
    public Flight(String flightNumber, Airplane airplane, Captain captain, FirstOfficer firstOfficer, FlightAttendant flightAttendant1, Airport originAirport,
            Airport destinationAirport, ArrayList<StandbyCrew> crewMembers, LocalDateTime scheduledTakeOffTime, LocalDateTime scheduledTouchdownTime) {
    	this.flightNumber = flightNumber;
    	this.airplane = airplane;
    	this.captain = captain;
    	this.firstOfficer = firstOfficer;
    	this.flightAttendant1 = flightAttendant1;
    	this.originAirport = originAirport;
    	this.destinationAirport = destinationAirport;
    	this.crewMembers = crewMembers;
    	this.scheduledTakeOffTime = scheduledTakeOffTime;
    	this.scheduledTouchdownTime = scheduledTouchdownTime;
    	
    }
        
    public long getDuration() {
    	this.duration = scheduledTakeOffTime.until(scheduledTouchdownTime, ChronoUnit.HOURS);
    	return this.duration;
    }

    public void setTakeOff(LocalDateTime scheduledTakeOffTime) {
        this.scheduledTakeOffTime = scheduledTakeOffTime;
    }
// to indicate if there is a delay to depart
    public void setEstimatedTakeOff(LocalDateTime estimatedTakeOff) {
        this.estimatedTakeOff = estimatedTakeOff;
        this.estimatedTouchdownTime= this.estimatedTakeOff.plusHours(duration);
    }

    public void setActualTakeOff(LocalDateTime actualTakeOff) {
        this.actualTakeOff = actualTakeOff;
        this.estimatedTouchdownTime = this.actualTakeOff.plusHours(duration);

    }

    public void setTouchdownTime(LocalDateTime touchdownTime) {
        this.touchdownTime = touchdownTime;
    }
    // can be used to determine if a flight was delayed. this is for landing due to weather eg.
    public void setEstimatedTouchdownTime(LocalDateTime estimatedTouchdownTime) {
        if(estimatedTouchdownTime.isBefore(estimatedTakeOff))
            this.estimatedTouchdownTime = estimatedTouchdownTime;
        else
            System.out.println("Sorry you cannot update the touchdown time because it was before the takeoff time");
    }

    public void setActualTouchdownTime(LocalDateTime actualTouchdownTime) {
        this.actualTouchdownTime = actualTouchdownTime;

    }

    public String getFlightNum() {
    	return this.flightNumber;
    }
    
    public Airplane getAirplane() {
    	return this.airplane;
    }
    
    public Captain getCaptain() {
    	return this.captain;
    }
    
    public void setCaptain(Captain captain) {
    	this.captain = captain;
    }
    
    public FirstOfficer getFirstOfficer() {
    	return this.firstOfficer;
    }
    
    public void setFirstOfficer(FirstOfficer firstOfficer) {
    	this.firstOfficer = firstOfficer;
    }

    public FlightAttendant getFlightAttendant1() {
    	return this.flightAttendant1;
    }
    
    public void setFlightAttendant1(FlightAttendant flightAttendant1) {
    	this.flightAttendant1 = flightAttendant1;
    }
    
    public FlightAttendant getFlightAttendant2() {
    	return this.flightAttendant2;
    }
    
    public void setFlightAttendant2(FlightAttendant flightAttendant2) {
    	this.flightAttendant2 = flightAttendant2;
    }
    
    public int getNumOfPassengers() {
    	return this.numberofPassengers;
    }
    
    public Airport getOriginAirport() {
    	return this.originAirport;
    }
    
    public Airport getDestinationAirport() {
    	return this.destinationAirport;
    }
    
    public ArrayList<StandbyCrew> getCrewMembersList(){
    	return this.crewMembers;
    }
    
    public LocalDateTime getScheduledTakeOffTime() {
    	return this.scheduledTakeOffTime;
    }
    
    public LocalDateTime getEstimatedTakeOff() {
    	return this.estimatedTakeOff;
    }
    
    public LocalDateTime getActualTakeOff() {
    	return this.actualTakeOff;
    }
    
    public LocalDateTime getScheduledTouchdownTime() {
    	return this.scheduledTouchdownTime;
    }
    
    public LocalDateTime getEstimatedTouchdownTime() {
    	return this.estimatedTouchdownTime;
    }
    
    public LocalDateTime getActualTouchdownTime() {
    	return this.actualTouchdownTime;
    }
    public void printFlight(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(String.format("%-8s %-30s %-10s %-30s %9s\n", "Flight Number", "Origin Airport", "Destination Airport", 
    			"Scheduled Take Off", "Scheduled Touchdown", "Captain", "First Officer", "Duration"));
    	sb.append(String.format("%-8s %-30s %-10s %-30s\n", getFlightNum(), getOriginAirport().getAirPortName(), 
    			getDestinationAirport().getAirPortName(), getScheduledTakeOffTime().toString(),getScheduledTouchdownTime().toString()));
    	System.out.println(sb);
    }
    public void printAllDetails(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(String.format("%-20s %-30s %-30s %-30s %15s\n", getFlightNum(), getOriginAirport().getAirPortName(), 
    			getDestinationAirport().getAirPortName(), getScheduledTakeOffTime().toString(),getScheduledTouchdownTime().toString()));
    	System.out.println(sb);
    }
}

