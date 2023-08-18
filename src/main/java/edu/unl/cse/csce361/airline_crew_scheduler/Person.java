package edu.unl.cse.csce361.airline_crew_scheduler;

public abstract class Person {

    private String name;
    private String credentials;
    private String role;

    public Person(String name, String credentials, String role) {
        this.name = name;
        this.credentials = credentials;
        this.role = role;
    }
    
    public Person(String name, String role) {
    	this.name = name;
    	this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //credentials are what planes the captain can fly
    //"both" == can fly both planes
    //"NU-150" == can fly NU-150
    //"GBR-10" == can fly GBR-10
    public String getCredentials() {
        return this.credentials;
    }

    //Dont think we will need this
    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public boolean verifyCredntials(Airplane airplane) {
        if(airplane.getAirplaneType().contentEquals("NU-150") && credentials.contentEquals("NU-150")) {
            return true;
        }else if(airplane.getAirplaneType().contentEquals("GBR-10") && credentials.contentEquals("GBR-10")){
            return true;
        }else if(credentials.contentEquals("both")) {
            return true;
        }
        return false;
    }

    public abstract String getRole();

    public void setRole(String role) {
        this.role = role;
    }
}
