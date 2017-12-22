package com.myproject;



import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerRegime {

	Stage stage = new Stage();
	MainApp app = new MainApp();
	
	@FXML
	RadioButton regime1;
	
	@FXML
	RadioButton regime2;
	
	@FXML
	RadioButton regime3;
	
	@FXML
	RadioButton regime4;
	
	@FXML
	RadioButton regime5;
	
	@FXML
	Button chooseRegime;
	
	@FXML
	Pane adminLogin;
	
	@FXML
	Pane userLoginPassword;
	
	@FXML
	public void initialize(){
		chooseRegime.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	if (regime1.isSelected()) {
            		Parent root;
    				try {
    					root = FXMLLoader.load(getClass().getResource("fx/LoginAdmin.fxml"));
    					Scene scene = new Scene(root);
    	                stage.setScene(scene);
    	                stage.show();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            	}
            	
            	else if (regime2.isSelected()) {
            		Parent root;
    				try {
    					
    					root = FXMLLoader.load(getClass().getResource("fx/LoginUserPassword.fxml"));
    					Scene scene = new Scene(root);
    	                
    	                stage.setScene(scene);
    	                stage.show();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            	}
            	
            	else if (regime3.isSelected()) {
            		Parent root;
    				try {
    					
    					root = FXMLLoader.load(getClass().getResource("fx/LoginUserNumeric.fxml"));
    					Scene scene = new Scene(root);
    	                stage.setScene(scene);
    	                stage.show();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            	}
            	
            	else if (regime4.isSelected()) {
            		Parent root;
    				try {
    					
    					root = FXMLLoader.load(getClass().getResource("fx/LoginUserEmail.fxml"));
    					Scene scene = new Scene(root);
    	                stage.setScene(scene);
    	                stage.show();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            	}
            	
            	else if (regime5.isSelected()) {
            		Parent root;
    				try {
    					
    					root = FXMLLoader.load(getClass().getResource("fx/LoginUserSMS.fxml"));
    					Scene scene = new Scene(root);
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
