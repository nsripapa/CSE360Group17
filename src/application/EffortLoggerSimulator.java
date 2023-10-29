package application;
//Author: Ribhay Singh
//This is the basic layout of how the test cases will be carried out. 
//For the sake of reference and simplicity, I have decided to test the UserName and Password function of the program 
public class EffortLoggerSimulator {

    private UNandPW usersAndPasswords = new UNandPW();
//In application, we will add more test cases.
    public String runTestCases() {
        StringBuilder results = new StringBuilder();

        results.append(testUNandPWInitialization());
        results.append(testGetLoginInfo());

        return results.toString();
    }

    private String testUNandPWInitialization() {
        // Check if the HashMap contains the hardcoded keys
        boolean containsKeyA = usersAndPasswords.getLoginInfo().containsKey("a");
        boolean containsKeyJfett2 = usersAndPasswords.getLoginInfo().containsKey("jfett2");
        boolean containsKeyNsripapa3 = usersAndPasswords.getLoginInfo().containsKey("nsripapa3");
        boolean containsKeyRsingh7 = usersAndPasswords.getLoginInfo().containsKey("rsingh7");
        
        return (containsKeyA && containsKeyJfett2 && containsKeyNsripapa3 && containsKeyRsingh7) 
            ? "UNandPW Initialization Test: Success\n" 
            : "UNandPW Initialization Test: Failed\n";
    }

    private String testGetLoginInfo() {
        // Simply check if getLoginInfo() returns a non-empty HashMap
        boolean hasInfo = !usersAndPasswords.getLoginInfo().isEmpty();

        return hasInfo 
            ? "Get Login Info Test: Success\n" 
            : "Get Login Info Test: Failed\n";
    }
}
