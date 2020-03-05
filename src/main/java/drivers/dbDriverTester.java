package drivers;

import java.sql.Connection;
import java.time.LocalDate;

import daos.ReimbursementDao;
import models.Reimbursement;
import util.ConnectionFactory;

public class dbDriverTester {

	public static void main(String[] args) {
		
		ReimbursementDao dao = new ReimbursementDao();
		
		Reimbursement reim = new Reimbursement();
		
		reim.setEmployeeId(9);
		reim.setDateSubmitted(LocalDate.now());
		reim.setEventDate(LocalDate.now());
		reim.setApprovalState("Detention Captain");
		reim.setAmount(250);
		reim.setGradingFormat("Completion");
		reim.setActive(true);
		reim.setLastApprovalDate(LocalDate.now());
		
		dao.addReimbursement(reim);
	
		
	
		
		

	}

}
