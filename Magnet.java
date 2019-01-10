package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * @author div,salil
 *This class is used to make another token called Magnet for the Game
 */
public class Magnet extends Token {
	
	/**
	 * This is the constructor for the class
	 */
	public Magnet() {
		Image img = new Image("/application/magnet.jpg");
		this.setFill(new ImagePattern(img));
	}

}
