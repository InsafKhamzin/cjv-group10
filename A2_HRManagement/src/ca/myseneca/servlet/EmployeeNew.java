package ca.myseneca.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class EmployeeAdd
 */
@WebServlet("/EmployeeNew")
public class EmployeeNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeNew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Department> departments = DaManager.getAllDepartments();
		ArrayList<String> jobs = DaManager.getAllJobIds();
		request.setAttribute("departments", departments);
		request.setAttribute("jobs", jobs);
		getServletContext().getRequestDispatcher("/EmployeeNew.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		saveParams(request);
		
		int empId = Integer.parseInt(request.getParameter("empID"));
		Employee employee = DaManager.getEmployeeById(empId);
		if(employee != null) {
			sendErrorMessage(request, response, "Employee id already exists");
			return;
		}

		try {

			// ********** Validation  **********//
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phNum = request.getParameter("phNum");

			String hireDateParam = request.getParameter("hireDate");
			if (!StringUtil.tryParseDate(hireDateParam)) {
				sendErrorMessage(request, response, "Wrong date format");
				return;
			}
			Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(hireDateParam);
			if(hireDate.after(new Date())) {
				sendErrorMessage(request, response, "Hire date can't be in future");
				return;
			}
			
			String jobId = request.getParameter("jobID");
			
			String salaryParam = request.getParameter("salary");
			if (!StringUtil.tryParseFloat(salaryParam)) {
				sendErrorMessage(request, response, "Wrong salary format");
				return;
			}
			float salary = Float.parseFloat(salaryParam);
			if(salary < 0) {
				sendErrorMessage(request, response, "Invalid salary");
				return;
			}
		
			String commissionParam = request.getParameter("commission");
			if (!StringUtil.tryParseFloat(commissionParam)) {
				sendErrorMessage(request, response, "Wrong commission format");
				return;
			}
			float commission = Float.parseFloat(commissionParam);
			if(commission < 0) {
				sendErrorMessage(request, response, "Invalid commision");
				return;
			}
			
			String managerIDParam = request.getParameter("managerID");
			if (!StringUtil.tryParseInt(managerIDParam)) {
				sendErrorMessage(request, response, "Wrong manager id format");
				return;
			}
			int managerId = Integer.parseInt(managerIDParam);	
			if(managerId < 0) {
				sendErrorMessage(request, response, "Invalid manager id");
				return;
			}else if (managerId > 0) {
				Employee manager = DaManager.getEmployeeById(managerId);
				if(manager == null) {
					sendErrorMessage(request, response, "Manager doesn't exist");
					return;
				}
			}
			
			int deptId = Integer.parseInt(request.getParameter("deptID"));
			// ********** Validation  **********//
			
			employee = new Employee();
			employee.setEmployeeId(empId);
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
			
			boolean updated = DaManager.addEmployee(employee);	
			if(!updated) {
				sendErrorMessage(request, response, "Failed to save. Check parameters");
				return;
			}
			

			request.setAttribute("message", "Employee "+ empId + " saved");
			getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e);
			sendErrorMessage(request, response, "Invalid input");
		}
	}
	
	//Saving parameters
	private void saveParams(HttpServletRequest request) {		
		request.setAttribute("empID", request.getParameter("empID"));
		request.setAttribute("firstName", request.getParameter("firstName"));
		request.setAttribute("lastName", request.getParameter("lastName"));
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("phNum", request.getParameter("phNum"));
		request.setAttribute("hireDate", request.getParameter("hireDate"));
		request.setAttribute("jobID", request.getParameter("jobID"));
		request.setAttribute("salary", request.getParameter("salary"));
		request.setAttribute("commission", request.getParameter("commission"));
		request.setAttribute("managerID", request.getParameter("managerID"));
		request.setAttribute("deptID", request.getParameter("deptID"));
	}
	

	private void sendErrorMessage(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
		request.setAttribute("error", msg);

		ArrayList<Department> departments = DaManager.getAllDepartments();
		ArrayList<String> jobs = DaManager.getAllJobIds();
		
		request.setAttribute("departments", departments);
		request.setAttribute("jobs", jobs);
		
		getServletContext().getRequestDispatcher("/EmployeeNew.jsp").forward(request, response);
	}

}
