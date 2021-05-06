package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {
	void add(User user);
	List<User>getAll();
	void login(String email,String password);

}
