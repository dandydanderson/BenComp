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
import models.FullReimbursement;
import models.Reimbursement;
import services.EmployeeService;
import services.ReimbursementService;

public class ReimbActionServlet extends HttpServlet{

	EmployeeService empServ = new EmployeeService();
	ReimbursementService reimServ = new ReimbursementService();
	FullReimbursement reim = new FullReimbursement();

		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//approve or deny based on button

		System.out.println("made it to doPost from button click");
		
		PrintWriter pw = resp.getWriter();
		HttpSession sess = req.getSession();
		reim = (FullReimbursement) sess.getAttribute("Full Reimbursement");
		
		System.out.println(reim);
		
		
		String status = req.getReader().readLine();
		
		System.out.println(status);
		
		if(status.equals("deny")) {
			
			System.out.println("passed into if statement");
			reimServ.denyReimbursement(reim.getReimbursementId());
			pw.write("Reimbursement was denied");
		}
		if(status.equals("approve")) {
			
			
			reimServ.approveReimbursement(reim.getReimbursementId(), reim.getApprovalState(), reim.getEmployeeId());
			
			pw.write("Reimbursement was approved");
			
			
		}
		
		//send some kind of message about the form
		
			
			
		}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//Reimbursement info
	
		
		}

	
	}

