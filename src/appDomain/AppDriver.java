package appDomain;

public class AppDriver {
	
	public static void main( String[] args ) {
		
		try {			
			App app = new App.Builder()
					.of(args)
					.build();
					
			app.run();	
		} catch (Exception ex) {
			System.out.println("Internal Error: something failed silently");
		}
	}	
}