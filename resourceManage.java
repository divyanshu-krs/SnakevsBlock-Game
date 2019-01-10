package application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * This is class helps managing the serialized files
 * @author div,salil
 *
 */
public class resourceManage {
	
	/**
	 * This class help is saving the data to the appropriate file
	 * @param data which has to be serialized(type Serializable)
	 * 
	 * @param fileName is the the name of the file in which we are saving the data
	 * @throws Exception is checked is we aren't able to generate a file to store data
	 */
	public static void save(Serializable data,String fileName) throws Exception{
		try (ObjectOutputStream outstream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))){
			outstream.writeObject(data);
		}
	}
	
	/**
	 * @param fileName from which we need to load the data
	 * @return The the data from that file
	 * @throws Exception to handled as File may be not found
	 */
	public static Object load(String fileName)throws Exception{
		try  (ObjectInputStream imputstream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))){
			return imputstream.readObject();
			
		}
	}

}
