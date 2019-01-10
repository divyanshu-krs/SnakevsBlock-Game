package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

//OLD MAIN CLASS. FOR TESTING


/**
 * This is main class for the user to run this game
 * @author div,salil
 *
 */
public class Main extends Application {
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * This class has extended Application so we need to override the default method of the super class
	 */
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
			primaryStage.setTitle("Game Window");
			primaryStage.setScene(new Scene(root, 297, 500));
			primaryStage.show();
			*/
			/*
			Ball ball = new Ball();
			ball.setFill(Color.AQUAMARINE);
			ball.setRadius(50);
			ball.setLayoutX(50);
			ball.setLayoutY(50);
			ball.moveLeft();
			
			Pane root = new Pane();
			root.getChildren().add(ball);
			Scene scene = new Scene(root, 500, 500);
			primaryStage.setTitle("Movement");
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			Game game = new Game();
			primaryStage = game.gameStage;
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This is the main method of this class
	 * @param args array of String argument
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
