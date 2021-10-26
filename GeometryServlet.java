import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GeometryServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        Cylinder cyl = new Cylinder();
        int rad;
        int ht;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Geometry Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Calculate Values for Cylinder</h3>");
        out.println("Parameters in this request:<br>");

        String radius = request.getParameter("radius");
        String height = request.getParameter("height");

        if (radius != null || height != null) {
            out.println("Radius Entered:");
            out.println(" = " + HTMLFilter.filter(radius) + "<br>");
            out.println("Height:");
            out.println(" = " + HTMLFilter.filter(height) + "<br>");
            double surfArea = cyl.surfaceArea();
            double volume = cyl.volume(Integer.parseInt(radius), Integer.parseInt(height));
            out.println("Volume:");
            out.println(volume);
        } else {
            out.println("No Parameters, Please enter some");
        }
        out.println("<P>");
        out.print("<form action=\"");
        out.print("geometry\" ");
        out.println("method=POST>");
        out.println("Radius:");
        out.println("<input type=text size=20 name=radius>");
        out.println("<br>");
        out.println("Height:");
        out.println("<input type=text size=20 name=height>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        doGet(request, response);
    }
    
}
