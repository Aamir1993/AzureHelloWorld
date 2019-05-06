package main;
import java.util.UUID;

public class User {
	//System and user informations
	private String username, password, sessionID;
	private UUID id;
	
	/**
	 * Constructor
	 * @param username
	 * @param password
	 */
	public User (String username, String password) {
		//Logger.debugUser("Create new useraccount " + username);
		this.username = username;
		this.password = password;
		this.id = UUID.randomUUID();
		this.sessionID = "none";
	}
	
	/**
	 * get user큦 UUID
	 * @return
	 */
	public String getId() {
		return this.id.toString();
	}
	
	/**
	 * Get user큦 current SessionID
	 * @return
	 */
	public String getSessionID() {
		return sessionID;
	}

	/**
	 * Set new SessionID to the User
	 * @param sessionID
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	/**
	 * Get user큦 username
	 * @return
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Validate user큦 password
	 * @param password
	 * @return
	 */
	public boolean validatePassword(String password) {
		return this.password.equals(password);
	}
	
	public boolean validateSessionID(String id) {
		return this.sessionID.equals(id);
	}
	
	/**
	 * Validate and Change user큦 password
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public boolean changePassword(String oldPassword, String newPassword) {
		if(this.validatePassword(oldPassword)) {
			this.password = newPassword;
			return true;
		}
		return false;
	}
}
