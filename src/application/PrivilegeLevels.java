package application;

import java.util.HashMap;

public class PrivilegeLevels {

	// Similar handling to how UNandPW handles password and usernames, will be migrated to a database prior to final release
	HashMap<String, String> accesslevel = new HashMap<String, String>();
	
	PrivilegeLevels() {
		
		accesslevel.put("a", "admin");
		accesslevel.put("b", "user");
		
	}
	
	protected HashMap getAccessLevel() {
		return accesslevel;
	}
}
