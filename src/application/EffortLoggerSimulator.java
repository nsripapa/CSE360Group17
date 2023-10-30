//Author: Ribhay Singh
//This is the basic layout of how the test cases will be carried out. 
//For the sake of reference and simplicity, I have decided to test the UserName and Password function of the program 

package application;

public class EffortLoggerSimulator {
    
    private ControllerLogin loginController = new ControllerLogin(); //Check controller login for further info 
    
    public String runTestCases() {
        StringBuilder results = new StringBuilder();

        // At first, we will test valid login attempts 
        results.append(testLogin("a", "a", "Valid Login Test 1: "));
        results.append(testLogin("jfett2", "xle952!", "Valid Login Test 2:  "));
        
        // Then, we will carry out the test with an invalid username
        results.append(testLogin("fakeUser", "somepass", "Invalid Username Test: "));
        
        // Finally, we will test with a wrongpassword 
        results.append(testLogin("a", "wrongpass", "Invalid Password Test: "));
        
        return results.toString();
    }
    
    private String testLogin(String username, String password, String testName) {
        loginController.textFieldUN.setText(username);
        loginController.passwordField.setText(password);
        
        String messageBefore = loginController.labelMessage.getText();
        try {
            loginController.login(null); 
        } catch(Exception e) {
            return testName + "Exception encountered: " + e.getMessage() + "\n";
        }
        
        String messageAfter = loginController.labelMessage.getText();
        
    if (messageBefore.equals(messageAfter)) {
            return testName + "Failed\n";
        } else {
            return testName + "Success\n";
        }
    }
}
