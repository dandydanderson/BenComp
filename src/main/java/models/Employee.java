package models;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String deptName;
	private String position;
	private double reimbursementTotal;
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
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", deptName=" + deptName + ", position=" + position + ", reimbursementTotal=" + reimbursementTotal
				+ "]";
	}
	
	

}
