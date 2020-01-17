
//import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proiect.business.PrezentaManager;
import com.proiect.business.UserManager;
//import com.proiect.business.impl.UserManagerImpl;
import com.proiect.business.impl.DateParser;
import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.dao.PrezentaDAO;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.dao.UserTypeDAO;

//import com.proiect.persistence.entity.Curs;
//import com.proiect.persistence.entity.User;
//import com.proiect.persistence.entity.UserType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = sdf.parse("2020-01-20");
		
		String dataString = DateParser.toString(myDate);
		
		System.out.println(dataString);
		Date newDate = DateParser.parse(dataString);
		Calendar calendar = Calendar.getInstance();
		Long l = 1584655200000L;
		calendar.setTimeInMillis(l);
		
		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+mYear +" " + mMonth+ " " + mDay);
		

		@SuppressWarnings("resource")
		final ApplicationContext appContextbussiness = new ClassPathXmlApplicationContext("spring-dto.xml");
		UserManager usMang = appContextbussiness.getBean(UserManager.class);
		PrezentaManager prezManag = appContextbussiness.getBean(PrezentaManager.class);
//		System.out.println(prezentaDAO.display("AndreB", "Economie", myDate));	
		System.out.println(prezManag.present("Marina04", "Economie", myDate));
//		prezManag.insert("AndreB", "Economie", false, newDate);
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

		


//		System.out.println("Logare: "+userDAO.login("AndreB", "5678").toString());

	}
}
