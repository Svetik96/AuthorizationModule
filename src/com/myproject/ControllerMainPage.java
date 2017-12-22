package com.myproject;


import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class ControllerMainPage {

	MainApp q = new MainApp();
	
	@FXML
    public Button registrationButton;
	
	@FXML
    public Button loginButton;
	
	
	
	@FXML
	AnchorPane pane;
 
	@FXML
    public void initialize(){
		registrationButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("fx/Registration.fxml"));
					Scene scene = new Scene(root);
	                Stage stage = new Stage();
	                stage.setScene(scene);
	                stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            };
		});
		
		loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	Parent root;
				try {
					
					root = FXMLLoader.load(getClass().getResource("fx/LoginUserPassword.fxml"));
					Scene scene = new Scene(root);
	                Stage stage = new Stage();
	                stage.setScene(scene);
	                stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            };
		});
		
		pane.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.R) {
					Parent root;
					try {
						
						root = FXMLLoader.load(getClass().getResource("fx/LoginRegime.fxml"));
						Scene scene = new Scene(root);
		                Stage stage = new Stage();
		                stage.setScene(scene);
		                stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                    //event.consume();
                }
			}
			
		});
		
		
		
/*		
		loginButton3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			Parent root;
            @Override
            public void handle(MouseEvent mouseEvent) {
            	try {
					Thread.sleep(5000);
					
					loginButton3.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
	        			
	        			@Override
	        			public void handle(KeyEvent event) {
	        				
	        					if (!(!event.equals(null))){
	        					
	        					//if (event.getCode() == KeyCode.R) {
	        						//Parent root;
	        						try {
	        							
	        							root = FXMLLoader.load(getClass().getResource("fx/LoginRegime.fxml"));
	        							Scene scene = new Scene(root);
	        			                Stage stage = new Stage();
	        			                stage.setScene(scene);
	        			                stage.show();
	        						} catch (IOException e) {
	        							// TODO Auto-generated catch block
	        							e.printStackTrace();
	        						}

	        	                    //event.consume();
	        	                    
	        	                } 
	        				
	        				
	        				// TODO Auto-generated method stub
	        				
	        				//event.consume();
	        				
	        			}
	        			
	        		});
					/*
					Parent root;
    				try {
    					
    					root = FXMLLoader.load(getClass().getResource("fx/LoginUserPassword.fxml"));
    					Scene scene = new Scene(root);
    	                Stage stage = new Stage();
    	                stage.setScene(scene);
    	                stage.show();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
            	
            	
            }
		});
		
		
		loginButton2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			Parent root;
            @Override
            public void handle(MouseEvent mouseEvent) {
            	try {
					Thread.sleep(5000);
					
					if (mouseEvent.getClickCount()>=1) {
						loginButton2.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
							
		        			@Override
		        			public void handle(KeyEvent event) {
		        				 
		        				
		        				// TODO Auto-generated method stub
		        				if (event.getCode() == KeyCode.R) {
		        					//Parent root;
		        					try {
		        						
		        						root = FXMLLoader.load(getClass().getResource("fx/LoginRegime.fxml"));
		        						Scene scene = new Scene(root);
		        		                Stage stage = new Stage();
		        		                stage.setScene(scene);
		        		                stage.show();
		        					} catch (IOException e) {
		        						// TODO Auto-generated catch block
		        						e.printStackTrace();
		        					}

		                           //event.consume();
		                            
		                        } 
		        				//event.consume();
		        				
		        			}
		        			
		        		});
						
						
					}
					
					try {
    					
    					root = FXMLLoader.load(getClass().getResource("fx/LoginUserPassword.fxml"));
    					Scene scene = new Scene(root);
    	                Stage stage = new Stage();
    	                stage.setScene(scene);
    	                stage.show();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
					
					
					
					
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
		});
		
		
		loginButton4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			Parent root;
			
            @Override
            public void handle(MouseEvent mouseEvent) {
            	try {
					Thread.sleep(5000);
					
					if (mouseEvent.getClickCount()>=1) {
						loginButton4.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
							
		        			@Override
		        			public void handle(KeyEvent event) {
		        				 
		        				if (KeyEvent.ANY == null) {
		        					System.out.println("nullik");
		        				}
		        				// TODO Auto-generated method stub
		        				if (event.getCode() == KeyCode.R) {
		        					//Parent root;
		        					try {
		        						
		        						root = FXMLLoader.load(getClass().getResource("fx/LoginRegime.fxml"));
		        						Scene scene = new Scene(root);
		        		                Stage stage = new Stage();
		        		                stage.setScene(scene);
		        		                stage.show();
		        					} catch (IOException e) {
		        						// TODO Auto-generated catch block
		        						e.printStackTrace();
		        					}
		        					System.out.println(event.getEventType().toString());

		                           //event.consume();
		                            
		                        } else {
		                        	System.out.println(event.getEventType().toString());
		                        }
		        				
		        				
		        				//event.consume();
		        				
		        			}
		        			
		        		});
						
						
					}
					
					
					
					
					
					
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
		});
		*/
	}
}
                    
				
            	
            	
        
	
	

	

	

