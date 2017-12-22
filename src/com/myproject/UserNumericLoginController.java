package com.myproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.myproject.orm.AuthorizationFX;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserNumericLoginController {

	@FXML
	TextField loginUserNumeric;
	
	@FXML
	TextField numericUserNumeric;
	
	@FXML
	Button singInButtonUserNumeric;
	
	@FXML
	Label hint;
	
	@FXML
	Label errorSignInUserNumeric;
	
	AuthorizationFX message = new AuthorizationFX();
	
	public int difference;
	
	@FXML
	public void initialize() throws IOException{
		Integer randomNumber = (int)(Math.random() * 100);
		
		hint.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				hint.setVisible(true);
				hint.setText(randomNumber.toString());
			}
			
		});
		
		hint.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				hint.setVisible(false);
			}
			
		});
		
		singInButtonUserNumeric.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	errorSignInUserNumeric.setText(null);
            	try {
					try {
						AuthorizationFX.userLoginNumeric(loginUserNumeric.getText(), numericUserNumeric.getText(), randomNumber);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	errorSignInUserNumeric.setText(message.errorMessage);
            	if (message.successfulEntry.equals("Successful entry")) {
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
				}
            };
		});
	}
	
}
