package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import models.Employee;
import models.Reimbursement;
import util.ConnectionFactory;

public class ReimbursementDao implements Dao {

	public void addReimbursement(Reimbursement reimbursement) {//adds a new reimbursement to the table


		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reimbursements (employee_id, date_submitted , event_date , approval_stage , amount , grading_format , active , last_approval_date) values(?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, reimbursement.getEmployeeId());
			ps.setDate(2, Date.valueOf(reimbursement.getDateSubmitted()));
			ps.setDate(3, Date.valueOf(reimbursement.getEventDate()));
			ps.setString(4, reimbursement.getApprovalState());
			ps.setDouble(5, reimbursement.getAmount());
			ps.setString(6, reimbursement.getGradingFormat());
			ps.setBoolean(7, true);
			ps.setDate(8, Date.valueOf(reimbursement.getLastApprovalDate()));
			
			ps.execute();	
					
		}catch (SQLException e) {
			e.printStackTrace();
	
		}
		

	}

	public Reimbursement getReimbursement(int reimbursementId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> getReimbursementList(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void approveReimbursement(int reimbursementId) {
		// TODO Auto-generated method stub

	}

	public void denyReimbursement(int reimbursementId) {
		// TODO Auto-generated method stub

	}

	public void deleteReimbursement() {
		// TODO Auto-generated method stub

	}

}
