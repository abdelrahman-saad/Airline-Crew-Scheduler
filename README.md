#   AIRLINE CREW SCHEDULER

##  Incomplete features 
-   Does not give user the option to change estimated takeoff time,estimated touchdown time, airplane in the start up menu in Main.java
-   Did not accomodate and check the number of hours employees worked

##  Instructions to build and run the program
-   User will need to refer to the specific names in persons.csv and flight details from hardcoded data in flightList() method to run this program 

##  Description

Cornhusker Airways (CHA) is a small regional airline that flies out of
Lincoln, Nebraska; Iowa City, Iowa; Evanston, Illinois; and West Lafayette,
Indiana.  CHA needs a crew scheduling system to keep track of which employees
are on (or are scheduled to be on) each flight.  The crew positions are:

-   *Captain* - One of two cockpit positions.  The captain must be a qualified
    pilot for the particular aircraft.
-   *First Officer* - One of two cockpit positions.  The first officer must be
    a qualified pilot or co-pilot for the particular aircraft.
-   *Flight Attendant* - Crew member(s) who are responsible for the safety of
    passengers in the main cabin.

CHA operates two types of passenger aircraft.  **GBR-10** aircraft can
carry 45 passengers, and **NU-150** aircraft can carry 75 passengers. You may
assume both types of aircraft have enough range to fly between any two
airports that CHA services and, under ideal conditions, will average 500 mph
when flying between airports.  You do not need to keep track of the
maintenance condition of the aircraft.

Each flight must have a flight number, an aircraft (designated by aircraft
type and registration number), a captain, a first officer, plus one flight
attendant for every fifty passengers (rounded up).  A flight has an origin
airport, a destination airport, a scheduled takeoff time, an estimated takeoff
time, an actual takeoff time, a scheduled touchdown time, an estimated
touchdown time, and an actual touchdown time.  (For our purposes, a "time"
combines the date and the time of date.)

Each airport must have a full standby crew for each type of aircraft, though
the standby crew members may be assigned to flights individually rather than
as an atomic crew.

Updates to the schedule must be maintained in an electronic log that can be
searched by flight, crew member, airport, and/or date range.  Each update will
generate a unique update number, represented as `YYYYMM-n`, where `n` is a
positive integer, `MM` is a two-digit representation of the month, and `YYYY`
is a four-digit representation of the year.

### Schedule Updates

These are the schedule updates that the system shall support:

-   Place aircraft.  Establishes the initial airport for an aircraft.  This is
    done once per aircraft when it is brought into CHA's fleet.
-   Place employee.  Establishes the initial airport for a crew member.  This
    is done when a crew member is first employed and anytime a crew member is
    flown as a passenger to another airport.
-   Qualify pilot.  Establishes that a crew member is qualified to be a co-
    pilot for a particular aircraft or is qualified to be a pilot for a
    particular aircraft.  This is done when a pilot or co-pilot qualifies to
    operate an aircraft they were not previously qualified to operate and when
    a co-pilot upgrades their qualification to pilot.
-   Create flight.  When a flight is initially created, it will have only a
    flight number, an aircraft, origin & destination airports, and scheduled
    takeoff & touchdown times, and the required crew members.  The scheduled
    times cannot be changed.
-   Cancel flight.  This frees crew members for other flights.
-   Change crew member.  This removes an employee from a flight and adds a
    different employee.
-   Change aircraft.  Cannot be done after the actual takeoff time has been set.
-   Change estimated takeoff time.  This will also set the estimated touchdown
    time to the estimated takeoff time plus the duration of the flight.  A
    typical use for this update would be a delay before the flight departs,
    such as due to weather or maintenance.
-   Set actual takeoff time.  This will also set the estimated touchdown time
    to the actual takeoff time plus the duration of the flight.
-   Change estimated touchdown time.  A typical use for this update would be an
    in-flight delay, such as due to weather.
-   Set actual touchdown time.

### Schedule Constraints

The crew scheduling software shall check for the following constraints:
-   Each flight must have sufficient qualified crew members
-   A flight cannot use an aircraft that is not located at the origin airport
-   An aircraft must have at least 30 minutes between touching down for one
    flight and taking off for the next
-   If a flight's estimated or actual touchdown time is less than 30 minutes
    before the aircraft's next flight, then either the next flight must be
    delayed or the next flight's aircraft must be changed
-   A flight cannot use an employee that is not located at the origin airport
-   Once an employee's day begins, they cannot be scheduled to work more than
    eight hours
    -   An employee must have a rest period of at least sixteen hours between
        days
    -   A day begins with the scheduled takeoff time of their first flight
        after a rest period, or with the beginning of their time as a standby
        crew member
    -   Employees cannot be scheduled to be between takeoff and touchdown at
        the end of their 8-hour day
    -   If the end of an 8-hour day occurs while the crew member is on the
        ground, the crew member may not be part of a flight or standby crew
        until after a rest period
    -   If, due to an in-flight delay, the a crew member is flying at the end
        of their 8-hour day, they may complete the flight but must immediately
        enter a rest period after touchdown

##  Rubrics

The assignment is worth **100 points**:

-   **8 points** for providing meeting minutes (1 point per meeting).
-   **15 points** for implementing the functionality as required.
-   **10 points** for following Scrum practices.
-   **16 points** for making good design decisions.
-   **16 points** for using good coding style.
-   **6 points** for class diagram (3 points per sprint)
-   **10 points** for meaningful and well-formatted commit messages.
-   **9 points** for otherwise following good software engineering practices.
-   **10 points** for presentation/demonstration.

The contribution is worth **20 points**:

-   **1 point** for completing sprint 1 peer assessment
-   **1 point** for completing sprint 2 peer assessment
-   **5 points** for equitable contribution based on sprint 1 peer assessments
-   **5 points** for equitable contribution based on sprint 2 peer assessments
-   **8 points** for equitable contribution based on git history
