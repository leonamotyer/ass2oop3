package appDomain;
 
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.util.List;
 
 
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
 		
 		List<String> lines = parseXML(filePath);
 		

 		if (lines != null) {
 			for ( String line : lines ) {
 				System.out.println(line.trim());
 			}}
 		else {
 			System.err.println("File found but had no shapes");
 			System.exit(0);
 		}
 	}
 
 	
 	
 	/**
 
 	 */
 	public static List<String> parseXML(String filePath) {
 		List<String> temp = null;
 
 		try {
 			List<String> lines = Files.readAllLines(Paths.get(filePath));
 			temp = lines;
 			
 			
 		}
 		catch(IOException e){
 			System.err.println("The file titled \'" + filePath + "\' was not found");
 			System.exit(0);
 		}
 		return temp;
 	}
 
 }