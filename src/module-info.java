module EffortLoggerV2 
{
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	requires java.mail;
	requires javax.activation;
	
	opens application to javafx.graphics, javafx.fxml;
}
