package application;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author div,salil
 *
 */
public class Block extends Rectangle {
	//Text value = new Text();
	/**
	 * this parameter is used to assign the value of the particular block
	 */
	int value;
	
	/**
	 * this is constructor of the class, which is making the block.
	 */
	public Block() {
		Random rand = new Random();
		int v = rand.nextInt(29) + 1;
		//this.value = new Text(Integer.toString(v));
		this.value = v;
		this.setWidth(120);
		this.setHeight(120);
		
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(5);
		if(v <= 7)
			this.setFill(Color.CHARTREUSE);
		else if(v > 7 && v <= 14)
			this.setFill(Color.YELLOW);
		else if(v > 14 && v <= 21)
			this.setFill(Color.LIGHTSALMON);
		else if(v > 21)
			this.setFill(Color.MEDIUMVIOLETRED);
	}

}
