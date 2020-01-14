
import java.util.List;

import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proiect.business.PrezentaManager;
import com.proiect.business.UserManager;
import com.proiect.business.impl.UserManagerImpl;
import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.dao.PrezentaDAO;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.dao.UserTypeDAO;

import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Application {
	public static void main(String[] args) throws ParseException {
	
		@SuppressWarnings("resource")
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		UserDAO userDAO = appContext.getBean(UserDAO.class);
		UserTypeDAO usertDAO = appContext.getBean(UserTypeDAO.class);
		UserCursDAO usercursDAO = appContext.getBean(UserCursDAO.class);
		CursDAO cursDAO = appContext.getBean(CursDAO.class);
		PrezentaDAO prezentaDAO = appContext.getBean(PrezentaDAO.class);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = sdf.parse("2019-07-30");
		

		
		
		final ApplicationContext appContextbussiness = new ClassPathXmlApplicationContext("spring-dto.xml");
		UserManager usMang = appContextbussiness.getBean(UserManager.class);
		PrezentaManager prezManag = appContextbussiness.getBean(PrezentaManager.class);
		prezManag.insert("AndreB", "Economie", false, myDate);
//		System.out.println(userDAO.getCursUser("Marina04"));
//		System.out.println(cursDAO.getUsersbyCourse("Matematica"));
//		usMang.insertDTO("AndreB", "Andreea", "Barbu", "andreb@gmail.com", "1234", "Student");
//		usMang.updateDTO("AndreB", "MorariuP");
//		System.out.println(usMang.getCursUser("Economie"));
//		System.out.println(usMang.getUserCurs("AndreB"));
//		usMang.deleteDTO("Marina04");
//		usMang.editDTO("Marina04", "Marina", "Hanzu", "hanzumarina@yahoo.com", "1234");
		
//	usertDAO.insert("Profesor");
//	userDAO.insert("RaveH","Raveca","Halmaghi", "raveh@yahoo.com", "1234", "Admin");
//	cursDAO.insert(1,"Economie");
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
