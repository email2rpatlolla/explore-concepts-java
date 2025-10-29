package com.practices.concepts.string;

 
class Connect2System {
	private String connect2URL;
	private StringBuilder generalText; 

	public String getConnect2URL() {
		return connect2URL;
	}

	public void setConnect2URL(String connect2url) {
		connect2URL = connect2url;
	}

	public StringBuilder getGeneralText() {
		return generalText;
	}

	public void setGeneralText(StringBuilder generalText) {
		this.generalText = generalText;
	}
	
	public void connect() {
		System.out.println("Connecting to: "+ connect2URL + " with general text: "+ generalText);
	}
	
	public void execute() {
		System.out.println("Executing with: "+ connect2URL + " with general text: "+ generalText);
	}
	
	
}

public class StringSecurity {
	
	private static final String VALID_URL = "I am a valid URL";
	private static final String HACKER_URL = "I am hacker URL";
	
	private static final String VALID_DESC = "General help text";
	private static final String HACKER_DESC = "Hacker help text";

	public static void main(String[] args) {
		
		var myURL = VALID_URL;
		var generalTxt = new StringBuilder(VALID_DESC);
		
		Connect2System connection = new Connect2System();
		connection.setConnect2URL(myURL);
		connection.setGeneralText(generalTxt);
		
		connection.connect();
		
//		myURL = HACKER_URL;
		myURL.concat(HACKER_URL);
		generalTxt.delete(0, generalTxt.length()).append(HACKER_DESC);
		
		connection.execute();
		
	}

}
