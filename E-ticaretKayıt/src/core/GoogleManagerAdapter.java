package core;

import Google.GoogleManager;

public class GoogleManagerAdapter implements GoogleService {

	GoogleManager google=new GoogleManager();
	
	@Override
	public void add(String name, String surname, String email, String password) {
		google.add(name,surname,email,password);
		
	}

	@Override
	public void login(String email, String password) {
		google.login(email, password);
		
	}

}
