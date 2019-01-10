package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/**
 * This is the main app page of the game.With buttons such as start game, score board and etc.
 * @author div
 *
 */
public class MainAppPage extends Application implements EventHandler<ActionEvent>{

	
	/**
	 * Stage is property of the JavaFX we are using it to make our window and stage is most basic layer of making an gui interface in JavaFX.
	 */
	private Stage primaryStage;
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * 
	 * As our class extends Application we need to Override the method from the parent
	 * here it is called start whose input is of type Stage
	 * within this method we design our GUI and add other functioning
	 * Note: this method doesn't return anything
	 */
	@Override
	public void start(Stage primaryStage) {
			this.primaryStage=primaryStage;
		  primaryStage.setTitle( "SnakeVsBlock" );
		
		  
	      
	       
	        
	        Pane root = new Pane();
	        
	       
//	       
	        Image image = new Image("/application/backfirst.jpg");
	        ImageView mv = new ImageView(image);
	        root.getChildren().add(mv);
        Button strt = new Button();
	        strt.setText("NEW GAME");
	        
	        Button exit = new Button();
	        exit.setText("LEADERBOARD");
	        
	        Button res = new Button();
	        
	        //Button button = new Button("click me");
	        
	        //root.getChildren().add(button);
	        //button.setOnAction(this);
	        root.getChildren().add(strt);
	        root.getChildren().add(exit);
	        root.getChildren().add(res);
       
	        
	        res.setStyle("-fx-background-color: #ff9900 ; -fx-border-width: 5px; -fx-font-size: 3em; ");
	        exit.setStyle("-fx-background-color: #ff9900 ; -fx-border-width: 5px; -fx-font-size: 3em; ");
	        strt.setStyle("-fx-background-color: #ff9900 ; -fx-border-width: 5px; -fx-font-size: 3em; ");
	        
	        strt.setOnAction(this);
	        strt.setOnMouseClicked(event -> {
				Main game = new Main();
				game.start(primaryStage);
				this.primaryStage.close();
				
				
			});
	        
	        
	        exit.setOnAction(event -> {
	        	LeaderBoard lead = new LeaderBoard();
	        	lead.start(primaryStage);
	        });
	        
			res.setOnAction(event ->{
				try {
					saveData data = (saveData) resourceManage.load("1.save");
					loadData p =  new loadData();
					p.start(primaryStage);
					//fieldName.setText(data.name);
					//fieldHP.setText(String.valueOf(data.hp));
					
				}
				catch(Exception e) {
					System.out.println("Couldn't load save data"+e.getMessage());
					
				}
			});
	        
	        strt.setLayoutX(0);
	        strt.setLayoutY(50);
	        res.setLayoutX(0);
	        res.setLayoutY(500);
	        exit.setLayoutX(200);
	        exit.setLayoutY(500);
	        res.setText("RESUME");
      
	        Scene scne = new Scene(root,700,650);
	        primaryStage.setScene(scne);
	        primaryStage.setResizable(false);
	        primaryStage.show();
	      
	         


}
	
	/* (non-Javadoc)
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 * this method is has been Overridden because this class implements EventHandler
	 * this method is used to detect whether the user has clicked a button or not
	 * if clicked it print "clicked" in the console
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		System.out.println("clicked");
	}
	
	/**
	 * This method return the Stage which we have initialized as parameter at the very start of the class.
	 * @return so we are returning the parameter of type Stage
	 */
	public Stage getstage() {
		return(this.primaryStage);
	}
	
	

	/**
	 * The main method of this application
	 * @param args array of string argument
	 */
	public static void main(String[] args) {
	
	 launch(args);
	 

	}
	}
