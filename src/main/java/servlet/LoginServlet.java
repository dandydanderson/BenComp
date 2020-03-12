package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.GsonBuilder;

import models.Employee;
import services.EmployeeService;
import services.ReimbursementService;

public class LoginServlet extends HttpServlet{
	
	EmployeeService empServ = new EmployeeService();
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: " + username + " Password: " + password);
		
		Employee employee =  new Employee();
		
		if(username != null && password != null) {
		employee = empServ.checkForUser(username, Integer.valueOf(password));
		
		}
		
		System.out.println("Employee: " + employee);
		if (employee.getPosition() == null) {
			response.setStatus(response.SC_UNAUTHORIZED);
		} else {
			HttpSession sess = request.getSession(true);
			sess.setAttribute("Employee", employee);
			response.sendRedirect("pages/Dashboard.html");//not sure if this is gonna work
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the employee to send
		
				HttpSession sess = request.getSession(false);
				Employee emp = (Employee) sess.getAttribute("Employee");
				
				
				
				String employeeJSON = new GsonBuilder().create().toJson(emp);

				PrintWriter pw = response.getWriter();
				pw.write(employeeJSON);
		
	}
	

}
