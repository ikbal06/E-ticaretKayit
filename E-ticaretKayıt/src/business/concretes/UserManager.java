package business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import core.GoogleService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	GoogleService googleService;
	private ArrayList<String>emailList=new ArrayList<String>();
	private ArrayList<String>passwordList=new ArrayList<String>();
	
	public UserManager(UserDao userDao, GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.googleService=googleService;
	}

	public static boolean emailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
	
	
	public static boolean emailVerification(){
		return true;
	}
	public static boolean googleOrEmail() {
		return true;
	}

	@Override
	public void add(User user) {
		if (user.getPassword().length()<5) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr");
			return;
		}else {
			passwordList.add(user.getPassword());
		}
		if(emailList.contains(user.getEmail())) {
			System.out.println("Bu eposta zaten kayýtlý");
			return;
		}
		if(emailValid(user.getEmail())==false) {
			System.out.println("Eposta yanlýþ");
			return;
		}
		if (emailVerification()==false) {
			System.out.println("epostanýzý doðrulayýn");
			return;
		}
		else {
			emailList.add(user.getEmail());
		}
		if (user.getName().length()<2||user.getSurname().length()<2) {
			System.out.println("Ad ve soyad en az iki karakterden oluþmalýdýr.");
			return;
		}
		if(googleOrEmail() == true) {
			googleService.add(user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
		}else {
			userDao.add(user);
			
		}
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

	@Override
	public void login(String email, String password) {
		if (emailList.contains(email)&&passwordList.contains(password)) {
			System.out.println("giriþ baþarýlý");
		}else {
			System.out.println("Eposta veya þifre yanlýþ");
		}
		
	}


	

}
