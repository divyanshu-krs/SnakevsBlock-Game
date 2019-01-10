package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * @author div,salil
 *This class is used for making the Shield that is token for the game
 */
public class Shield extends Token{
	
	/**
	 * This is the constructor for this class
	 */
	public Shield() {
		Image img = new Image("/application/shield.png");
		this.setFill(new ImagePattern(img));
	}
}
