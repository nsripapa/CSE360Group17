//AUTHOR UNLESS SPECIFIED: Ream Russom Teame
//This Prototype will send an email to an internal support email address with a user specified problem.
//We have added a sleek menu bar to the top of the UI, and in that menubar is a control to navigate to this prototype

package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.mail.*;
import javax.mail.internet.*;

public class ControllerSupport {

	
	@FXML
	private TextField textFieldEmail;
	@FXML
	private TextArea textAreaIssue;
	@FXML
	private Button buttonSend;
	@FXML
	private Label labelMessage;
	
	
	//clicked send button
	public void send(MouseEvent e)
	{
		//make sure both fields are filled out
		if (textFieldEmail.getText().isEmpty() || textAreaIssue.getText().isEmpty())
		{
			labelMessage.setText("Error sending request. Please fill out all required fields.");
			labelMessage.setVisible(true);
		} else 
		{
			
			
			java.util.Properties props = new java.util.Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			
			//in real world, we will use a dedicated email for sending support tickets.
			Authenticator auth = new Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication("jacob.fett03@gmail.com", "jjuv ltxi tjdk lizq");
			    }
			};
			
			
			Session session = Session.getDefaultInstance(props, auth);
			
			//in real world, we will use a general support email that a support team can access
			String to = "jfett2@asu.edu";
			String from = "jacob.fett03@gmail.com";
			String subject = "EffortLogger Support Ticket";
			Message msg = new MimeMessage(session);
			try {
			    msg.setFrom(new InternetAddress(from));
			    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			    msg.setSubject(subject);
			    msg.setText("Email Address of user: " + textFieldEmail.getText() + "\n\nIssue:\n\n" + textAreaIssue.getText());
			    // Send the message.
			    Transport.send(msg);
			    
			    labelMessage.setText("We have been notified of your issue and will respond as soon as we can. You may now close this window.");
			    labelMessage.setVisible(true);
			} catch (MessagingException ex) {
			    // Error.
				labelMessage.setText("Error sending message to Support");
			}
			
		}
	}
}
