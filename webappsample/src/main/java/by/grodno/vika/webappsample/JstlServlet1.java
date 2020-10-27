package by.grodno.vika.webappsample;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.vika.webappsample.service.User;
import by.grodno.vika.webappsample.service.UserService;

/**
 * Servlet implementation class JstlServlet1
 */
public class JstlServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = UserService.getService().getUsers();

		request.setAttribute("users", users);

		getServletContext().getRequestDispatcher("/jstl1.jsp").forward(request, response);
	}
}
