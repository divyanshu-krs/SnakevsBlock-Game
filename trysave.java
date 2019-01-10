package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author div,salil
 *This class is used for making a new window which give you option to save your progess or quit
 */
public class trysave extends Application {

	/**
	 * This is parameter of type Stage which is used to make a window to add GUI components
	 */
	Stage primaryStage;
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * This class extends Application therefore we have override the default method of the superclass
	 */
	@Override
	public void start(Stage primaryStage)throws Exception{
		this.primaryStage=primaryStage;
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("CHECK");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * This method is creating the content for this window like button and text field
	 * @return is of type Parent and we are returning a VBox
	 */
	private Parent createContent() {
		TextField Name = new TextField();
		TextField Point = new TextField();
		
		Button btnSave = new Button("Save");
		btnSave.setOnAction(event -> {
			saveData data = new saveData();
			data.name = Name.getText();
			data.point = Game.score;
        	MainAppPage main = new MainAppPage();
        	main.start(primaryStage);
			try {
				resourceManage.save(data, "1.save");
			}
			catch(Exception e){
				System.out.println("couldn't save : " + e.getMessage());
			}
			
		});
		
		Button exit = new Button("Don't Save and Exit ");
		exit.setOnAction(event ->{
			MainAppPage main = new MainAppPage();
        	main.start(primaryStage);
		});
		
		VBox vbox = new VBox(10,Name,Point,btnSave,exit);
		vbox.setAlignment(Pos.CENTER);
		//vbox.backgroundProperty().
		vbox.setPadding(new Insets(50,50,50,50));
		return vbox;
	}
	

	/**
	 * This is the main method of the class
	 * @param args array of String argument
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
