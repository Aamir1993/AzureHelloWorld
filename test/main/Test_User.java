package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_User {
	private User testUser;
	
	@Test
	void testPassword() {
		this.testUser = new User("TestName", "TestPassword");
		assertTrue(testUser.validatePassword("TestPassword"));
	}

}
