
//import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proiect.business.PrezentaManager;
import com.proiect.business.UserManager;
//import com.proiect.business.impl.UserManagerImpl;

import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.dao.PrezentaDAO;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.dao.UserTypeDAO;

//import com.proiect.persistence.entity.Curs;
//import com.proiect.persistence.entity.User;
//import com.proiect.persistence.entity.UserType;

import java.text.ParseException;




public class Application {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException {
	
		@SuppressWarnings("resource")
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		UserDAO userDAO = appContext.getBean(UserDAO.class);
		UserTypeDAO usertDAO = appContext.getBean(UserTypeDAO.class);
		UserCursDAO usercursDAO = appContext.getBean(UserCursDAO.class);
		CursDAO cursDAO = appContext.getBean(CursDAO.class);
		PrezentaDAO prezentaDAO = appContext.getBean(PrezentaDAO.class);


		

		@SuppressWarnings("resource")
		final ApplicationContext appContextbussiness = new ClassPathXmlApplicationContext("spring-dto.xml");
		UserManager usMang = appContextbussiness.getBean(UserManager.class);
		PrezentaManager prezManag = appContextbussiness.getBean(PrezentaManager.class);

		
	usertDAO.insert("Admin");




	}
}
