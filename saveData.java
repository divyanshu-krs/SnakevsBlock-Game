package application;

/**
 * This is class is the main class which implements Serializable and is used for serializing the state of the game
 * @author div,salil
 * 
 *
 */
public class saveData implements java.io.Serializable{
		
	/**
	 * This is the serialVersionID which store a integer which can't be changed.
	 * It is like a serial number for a particular file which has to been serialized
	 */
	private static final long serialVersionID = 2L;
	
	/**
	 * this  is one the parameter which is being serialized
	 */
	public String name;
	/**
	 * this is another parameter which is being serialized 
	 */
	public int point;
	
}
