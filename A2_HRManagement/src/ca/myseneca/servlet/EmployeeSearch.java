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
import ca.myseneca.model.Employee;

/**
 * Servlet implementation class EmployeeSearch
 */
@WebServlet("/EmployeeSearch")
public class EmployeeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("EmployeeSearch.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchValue = request.getParameter("searchValue");
		
		searchValue = searchValue.replaceAll("[^A-Za-z0-9.]","");
		
		ArrayList<Employee> employees = DaManager.searchEmployees(searchValue.toLowerCase());
		if(employees.size() == 0) {
			request.setAttribute("error", "No employees found");
			getServletContext().getRequestDispatcher("/EmployeeSearch.jsp").forward(request, response);
			return;
		}

		request.setAttribute("searchValue", searchValue);
		request.setAttribute("employees", employees);
		getServletContext().getRequestDispatcher("/EmployeeSearchResult.jsp").forward(request, response);
	}

}
