package by.grodno.vika.webappsample;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.vika.webappsample.service.User;
import by.grodno.vika.webappsample.service.UserService;

@WebServlet(name = "UsersAndDeptServlet8", urlPatterns = { "/dep/listOfUsers" })
public class UsersAndDeptServlet8 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer parameter = Integer.valueOf(request.getParameter("id"));
		List<User> users = UserService.getService().getUsersWithDept(parameter);
		request.setAttribute("users", users);

		getServletContext().getRequestDispatcher("/userAndDeptList.jsp").forward(request, response);
	}
}
