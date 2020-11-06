package by.grodno.vika.webappsample;

import java.io.IOException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				+ "&birthdate=" + user.getBirthdate() + "&male=" + user.isMale() + "&salary=" + user.getSalary() + "&department=" + user.getDepartment() + "&id="
				+ user.getId());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			Date birthdate = new SimpleDateFormat("yyy-MM-dd").parse(req.getParameter("birthdate"));
			Integer id = Integer.valueOf(req.getParameter("id"));
			
			Boolean male = Boolean.valueOf(req.getParameter("male"));			
			Double salary = Double.valueOf(req.getParameter("salary"));
			Integer department = Integer.valueOf(req.getParameter("department"));
			

			UserService.getService().updateUser(firstName, lastName, male, birthdate, salary, department, id);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		resp.sendRedirect("/webappsample/jstl1");
	}

}