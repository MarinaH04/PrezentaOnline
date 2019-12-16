
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proiect.persistence.dao.CursDAO;
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
		CursDAO cursDAO = appContext.getBean(CursDAO.class);
//	usertDAO.insert("Student");
//	userDAO.insera("Andreea", "andres@yahoo.com", "557095", "Student");
//	cursDAO.insert(1,"Matematica");

//	Curs econ = new Curs("Matematica");
//	cursDAO.saveObj(econ);
//	System.out.println(econ.toString());
//	userDAO.displayUsers();
//	econ.add_user(userDAO.getUserByUsername("Marina"));
//	cursDAO.saveObj(econ);
		try {

			List<User> detailList = userDAO.displayUsers();
			for (final User user : detailList) {

				System.out.println(user.toString());
			}
		} catch (Exception ex) {

		}
		cursDAO.displayCursuri();
		try {
			List<Curs> cursuri = cursDAO.displayCursuri();
			for (final Curs curs : cursuri) {

				System.out.println(curs.toString());
			}
		} catch (Exception ex) {

		}
		usertDAO.displayUsersType();
		try {
			List<UserType> usersType = usertDAO.displayUsersType();
			for (final UserType usert : usersType) {
				System.out.println(usert.toString());
			}
		} catch (Exception ex) {

		}

		

		// System.out.println(useri.toString());

		//userDAO.update("Marina","Economie");

	}
}
