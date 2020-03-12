package models;

import java.sql.Timestamp;

public class FullReimbursement {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	@Override
	public String toString() {
		return "FullReimbursement [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", position=" + position + ", reimbursementId=" + reimbursementId + ", dateSubmitted=" + dateSubmitted
				+ "]";
	}
	private String deptName;
	private String position;
	private double reimbursementTotal;
	private int reimbursementId;
	private Timestamp dateSubmitted;
	private Timestamp eventDate;
	private String approvalState;
	private double amount;
	private String gradingFormat;
	private boolean active;
	private Timestamp lastApprovalDate;
	private String eventType;
	private String courseName;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getReimbursementTotal() {
		return reimbursementTotal;
	}
	public void setReimbursementTotal(double reimbursementTotal) {
		this.reimbursementTotal = reimbursementTotal;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public Timestamp getEventDate() {
		return eventDate;
	}
	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}
	public String getApprovalState() {
		return approvalState;
	}
	public void setApprovalState(String approvalState) {
		this.approvalState = approvalState;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Timestamp getLastApprovalDate() {
		return lastApprovalDate;
	}
	public void setLastApprovalDate(Timestamp lastApprovalDate) {
		this.lastApprovalDate = lastApprovalDate;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
