package by.grodno.vika.webappsample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.vika.webappsample.service.DepService;
import by.grodno.vika.webappsample.service.Department;


@WebServlet(name = "DepDeleteSrvlt6", urlPatterns = { "/dep/delete" })
public class DepDeleteSrvlt6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id");
		
		

		DepService.getService().deleteDep(Integer.valueOf(parameter));

		resp.sendRedirect("/webappsample/dep");
	}
}