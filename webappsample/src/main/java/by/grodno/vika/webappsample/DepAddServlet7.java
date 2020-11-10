package by.grodno.vika.webappsample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.vika.webappsample.service.Department;
import by.grodno.vika.webappsample.service.DepService;


@WebServlet(name = "DepAddServlet7", urlPatterns = { "/add_dep" })
public class DepAddServlet7 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Department dep = new Department();
		
		dep.setDepName(req.getParameter("department"));

		DepService.getService().addDep(dep);

		resp.sendRedirect("/webappsample/dep");
	}

}