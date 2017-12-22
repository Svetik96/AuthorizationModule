package com.myproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myproject.orm.AuthorizationFX;
import com.myproject.orm.DBConnection;
import com.myproject.orm.PropertyProvider;
import com.myproject.orm.SendEmailSSL;

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

public class UserEmailLoginController {

	@FXML
	TextField loginUserEmail;
	
	@FXML
	TextField codeUserEmail;
	
	@FXML
	Button singInButtonUserEmail;
	
	@FXML
	Button getCodeButton;
	
	@FXML
	Label messageLabelUserEmail;
	
	public int randomNumber;
	
	AuthorizationFX message = new AuthorizationFX();
	
	@FXML
	public void initialize(){
		
		getCodeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				randomNumber = 1000 + (int)(Math.random() * 9999);
				
				String textMessage = "Your code for login is\n" + randomNumber;
						
				SendEmailSSL sslSender = new SendEmailSSL(PropertyProvider.getInstance().getProperty("email.login"), 
												PropertyProvider.getInstance().getProperty("email.password"));
				
				Connection dbConnection = null;
				PreparedStatement preparedStatement = null;
				
				String email = "SELECT email FROM users WHERE username = ?";
				
				try {
					dbConnection = DBConnection.getConnection();
					preparedStatement = dbConnection.prepareStatement(email);
					preparedStatement.setString(1, loginUserEmail.getText());
					
					ResultSet rs = preparedStatement.executeQuery();
					
					if(rs.next()) {				
						sslSender.send("Code for login", textMessage, PropertyProvider.getInstance().getProperty("email.login"), rs.getString(1));
						messageLabelUserEmail.setText("Letter was sent.");
						System.out.println("Letter was sent.");
					} else {
						messageLabelUserEmail.setText("User doesn't exist");
						System.out.println("User doesn't exist");
					}
					
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
					try {
						if (dbConnection != null) {
							dbConnection.close();
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		
		singInButtonUserEmail.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	AuthorizationFX.userLoginEmail(loginUserEmail.getText(), codeUserEmail.getText(), randomNumber);
            	messageLabelUserEmail.setText(message.errorMessage);
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
