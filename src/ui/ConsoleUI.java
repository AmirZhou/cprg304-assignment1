package ui;

public class ConsoleUI implements UI{
	
	public void display(String message) {
		System.out.println(message);
	}
	
	public void displayResult(Object[] result) {
		
		
		
		for (Object e: result) {
			System.out.println(e);
		}
	}
}
