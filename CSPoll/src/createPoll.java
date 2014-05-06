import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createPoll
 */
@WebServlet("/createPoll")
public class createPoll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createPoll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		if (request.getSession().getAttribute("user") == null) {
//			response.sendRedirect("./LogIn");
//
//		}
//
//		else {
//
//			request.getRequestDispatcher("/WEB-INF/CreatePoll.jsp").forward(
//					request, response);
//
//		}
		String description = request.getParameter("description");
		boolean allowMultipleAnswer = Boolean.valueOf(request
				.getParameter("allowMultipleAnswer"));
		String[] options = request.getParameterValues("options");
		int auto_id=0;
		try {
			Connection c = DriverManager.getConnection(Constants.DATABASE_URL, Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);


			String sql = "insert into poll (description, allow_multiple_answer) values (?, ?)";
			PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, description);
			pstmt.setBoolean(2, allowMultipleAnswer);
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
		    rs.next();
		   auto_id = rs.getInt(1);
			
			for (int i = 0; i < options.length; i++) {
				String optionSql = "insert into poll_option (poll_id, option_string) values (?, ?)";
				PreparedStatement pstmt2 = c.prepareStatement(optionSql);
				pstmt2.setInt(1, auto_id);
				pstmt2.setString(2, options[i]);
				pstmt2.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		response.sendRedirect("./Vote?id="+auto_id);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		boolean allowMultipleAnswer = Boolean.valueOf(request
				.getParameter("allowMultipleAnswer"));
		String[] options = request.getParameterValues("options");
		int auto_id=0;
		try {
			Connection c = DriverManager.getConnection(Constants.DATABASE_URL, Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);


			String sql = "insert into poll (description, allow_multiple_answer) values (?, ?)";
			PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, description);
			pstmt.setBoolean(2, allowMultipleAnswer);
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
		    rs.next();
		   auto_id = rs.getInt(1);
			
			for (int i = 0; i < options.length; i++) {
				String optionSql = "insert into poll_option (poll_id, option_string) values (?, ?)";
				PreparedStatement pstmt2 = c.prepareStatement(optionSql);
				pstmt2.setInt(1, auto_id);
				pstmt2.setString(2, options[i]);
				pstmt2.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		response.sendRedirect("./Vote?id="+auto_id);
	}

}
