package com.myproject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.myproject.orm.ActionsFX;
import com.myproject.orm.AuthorizationFX;
import com.myproject.orm.ValidationFX;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerRegistration {
	
	ValidationFX message = new ValidationFX();
	ActionsFX createUser = new ActionsFX();

	@FXML
	TextField username;
	
	@FXML
	PasswordField password;
	
	@FXML
	TextField email;
	
	@FXML
	TextField firstname;
	
	@FXML
	TextField lastname;
	
	@FXML
	Button signUpButton;
	
	@FXML
	Label errorUsername;
	
	@FXML
	Label errorPassword;
	
	@FXML
	Label errorEmail;
	
	@FXML
	Label errorRegistration;
	
	@FXML
	public void initialize(){
		
		signUpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	
            	String usernameInput = new String();
        		String passwordInput = new String();
        		String emailInput = new String();
        		
        		errorUsername.setText("");
				errorPassword.setText("");
				errorEmail.setText("");
            		
            	if ((ValidationFX.checkUsernameRepeats(username.getText()) == true) &&
        				(ValidationFX.checkUsernameAndPassword(username.getText()) == true)) {
        				usernameInput = username.getText();
        		} else if (ValidationFX.checkUsernameRepeats(username.getText()) == false) {
        			errorUsername.setText("This username is already exist");
        				
        		} else if (ValidationFX.checkUsernameAndPassword(username.getText()) == false) {
        			errorUsername.setText("Invalid username");
        		}
            	
            	if (ValidationFX.checkUsernameAndPassword(password.getText()) == true){
        			passwordInput = password.getText();
        		} else {
        			errorPassword.setText("Invalid password");
        		}
            	
            	if ((ValidationFX.checkEmailRepeats(email.getText()) == true) && 
            			(ValidationFX.checkEmail(email.getText()) == true)){
        			emailInput = email.getText();
        		} else if (ValidationFX.checkEmailRepeats(email.getText()) == false){
        			errorEmail.setText("This email is alredy used");
        		} else if (ValidationFX.checkEmail(email.getText()) == false) {
        			errorEmail.setText("Invalid email");
        		}
        				
        		if ((!usernameInput.isEmpty()) && (!passwordInput.isEmpty()) && (!emailInput.isEmpty())) {
        			try {
    					ActionsFX.addUser(usernameInput, passwordInput, emailInput, firstname.getText(), lastname.getText());
    					
    					if (createUser.newUser.equals("New user created")) {
    						Parent root;
    	    				try {
    	    					root = FXMLLoader.load(getClass().getResource("fx/AdminUserPage.fxml"));
    	    					Scene scene = new Scene(root);
    	    					Stage stage = new Stage();
    	    	                stage.setScene(scene);
    	    	                stage.show();
    	    				} catch (IOException e) {
    	    					// TODO Auto-generated catch block
    	    					e.printStackTrace();
    	    				}
    					} else {
    						
    					}
    				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
        		}
            };
		});
	}
	
}
