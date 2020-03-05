package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Reimbursement;
import services.ReimbursementService;


public class ReimbursmentServlet extends HttpServlet {
	
	ReimbursementService reimService = new ReimbursementService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter pw = resp.getWriter();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reimJson = req.getReader().readLine();
		System.out.println(reimJson);
		Reimbursement reim = new GsonBuilder().create().fromJson(reimJson, Reimbursement.class);
		try {
			reimService.addReimbursement(reim);
			resp.getWriter().write("Success");
		} catch (Exception e) {
			resp.getWriter().write("Reimbursement could not be completed");
			e.printStackTrace();
		}
	}
	
	

}
