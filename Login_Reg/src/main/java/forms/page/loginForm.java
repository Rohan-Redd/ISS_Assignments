package forms.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginForm")
public class loginForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("name1");
        String password = request.getParameter("pass1");

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/forms?useSSL=false";
            con = DriverManager.getConnection(connectionUrl, "root", "admin");

            String sql = "SELECT * FROM forms.members WHERE name = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // User authenticated, redirect to welcome page
                response.sendRedirect("welcome.jsp");
            } else {
                // Incorrect credentials, display message on the login page
            	out.println("<html><head><title>Login Failed</title></head><body>");
                out.println("<script>");
                out.println("alert('Incorrect credentials. Please check your username and password and try again.');");
                out.println("window.location.href='login.jsp';");
                out.println("</script>");
                out.println("</body></html>");
                //response.sendRedirect(".jsp");
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
