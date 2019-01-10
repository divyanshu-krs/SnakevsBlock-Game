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
 * This is
 * @author div,salil
 *
 */
public class hitsave extends Application {
	
	
	private Parent createContent() {
		TextField Name = new TextField();
		TextField Point = new TextField();
		
		Button btnSave = new Button("Save");
		btnSave.setOnAction(event -> {
			saveData data = new saveData();
			data.name = Name.getText();
			data.point = Integer.parseInt(Point.getText());
			try {
				resourceManage.save(data, "1.save");
			}
			catch(Exception e){
				System.out.println("couldn't save : " + e.getMessage());
			}
			
		});
		
		Button btnLoad = new Button("LOAD");
		btnLoad.setOnAction(event ->{
			try {
				saveData data = (saveData) resourceManage.load("1.save");
				Name.setText(data.name);
				Point.setText(String.valueOf(data.point));
				
			}
			catch(Exception e) {
				System.out.println("Couldn't load save data"+e.getMessage());
				
			}
		});
		
		VBox vbox = new VBox(10,Name,Point,btnSave,btnLoad);
		vbox.setAlignment(Pos.CENTER);
		//vbox.backgroundProperty().
		vbox.setPadding(new Insets(50,50,50,50));
		return vbox;
	}
	
	@Override
	public void start(Stage primaryStage)throws Exception{
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("CHECK");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
