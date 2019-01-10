package application;
import javafx.event.*;


import java.io.FileNotFoundException;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

/**
 * @author div,salil
 * This class used to make Leader-Board for the Game
 *
 */
public class LeaderBoard extends Application {
	
	
    /**
     * We are making a Table where we can add our top scores
     */
    private TableView table = new TableView();
    
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * This class extends Application therefore it override the default method of the super class
	 */
	@Override
	public void start(Stage mystage) {
		
		mystage.setTitle( "LEADERBOARD" );
		Label my = new Label("LEADERBOARD");
		
		
		Pane pane = new Pane();
		Group root = new Group(pane);
		
		 Button btn = new Button();
		 btn.setText("Main Menu");
	        btn.setStyle("-fx-background-color: #ff9900 ; -fx-border-width: 5px; -fx-font-size: 2em; ");
	        btn.setOnAction(new EventHandler<ActionEvent>(){
	        	@Override
	        	public void handle(ActionEvent event)  {
	        		
	        	MainAppPage m = new MainAppPage();
	        	
	        	m.start(mystage);
	        }
	        });
	  
	        
	        btn.setLayoutX(600);
	        btn.setLayoutY(0);
	        my.setTranslateY(0);
	        
	        my.setFont(new Font("Arial", 50));
	        //my.setTranslateX(350);
	        my.setTextFill(Color.AQUA);
	        pane.getChildren().add(btn);
	        
	        TableColumn firstNameCol = new TableColumn("Name");
	        //TableColumn lastNameCol = new TableColumn("Last Name");
	        TableColumn emailCol = new TableColumn("Score");
	        
	        table.getColumns().addAll(firstNameCol,emailCol);
	 
	        final VBox vbox = new VBox();
	        vbox.setSpacing(20);
	        vbox.setPadding(new Insets(130, 0, 0, 0));
	        vbox.getChildren().addAll(my, table);
	        Scene scene=new Scene(root,800,700,Color.BLACK);  
	        scene.getFill();
	        pane.getChildren().add(my);
	        pane.getChildren().add(vbox);
	        mystage.setScene(scene);  
	        mystage.show();
		
	}
	/**
	 * This is the main method of the class
	 * @param args array pf String argument
	 */
	public static void main (String[] args) {
		launch(args);
	}

}
