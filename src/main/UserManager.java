package main;
/*
 * Singleton class used for user management
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
	//Singleton instance
	private static UserManager instance;
	//Storage for users
	private UserDatabase userDB;
	//Storage for incoming user requests
	private Map<String, String> userRequests;
	
	/**
	 * Constructor
	 */
	private UserManager () {
		this.userDB = new UserDatabase();
		this.userRequests = new HashMap<String, String>();
		this.init();
	}
	
	/**
	 * Singleton getInstance
	 * @return	instance
	 */
	public static UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
	
	/**
	 * initialize default users
	 */
	private void init() {
		this.userDB.addUser(new User("Aamir", "Aamir"));
		this.userDB.addUser(new User("Tim", "Tim"));
		this.userDB.addUser(new User("Samson", "Samson"));
	}
	
	public User getUserBySession(String sessionId) {
		return this.userDB.getUserBySessionId(sessionId);
	}
	
	public User getUserByUsername(String username) {
		return this.userDB.getUserByUsername(username);
	}
	
	/**
	 * checks username and password
	 * 
	 * @param username
	 * @param password
	 * @return	checking result
	 */
	public boolean verifyUser(String username, String password) {
		User user = this.userDB.getUserByUsername(username);
		if(user == null) {
			return false;
		}
		
		return true;
		
		//TODO
		//return user.validatePassword(password);
	}
	
	/**
	 * returns complete users list
	 * @return
	 */
	public ArrayList<User> getUserList(){
		return this.userDB.getDatabase();
	}
	
	public ArrayList<String> getRequestList(){
		ArrayList<String> list = new ArrayList<String>();
		for(String user : this.userRequests.keySet()) {
			list.add(user);
		}
		return list;
	}
	
	/**
	 * adds new userrequest
	 * @param username
	 * @param password
	 */
	public void addUserRequest(String username, String password) {
		if(this.userRequests.size() <= 50) {
			this.userRequests.put(username, password);
		}
		
	}
	
	/**
	 * Adds the request to user database
	 * @param username
	 */
	public void confirmUserRequest(String username) {
		if(this.userRequests.containsKey(username)) {
			//create new user
			User user = new User(username, this.userRequests.get(username));
			//add user to database
			this.userDB.addUser(user);
			//delete user request
			this.deleteUserRequest(username);
		}	
	}
	
	public void addUser(String username) {
		if(!this.userDB.containsUser(username)) {
			//create new user
			User user = new User(username, username);
			//add user to database
			this.userDB.addUser(user);
		}
	}
	
	/**
	 * Deletes user request
	 * @param username
	 */
	public void deleteUserRequest(String username) {
		if(this.userRequests.containsKey(username)) {
			this.userRequests.remove(username);
		}
	}
	
	public void deleteUser(String username) {
		this.userDB.removeUser(username);
	}
	
	public void logout(String username) {
		this.userDB.getUserByUsername(username).setSessionID("None");
	}
}
