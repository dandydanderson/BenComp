package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Employee;
import models.Reimbursement;
import util.ConnectionFactory;

public class ReimbursementDao implements Dao {

	private static final String MYREIMSQL = "select * from reimbursements where employee_id = ?";
	
	private static final String MYMANAGERREIMSQL = "select * from reimbursements where approval_stage = ?";
	
	private static final String GETEMPLOYEEBYLOGIN = "select * from employees where employee_id = ? and last_name = ?";
	
	private static final String GETEMPLOYEEPOSITION = "select position_name from managers where employee_id = ?";
	
	private static final String GETEMPLOYEEBYID = "select * from employees where employee_id = ?";
	
	private static final String GETREIMBYID = "select * from reimbursements where reimbursement_id = ?";
	
	private static final String DENYREIMBURSEMENT = "update reimbursements set active = false, approval_stage = 'Unassigned' where reimbursement_id = ?";
	
	private static final String APPROVEREIMBURSMENT = "update reimbursements set approval_stage = ? where reimbursement_id = ?";
	
	private static final String GETAWARDLEFT = "select sum(amount) from reimbursements where employee_id = ? and approval_stage != 'Unassigned'";
	
	
	
	
	public void addReimbursement(Reimbursement reimbursement) {//adds a new reimbursement to the table

		
		
		

		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reimbursements (employee_id, date_submitted , event_date , approval_stage , amount , grading_format , active , last_approval_date, course_name) values(?,?,?,?,?,?,?,?,?)");
			
			
			
			ps.setInt(1, reimbursement.getEmployeeId());
			ps.setTimestamp(2, reimbursement.getDateSubmitted());
			ps.setTimestamp(3, reimbursement.getEventDate());
			ps.setString(4, reimbursement.getApprovalState());
			ps.setDouble(5, reimbursement.getAmount());
			ps.setString(6, reimbursement.getGradingFormat());
			ps.setBoolean(7, true);
			ps.setTimestamp(8, reimbursement.getLastApprovalDate());
			ps.setString(9, reimbursement.getCourseName());
			
			ps.execute();	
					
		}catch (SQLException e) {
			e.printStackTrace();
	
		}
		

	}
	
	
	public int getAwardLeft(int employeeId) {
		
		int award = 0;
		try(Connection conn = ConnectionFactory.getConnection()){
			PreparedStatement ps = conn.prepareStatement(GETAWARDLEFT);
			
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				award = rs.getInt(1);
			}
			
			return 1000-award;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return award;
	}

	public Reimbursement getReimbursement(int reimbursementId) {
	
		Reimbursement reim = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(GETREIMBYID);
			ps.setInt(1, reimbursementId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				reim.setReimbursementId(rs.getInt(1));
				reim.setEmployeeId(rs.getInt(2));
				reim.setDateSubmitted(rs.getTimestamp(3));
				reim.setEventDate(rs.getTimestamp(4));
				reim.setApprovalState(rs.getString(5));
				reim.setAmount(rs.getDouble(6));
				reim.setGradingFormat(rs.getString(7));
				reim.setActive(rs.getBoolean(8));
				reim.setLastApprovalDate(rs.getTimestamp(9));
				reim.setCourseName(rs.getString(10));
				
			}
			
			return reim;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	

	public List<Reimbursement> getReimbursementList(int employeeid) {
		
		System.out.println("Made it to the DAO");

		try (Connection conn = ConnectionFactory.getConnection()){
			
			List<Reimbursement> reimList = new ArrayList<Reimbursement>();
			
			PreparedStatement ps = conn.prepareStatement(MYREIMSQL);
			
			ps.setInt(1, employeeid);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Reimbursement reim = new Reimbursement();
				reim.setReimbursementId(rs.getInt(1));
				reim.setEmployeeId(rs.getInt(2));
				reim.setDateSubmitted(rs.getTimestamp(3));
				reim.setEventDate(rs.getTimestamp(4));
				reim.setApprovalState(rs.getString(5));
				reim.setAmount(rs.getDouble(6));
				reim.setGradingFormat(rs.getString(7));
				reim.setActive(rs.getBoolean(8));
				reim.setLastApprovalDate(rs.getTimestamp(9));
				reim.setCourseName(rs.getString(10));
				reimList.add(reim);
				
			}
			
			return reimList;
					
		}catch (SQLException e) {
			e.printStackTrace();
	
		}
			
		return null;
	}
	
	
public List<Reimbursement> getManagerReimbursementList(String employeePosition) {
		
		System.out.println("Made it to the DAO");

		try (Connection conn = ConnectionFactory.getConnection()){
			
			List<Reimbursement> reimList = new ArrayList<Reimbursement>();
			
			PreparedStatement ps = conn.prepareStatement(MYMANAGERREIMSQL);
			
			ps.setString(1, employeePosition);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Reimbursement reim = new Reimbursement();
				reim.setReimbursementId(rs.getInt(1));
				reim.setEmployeeId(rs.getInt(2));
				reim.setDateSubmitted(rs.getTimestamp(3));
				reim.setEventDate(rs.getTimestamp(4));
				reim.setApprovalState(rs.getString(5));
				reim.setAmount(rs.getDouble(6));
				reim.setGradingFormat(rs.getString(7));
				reim.setActive(rs.getBoolean(8));
				reim.setLastApprovalDate(rs.getTimestamp(9));
				reim.setCourseName(rs.getString(10));
				reimList.add(reim);
				
			}
			

			return reimList;
					
		}catch (SQLException e) {
			e.printStackTrace();
	
		}
			
		return null;
	}

	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Employee getEmployee(String lastName, int employeeId) {
		
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			Employee emp = new Employee();
			
			PreparedStatement ps = conn.prepareStatement(GETEMPLOYEEBYLOGIN);
			PreparedStatement ps2 = conn.prepareStatement(GETEMPLOYEEPOSITION);
			
			ps.setString(2, lastName);
			ps.setInt(1, employeeId);
			
			ps2.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs.next()) {
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setDeptName(rs.getString(4));
				emp.setPosition(rs.getString(5));
				emp.setReimbursementTotal(rs.getDouble(6));
			}
			
			while (rs2.next()) {
				System.out.println("Where in the second resultset");
				emp.setPosition(rs2.getString(1));
			}
			
			return emp;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void approveReimbursement(int reimbursementId, String newState) {//"update reimbursements set approval_stage = ? where reimbursement_id = ?"
	
		try(Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(APPROVEREIMBURSMENT);
			
			ps.setString(1, newState);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
			
			

	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
		
	}
	
	
	

	public void denyReimbursement(int reimbursementId) {//"update reimbursements set active = false, approval_stage = 'Unassigned' where reimbursement_id = ?";

		System.out.println("In deny reim in dao");
		
	try(Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(DENYREIMBURSEMENT);
			
			ps.setInt(1, reimbursementId);
			ps.executeUpdate();
			
			

	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	public void deleteReimbursement() {
		// TODO Auto-generated method stub

	}

	public Employee getEmployeeById(int employeeId) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			Employee emp = new Employee();
	
			PreparedStatement ps = conn.prepareStatement(GETEMPLOYEEBYID);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setDeptName(rs.getString(4));
				emp.setReimbursementTotal(rs.getDouble(6));
					
			}
			
			return emp;
	
	
		}catch(SQLException e) {
		e.printStackTrace();
	}
		return null;
	}

}
