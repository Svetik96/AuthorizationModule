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
import com.myproject.orm.SendSMS2;

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

public class UserSMSLoginController {

	@FXML
	TextField loginUserSMS;
	
	@FXML
	TextField codeUserSMS;
	
	@FXML
	Button singInButtonUserSMS;
	
	@FXML
	Button getSMSButton;
	
	@FXML
	Label messageLabelUserSMS;
	
	public int randomNumber;
	
	AuthorizationFX message = new AuthorizationFX();
	
	@FXML
	public void initialize(){
		
		getSMSButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				randomNumber = 1000 + (int)(Math.random() * 9999);
				
				String textMessage = "Your code for login is\n" + randomNumber;
						
				//SendEmailSSL sslSender = new SendEmailSSL(PropertyProvider.getInstance().getProperty("email.login"), 
				//								PropertyProvider.getInstance().getProperty("email.password"));
				
				Connection dbConnection = null;
				PreparedStatement preparedStatement = null;
				
				String phone = "SELECT phone FROM users WHERE username = ?";
				
				//int phoneNumber = Integer.parseInt(phone);
				
				try {
					dbConnection = DBConnection.getConnection();
					preparedStatement = dbConnection.prepareStatement(phone);
					preparedStatement.setString(1, loginUserSMS.getText());
					
					ResultSet rs = preparedStatement.executeQuery();
					
					if(rs.next()) {	
						new SendSMS2(textMessage); 
						//sslSender.send("Code for login", textMessage, PropertyProvider.getInstance().getProperty("email.login"), rs.getString(1));
						messageLabelUserSMS.setText("SMS was sent.");
						System.out.println(rs.getString(1));
						System.out.println("SMS was sent.");
					} else {
						messageLabelUserSMS.setText("User doesn't exist");
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
		
		singInButtonUserSMS.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	AuthorizationFX.userLoginEmail(loginUserSMS.getText(), codeUserSMS.getText(), randomNumber);
            	messageLabelUserSMS.setText(message.errorMessage);
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
