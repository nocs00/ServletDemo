import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // session object creation
        HttpSession newSession = request.getSession(true);
        // Session creation time.
        Date cTime = new Date(newSession.getCreationTime());
        // The last time the client sent a request.
        Date lTime = new Date( newSession.getLastAccessedTime());
        /* sets the time, in seconds, between client requests before the servlet container
        invalidates this session */
        newSession.setMaxInactiveInterval(1 * 60 * 60);
        String str = "Website | Session";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String document =
        "<!doctype html public \"-//w3c//dtd html 4.0 " +
        "transitional//en\">\n";
        out.println(document +
        "<html>\n" +
        "<head><title>" + str + "</title></head>\n" +
        "<body bgcolor=\"#bbf5f0\">\n" +
        "<h2>Website: Displaying Session Information</h2>\n" +
        "|=======================\n" +
        "<br>" +
        " |Unique identifier assigned to this session\n" +
        " |" + newSession.getId() + ""
        + "<br>" +
        "<br>" +
        " |The time when this session was created\n" +
        " |" + cTime +
        " "
        + "<br>" +
        "<br>" +
        " |The last time the client sent a request associated with this session\n"
        + " |" + lTime +
        " "
        + "<br>" +
        "</tr><br>" +
        "<br>" +
        " | the maximum time interval, in seconds that the servlet container will"
                + "keep this session open between client accesses.\n" +
        " |" + newSession.getMaxInactiveInterval() +
        " "
        + "<br>" +
        "|=======================\n" +
        "</body></html>");
    }
}
