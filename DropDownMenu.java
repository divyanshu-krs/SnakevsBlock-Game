package application;


import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.*;

/**
 * @author div,salil
 *This class is used to make a Drop down menu for the game
 */
public class DropDownMenu extends Application {

	/**
	 * This is the main method of the class
	 * @param args array of the String argument
	 */
	public static void main(String[] args) {
		launch(args);

	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * This class extends Application therefore it override the default method of the super class
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button exit = new Button();
		Button restart = new Button();
		//Button resume = new Button();
		
		Group root = new Group();
		
		exit.setText("EXIT");
		restart.setText("RESTART");
		//resume.setText("RESUME");
		
        exit.setOnAction(event -> {
        	trysave p = new trysave();
        	try {
				p.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });

        
        restart.setOnAction(event -> {
        	System.out.println("hello");
        	Main game = new Main();
			game.start(primaryStage);
			primaryStage.close();
        });
        
		
		exit.setStyle("-fx-background-color: #ff9900 ; -fx-border-width: 5px; -fx-font-size: 3em; ");
		restart.setStyle("-fx-background-color: #ff9900 ; -fx-border-width: 5px; -fx-font-size: 3em; ");
		//resume.setStyle("-fx-background-color: #ff9900 ; -fx-border-width: 5px; -fx-font-size: 3em; ");

		exit.setLayoutX(300);
		exit.setLayoutY(350);
		
		restart.setLayoutX(260);
		restart.setLayoutY(250);
		
		//resume.setLayoutX(260);
		//resume.setLayoutY(150);
		
		root.getChildren().add(exit);
		root.getChildren().add(restart);
		//root.getChildren().add(resume);
		
		
		Scene sci = new Scene(root,700,650,Color.BLACK);
        primaryStage.setScene(sci);
       primaryStage.setResizable(false);
        primaryStage.show();
		
	}

}