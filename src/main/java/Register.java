import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Register() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repassword");
		
		String errorMsg = "";
		
		if (isEmpty(name) || isEmpty(email) || isEmpty(pass) || isEmpty(repass) )
			errorMsg = "Required to enter full information";
		if (!email.endsWith("@gmail.com")) {
			errorMsg = "Email must have the extension @gmail.com.";
		} else if (!pass.equals(repass)) {
			errorMsg = "Password and Re-enter password do not match.";
		} else if (pass.length() != 8) {
			errorMsg = "Password must be 8 characters long.";
		} else if (!isEmailAvailable(email)) {
			errorMsg = "The Email was registered. Please use another email.";
		} else {
          if (registerUser(name, email, pass, repass)) {
        	  errorMsg = "Bạn đã đăng ký thành công!\"";
        	  request.setAttribute("register", errorMsg);
        	  request.getRequestDispatcher("/Login.jsp").forward(request, response);
        } else {
        	  errorMsg = "Đã xảy ra lỗi trong quá trình đăng ký. Vui lòng thử lại sau.";
        	}
		}
		
		request.setAttribute("errorMsg", errorMsg);
        request.getRequestDispatcher("/Register.jsp").forward(request, response);
		
	}
	
	private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }


	private boolean registerUser(String name, String email, String pass, String repass) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
            if (connection != null) {
                String sql = "INSERT INTO register (username, email, password, repass) VALUES (?, ? ,?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, pass);
                preparedStatement.setString(4, repass);
                

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
	}


	private boolean isEmailAvailable(String email) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = DatabaseConnection.getConnection();

            if (connection != null) {
                String sql = "SELECT COUNT(*) FROM register WHERE email = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
	}

	
}
