import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class writecookie extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        String s=req.getParameter("t1");
        String ph=req.getParameter("t2");
        Cookie c1=new Cookie(s,ph);
        res.addCookie(c1);
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        pw.println("cookie is written sucessfully to client");
        pw.close();
    }
}
