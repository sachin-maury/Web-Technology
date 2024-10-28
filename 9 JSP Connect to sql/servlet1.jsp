<html>
<body>
<%@page contentType="text/html" import="java.io.*, java.net.*,java.sql.*,javax.servlet.*,javax.servlet.http.*"%>
<%
        response.setContentType("text/html;charset=UTF-8");
        String n1=request.getParameter("username");
        String n2=request.getParameter("password");
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:servlet","scott","tiger");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from register808 where name like '"+n1+"' and pwd like '"+n2+"' ");
           
	 rs.next();
            if(rs.getRow()!=0) {
                out.println("<center><h1>valid user</h1>");
            } else
                out.println("<h1>invalid user</h1></center>");
            out.close();
            con.close();
        } catch(Exception e2) {
            out.println(e2.getMessage());
        }
%>
</body>
</html>
