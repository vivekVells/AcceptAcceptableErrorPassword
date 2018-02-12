/*
 * Plan:
 * - get input from user
 * - parse the input 
 * - final status
 * 		- allow
 * 			- if it matches the predefined password perfectly
 * 			- if there is a mild deviation. say, near by letters. so its fine.
 * 		- reject
 * 			- if the given passoword is not matching properly (very difference)
 * - Steps involved:
 * 	  - input predefined password (minimum 6 as of now)
 * 	  - input password to test against predefined password
 * 	  - results:
 * - Things to consider here
 * 		- the severity of checking... hmmm.. do not overthink... lets start coding...  
 */

package passwordmistakeaccept;

import java.util.Scanner;

public class AAEP {
	protected static Scanner scan = new Scanner(System.in);
	
	public void pmaBanner() {
		System.out.println("********************************************************************************************************************************************************");
		System.out.println("\t\t\t\t\t\tACCEPT ACCEPTABLE ERROR PASSWORD PAGE");
		System.out.println("********************************************************************************************************************************************************");
		System.out.println("Today: " + utility.Utility.getCurrentDateTime() + "\n\n");		
	}
	
	public Boolean isIgnoredCaseSensitive(String pass, String errPass) {
		return pass.equalsIgnoreCase(errPass) ? true : false; 
	}
	
	public void matchNearByKeys(String pass, String errPass) {
		// which to use hashmap or json thingy
		// lets go with json thingy.... 
		// I have to complete the JSONConverter project to proceed here.... hmmm.... link: https://github.com/vivekVells/JSONConverter
		
	}
	
	public String validateInputExtended(String pass, String errPass) {		
		if (isIgnoredCaseSensitive(pass, errPass)) {
			matchNearByKeys(pass, errPass);
			return "MATCHED. ACCEPTED";
		} else {
			return "NOT MATCHED. DENIED";
		}	
	}
	
	public void validateInput(String pass, String errPass) {
		if (pass.equals(errPass)) {
			System.out.println("MATCHABLE. ACCEPTED.");
			System.out.println("Match Percentage: 100% \nNumber of words matched: " + pass.length() + " / " + errPass.length());
		} else {
			System.out.println(validateInputExtended(pass, errPass));
		}
	}
	
	public void getInputFromUser() {
		String passDefined; 
		String password;
		
		while (true) {
			System.out.print("Input your predefined password: ");
			passDefined = scan.nextLine();
			System.out.print("Input your password to test against the previous one: ");
			password = scan.nextLine();
			validateInput(passDefined, password);
			utility.Utility.clearScreen();
		}
	}
	public static void main(String[] args) {
		AAEP mainObj = new AAEP();
		mainObj.pmaBanner();
		
		mainObj.getInputFromUser();
	}
	
}
