
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// This resets the vote counts of the options of a poll
		int pollIdToReset = Integer.parseInt(req.getParameter("id"));

		try {
			Connection c = DriverManager.getConnection(Constants.DATABASE_URL,
					Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);
			String setNewPageCount = "update poll_option set vote_count=0 where id =?";
			PreparedStatement pstmt = c.prepareStatement(setNewPageCount);
			pstmt.setInt(1, pollIdToReset);
			pstmt.executeUpdate();

			c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

}
