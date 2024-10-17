import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentCookieServlet")
public class StudentCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Retrieve cookies
        Cookie[] cookies = request.getCookies();
        String studentName = "";
        String phoneNumber = "";

        // Check for existing cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("studentName")) {
                    studentName = cookie.getValue();
                } else if (cookie.getName().equals("phoneNumber")) {
                    phoneNumber = cookie.getValue();
                }
            }
        }

        // HTML form to input student details
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Student Cookie Example</h2>");
        response.getWriter().println("<form method='POST'>");
        response.getWriter().println("Student Name: <input type='text' name='name' required><br>");
        response.getWriter().println("Phone Number: <input type='text' name='phone' required><br>");
        response.getWriter().println("<input type='submit' value='Save Cookies'>");
        response.getWriter().println("</form>");

        // Display cookies if available
        if (!studentName.isEmpty() && !phoneNumber.isEmpty()) {
            response.getWriter().println("<h3>Stored Cookies:</h3>");
            response.getWriter().println("Name: " + studentName + "<br>");
            response.getWriter().println("Phone: " + phoneNumber + "<br>");
        }

        response.getWriter().println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentName = request.getParameter("name");
        String phoneNumber = request.getParameter("phone");

        // Create cookies
        Cookie nameCookie = new Cookie("studentName", studentName);
        Cookie phoneCookie = new Cookie("phoneNumber", phoneNumber);

        // Set cookie age (in seconds)
        nameCookie.setMaxAge(60 * 60 * 24); // 1 day
        phoneCookie.setMaxAge(60 * 60 * 24); // 1 day

        // Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(phoneCookie);

        // Redirect back to doGet to display the cookies
        response.sendRedirect("StudentCookieServlet");
    }
}
