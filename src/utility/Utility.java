package utility;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {
	/**
	 * Adding a private constructor to hide the implicit public one.
	 * Utility classes, which are collections of static members, are not meant to be instantiated. 
	 * 	Even abstract utility classes, which can be extended, should not have public constructors.
	 * Java adds an implicit public constructor to every class which does not define at least one explicitly. 
	 * 	Hence, at least one non-public constructor should be defined.
	 */
  private Utility() {
    throw new IllegalStateException("Utility class");
  }
  
	/**
	 * clearScreen() function as of now works only in microsoft windows to clear the previous statements available in console window
	 */
	public static void clearScreen() {  
    try {
        if (System.getProperty("os.name").contains("Windows"))
        	try {
        		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        	} catch (InterruptedException e) {
            // Restore interrupted state...
            Thread.currentThread().interrupt();
      			System.out.println(e);
        	}
        else
        	Runtime.getRuntime().exec("clear");
        } catch (IOException ex) {
        	System.out.println(ex);
        }
  }
	
	/**
	 * getCurrentDate			To provide current date. This is based on current locale machine time...
	 * 
	 * @return		returns string of current date in a pattern "yyyy-MM-dd"
	 */
	public static String getCurrentDate() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return dtf.format(ldt);
	}
	
	/**
	 * getCurrentDateTime			To provide current date and time. This is based on current locale machine time...
	 * @return		returns current date and time in a "yyyy/MM/dd HH:MM:ss" format
	 */
	public static String getCurrentDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:MM:ss");
		return dtf.format(ldt);
	}
}
