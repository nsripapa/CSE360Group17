// Author: Augustine Suter
// This Prototype will allow a user to send an email to our Dev team regarding any feedback they may have regarding the software.
// This will let them make any suggestions which may improve the user interface, or potentially add new features.


package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
// Use JavaMail to host smtp email server
import javax.mail.*;
import javax.mail.internet.*;

// Import properties to get user's OS version
import java.util.Properties;


public class ControllerFeedback extends Controller {

	
	@FXML
	private TextField textFieldEmail;
	@FXML
	private TextArea textAreaIssue;
	@FXML
	private Button buttonSend;
	@FXML
	private Label labelMessage;
	
	
	//clicked send button
	public void send(MouseEvent e) {
		
		// check if all boxes are filled out
		if (textFieldEmail.getText().isEmpty() || textAreaIssue.getText().isEmpty()){
			labelMessage.setText("Error sending request. Please fill out all required fields.");
			labelMessage.setVisible(true);
		} 
		
		else {
			
			// set up smtp email server
			java.util.Properties props = new java.util.Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			
			//  This email to be replaced with an official Dev team email
			Authenticator auth = new Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication("apsuterdev@gmail.com", "rlpu oipy kwqx agmn");
			    }
			};
			
			
			Session session = Session.getDefaultInstance(props, auth);
			
			// Set up email properties
			// This email to be replaced with an official Dev team email
			String to = "apsuterdev@gmail.com";
			String from = "apsuterdev@gmail.com";
			String subject = "EffortLogger Feedback Ticket";
			Message msg = new MimeMessage(session);
			try {
				
				// Get the app version from SharedData
				String applicationVersion = SharedData.getAppVersion();
				// Get the username from SharedData
				String username = SharedData.getUsername();
				
			    msg.setFrom(new InternetAddress(from));
			    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			    msg.setSubject(subject);
			    msg.setText("Username: " + username +
			    		"\nEmail Address: " + textFieldEmail.getText() + 
			    		"\nApplication Version: " + applicationVersion +
			    		"\nJava Version: " + getJavaVersion() +
	                    "\nOperating System: " + getOperatingSystem() +
			    		"\n\nFeedback:\n" + textAreaIssue.getText());
			    
			    
			    // sends the message.
			    Transport.send(msg);
			    
			    // update label to display result of request
			    labelMessage.setText("Your feedback has been recorded, and is very valuable to us. You may now close this window.");
			    labelMessage.setVisible(true);
			    
			    // clears the text fields after sent
	            textFieldEmail.clear();
	            textAreaIssue.clear();
			}
			// catch error
			catch (MessagingException ex) {
				labelMessage.setText("Error sending Feedback message");
			}
			
		}
	}


    // get user's OS properties
    private String getOperatingSystem() {
        return System.getProperty("os.name") + " " + System.getProperty("os.version");
    }
    // Get user's Java version
    private String getJavaVersion() {
        return System.getProperty("java.version");
    }
}
