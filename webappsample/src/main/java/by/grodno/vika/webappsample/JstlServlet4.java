package by.grodno.vika.webappsample;

import java.io.IOException;
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

		req.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/jstl2.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = new User(Integer.valueOf(req.getParameter("id")), req.getParameter("firstName"),
					req.getParameter("lastName"),
					new SimpleDateFormat("yyy-MM-dd").parse(req.getParameter("birthdate")),
					Boolean.valueOf(req.getParameter("male")));

			user.setSalary(Double.valueOf(req.getParameter("salary")));
			user.setDepartment(Integer.valueOf(req.getParameter("department")));

			UserService.getService().updateUser(user);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/webappsample/jstl1");
	}

}