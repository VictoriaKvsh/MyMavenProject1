package by.grodno.vika.webappsample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.vika.webappsample.service.User;
import by.grodno.vika.webappsample.service.UserService;

public class JstlServlet4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("number");

		User user = UserService.getService().getUsers().get(Integer.valueOf(parameter));

		resp.sendRedirect("/webappsample/jstl2.jsp?firstName=" + user.getFirstName() + "&lastName=" + user.getLastName()
				+ "&birthdate=" + user.getBirthdate() + "&male=" + user.isMale() +"&salary=" + user.getSalary());
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = new User(null, 
					             req.getParameter("firstName"), 
					             req.getParameter("lastName"),
					             new SimpleDateFormat("yyy-MM-dd")
					                 .parse(req.getParameter("birthdate")),
					             Boolean.valueOf(req.getParameter("male")));
			user.setSalary(Double.valueOf(req.getParameter("salary")));
			
			UserService.getService().updateUser(user);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/webappsample/jstl1");
	}

}