
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
		ArrayList<Poll> polls = new ArrayList<Poll>();
		Connection c;
		try {
			c = DriverManager.getConnection(Constants.DATABASE_URL, Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);
			String requestSql = ("select * from poll");
			PreparedStatement pstmt = c.prepareStatement(requestSql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int pollId = rs.getInt("poll_id");
				int totalCount = rs.getInt("total_count");
				String description = rs.getString("description");
				Poll poll = new Poll(pollId, description, totalCount);
				polls.add(poll);
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("polls", polls);
		request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(
				request, response);
	
	
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// This resets the vote counts of the options of a poll
		int pollIdToReset = Integer.parseInt(req.getParameter("id"));

		try {
			Connection c = DriverManager.getConnection(Constants.DATABASE_URL,
					Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);
			
			String setNewPollCount = "update poll set total_count=0 where poll_id =?";
			PreparedStatement pstmt4 = c.prepareStatement(setNewPollCount);
			pstmt4.setInt(1, pollIdToReset);
			pstmt4.executeUpdate();
			
			
			
			String setNewPageCount = "update poll_option set vote_count=0 where poll_id =?";
			PreparedStatement pstmt = c.prepareStatement(setNewPageCount);
			pstmt.setInt(1, pollIdToReset);
			pstmt.executeUpdate();
			
			
			String deleteIps = "delete from poll_ip where poll_id =?";
			PreparedStatement pstmt2 = c.prepareStatement(deleteIps);
			pstmt2.setInt(1, pollIdToReset);
			pstmt2.executeUpdate();
			
			
			resp.sendRedirect("./Admin");

			c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

}
