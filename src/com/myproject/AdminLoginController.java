package com.myproject;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminLoginController {
	
	@FXML
	TextField loginAdmin;
	
	@FXML
	PasswordField passwordAdmin;
	
	@FXML
	Button singInButtonAdmin;
	
	@FXML
	Label errorSignInAdmin;
	
	AuthorizationFX message = new AuthorizationFX();
	
	@FXML
	public void initialize(){
		singInButtonAdmin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	try {
					AuthorizationFX.adminLogin(loginAdmin.getText(), passwordAdmin.getText());
					errorSignInAdmin.setText(message.errorMessage);
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
				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            };
		});
	}

}
