package by.grodno.vika.webappsample;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.vika.webappsample.service.Department;
import by.grodno.vika.webappsample.service.DepService;

@WebServlet(name = "DepServlet5", urlPatterns = { "/dep" })
public class DepServlet5  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Department> data = DepService.getService().getCarList();
		
		req.setAttribute("department", data);
	
		getServletContext().getRequestDispatcher("/dList.jsp").forward(req, resp);
	}
}