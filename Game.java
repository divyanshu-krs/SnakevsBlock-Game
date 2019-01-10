package application;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author div,salil
 * This is the where main working screen is designed
 *
 */
public class Game {
	
	/**
	 * Anchorpane used to add the different GUI component in Pane
	 */
	AnchorPane gamePane;
	/**
	 * Scene is the current scene of the window which has the StackPane
	 */
	Scene gameScene;
	/**
	 * The main Stage where all GUI component are there. it comprises of scene and StacePane
	 */
	Stage gameStage;
	
	/**
	 * width of the window
	 */
	final int w = 605;
	/**
	 * height of the window
	 */
	final int h = 700;
	
	//Stage menuStage;
	
	//Circle circle;
	/**
	 * Snake which is being used in the game
	 */
	Snake snake;
	/**
	 * The size of the snake
	 */
	int snakeSize;
	
	/**
	 * boolean value to detect if left is key pressed or not
	 */
	boolean leftPressed;
	/**
	 * boolean value to detect if righ key is pressed or not
	 */
	boolean rightPressed;
	/**
	 * Animation timer to run animation
	 */
	AnimationTimer timer;
	
	/**
	 * score variable to add score
	 */
	static int score;
	/**
	 * 
	 */
	Label l;
	
	//Rectangle[] blocks;
	//Block[] blocks;
	/**
	 * random value to randomize the integers
	 */
	Random rand;
	
	
	/**
	 * This is constructor for the class 
	 */
	public Game() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, w, h);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setResizable(true); //RESIZABLE

		Button pause = new Button();
		ImageView iv = new ImageView("application/pause.png");
		
		iv.setFitHeight(40);
		iv.setFitWidth(40);
		pause.setGraphic(iv);
		pause.setMinSize(40, 40);
		pause.setPrefSize(40, 40);
		pause.setMaxSize(40, 40);
		
		pause.setOnAction(new EventHandler<ActionEvent>() {

			/* (non-Javadoc)
			 * @see javafx.event.EventHandler#handle(javafx.event.Event)
			 * As we are using EventHandler we need to override the handle method to implementing the handling of our event
			 */
			@Override
			public void handle(ActionEvent event) {
				DropDownMenu pau = new DropDownMenu();
			 try {
				pau.start(gameStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
			
		});
		
		gamePane.getChildren().add(pause);

		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
				 if(event.getCode() == KeyCode.LEFT){
					 leftPressed = true;
				 } else if(event.getCode() ==  KeyCode.RIGHT) {
					 rightPressed = true;
				 } 
			}
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.LEFT){
					 leftPressed = false;
				 } else if(event.getCode() ==  KeyCode.RIGHT) {
					 rightPressed = false;
				 }
			}
		});
		//createGame(circle);
		createGame(snake);
		rand = new Random();
	}
	
	/**
	 * This method is used to instantiate the game with default setting like score =0; a new snake is used and new blocks and tokens
	 * @param snake is used to initialize a new game
	 */
	void createGame(Snake snake) { //SNAKE VERSION
		//this.menuStage = menuStage;
		//this.menuStage.hide();
		score = 0;
		l = new Label(String.valueOf(score));
		gamePane.getChildren().add(l);
		l.setLayoutX(560);
		l.setLayoutY(20);
		snakeSize = 3;
		createPlayer(snake, snakeSize);
		createBlocks();
		//makeloop(snake);
		//makeTokens();
		gameStage.show();
	}
	/**
	 * This method is used to update the score parameter
	 */
	void updateScore() {
		l = new Label("Score : " + String.valueOf(score));
		
	}
	
	/**
	 * This method is used to make a stackpane 
	 * @param item is of type of Ball
	 * @return we return the StackPane which has new added tokens
	 */
	StackPane makeStackPane(Ball item) {
		StackPane sp = new StackPane();
		Random r = new Random();
		int value = r.nextInt(29) + 1;
		item.size = value;
		Text val = new Text(Integer.toString(value));
		sp.getChildren().addAll(item, val);
		return sp;
	}
	
	/**
	 * This method is used to create the new Blocks(which is a token)
	 */
	void createBlocks() {
		Random r = new Random();
		hitBottom = false;
		//pos1
		double xpos1 = 0;
		double ypos1 = -120;
		int prob1 = r.nextInt(4);
		//System.out.println("prob1 = " + prob1);
		if(prob1 == 0 || prob1 == 1) {
			spawnBlock(xpos1, ypos1, 0);
		}
		else if(prob1 == 2) {
			spawnToken(xpos1, ypos1, 0);
		}
		else{
			spawnEmptyPane(xpos1, ypos1, 0);
			//System.out.println("no block at pos 1");
		}
		//pos2
		double xpos2 = 120;
		double ypos2 = -120;
		int prob2 = r.nextInt(4);
		//System.out.println("prob2 = " + prob2);
		if(prob2 == 0 || prob2 == 1) {
			spawnBlock(xpos2, ypos2, 1);
		}
		else if(prob2 == 2) {
			spawnToken(xpos2, ypos2, 1);
		}
		else{
			spawnEmptyPane(xpos2, ypos2, 1);
			//System.out.println("no block at pos 2");
		}
		//pos3
		double xpos3 = 240;
		double ypos3 = -120;
		int prob3 = r.nextInt(4);
		//System.out.println("prob3 = " + prob3);
		if(prob3 == 0 || prob3 == 1) {
			spawnBlock(xpos3, ypos3, 2);
		}
		else if(prob3 == 2) {
			spawnToken(xpos3, ypos3, 2);
		}
		else{
			spawnEmptyPane(xpos3, ypos3, 2);
			//System.out.println("no block at pos 3");
		}
		//pos4
		double xpos4 = 360;
		double ypos4 = -120;
		int prob4 = r.nextInt(4);
		//System.out.println("prob4 = " + prob4);
		if(prob4 == 0 || prob4 == 1) {
			spawnBlock(xpos4, ypos4, 3);
		}
		else if(prob4 == 2) {
			spawnToken(xpos4, ypos4, 3);
		}
		else{
			spawnEmptyPane(xpos4, ypos4, 3);
			//System.out.println("no block at pos 4");
		}
		//pos5
		double xpos5 = 480;
		double ypos5 = -120;
		int prob5 = r.nextInt(4);
		//System.out.println("prob5 = " + prob5);
		if(prob5 == 0 || prob5 == 1) {
			spawnBlock(xpos5, ypos5, 4);
		}
		else if(prob5 == 2) {
			spawnToken(xpos5, ypos5, 4);
		}
		else{
			spawnEmptyPane(xpos5, ypos5, 4);
			//System.out.println("no block at pos 5");
		}
	}
	/*
	void spawnEmptyPane(double xpos, double ypos) {
		StackPane sp = new StackPane();
		sp.setLayoutX(xpos);
		sp.setLayoutY(ypos);
		gamePane.getChildren().add(sp);
		empties.add(sp);
	}
	*/
	/**
	 * This method is used to generate some empty StackPane on the window
	 * @param xpos is the x-coordinate 
	 * @param ypos is the y- coordinate
	 * @param index of where we need to this in paneArr
	 */
	void spawnEmptyPane(double xpos, double ypos, int index) {
		StackPane sp = new StackPane();
		sp.setLayoutX(xpos);
		sp.setLayoutY(ypos);
		gamePane.getChildren().add(sp);
		paneArr[index] = sp;
	}
	
	
	
	/**
	 * @param x is the x coordinate
	 * @param y is the y coordinate
	 * @param index where we need to add the StackPane in the paneArr
	 */
	void spawnToken(double x, double y, int index) {
		double xpos = x + 10;
		double ypos = y+ 10;
		Random r = new Random();
		int t = r.nextInt(6);
		if(t == 0) {	//spawn magnet
			StackPane sp = new StackPane();
			Magnet m = new Magnet();
			sp.getChildren().add(m);
			sp.setLayoutX(xpos);
			sp.setLayoutY(ypos);
			
			gamePane.getChildren().add(sp);
			paneArr[index] = sp;
			
		}
		else if(t == 1) {	//spawn bomb
			StackPane sp = new StackPane();
			Shield s = new Shield();
			sp.getChildren().add(s);
			sp.setLayoutX(xpos);
			sp.setLayoutY(ypos);
			gamePane.getChildren().add(sp);
			paneArr[index] = sp;
		}
		else if(t == 2) {	//spawn shield
			StackPane sp = new StackPane();
			BlockBomb b = new BlockBomb();
			sp.getChildren().add(b);
			sp.setLayoutX(xpos);
			sp.setLayoutY(ypos);
			gamePane.getChildren().add(sp);
			paneArr[index] = sp;
		}
		else {
			Ball b = new Ball();
			StackPane sp = makeStackPane(b);
			sp.setLayoutX(xpos + 30);
			sp.setLayoutY(ypos + 30);
			gamePane.getChildren().add(sp);
			paneArr[index] = sp;
		}
	}
	/*
	ArrayList<StackPane> tokens = new ArrayList<StackPane>();
	ArrayList<StackPane> empties = new ArrayList<StackPane>();
	ArrayList<StackPane> blocks = new ArrayList<StackPane>();
	*/
	/**
	 * It is the StackPane where we are addding basic GUI component
	 */
	StackPane[] paneArr = new StackPane[5];
	
	/*
	void spawnBlock(double xpos, double ypos) {
		Random r = new Random();
		Block block = new Block();
		int bsize = r.nextInt(29) + 1;
		Text val = new Text(Integer.toString(bsize));
		val.setStyle("-fx-font: 25 arial;");
		StackPane sp = new StackPane();
		sp.getChildren().addAll(block, val);
		sp.setLayoutX(xpos);
		sp.setLayoutY(ypos);
		gamePane.getChildren().add(sp);
		blocks.add(sp);
	}
	*/
	
	/**
	 * @param xpos is the x coordinate
	 * @param ypos is the y coordinate
	 * @param index where we need to add the StackPane to the paneArr
	 */
	void spawnBlock(double xpos, double ypos, int index) {
		Random r = new Random();
		Block block = new Block();
		int bsize = r.nextInt(29) + 1;
		Text val = new Text(Integer.toString(bsize));
		val.setStyle("-fx-font: 25 arial;");
		StackPane sp = new StackPane();
		sp.getChildren().addAll(block, val);
		sp.setLayoutX(xpos);
		sp.setLayoutY(ypos);
		gamePane.getChildren().add(sp);
		paneArr[index] = sp;
	}
	
	/**
	 * boolean value to check if the current block which are falling down have reached the bottom or not
	 */
	boolean hitBottom;
	/*
	void movePanes(ArrayList<StackPane> panes) {
		boolean clear = false;
		for(StackPane s : panes) {
			System.out.println("SIZE = " + panes.size());
			s.setLayoutY(s.getLayoutY() + 2);
			if(s.getLayoutY() > 700) {
				clear = true;
				break;
			}
		}
		if(clear) {
			for(StackPane s : panes){
				gamePane.getChildren().remove(s);
				s = null;
			}
			panes.clear();
			//System.out.println("reached bottom");
			hitBottom = true;
			return;
		}
		//createBlocks();
		
	}
	*/
	/**
	 * This method is used to move the StackPane
	 * @param panes , is the StackPane array which has GUI components in it
	 */
	void movePanes(StackPane[] panes) {
		boolean clear = false;
		for(StackPane s : panes) {
			//System.out.println("SIZE = " + panes.length);
			if(s == null) break;
			else{
				s.setLayoutY(s.getLayoutY() + 3);
				if(s.getLayoutY() > 700) {
					clear = true;
					break;
				}
			}
		}
		if(clear) {
			for(StackPane s : panes){
				gamePane.getChildren().remove(s);
				s = null;
			}
			clear(panes);
			//System.out.println("reached bottom");
			hitBottom = true;
			return;
		}
		//createBlocks();
		
	}
	
	/**
	 * this is method is used to clear the whole array of StackPane
	 * @param arr is the StackPane array which need to be cleared up
	 */
	void clear(StackPane[] arr) {
		for(StackPane s : arr) {
			s = null;
		}
	}
	
	/**
	 * this array is used to make a loop to run snake
	 * @param snake , is input which has to been moved
	 */
	void makeloop(Snake snake) {
		timer = new AnimationTimer() {
		

			@Override
			public void handle(long now) {
				//updateSnake(snake);
				updateScore();
				movePlayer(snake);
				if(hitBottom)
					createBlocks();
				movePanes(paneArr);
				detectCollisions(snake, paneArr);
			}
			
		};
		
		timer.start();
		
	}
	
	
	/**
	 * this method create a new player for the game
	 * @param snake , a new snake is used for every player
	 * @param snakeSize , initial snake size is fixed for every player
	 */
	void createPlayer(Snake snake, int snakeSize) {
		snake = new Snake(gamePane);
		/*
		//snake..setFill(Color.AQUAMARINE);
		//snake.setRadius(15);
		snake.setLayoutX(w/2);
		snake.setLayoutY(h/1.5);
		gamePane.getChildren().add(snake);
		*/
		//Group root = new Group();
		makeloop(snake);
		snake.addBalls(snakeSize, gamePane);
		//root.getChildren().addAll(snake);
		//gamePane.getChildren().addAll(snake);
		for(Ball b : snake)
			b.setLayoutX(w/2);
	}
	
	/**
	 * This method update the snake
	 * @param snake , it is given as  input so that this method can update it
	 */
	
	/**
	 * this is method is moving the snake either in left or right depending upon the keypressed
	 * @param snake , snake which is under moment is the input
	 */
	void movePlayer(Snake snake) {
		try{
			
			if(leftPressed && !rightPressed) {
				if(snake.get(0).getLayoutX() > 20)
					for(Ball b : snake)
						b.setLayoutX(b.getLayoutX() - 4);
				//System.out.println("left pressed");
				//System.out.println(snake.getLayoutX());
			}
			if(!leftPressed && rightPressed) {
				if(snake.get(0).getLayoutX() < 580)
					for(Ball b : snake)
						b.setLayoutX(b.getLayoutX() + 4);
				//System.out.println("right pressed");
				//System.out.println(snake.getLayoutX());
			}
			if(leftPressed && rightPressed) {
				//System.out.println("both pressed");
			}
			if(!leftPressed && !rightPressed) {
				
			}
			else {
				
			}
			//end try
			}
			catch(NullPointerException e) {
				
			}
	}
	
	/**
	 * This  method is used to detect the collision between snake and tokens
	 * @param snake , snake which has to used to detect collision
	 * @param panes , array of StackPane which has all the tokens
	 */
	void detectCollisions(Snake snake, StackPane[] panes) {
		
		try{
		
		for(int i = 0; i < 5; i++) {
			StackPane pane = panes[i];
			
			boolean col = false;
		
		
			
			if(!pane.getChildren().isEmpty()) { //empty
				Shape intersect = Shape.intersect(snake.get(0), (Shape) pane.getChildren().get(0));
				if(intersect.getBoundsInParent().getWidth() > 0) {
					col = true;
					//System.out.println("HIT " + i);
				}
		
				if(col) {
					handleCol(snake, pane, panes);
					col = false;
					break;
				}
			}//for empty
		}
		
		}
		catch(NullPointerException e) {
			
		}
	}
	
	/**
	 * this method help in adding more Balls to snake
	 * @param snake whose length is to be increase
	 * @param ball , the number of ball to be added
	 */
	void addBalls(Snake snake, Ball ball) {
		snake.addBalls(ball.size, gamePane);
		
		score += ball.size;
		System.out.println("size of ball: " + ball.size);
		System.out.println("Snake size: " + snake.size());
		System.out.println("Score is: " + score);
	}
	
	/**
	 * this method help to subtract the blocks when a collision is detected
	 * @param snake , snake whose balls are going to be deleted due to collision
	 * @param block which has collided with the snake
	 */
	void subBlocks(Snake snake, Block block) {
		if(block.value >= snake.size()) {
			System.out.println("GAME OVER");
			gameStage.hide();
			MainAppPage m = new MainAppPage();
			m.start(gameStage);;
			//gameStage.hide();
		}
		
		snake.subBalls(block.value, gamePane);
		
		//score -= block.value;
		System.out.println("size of block: " + block.value);
		System.out.println("Snake size: " + snake.size());
		System.out.println("Score is: " + score);
	}
	
	/**
	 * This method handle the collision between different GUI component
	 * @param snake which has collided
	 * @param pane pane which is under consideration of collision
	 * @param panes is the array of StackPane which contain tokens
	 */
	void handleCol(Snake snake, StackPane pane, StackPane[] panes) {
		//Rectangle rect = (Rectangle) pane.getChildren().get(0);
		//deletePane(pane);
		
		//System.out.println("rect is: " + rect.getClass());
			if(pane.getChildren().get(0) instanceof Block) {
				//System.out.println("HIT BLOCK");
				Block b = (Block)pane.getChildren().get(0);
				pane.getChildren().remove(b);
				subBlocks(snake, b);
				deletePane(pane);
			}
			try {
			if(pane.getChildren().get(0) instanceof Ball) {
				Ball b = (Ball)pane.getChildren().get(0);
				pane.getChildren().remove(b);
				//System.out.println("HIT BALL");
				addBalls(snake, b);
				deletePane(pane);
			}
			}catch (ClassCastException e) {
				
			}
			
			if(pane.getChildren().get(0) instanceof Shield) {
				//System.out.println("HIT Shield");
				deletePane(pane);
			}
			if(pane.getChildren().get(0) instanceof Magnet) {
				try {
					for(StackPane p : panes) {
						if(!p.getChildren().isEmpty()) {
							if(p.getChildren().get(0) instanceof Ball) {
								Ball b = (Ball)p.getChildren().get(0);
								p.getChildren().remove(b);
								addBalls(snake, b);
								deletePane(p);
							}
						} else {
							continue;
						}
				}
				//System.out.println("HIT Magnet");
				//deletePane(pane);
				}
				//}catch(IndexOutOfBoundsException e) {
					
				//}
				//catch(ConcurrentModificationException e) {
					
				//}
				finally{
					deletePane(pane);
				}
				
			}
			if(pane.getChildren().get(0) instanceof BlockBomb) {
				try {
				for(StackPane p : panes) {
					if(!p.getChildren().isEmpty()) {
						if(p.getChildren().get(0) instanceof Block) {
							deletePane(p);
						}
					} else {
						continue;
					}
				}
				//System.out.println("HIT Bomb");
				//deletePane(pane);
				}
				//}catch(IndexOutOfBoundsException e) {
					
				//}
				//catch(ConcurrentModificationException e) {
					
				//}
				finally{
					deletePane(pane);
				}
			}
		//}
	}
	
	
	boolean intersect(Snake snake, StackPane pane) {
		boolean x = false;
		boolean y = false;
		if(((snake.get(0).getLayoutX() + 20) > pane.getLayoutX()) && (snake.get(0).getLayoutX() < (pane.getLayoutX() + 120))) {
			x = true;
		}
		if(((snake.get(0).getLayoutY() + 20) > pane.getLayoutY()) && (snake.get(0).getLayoutY() < (pane.getLayoutY() + 120))) {
			y = true;
		}
		if(y && x) {
			return true;
		}
		else
			return false;
	}
	
	/**
	 * This method help to delete the pane
	 * @param pane which need to be deleted
	 */
	private void deletePane(StackPane pane) {
		gamePane.getChildren().remove(pane);
		pane = null;
		
	}
	
	/**
	 * @param x1 x coordinate of a point say p1
	 * @param x2 x coordinate of a point say p2
	 * @param y1 y coordinate of a point say p1
	 * @param y2 y coordinate of a point say p2
	 * @return the integral distance between the two points
	 * 
	 */

}
