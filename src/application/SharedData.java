// Author: Augustine Suter
// This is where I will store data which might be needed to be accessed by multiple controllers
package application;

public class SharedData {
	
	// defines the application version we are on
    private static final String APP_VERSION = "v1.0 Alpha";
    
    // method to get user's app version
    public static String getAppVersion() {
        return APP_VERSION;
    }
	
	
    
	private static String username;
    
    // Call this to get current user's username
    public static String getUsername() {
        return username;
    }
    // called in ControllerLogin.java
    public static void setUsername(String username) {
        SharedData.username = username;
    }
}