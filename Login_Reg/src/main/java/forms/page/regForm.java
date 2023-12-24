package forms.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regForm
 */
@WebServlet("/regForm")
public class regForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String myname = request.getParameter("name0");
        String mymail = request.getParameter("mail0");
        String mypass = request.getParameter("pass0");

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/forms?useSSL=false";
            con = DriverManager.getConnection(connectionUrl, "root", "admin");

            String sql = "INSERT INTO forms.members VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, myname);
            ps.setString(2, mymail);
            ps.setString(3, mypass);

            int count = ps.executeUpdate();

            if (count > 0) {
            	out.println("<html><head><title>Registration Successful</title></head><body>");
                out.println("<div style='text-align:center;'>");
                out.println("<h1 style='color:green;'>Registration Successful</h1>");
                out.println("<h5>Welcome, " + myname + "!</h5>");
                out.println("<button onclick=\"location.href='login.jsp'\">Back to Login</button>");
                out.println("</div>");
                out.println("</body></html>");
            } else {
            	out.println("<html><head><title>Registration Successful</title></head><body>");
                out.println("<div style='text-align:center;'>");
                out.println("<h1 style='color:red;'>Registration Unsuccessful</h1>");
                out.println("</div>");
                out.println("</body></html>");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.print("<h3 style='color:red'>An error occurred during registration</h3>");
        } catch (SQLException e) {
        	e.printStackTrace();
            out.print("<h3 style='color:red'>An SQL error occurred during registration:" + e.getMessage() + "</h3>");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}