import business.abstracts.UserService;
import business.concretes.UserManager;
import core.GoogleManagerAdapter;
import dataAccess.concretes.HipernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService=new UserManager(new HipernateUserDao(),
				new GoogleManagerAdapter());
        User user1=new User(1,"Ýkbal","Kýrklar","ikbal@ikbal.com","123456");
        userService.add(user1);
        userService.login("ikbal@ikbal.com","123456");
	}

}
