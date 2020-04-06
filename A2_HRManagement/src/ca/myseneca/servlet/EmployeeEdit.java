package ca.myseneca.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.myseneca.model.DaManager;
import ca.myseneca.model.Department;
import ca.myseneca.model.Employee;
import ca.myseneca.util.StringUtil;

/**
 * Servlet implementation class EmployeeEdit
 */
@WebServlet("/EmployeeEdit")
public class EmployeeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));

		Employee employee = DaManager.getEmployeeById(empId);
		ArrayList<Department> departments = DaManager.getAllDepartments();
		ArrayList<String> jobs = DaManager.getAllJobIds();

		request.setAttribute("employee", employee);
		request.setAttribute("departments", departments);
		request.setAttribute("jobs", jobs);

		getServletContext().getRequestDispatcher("/EmployeeEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int empId = Integer.parseInt(request.getParameter("empID"));
		Employee employee = DaManager.getEmployeeById(empId);

		try {

			// ********** Validation  **********//
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phNum = request.getParameter("phNum");

			String hireDateParam = request.getParameter("hireDate");
			if (!StringUtil.tryParseDate(hireDateParam)) {
				sendErrorMessage(request, response, employee, "Wrong date format");
				return;
			}
			Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(hireDateParam);
			if(hireDate.after(new Date())) {
				sendErrorMessage(request, response, employee, "Hire date can't be in future");
				return;
			}
			
			
			String jobId = request.getParameter("jobID");
			
			String salaryParam = request.getParameter("salary");
			if (!StringUtil.tryParseFloat(salaryParam)) {
				sendErrorMessage(request, response, employee, "Wrong salary format");
				return;
			}
			float salary = Float.parseFloat(salaryParam);
			if(salary < 0) {
				sendErrorMessage(request, response, employee, "Invalid salary");
				return;
			}
		
			String commissionParam = request.getParameter("commission");
			if (!StringUtil.tryParseFloat(commissionParam)) {
				sendErrorMessage(request, response, employee, "Wrong commission format");
				return;
			}
			float commission = Float.parseFloat(commissionParam);
			if(commission < 0) {
				sendErrorMessage(request, response, employee, "Invalid commision");
				return;
			}
			
			String managerIDParam = request.getParameter("managerID");
			if (!StringUtil.tryParseInt(managerIDParam)) {
				sendErrorMessage(request, response, employee, "Wrong manager id format");
				return;
			}
			int managerId = Integer.parseInt(managerIDParam);	
			if(managerId < 0) {
				sendErrorMessage(request, response, employee, "Invalid manager id");
				return;
			}else if (managerId > 0) {
				Employee manager = DaManager.getEmployeeById(managerId);
				if(manager == null) {
					sendErrorMessage(request, response, employee, "Manager doesn't exist");
					return;
				}
			}
			if(empId == managerId) {
				sendErrorMessage(request, response, employee, "Employee can't manage him/herself");
				return;
			}
			
			
			int deptId = Integer.parseInt(request.getParameter("deptID"));
			// ********** Validation  **********//
			
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employee.setPhoneNumber(phNum);
			employee.setHireDate(new java.sql.Date(hireDate.getTime()));
			employee.setJobId(jobId);
			employee.setSalary(salary);
			employee.setCommissionPercent(commission);
			employee.setManagerId(managerId);
			employee.setDepartmentId(deptId);
			
			boolean updated = DaManager.updateEmployee(employee);	
			if(!updated) {
				sendErrorMessage(request, response, employee, "Failed to update. Check parameters");
				return;
			}
			

			request.setAttribute("message", "Employee "+ empId + " has been updated");
			getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
			
		} catch (Exception e) {
			sendErrorMessage(request, response, employee, "Invalid input");
		}
	}

	private void sendErrorMessage(HttpServletRequest request, HttpServletResponse response, Employee employee,
			String msg) throws ServletException, IOException {
		request.setAttribute("error", msg);
		request.setAttribute("employee", employee);

		ArrayList<Department> departments = DaManager.getAllDepartments();
		ArrayList<String> jobs = DaManager.getAllJobIds();
		
		request.setAttribute("departments", departments);
		request.setAttribute("jobs", jobs);
		
		getServletContext().getRequestDispatcher("/EmployeeEdit.jsp").forward(request, response);
	}

}
