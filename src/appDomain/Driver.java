package appDomain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Driver 
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
		
		parseXML(filePath);
		

		int count = 1;
		if (count != 0) {
						
			
		}
		else {
			System.err.println("File found but had no shapes");
			System.exit(0);
		}
	}

	
	
	/**

	 */
	public static String parseXML(String filePath) {
		String temp = "";
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			
			if (!lines.isEmpty()) {
	        	
				for (String line : lines ) {
					if (line != null && !line.trim().isEmpty()) {
	        		String[] parts = line.split(" ");
		        
					}
				}
			}
		}
		catch(IOException e){
			System.err.println("The file titled \'" + filePath + "\' was not found");
			System.exit(0);
		}
		return temp;
	}

}

