package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * This class is used to make Ball elements for our Game
 * @author div,salil
 *
 */
public class Ball extends Token {
	
	/**
	 * this variable store the size of the ball
	 */
	int size;
	
	/**
	 * This is the constructor of this class which can be initialized by other classes to make elements
	 * of the type ball
	 */
	public Ball() {
		this.setWidth(40);
		this.setHeight(40);
		Image img = new Image("/application/bluecircle.png");
		this.setFill(new ImagePattern(img));
	}
	
}
