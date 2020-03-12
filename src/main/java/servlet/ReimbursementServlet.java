package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Employee;
import models.Reimbursement;
import services.ReimbursementService;


public class ReimbursementServlet extends HttpServlet {
	
	ReimbursementService reimService = new ReimbursementService();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//return all relevant reimbursements to the dashboard FOR NOW THE EMPLOYEE USING SYSTEM IS HARD CODED, THAT'S TO CHANGE NEXT
		
		HttpSession sess = req.getSession(false);
		Employee emp = (Employee) sess.getAttribute("Employee");
		
		//personal reimbursements:
		
		System.out.println("Made it to the doGet for the Reimbursement List");
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		reimList = reimService.getReimbursementList(emp);;

	
		
		//managed reimbursements:
		
		List<Reimbursement> reimManagerList = new ArrayList<Reimbursement>();
		reimManagerList = reimService.getManagerReimbursementList(emp);
		reimList.addAll(reimManagerList);
	
		
		String reimListJSON = new GsonBuilder().create().toJson(reimList);
		
		//Send it all

		PrintWriter pw = resp.getWriter();
		pw.write(reimListJSON);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reimJson = req.getReader().readLine();
		System.out.println(reimJson);
		Reimbursement reim = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create().fromJson(reimJson, Reimbursement.class);
		
		try {
			reimService.addReimbursement(reim);
			resp.getWriter().write("Success");
		} catch (Exception e) {
			resp.getWriter().write("Reimbursement could not be completed");
			e.printStackTrace();
		}
	}
	
	

}
