package appDomain;
 
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.util.List;

import implementations.MyArrayList;
 
 
 public class XMLAppDriver  
 {
 	/**
 	 *  
 	 */
 	
 	public static void main( String[] args )
 	{
 		String filePath = "";
 		
 		// Check if command line arguments were entered
 		if (args.length > 0) {
 			filePath = args[0];
 		}
 		else {
 			System.err.println("Missing Command Line Arguments");
 			System.exit(0);
 		}
 		
 		MyArrayList<String> lines = getLines(filePath);
 		XmlParser xmlParser = new XmlParser();

 		if ( lines.size() != 0 ) {
 			xmlParser.parseXML(lines);
 		}
 		else {
 			System.err.println("File found but had no shapes");
 			System.exit(0);
 		}
 	}
 
 	
 	
 	/**
 
 	 */
	public static MyArrayList<String> getLines(String filePath) {
		MyArrayList<String> toReturn = new MyArrayList<String>();
 
 		try {
 			List<String> lines = Files.readAllLines(Paths.get(filePath));
 			for ( String line : lines ) {
 				toReturn.add(line.trim());
 			}
 						
 			
 		}
 		catch(IOException e){
 			System.err.println("The file titled \'" + filePath + "\' was not found");
 			System.exit(0);
 		}
 		return toReturn;
 	}
 
 }