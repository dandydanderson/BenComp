package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Employee;
import models.FullReimbursement;
import models.Reimbursement;
import services.EmployeeService;
import services.ReimbursementService;

public class ManagedReimbursementServlet extends HttpServlet{
	
EmployeeService empServ = new EmployeeService();
ReimbursementService reimServ = new ReimbursementService();
private Reimbursement reim = new Reimbursement();
private Employee emp = new Employee();
private FullReimbursement full = new FullReimbursement();


	

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//get the employee and the reimbursement

		
		String reimId = req.getReader().readLine();
		System.out.println(reimId);	
		
		int reimIdInt = Integer.valueOf(reimId);
		
		reim = reimServ.getReimbursementById(reimIdInt);
		emp = empServ.getEmployeeById(reim.getEmployeeId());
		
		full.setEmployeeId(emp.getEmployeeId());
		full.setFirstName(emp.getFirstName());
		full.setLastName(emp.getLastName());
		full.setDeptName(emp.getDeptName());
		full.setReimbursementTotal(emp.getReimbursementTotal());
		
		full.setReimbursementId(reim.getReimbursementId());
		full.setCourseName(reim.getCourseName());
		full.setDateSubmitted(reim.getDateSubmitted());
		full.setEventDate(reim.getEventDate());
		full.setAmount(reim.getAmount());
		full.setLastApprovalDate(reim.getLastApprovalDate());
		full.setApprovalState(reim.getApprovalState());
		
	     HttpSession sess = req.getSession();
		 sess.setAttribute("Full Reimbursement", full);
		 
		 System.out.println(sess.getAttribute("Full Reimbursement"));
		
	}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//Reimbursement info
	//Reimbursement info
	HttpSession sess = req.getSession();
	while(sess.getAttribute("Full Reimbursement")==null) {//this line of code is here so that it doesn't try and send this before the session attribute is set
	System.out.println(sess.getAttribute("Full Reimbursement"));
	}
	FullReimbursement full = (FullReimbursement) req.getSession().getAttribute("Full Reimbursement");
	
	String fullStringJSON = new GsonBuilder().create().toJson(full);
	
	
	//Send it all

	PrintWriter pw = resp.getWriter();
	pw.write(fullStringJSON);
	
}

}
