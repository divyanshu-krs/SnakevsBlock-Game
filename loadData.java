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
 * This class is used to load the info about the prev user only
 * @author div,salil
 *
 */
public class loadData extends Application{
		
		/**
		 * 
		 * @return type is Parent is we are returning to the VBox
		 */
		private Parent createContent() {
			TextField Name = new TextField();
			TextField Point = new TextField();
			
//			Button btnSave = new Button("Save");
//			btnSave.setOnAction(event -> {
//				saveData data = new saveData();
//				data.name = fieldName.getText();
//				data.hp = Integer.parseInt(fieldHP.getText());
//				try {
//					resourceManage.save(data, "1.save");
//				}
//				catch(Exception e){
//					System.out.println("couldn't save : " + e.getMessage());
//				}
//				
//			});
			
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
			
			VBox vbox = new VBox(10,Name,Point,btnLoad);
			vbox.setAlignment(Pos.CENTER);
			//vbox.backgroundProperty().
			vbox.setPadding(new Insets(50,50,50,50));
			return vbox;
		}
		
		/* (non-Javadoc)
		 * @see javafx.application.Application#start(javafx.stage.Stage)
		 * As this class extends Application we have to override the default method defined in the super class
		 */
		@Override
		public void start(Stage primaryStage)throws Exception{
			Scene scene = new Scene(createContent());
			primaryStage.setTitle("CHECK");
			primaryStage.setScene(scene);
			primaryStage.show();
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
