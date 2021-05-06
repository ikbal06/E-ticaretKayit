package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HipernateUserDao implements UserDao{

	List<User> userList = new ArrayList<>();
	
	@Override
	public void add(User user) {
		System.out.println(user.getName() + " "+ user.getSurname() + "kaydedildi");
		userList.add(user);
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile silindi");
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile güncellendi");
		
	}

	@Override
	public List<User> getAll() {
		return userList;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
