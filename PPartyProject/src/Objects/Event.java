package Objects;
import java.io.Serializable;
import java.time.LocalDateTime;
/*
Author:  Shaheer Khan - 190693830
         
Repository:
         https://github.com/PPartyImplementation

 -------------------------------------
 File:    Event.java
 Description: Event details constructor, getters, setters
 Version  4/5/2022
 -------------------------------------
 */

public class Event implements Serializable {

	private static final long serialVersionUID = 8036985069043565137L;
	private String name;
	private String description;
	private String game;
	private String skill_level;
	private String startTime;
	private int maxUsers;
	private User host;
	private int eventID;
	
	//CONSTRUCTION FUNCTION 
	public Event (String name, String desc, String game, String skill_level, int maxUser, User host, int eventID, String time) {
		this.setName(name); 
		this.setDescription(desc);
		this.setGame(game);
		this.setSkill_level(skill_level);
		this.setMaxUsers(maxUser);
		this.setHost(host);
		this.setEventID(eventID);
		this.setStartTime(time);
	}

	//ALL THE GET SET METHODS 
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGame() {
		return game;
	}


	public void setGame(String game) {
		this.game = game;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getSkill_level() {
		return skill_level;
	}


	public void setSkill_level(String skill_level) {
		this.skill_level = skill_level;
	}


	public int getMaxUsers() {
		return maxUsers;
	}


	public void setMaxUsers(int maxUsers) {
		this.maxUsers = maxUsers;
	}


	public int getEventID() {
		return eventID;
	}


	public void setEventID(int eventID) {
		this.eventID = eventID;
	}


	public User getHost() {
		return host;
	}


	public void setHost(User host) {
		this.host = host;
	}
	
	
	//EVERYTHING ELSE
	public boolean compareEvent(Event a) {
		boolean isSame = false;
		if (a.getHost().compareUser(this.getHost()) || a.getEventID()== this.getEventID()) {
			isSame=true;
		}
		return isSame;
		}
}
