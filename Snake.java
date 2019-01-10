package application;

import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;

/**
 * @author div,salil
 * This is class is used to make Snake which is used in the game
 *
 */
public class Snake extends ArrayList<Ball> {
	/**
	 * this is used to store the size of snake
	 */
	/**
	 * this is used to store the end point for the postioning of the snake
	 */
	int last;
	
	/**
	 * This is the constructor of the class
	 * @param gamePane is the input for this constructor so that we can add our snake to the window
	 */
	public Snake(AnchorPane gamePane) {
		last = 500;
		this.addBalls(1, gamePane);
		//this.get(0).setLayoutY(last - 40);
	}
	
	/**
	 * This is the method used to increase the length of the snake by adding more balls
	 * @param num is input for specifying how much ball need to added
	 * @param gamePane is used to update update the snake in the window
	 */
	void addBalls(int num, AnchorPane gamePane) {
		int pos = last;
		for(int i = 0; i < num; i++) {
			Ball ball = new Ball();
			this.add(ball);
			//size++;
			pos = last + 40*(i+1);
			ball.setLayoutX(this.get(0).getLayoutX());
			//ball.setLayoutX(302.5);
			ball.setLayoutY(pos);
			gamePane.getChildren().add(ball);
		}
		last = pos;
		System.out.println("addLAST = "+last);
	}
	
	/**
	 * This method is used to decrease the length of the snake by subtracting the number of the balls from it
	 * @param num specifies the number of ball that need to be removed
	 * @param gamePane to be updated after the changes
	 */
	void subBalls(int num, AnchorPane gamePane) {
		if(num >= this.size()) {
			System.out.println("GAME OVER");
		}
		else {
			int curr = last;
			curr -= 40*num;
			gamePane.getChildren().remove(this.size() - (num + 1), this.size() - 1);
			this.removeRange(this.size() - (num+1), this.size());
			last = curr;
		}
		
		/*
		else {
		int pos = last;
		for(int i = 1; i < num; i++) {
			//size--;
			pos -= 40;
			System.out.println("subPOS = " + pos);
			
			gamePane.getChildren().remove(this.get(this.size() - i));
			this.remove(this.size() - i);
		}
		
		last = pos;
		System.out.println("subLAST = "+last);
		}
		*/
	}
	
}