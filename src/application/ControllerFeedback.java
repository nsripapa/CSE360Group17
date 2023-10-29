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


public class ControllerFeedback {

	
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
		
		// check if everything is filled out
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
			        return new PasswordAuthentication("jacob.fett03@gmail.com", "jjuv ltxi tjdk lizq");
			    }
			};
			
			
			Session session = Session.getDefaultInstance(props, auth);
			
			// This email to be replaced with an official Dev team email
			String to = "jfett2@asu.edu";
			String from = "jacob.fett03@gmail.com";
			String subject = "EffortLogger Feedback Ticket";
			Message msg = new MimeMessage(session);
			try {
			    msg.setFrom(new InternetAddress(from));
			    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			    msg.setSubject(subject);
			    msg.setText("Email Address of user: " + textFieldEmail.getText() + "\n\nFeedback:\n\n" + textAreaIssue.getText());
			    
			    // Sends the message.
			    Transport.send(msg);
			    
			    // update label to display result of request
			    labelMessage.setText("Your feedback has been recorded, and is very valuable to us. You may now close this window.");
			    labelMessage.setVisible(true);
			}
			
			catch (MessagingException ex) {
			    // catch error
				labelMessage.setText("Error sending Feedback message");
			}
			
		}
	}
}
