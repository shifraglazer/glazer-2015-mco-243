package glazer.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunPrgm {
	
	public static void main(String args[]){
		
		 String s = null;
		 
	        try {
	           // Process p = Runtime.getRuntime().exec("CMD /c echo %cd%");
	            Process p = Runtime.getRuntime().exec("Java -cp ./bin glazer.processes.Server");
	            Process p2 = Runtime.getRuntime().exec("Java -cp ./bin glazer.processes.Client");
	            BufferedReader stdInput = new BufferedReader(new
	                 InputStreamReader(p.getInputStream()));
	 
	            BufferedReader stdError = new BufferedReader(new
	                 InputStreamReader(p.getErrorStream()));
	 
	            // read the output from the command    
	            while ((s = stdInput.readLine()) != null) {
	                System.out.println(s);
	            }
	             
	         
	            while ((s = stdError.readLine()) != null) {
	                System.out.println(s);
	            }
	             
	            System.exit(0);
	        }
	        catch (IOException e) {
	     
	            e.printStackTrace();
	            System.exit(-1);
	        }
	    }

	}


