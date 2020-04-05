package ca.myseneca.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class EmployeeList
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("EmployeeList.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String deptID = request.getParameter("deptID");

		ArrayList<Employee> employees = null;

		if (StringUtil.isNullOrEmpty(deptID)) {
			employees = DaManager.getAllEmployees();
		} else {
			int departmentId = Integer.parseInt(deptID);
			Department department = DaManager.getDepartmentById(departmentId);
			if (department == null) {
				request.setAttribute("error", "Department doesn't exist");
				getServletContext().getRequestDispatcher("/EmployeeList.jsp").forward(request, response);
				return;
			}
			employees = DaManager.getEmployeesByDepartmentID(departmentId);
			request.setAttribute("deptName", department.getName());
		}

		request.setAttribute("employees", employees);

		getServletContext().getRequestDispatcher("/EmployeeListResult.jsp").forward(request, response);

	}

}
