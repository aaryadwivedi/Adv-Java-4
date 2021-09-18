import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Aarya
 */
@WebServlet(urlPatterns = {"/LogServ"})
public class LogServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String uname=request.getParameter("uname");
            String pass=request.getParameter("pass");
            HttpSession session =request.getSession();
            session.setAttribute("uname",uname);
            session.setAttribute("pass",pass);
            if(uname.equals("aarya")&& pass.equals("aarya"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Success</title>");            
                out.println("</head>");
                out.println("<body>");             
                out.println("<h1>Thank you " + uname + "</h1>");
                String newUrl=response.encodeURL("GetSession");
                out.println("Click <a href=\""+newUrl+"\">here</a> for another servlet");
                out.println("</body>");
                out.println("</html>");
            }
            else
            {
                out.println("<h2 style='color:red'>Authentication Failed<h2>");
            }
    }
}
