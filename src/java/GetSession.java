import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
/**
 *
 * @author Aarya
 */
public class GetSession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(true);
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
           if(session==null)
           {
               out.println("<h2>You are logged out!</h2>");
           }
           else
           {
               out.println("<h2>You are logged in!</h2>");
               out.println("<h2>Data:</h2>");
               Enumeration e= session.getAttributeNames();
               while(e.hasMoreElements())
               {
                   String name=(String) e.nextElement();
                   Object value=session.getAttribute(name);
                   out.println("<h3>Name: "+name+" Value: "+value+"<h3>");
               }
               session.invalidate();
               out.println("<p><a href=\"index.html\">Return"+"</a> to login page</p>");
           }
    }
}
