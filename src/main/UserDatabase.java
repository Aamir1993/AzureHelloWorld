package main;


import java.util.ArrayList;

public class UserDatabase {
	private ArrayList<User> database;
	
	protected UserDatabase() {
		this.database = new ArrayList<User>();
	}
	
	protected void addUser(User newUser) {
		if(!database.contains(newUser)) {
			this.database.add(newUser);
		}
	}
	
	protected boolean containsUser(String username) {
		boolean result = false;
		for(User user : this.database) {
			if(user.getUsername().equals(username)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	protected User getUserByUsername(String username) {
		for(User user : this.database) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	protected User getUserBySessionId(String sessionId) {
		for(User user : this.database) {
			if(user.getSessionID().equals(sessionId)) {
				return user;
			}
		}
		return null;
	}
	
	protected ArrayList<User> getDatabase(){
		return this.database;
	}
	
	protected void removeUser(String username) {
		this.database.remove(this.getUserByUsername(username));
	}
}
