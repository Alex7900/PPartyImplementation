package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.NoSuchElementException;

import Objects.Event;
import Objects.User;

/*
Author:  Eric Wildfong - 190559940
         
Repository:
         https://github.com/PPartyImplementation

 -------------------------------------
 File:    Database.java
 Description: Simulated Database using txt files
 Version  4/5/2022
 -------------------------------------
 */

public class Database {

	private Map<Integer,Event> events;
	private Map<String,User> users;
	private int nextEvent;
	private User currUser=new User(-1,"","",""); 
	
	public Database() {
		events = new HashMap<Integer,Event>();
		users = new HashMap<String,User>();
		load(); // Load from the disk
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			// Register shutdown hook to save to disk
			@Override
			public void run() {
				save();
			}
			
		}));
	}
	
	private void load() {
		nextEvent = 1;
		// Load Users
		try {
			File usersFile = new File("./users.txt");
			Scanner usersScan = new Scanner(usersFile);
			while(usersScan.hasNextLine()) {
				String line = usersScan.nextLine();
				Scanner lineScan = new Scanner(line).useDelimiter("\\t");
				int userID = lineScan.nextInt();
				String username = lineScan.next();
				String email = lineScan.next();
				String pswd = lineScan.next();
				User user = new User(userID, username, email, pswd);
				putUser(user);
				lineScan.close();
			}
			usersScan.close();
		}
		catch(NoSuchElementException e) {
			System.err.println("Error loading users");
		}
		catch(FileNotFoundException e) {
			// If the event's file doesn't exist we assume there were no events
		}
		//Load events
		try {
			File eventsFile = new File("./events.txt");
			Scanner eventsScan = new Scanner(eventsFile);
			nextEvent = eventsScan.nextInt();
			eventsScan.nextLine(); // Clear the newline
			while(eventsScan.hasNextLine()) {
				String line = eventsScan.nextLine();
				Scanner lineScan = new Scanner(line).useDelimiter("\\t");
				int eventID = lineScan.nextInt();
				String eventName = lineScan.next();
				String eventDescription = lineScan.next();
				String eventGame = lineScan.next();
				String eventSkill = lineScan.next();
				int eventMax = lineScan.nextInt();
				String eventHost = lineScan.next();
				String eventStart = lineScan.next();
				LocalDateTime startTime = LocalDateTime.parse(eventStart);
				User userHost = fetchUser(new User(0, eventHost, null, null));
				if(userHost != null) {
					Event event = new Event(eventName, eventDescription, eventGame, eventSkill, eventMax, userHost, eventID, eventStart);
					//event.setStartTime(startTime);
					putEvent(event);
				}
				lineScan.close();
			}
			eventsScan.close();
		}
		catch(NoSuchElementException e) {
			System.err.println("Error loading events");
		}
		catch(FileNotFoundException e) {
			// If the event's file doesn't exist we assume there were no events
		}
	}
	
	private void save() {
		try {
			File eventsFile = new File("./events.txt");
			PrintStream eventsOut = new PrintStream(eventsFile);
			eventsOut.println(nextEvent);
			for(Event event:events.values()) {
				String s = event.getEventID() + "\t" + event.getName() + "\t" + event.getDescription() + "\t" + event.getGame() +"\t";
				s += event.getSkill_level() + "\t" + event.getMaxUsers() + "\t" + event.getHost().getUserName() + "\t";
				s += event.getStartTime().toString();
				eventsOut.println(s);
			}
			eventsOut.close();
			System.out.println("Saved Events");
		}
		catch(FileNotFoundException e) {
			System.err.println("Error saving events");
			e.printStackTrace();
		}
		try {
			File usersFile = new File("./users.txt");
			PrintStream usersOut = new PrintStream(usersFile);
			for(User user:users.values()) {
				String s = user.getUserID() + "\t" + user.getUserName() + "\t" + user.getEmail() + "\t" + user.getPswd();
				usersOut.println(s);
			}
			usersOut.close();
			System.out.println("Saved Users");
		}
		catch(FileNotFoundException e) {
			System.err.println("Error saving users");
			e.printStackTrace();
		}
	}
	
	/**
	 * Fetch a user from the database
	 * @param userPartial - Partial user object of the user to fetch
	 * @return Complete matching user object or null if it doesn't exist.
	 */
	public User fetchUser(User userPartial) {
		for(User user:users.values()) {
			if(user.compareUser(userPartial)) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * Fetch the first matching event from the database.
	 * Use fetchAllEvents for a complete list of matching events.
	 * @param eventPartial - Partial event object of the event to fetch
	 * @return Complete object of the first matching event or null if it doesn't exist
	 */
	public Event fetchEvent(Event eventPartial) {
		for(Event event:events.values()) {
			if(event.compareEvent(eventPartial)) {
				return event;
			}
		}
		return null;
	}
	
	/**
	 * Fetch the first matching event from the database.
	 * Use fetchEvent for the first matching event.
	 * @param eventPartial - Partial event object of the event to fetch
	 * @return List of complete event object which match the event
	 */
	public List<Event> fetchAllEvents(Event eventPartial) {
		List<Event> events =  new ArrayList<Event>();
		for(Event event:this.events.values()) {
			if(event.compareEvent(eventPartial)) {
				events.add(event);
			}
		}
		return events;
	}
	
	/**
	 * Store/update a user in the database
	 * @param user - User to store
	 * @throws IllegalArgumentException if user name is null or empty 
	 */
	public void putUser(User user) {
		if(user.getUserName() == null || user.getUserName().equals("")) {
			throw new IllegalArgumentException("Username required");
		}
		users.put(user.getUserName(), user);
	}
	
	/**
	 * Store an event
	 * @param event - Event to store
	 */
	public void putEvent(Event event) {
		int eventID = event.getEventID();
		Event existingEvent = fetchEvent(event);
		if(existingEvent != null) {
			// The event matches an existing event in the db, update that one instead of duplicating events
			eventID = existingEvent.getEventID();
		}
		if(eventID <= 0) {
			eventID = nextEvent;
			nextEvent++;
		}
		event.setEventID(eventID);
		events.put(eventID, event);
	}
	
	
	
	public void login(String username, String pswrd){
		for(User user:users.values()) {
			if(user.getUserName().equals(username)) {
				if(user.login(pswrd)) {
					setCurrUser(user);
				}
			}
		}
	}
	public void createNewEvent(String name, String desc, String game, String skill_level, int maxUser, int eventID, String time) {
		Event ev = this.getCurrUser().createEvent(name, desc, game, skill_level, maxUser, eventID, time);
		this.putEvent(ev);
	}

	public User getCurrUser() {
		return currUser;
	}

	public void setCurrUser(User currUser) {
		this.currUser = currUser;
	}

	
	public void deleteEvent (int eventID) {
		/* Author: Mark Luong - 170995900
		 * Deleting the event item from the main page.
		 * 
		*/
		for(Map.Entry<Integer,Event> entry: events.entrySet()) {
            int id = entry.getKey();
            Event event = entry.getValue();
            if(event.getEventID() == eventID) {
                events.remove(id);
                nextEvent --;
                boolean shouldSub = false;

                for (int i = 0; i <= events.size(); i++) {
                    if (shouldSub) {
                        events.replace(i - 1, events.get(i));
                        events.remove(i);
                    }

                    if(!events.containsKey(i)) {
                        shouldSub = true;
                    } else {
                      System.out.printf("Event %s has a id of %d\n", events.get(i).getName(), i);
                    }}
                return;
            }
        }
	}
}
