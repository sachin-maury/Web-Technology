import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class sessiondemo extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        Date date;
       long createdtime,currenttime;
       int vcount=1;
       String sid,svcount;
       HttpSession session;
       session=req.getSession(true);
       sid=session.getId();
       date=new Date();
       currenttime=date.getTime();
       createdtime=session.getCreationTime();
       session.setMaxInactiveInterval(5);
       svcount=(String)session.getAttribute("visitcount");
       if(svcount==null)
       {
           session.setAttribute("visitcount",""+vcount);
       }
       else
       {
           vcount=Integer.parseInt(svcount)+1;
           session.setAttribute("visitcount",""+vcount);
       }
       res.setContentType("text/html");
       PrintWriter pw=res.getWriter();
       if(svcount==null)
       {
           pw.println("you r visting page for the first time ");
           pw.println("sesion id"+sid);
       }
      
 else
       {
            pw.println("you visited this page for" +vcount+"times");
       
}
       pw.println("session was created at:"+createdtime+"<br>");
       pw.println("last time visted:"+session.getLastAccessedTime());
       pw.println("current time is :"+currenttime);
       pw.println("if ur inactive for 5 secc's the session wil expire");
    }
  
     
}
