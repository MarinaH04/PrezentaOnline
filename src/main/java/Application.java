
import java.util.List;

import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proiect.business.impl.UserManagerImpl;
import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.dao.UserTypeDAO;

import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserType;



public class Application {
	public static void main(String[] args) {
	
		@SuppressWarnings("resource")
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		UserDAO userDAO = appContext.getBean(UserDAO.class);
		UserTypeDAO usertDAO = appContext.getBean(UserTypeDAO.class);
		UserCursDAO usercursDAO = appContext.getBean(UserCursDAO.class);
		CursDAO cursDAO = appContext.getBean(CursDAO.class);
		
		usercursDAO.update("Marina04", "Matematica");
//	usertDAO.insert("Profesor");
//	userDAO.insert("RaveH","Raveca","Halmaghi", "raveh@yahoo.com", "1234", "Admin");
//	cursDAO.insert(2,"Mate");
//	userDAO.update("ManiutiuR","Economie");

//		try {
//
//			List<User> detailList = userDAO.displayUsers();
//			for (final User user : detailList) {
//
//				System.out.println(user.toString());
//			}
//		} catch (Exception ex) {
//
//		}
//		cursDAO.displayCursuri();
//		try {
//			List<Curs> cursuri = cursDAO.displayCursuri();
//			for (final Curs curs : cursuri) {
//
//				System.out.println(curs.toString());
//			}
//		} catch (Exception ex) {
//
//		}
//		usertDAO.displayUsersType();
//		try {
//			List<UserType> usersType = usertDAO.displayUsersType();
//			for (final UserType usert : usersType) {
//				System.out.println(usert.toString());
//			}
//		} catch (Exception ex) {
//
//		}
//		Set<Curs> courses = userDAO.getCourses(1);
//		System.out.println("Studentul cu id "+1+" participa la urmatoarele cursuri:");
//		for(Curs curs1:courses) {
//			System.out.println(curs1.toString());
//		}
//		
//		Set<User> users = cursDAO.getUsers("Matematica");
//		System.out.println("La cursul cu id "+2+" participa urmatorii studenti: ");
//		for(User user1:users) {
//			System.out.println(user1.toString());
//		}
		


//		System.out.println("Logare: "+userDAO.login("AndreB", "5678").toString());

	}
}
