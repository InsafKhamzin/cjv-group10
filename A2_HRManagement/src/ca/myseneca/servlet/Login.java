package ca.myseneca.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.myseneca.model.DaManager;
import ca.myseneca.model.Employee;
import ca.myseneca.util.StringUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		request.setAttribute("username", username);
		request.setAttribute("password", password);

		if (StringUtil.isNullOrEmpty(username) || StringUtil.isNullOrEmpty(password)) {
			request.setAttribute("error", "Wrong credential");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		int userId = DaManager.getEmployeeID(username, password);
		if (userId == 0) {
			request.setAttribute("error", "Wrong credential");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		Employee employee = DaManager.getEmployeeById(userId);

		HttpSession oldSession = request.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate();
		}
		// generate a new session
		HttpSession newSession = request.getSession(true);

		newSession.setAttribute("user", userId);
		// setting session to expiry in 5 mins
		newSession.setMaxInactiveInterval(5*60);

		// settting employee name in cookie
		Cookie message = new Cookie("username", username);
		response.addCookie(message);
		response.sendRedirect("EmployeeList.jsp");
	}
}
