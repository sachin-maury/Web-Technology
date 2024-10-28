import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class readcookie extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        Cookie c[]=null;
        c=req.getCookies();
        for(int i=0;i<c.length;i++)
        {
            pw.println(c[i].getName()+":"+c[i].getValue());
            pw.println("<br>");
        }
    }        
}
