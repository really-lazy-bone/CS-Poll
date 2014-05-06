

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
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		

			ArrayList<Option> options = new ArrayList<Option>(); 

			Connection c = DriverManager.getConnection(Constants.DATABASE_URL, Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);
			String requestSql = ("select * from poll where poll_id= ?");
			PreparedStatement pstmt = c.prepareStatement(requestSql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("id")));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String description = rs.getString("description");
				request.setAttribute("description", description);
			}
			
			String optionSql = ("select * from poll_option where poll_id= ?");
			PreparedStatement pstmt2 = c.prepareStatement(optionSql);
			pstmt2.setInt(1, Integer.parseInt(request.getParameter("id")));
			ResultSet rs1 = pstmt2.executeQuery();
			while (rs1.next()) {
				Option optionToAdd = new Option(Integer.parseInt(rs1.getString("id")), rs1.getString("option_string"));
				options.add(optionToAdd);
			}
			request.setAttribute("options", options);

			c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
		request.getRequestDispatcher("/WEB-INF/poll.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
