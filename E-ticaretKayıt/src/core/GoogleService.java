package core;

public interface GoogleService {

	void add(String name,String surname,String email,String password);
	
	void login(String email,String password);
}
