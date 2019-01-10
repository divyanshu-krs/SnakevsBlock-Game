package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * @author div,salil
 *This class is used to another tokens called Bomb
 */
public class BlockBomb extends Token { //destroy blocks on screen
	
	/**
	 * This is the constructor of the class,which make new bomb when initialized
	 */
	public BlockBomb() {
		Image img = new Image("/application/cartoonbomb.jpg");
		this.setFill(new ImagePattern(img));
	}
	
}
