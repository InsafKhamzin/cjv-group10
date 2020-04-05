package ca.myseneca.model;

import java.sql.Date;

/**
 * Java beans Employee class. Similar to EMPLOYEE table in database
 */
public class Employee implements java.io.Serializable {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private float salary;
    private float commissionPercent;
    private int managerId;
    private int departmentId;
    private String departmentName;

    public Employee() {}
    
    public Employee(int employeeId, String firstName, String lastName,
                    String email, String phoneNumber, Date hireDate,
                    String jobId, float salary, float commissionPercent,
                    int managerId, int departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPercent = commissionPercent;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(float commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getInfoString(){
        return String.format("Id: %d, First name: %s, Last name: %s, Email: %s,\n" +
                "Phone number: %s, Hire date: %s, Job id: %s,\n" +
                "Salary: %.2f, Commission: %.2f, Manager id: %d, Department id: %d",
                employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary,
                commissionPercent, managerId, departmentId);
    }

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
