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
	
	
	
	public void send(MouseEvent e)
	{
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
			
			
			Authenticator auth = new Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication("jacob.fett03@gmail.com", "jjuv ltxi tjdk lizq");
			    }
			};
			
			
			Session session = Session.getDefaultInstance(props, auth);
			
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
