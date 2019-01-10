package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * 
 * @author div,salil
 *This class deal with making token for the Game i.e bomb,magnet etc
 *so that all other respective classes can extend it
 */
public class Token extends Rectangle {
	
	/**
	 * This is the constructor for this class
	 */
	public Token() {
		this.setWidth(100);
		this.setHeight(100);
		
	}

}
