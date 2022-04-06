package Objects;
import java.io.Serializable;
/*
Author:  Shaheer Khan - 190693830
         
Repository:
         https://github.com/PPartyImplementation

 -------------------------------------
 File:    User.java
 Description: User details constructor, getters, setters
 Version  4/5/2022
 -------------------------------------
 */
public class User implements Serializable {

	private static final long serialVersionUID = -6130234685900515085L;
	private int userID;
	private String userName;
	private String email;
	private String pswd;
	private Event currEvent = null;
	private boolean isLogin = false; 
	
	public User(int userID, String userName, String email, String pswd) {
		this.userID = userID;
		this.setUserName(userName);
		this.email = email;
		this.setPassword(pswd);
		this.isLogin=false; 

	}

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPswd() {
		return pswd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String pswd) {
		this.pswd = pswd;
	}
	
	//compares the password 
	public boolean login(String pswrd) {
		if (this.pswd.equals(pswrd)) {
			this.isLogin=true;
		}
		return this.isLogin;
	}
	
	//checks to see if user logged in 
	public boolean isLoggedIn() {
		return this.isLogin;
	}
	
	public Event createEvent(String name, String desc, String game, String skill_level, int maxUser, int eventID, String time) {
		Event e = new Event(name, desc, game, skill_level, maxUser, this, eventID, time);
		this.currEvent = e;
		return e;
	}
	
	public void joinEvent(Event currEvent) {
		if (!this.hasCurrEvent()){
			this.currEvent = currEvent;
		}
	}
	
	public void leaveEvent() {
		this.currEvent = null;
	}
	
	public boolean hasCurrEvent() {
		return currEvent != null;
	}
	
	public boolean compareUser(User a) {
		boolean isSame = false;
		if (a.getUserName().equals(this.getUserName()) || this.getUserID() == a.getUserID()) {
			isSame=true;
		}
		return isSame;
	}
	
}
