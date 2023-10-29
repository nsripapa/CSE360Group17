package application;

public class EffortLoggerSimulator {

    private UNandPW usersAndPasswords = new UNandPW();

    public String runTestCases() {
        StringBuilder results = new StringBuilder();

        results.append(testUserLogin());
        results.append(testAddEntry());
        results.append(testDeleteEntry());
        results.append(testUpdateEntry());
        results.append(testRetrieveEntry());

        return results.toString();
    }

  
    private String testUserLogin() {
        boolean success = effortLogger.login("testUser", "testPassword");
        return success ? "User Login Test: Success\n" : "User Login Test: Failed\n";
    }
//More to be added 
